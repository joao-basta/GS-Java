package br.com.orbitalcenters.main;

import br.com.orbitalcenters.entities.*;
import br.com.orbitalcenters.entities.enums.*;
import br.com.orbitalcenters.service.GerenciadorDeEnergia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner leitura = new Scanner(System.in);

    public static double lerDouble(String mensagem) {
        System.out.println(mensagem);
        return leitura.nextDouble();
    }

    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        return leitura.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.println(mensagem);
        return leitura.nextInt();
    }

    public static boolean lerSimNao(String mensagem) {
        System.out.println(mensagem + " (sim/nao)");
        return leitura.next().equalsIgnoreCase("sim");
    }

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("  ORBITAL CENTERS - Gerenciador de Energia IA  ");
        System.out.println("================================================");

        GerenciadorDeEnergia gerenciador = new GerenciadorDeEnergia();

        System.out.println("\n[1] CONFIGURACAO DA FONTE DE ENERGIA");
        int tipoEnergia = lerInt("Tipo de energia:\n1 - Orbital (SBSP)\n2 - Terrestre");
        boolean ativo = lerSimNao("A fonte esta ativa?");

        FonteDeEnergia fonte;

        if (tipoEnergia == 1) {
            boolean eclipse = lerSimNao("Está ocorrendo eclipse agora?");
            double capacidade = lerDouble("Capacidade instalada (kW):");
            double eficiencia = lerDouble("Eficiencia do painel (0-100):");
            double percentualPainel = lerDouble("Percentual do painel funcionando (0-100):");
            double janela = lerDouble("Janela de transmissao (minutos por orbita):");
            fonte = new EnergiaOrbital(capacidade, eficiencia, ativo, eclipse, percentualPainel, janela);
        } else {
            boolean gridEstavel = lerSimNao("O grid esta estavel?");
            double capacidade = lerDouble("Capacidade instalada (kW):");
            double eficiencia = lerDouble("Eficiencia (0-100):");
            leitura.nextLine();
            String tipoFonte = lerString("Tipo de fonte (diesel/solar/grid):");
            fonte = new EnergiaTerrestre(capacidade, eficiencia, ativo, gridEstavel, tipoFonte);
        }

        System.out.println("\n[FONTE] Tipo: " + fonte.tipo());
        System.out.println("[FONTE] Disponibilidade calculada: " + String.format("%.2f", fonte.calcularDisponibilidade()) + " kW");

        System.out.println("\n[2] CONFIGURACAO DO SATELITE");
        String nomeSatelite = lerString("Nome do satelite:");
        double capacidadeProc = lerDouble("Capacidade de processamento (TFLOPS):");

        EnergiaOrbital energiaOrbitalSatelite = new EnergiaOrbital(
                500, 90, true, false, 95, 12
        );
        Satelite satelite = new Satelite(1, nomeSatelite, capacidadeProc, energiaOrbitalSatelite, new ArrayList<>());
        System.out.println("[SATELITE] " + satelite.getNome() + " configurado. Energia orbital disponivel: " +
                String.format("%.2f", energiaOrbitalSatelite.calcularDisponibilidade()) + " kW");

        System.out.println("\n[3] CONFIGURACAO DO DATA CENTER");
        leitura.nextLine();
        String nomeDC = lerString("Nome do data center:");
        double latitude = lerDouble("Latitude:");
        double longitude = lerDouble("Longitude:");
        double capacidadeDC = lerDouble("Capacidade instalada do data center (kW):");
        double consumoAtual = lerDouble("Consumo atual do data center (kW):");

        DataCenterRemoto dc = new DataCenterRemoto(1, nomeDC, latitude, longitude, capacidadeDC, consumoAtual, fonte);
        System.out.println("[DC] Data center '" + dc.getNome() + "' configurado.");


        System.out.println("\n[4] CADASTRO DE WORKLOADS DE IA");
        int qtdWorkloads = lerInt("Quantos workloads deseja cadastrar? (minimo 3):");
        List<WorkloadIA> fila = new ArrayList<>();
        leitura.nextLine();

        for (int i = 1; i <= qtdWorkloads; i++) {
            System.out.println("\n-- Workload " + i + " --");
            String nomeW = lerString("Nome do workload:");
            System.out.println("Tipo:\n1-INFERENCIA\n2-TREINAMENTO\n3-BATCH\n4-IDLE");
            int tipoW = lerInt("Escolha:");
            TipoWorkload tipo = switch (tipoW) {
                case 2 -> TipoWorkload.TREINAMENTO;
                case 3 -> TipoWorkload.BATCH;
                case 4 -> TipoWorkload.IDLE;
                default -> TipoWorkload.INFERENCIA;
            };
            System.out.println("Criticidade:\n1-CRITICO\n2-NORMAL\n3-DIFERIVEL");
            int critW = lerInt("Escolha:");
            NivelCriticidade criticidade = switch (critW) {
                case 2 -> NivelCriticidade.NORMAL;
                case 3 -> NivelCriticidade.DIFERIVEL;
                default -> NivelCriticidade.CRITICO;
            };
            double consumoW = lerDouble("Consumo estimado (watts):");
            double duracaoW = lerDouble("Duracao estimada (horas):");
            leitura.nextLine();
            String deadlineW = lerString("Deadline (ex: 2026-06-10):");

            fila.add(new WorkloadIA(i, nomeW, tipo, criticidade, consumoW, duracaoW, deadlineW));
        }


        System.out.println("\n================================================");
        System.out.println("  EXECUTANDO METODOS DO GERENCIADOR            ");
        System.out.println("================================================");


        System.out.println("\n--- METODO 1a: Priorizacao sem deadline ---");
        double energiaDisponivel = fonte.calcularDisponibilidade();
        List<WorkloadIA> priorizados = gerenciador.priorizarWorkload(fila, energiaDisponivel);


        System.out.println("\n--- METODO 1b: Priorizacao COM deadline (sobrecarga) ---");
        String deadlineUrgente = lerString("Informe um deadline urgente para priorizar (ex: 2026-06-10):");
        gerenciador.priorizarWorkload(fila, energiaDisponivel, deadlineUrgente);


        System.out.println("\n--- METODO 2: Decisao de local de processamento ---");
        int processados = 0;
        int diferidos = 0;
        double energiaTotalConsumida = 0;

        for (WorkloadIA w : priorizados) {
            LocalProcessamento decisao = gerenciador.decidirLocalDeProcessamento(w, satelite, dc);
            if (decisao != LocalProcessamento.DIFERIR) {
                processados++;
                energiaTotalConsumida += w.getConsumoEstimadoEmWatts();
            } else {
                diferidos++;
            }
        }


        System.out.println("\n--- METODO 3: Deteccao de desperdicio ---");
        gerenciador.detectarDesperdicio(dc);


        System.out.println("\n--- METODO 4: Projecao de consumo ---");
        int horasProjecao = lerInt("Para quantas horas deseja projetar o consumo?");
        gerenciador.projetarConsumo(fila, horasProjecao);


        System.out.println("\n--- METODO 5: Eficiencia energetica (PUE) ---");
        gerenciador.calcularEficienciaEnergetica(dc);


        System.out.println("\n--- METODO 6: Simulacao de impacto de novo workload ---");
        WorkloadIA workloadSimulado = new WorkloadIA(
                99, "GPT-Treinamento-Simulado", TipoWorkload.TREINAMENTO,
                NivelCriticidade.DIFERIVEL, 350.0, 48.0, "2026-12-31"
        );
        gerenciador.simularImpactoWorkload(workloadSimulado, dc);


        System.out.println("\n--- RELATORIO FINAL ---");
        double reducaoCO2 = (energiaTotalConsumida / 1000.0) * 0.233;
        double energiaEconomizada = energiaTotalConsumida * 0.3;

        Relatorio relatorio = new Relatorio(
                1,
                "2026-06-07",
                energiaTotalConsumida / 1000.0,
                energiaEconomizada / 1000.0,
                processados,
                diferidos,
                reducaoCO2,
                "Satelite: " + satelite.getNome() + " | Data Center: " + dc.getNome()
        );
        relatorio.exibir();

        System.out.println("\nObrigado por usar o Orbital Centers!");
        leitura.close();
    }
}
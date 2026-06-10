package br.com.orbitalcenters.service;

import br.com.orbitalcenters.entities.*;
import br.com.orbitalcenters.entities.enums.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeEnergia {

    private WorkloadIA workload;
    private FonteDeEnergia fonte;
    private PoliticaPriorizacao priorizacao;

    public GerenciadorDeEnergia() {
        this.priorizacao = new PoliticaPriorizacao();
    }

    public GerenciadorDeEnergia(PoliticaPriorizacao priorizacao) {
        this.priorizacao = priorizacao;
    }

    public GerenciadorDeEnergia(WorkloadIA workload, FonteDeEnergia fonte, PoliticaPriorizacao priorizacao) {
        this.workload = workload;
        this.fonte = fonte;
        this.priorizacao = priorizacao;
    }

    public List<WorkloadIA> priorizarWorkload(List<WorkloadIA> fila, double energiaDisponivel) {
        List<WorkloadIA> selecionados = new ArrayList<>();
        double energiaRestante = energiaDisponivel;

        for (WorkloadIA w : fila) {
            if (w.getCriticidade() == NivelCriticidade.CRITICO) {
                selecionados.add(w);
                energiaRestante -= w.getConsumoEstimadoEmWatts();
            }
        }

        for (WorkloadIA w : fila) {
            if (w.getCriticidade() != NivelCriticidade.CRITICO) {
                if (energiaRestante >= w.getConsumoEstimadoEmWatts()) {
                    selecionados.add(w);
                    energiaRestante -= w.getConsumoEstimadoEmWatts();
                }
            }
        }

        System.out.println("[PRIORIZACAO] " + selecionados.size() + " workloads selecionados de " + fila.size());
        return selecionados;
    }

    public List<WorkloadIA> priorizarWorkload(List<WorkloadIA> fila, double energiaDisponivel, String deadline) {
        List<WorkloadIA> filaOrdenada = new ArrayList<>(fila);

        filaOrdenada.sort((a, b) -> {
            boolean aUrgente = deadline.equals(a.getDeadline());
            boolean bUrgente = deadline.equals(b.getDeadline());
            if (aUrgente && !bUrgente) return -1;
            if (!aUrgente && bUrgente) return 1;
            return 0;
        });

        System.out.println("[PRIORIZACAO COM DEADLINE] Deadline considerado: " + deadline);
        return priorizarWorkload(filaOrdenada, energiaDisponivel);
    }

    public LocalProcessamento decidirLocalDeProcessamento(WorkloadIA tarefa, Satelite satelite, DataCenterRemoto dc) {
        double energiaOrbital = satelite.getFonteEnergia().calcularDisponibilidade();
        double energiaTerrestre = dc.getFonteEnergia().calcularDisponibilidade();
        double consumo = tarefa.getConsumoEstimadoEmWatts();

        double percentualDC = (energiaTerrestre / dc.getCapacidadeInstalada()) * 100;
        if (percentualDC < priorizacao.getThresholdMinimoEnergia()) {
            System.out.println("[DECISAO] Energia abaixo do threshold minimo. Workload DIFERIDO: " + tarefa.getNome());
            return LocalProcessamento.DIFERIR;
        }

        boolean sateliteViavel = energiaOrbital > 0 && consumo < (energiaOrbital * 0.8);
        double capacidadeResidualDC = dc.getCapacidadeInstalada() - dc.getConsumoAtual();
        boolean dcViavel = capacidadeResidualDC >= consumo;

        if (sateliteViavel && dcViavel) {
            System.out.println("[DECISAO] Ambos disponiveis. Priorizando SATELITE: " + tarefa.getNome());
            return LocalProcessamento.SATELITE;
        } else if (sateliteViavel) {
            System.out.println("[DECISAO] Apenas satelite viavel: " + tarefa.getNome());
            return LocalProcessamento.SATELITE;
        } else if (dcViavel) {
            System.out.println("[DECISAO] Apenas data center viavel: " + tarefa.getNome());
            return LocalProcessamento.DATA_CENTER;
        } else {
            System.out.println("[DECISAO] Nenhum ambiente disponivel. Workload DIFERIDO: " + tarefa.getNome());
            return LocalProcessamento.DIFERIR;
        }
    }

    public String detectarDesperdicio(DataCenterRemoto dc) {
        double percentualConsumo = (dc.getConsumoAtual() / dc.getCapacidadeInstalada()) * 100;
        double utilizacaoComputacional = 100 - (percentualConsumo * 0.5);

        boolean consumoAlto = percentualConsumo >= priorizacao.getThresholdDesperdicio();
        boolean utilizacaoBaixa = utilizacaoComputacional < priorizacao.getUtilizacaoMinimaEsperada();

        if (consumoAlto && utilizacaoBaixa) {
            String alerta = "[DESPERDICIO CRITICO] Data center '" + dc.getNome() +
                    "' com consumo em " + String.format("%.1f", percentualConsumo) +
                    "% e utilizacao computacional estimada em " +
                    String.format("%.1f", utilizacaoComputacional) + "%. Acao necessaria.";
            System.out.println(alerta);
            return alerta;
        }

        String status = "[OK] Data center '" + dc.getNome() + "' operando eficientemente. Consumo: " +
                String.format("%.1f", percentualConsumo) + "%";
        System.out.println(status);
        return status;
    }

    public double projetarConsumo(List<WorkloadIA> workloadsFuturos, int horasAdiante) {
        double totalKWh = 0;

        for (WorkloadIA w : workloadsFuturos) {
            double duracaoEfetiva = Math.min(w.getDuracaoEstimadaEmHoras(), horasAdiante);
            totalKWh += (w.getConsumoEstimadoEmWatts() / 1000.0) * duracaoEfetiva;
        }

        System.out.println("[PROJECAO] Consumo estimado para as proximas " + horasAdiante +
                " horas: " + String.format("%.2f", totalKWh) + " kWh");
        return totalKWh;
    }

    public double calcularEficienciaEnergetica(DataCenterRemoto dc) {
        if (dc.getConsumoAtual() == 0) return 1.0;
        double energiaTI = dc.getConsumoAtual() * 0.6;
        double pue = dc.getConsumoAtual() / energiaTI;

        System.out.println("[EFICIENCIA] PUE do data center '" + dc.getNome() +
                "': " + String.format("%.2f", pue) +
                (pue <= 1.5 ? " - Eficiente" : " - Ineficiente, revisar"));
        return pue;
    }

    public double simularImpactoWorkload(WorkloadIA w, DataCenterRemoto dc) {
        double consumoProjetado = dc.getConsumoAtual() + w.getConsumoEstimadoEmWatts();
        double percentualOcupacao = (consumoProjetado / dc.getCapacidadeInstalada()) * 100;

        System.out.println("[SIMULACAO] Aceitar workload '" + w.getNome() +
                "' levaria ocupacao do data center '" + dc.getNome() +
                "' para " + String.format("%.1f", percentualOcupacao) + "%");

        if (percentualOcupacao > 85) {
            System.out.println("[ALERTA] Ocupacao acima de 85%. Workload nao recomendado.");
        }
        return percentualOcupacao;
    }

    public WorkloadIA getWorkload() { return workload; }
    public void setWorkload(WorkloadIA workload) { this.workload = workload; }
    public FonteDeEnergia getFonte() { return fonte; }
    public void setFonte(FonteDeEnergia fonte) { this.fonte = fonte; }
    public PoliticaPriorizacao getPriorizacao() { return priorizacao; }
    public void setPriorizacao(PoliticaPriorizacao priorizacao) { this.priorizacao = priorizacao; }
}
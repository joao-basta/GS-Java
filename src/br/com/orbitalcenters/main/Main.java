package br.com.orbitalcenters.main;

import br.com.orbitalcenters.entities.*;

import javax.xml.crypto.Data;
import java.util.*;

public class Main{
    public static double lerDouble(Scanner sc, String mensagem){
        System.out.println(mensagem);
        return sc.nextDouble();
    }

    public static String lerString(Scanner sc, String mensagem){
        System.out.println(mensagem);
        return sc.next();
    }

    public static int lerInt(Scanner sc, String mensagem){
        System.out.println(mensagem);
        return sc.nextInt();
    }

    //int id, String nome, double latitude, double longitude, double capacidadeInstalada, double consumoAtual, FonteDeEnergia fonteEnergia
    public static DataCenterRemoto CreateDataCenter(FonteDeEnergia energia, String nome, double latitude, double longitude, double capacidadeInstalada, double consumoAtual){
         DataCenterRemoto datacenter = new DataCenterRemoto(
                1,
                nome,
                latitude,
                longitude,
                capacidadeInstalada,
                consumoAtual,
                energia
                );
        return datacenter;
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int tipoDeEnergia = 0;
        String verificacaoAtivo = "";
        boolean ativo = false;
        boolean eclipse = false;
        boolean grid = false;
        String nome = "";
        double latitude = 0;
        double longitude = 0;
        double capacidadeInstalada = 0;
        double consumoAtual = 0;

        System.out.println("Seja bem - vindo ao gerenciador e monitoramento de energia em Data Centers");

        System.out.println("Preencha algumas informações referentes ao Data Center:");
        nome = lerString(leitura, "Qual o nome do Data Center");
        latitude = lerDouble(leitura, "Qual a latitude que esse Data Center está");
        longitude = lerDouble(leitura, "Qual a longitude que esse Data Center está");
        capacidadeInstalada = lerDouble(leitura, "Qual a capacidade instalada que esse Data Center tem");
        consumoAtual = lerDouble(leitura, "Qual o consumo atual desse Data Center");



        tipoDeEnergia = lerInt(leitura, "Que tipo de energia será calculada a energia? \n1 - Orbital \n2 - Terrestre");

        verificacaoAtivo = lerString(leitura, "A fonte de energia orbital está ativada no momento? \nSim \nNão");


        if (verificacaoAtivo.equalsIgnoreCase("sim")){
            ativo = true;
        } else if (verificacaoAtivo.equalsIgnoreCase("nao")) {
            System.out.println();
        }

        if(tipoDeEnergia == 1){
            String verificacaoEclipse = lerString(leitura, "Está acontecendo um eclipse nesse momento? \nSim \nNão");

            if (verificacaoEclipse.equalsIgnoreCase("sim")){
                eclipse = true;
            } else if (verificacaoEclipse.equalsIgnoreCase("nao")) {
                System.out.println();
            }

            FonteDeEnergia energia = new EnergiaOrbital(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    eclipse,
                    lerDouble(leitura, "Qual o percentual do painel?"),
                    lerDouble(leitura, "Qual a janela de transmissão?")
            );

            System.out.println(energia.calcularDisponibilidade());

            CreateDataCenter(energia, nome, latitude, longitude, capacidadeInstalada, consumoAtual);

        } else {
            String verificacaoGrid = lerString(leitura, "O grid de energia dessa fonte está estavel? ");

            if (verificacaoGrid.equalsIgnoreCase("sim")){
                grid = true;
            } else if (verificacaoGrid.equalsIgnoreCase("nao")) {
                System.out.println();
            }

            FonteDeEnergia energia = new EnergiaTerrestre(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    grid,
                    lerString(leitura, "Qual é o tipo de fonte?")
            );
            System.out.println(energia.calcularDisponibilidade());

            CreateDataCenter(energia, nome, latitude, longitude, capacidadeInstalada, consumoAtual);


        }
    }
}
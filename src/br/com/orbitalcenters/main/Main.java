package br.com.orbitalcenters.main;

import br.com.orbitalcenters.entities.EnergiaOrbital;
import br.com.orbitalcenters.entities.EnergiaTerrestre;
import br.com.orbitalcenters.entities.FonteDeEnergia;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int tipoDeEnergia = 0;
        String verificacaoAtivo = "";
        boolean ativo = false;
        boolean eclipse = false;
        boolean grid = false;

        System.out.println("Seja bem - vindo ao gerenciador e monitoramento de energia em Data Centers");

        tipoDeEnergia = lerInt(leitura, "Que tipo de energia será calculada a energia? \n1 - Orbital \n2 - Terrestre");

        verificacaoAtivo = lerString(leitura, "A fonte de energia orbital está ativada no momento? \nSim \nNão");


        if (verificacaoAtivo.equalsIgnoreCase("sim")){
            ativo = true;
        } else if (verificacaoAtivo.equalsIgnoreCase("nao")) {
            System.out.println("");
        }

        if(tipoDeEnergia == 1){
            String verificacaoEclipse = lerString(leitura, "Está acontecendo um eclipse nesse momento? \nSim \nNão");

            if (verificacaoEclipse.equalsIgnoreCase("sim")){
                eclipse = true;
            } else if (verificacaoEclipse.equalsIgnoreCase("nao")) {
                System.out.println("");
            }

            EnergiaOrbital energia = new EnergiaOrbital(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    eclipse,
                    lerDouble(leitura, "Qual o percentual do painel?"),
                    lerDouble(leitura, "Qual a janela de transmissão?")
            );

            System.out.println(energia.calcularDisponibilidade());

        } else {
            String verificacaoGrid = lerString(leitura, "O grid de energia dessa fonte está estavel? ");

            if (verificacaoGrid.equalsIgnoreCase("sim")){
                grid = true;
            } else if (verificacaoGrid.equalsIgnoreCase("nao")) {
                System.out.println("");
            }

            EnergiaTerrestre energia = new EnergiaTerrestre(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    grid,
                    lerString(leitura, "Qual é o tipo de fonte?")
            );
            System.out.println(energia.calcularDisponibilidade());
        }
    }
}
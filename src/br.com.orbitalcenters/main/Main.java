package br.com.orbitalcenters.main;

import br.com.orbitalcenters.entities.EnergiaOrbital;
import br.com.orbitalcenters.entities.EnergiaTerrestre;

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

        if (verificacaoAtivo.toLowerCase() == "sim" || verificacaoAtivo.toLowerCase() == "s"){
            ativo = true;
        } else if (verificacaoAtivo.toLowerCase() == "não" || verificacaoAtivo.toLowerCase() == "n") {
            ativo = false;
        }

        if(tipoDeEnergia == 1){
            String verificacaoEclipse = lerString(leitura, "Está acontecendo um eclipse nesse momento? \nSim \nNão");

            if (verificacaoEclipse.toLowerCase() == "sim" || verificacaoEclipse.toLowerCase() == "s"){
                eclipse = true;
            } else if (verificacaoEclipse.toLowerCase() == "não" || verificacaoEclipse.toLowerCase() == "n") {
                eclipse = false;
            }

            EnergiaOrbital energia = new EnergiaOrbital(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    eclipse,
                    lerDouble(leitura, "Qual o percentual do painel?"),
                    lerDouble(leitura, "Qual a janela de transmissão?")
            );
        } else {
            String verificacaoGrid = lerString(leitura, "O grid de energia dessa fonte está estavel? ");

            if (verificacaoGrid.toLowerCase() == "sim" || verificacaoGrid.toLowerCase() == "s"){
                grid = true;
            } else if (verificacaoGrid.toLowerCase() == "não" || verificacaoGrid.toLowerCase() == "n") {
                grid = false;
            }

            EnergiaTerrestre energia = new EnergiaTerrestre(
                    lerDouble(leitura, "Qual a capacidade instalada?"),
                    lerDouble(leitura, "Qual a eficiência?"),
                    ativo,
                    grid,
                    lerString(leitura, "Qual é o tipo de fonte?")
            );
        }
    }
}
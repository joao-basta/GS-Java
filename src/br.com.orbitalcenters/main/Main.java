package br.com.orbitalcenters.main;

import br.com.orbitalcenters.entities.EnergiaOrbital;
import br.com.orbitalcenters.entities.EnergiaTerrestre;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int tipoDeEnergia = 0;



        System.out.println("Seja bem - vindo ao gerenciador e monitoramento de energia em Data Centers");
        System.out.println("Que tipo de energia será calculada a energia? \n1 - Orbital \n2 - Terrestre");
        tipoDeEnergia = leitura.nextInt();

        if(tipoDeEnergia == 1){
            EnergiaOrbital energia = new EnergiaOrbital(
                    leitura.nextDouble(),
                    leitura.nextDouble(),
                    leitura.nextBoolean(),
                    leitura.nextBoolean(),
                    leitura.nextDouble(),
                    leitura.nextDouble()
            );
        } else {
            //(double capacidadeInstalada, double eficiencia, boolean ativa, boolean gridEstavel, String tipoFonte)
            EnergiaTerrestre energia = new EnergiaTerrestre(
                    leitura.nextDouble(),
                    leitura.nextDouble(),
                    leitura.nextBoolean(),
                    leitura.nextBoolean(),
                    leitura.nextLine()
            );
        }
    }
}
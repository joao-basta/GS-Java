package br.com.orbitalcenters.entities;

public class EnergiaOrbital extends FonteDeEnergia{
    private boolean emEclipse;
    private double percetualPainel;
    private double janelaTransmissao;


    //Metodos
    @Override
    public double calcularDisponibilidade(){
        if (!isAtiva()){
            return 0;
        }
        if (emEclipse){
            return 0;
        }
        return getCapacidadeInstalada() * (percetualPainel / 100) * (getEficiencia() / 100);
    }

    public String tipo(){
        return null;
    }

}
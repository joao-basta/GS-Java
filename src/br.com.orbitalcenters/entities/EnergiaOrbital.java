package br.com.orbitalcenters.entities;

public class EnergiaOrbital extends FonteDeEnergia{
    //private LocalTime janelaInicio;
    //private LocalTime janelaFim;
    private boolean emEclipse;
    private double portenciaKW;
    private double frequenciaTransmissao;

    public boolean isEmEclipse() {
        return emEclipse;
    }

    public void setEmEclipse(boolean emEclipse) {
        this.emEclipse = emEclipse;
    }

    public double getPortenciaKW() {
        return portenciaKW;
    }

    public void setPortenciaKW(double portenciaKW) {
        this.portenciaKW = portenciaKW;
    }

    public double getFrequenciaTransmissao() {
        return frequenciaTransmissao;
    }

    public void setFrequenciaTransmissao(double frequenciaTransmissao) {
        this.frequenciaTransmissao = frequenciaTransmissao;
    }

    //Metodos
    public double calcularDisponibilidade(){
        return null;
    }

    public String tipo(){
        return null;
    }

    public boolean detectarEclipse(){
        return null;
    }
}
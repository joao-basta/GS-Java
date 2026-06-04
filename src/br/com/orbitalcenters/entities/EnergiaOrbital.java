package br.com.orbitalcenters.entities;

public class EnergiaOrbital extends FonteDeEnergia{
    private boolean emEclipse;
    private double percentualPainel;
    private double janelaTransmissao;

    public EnergiaOrbital(boolean emEclipse, double percentualPainel, double janelaTransmissao) {
        this.emEclipse = emEclipse;
        this.percentualPainel = percentualPainel;
        this.janelaTransmissao = janelaTransmissao;
    }

    public EnergiaOrbital(double capacidadeInstalada, double eficiencia, boolean ativa, boolean emEclipse, double percentualPainel, double janelaTransmissao) {
        super(capacidadeInstalada, eficiencia, ativa);
        System.out.println("Defina a capacidade instalada:");
        this.emEclipse = emEclipse;
        System.out.println("Defina a capacidade instalada:");
        this.percentualPainel = percentualPainel;
        System.out.println("Defina a capacidade instalada:");
        this.janelaTransmissao = janelaTransmissao;
    }

    public boolean isEmEclipse() {
        return emEclipse;
    }

    public void setEmEclipse(boolean emEclipse) {
        this.emEclipse = emEclipse;
    }

    public double getPercentualPainel() {
        return percentualPainel;
    }

    public void setPercentualPainel(double percentualPainel) {
        this.percentualPainel = percentualPainel;
    }

    public double getJanelaTransmissao() {
        return janelaTransmissao;
    }

    public void setJanelaTransmissao(double janelaTransmissao) {
        this.janelaTransmissao = janelaTransmissao;
    }

    //Metodos
    @Override
    public String tipo(){return "Orbital";}

    public double calcularDisponibilidade(){
        if (!isAtiva()){
            return 0;
        }
        if (emEclipse){
            return 0;
        }
        return getCapacidadeInstalada() * (percentualPainel / 100) * (getEficiencia() / 100);
    }


}
package br.com.orbitalcenters.entities;

public class EnergiaOrbital extends FonteDeEnergia{
    private boolean emEclipse;
    private double percetualPainel;
    private double janelaTransmissao;

    public EnergiaOrbital(boolean emEclipse, double percetualPainel, double janelaTransmissao) {
        this.emEclipse = emEclipse;
        this.percetualPainel = percetualPainel;
        this.janelaTransmissao = janelaTransmissao;
    }

    public EnergiaOrbital(double capacidadeInstalada, double eficiencia, boolean ativa, boolean emEclipse, double percetualPainel, double janelaTransmissao) {
        super(capacidadeInstalada, eficiencia, ativa);
        this.emEclipse = emEclipse;
        this.percetualPainel = percetualPainel;
        this.janelaTransmissao = janelaTransmissao;
    }

    public boolean isEmEclipse() {
        return emEclipse;
    }

    public void setEmEclipse(boolean emEclipse) {
        this.emEclipse = emEclipse;
    }

    public double getPercetualPainel() {
        return percetualPainel;
    }

    public void setPercetualPainel(double percetualPainel) {
        this.percetualPainel = percetualPainel;
    }

    public double getJanelaTransmissao() {
        return janelaTransmissao;
    }

    public void setJanelaTransmissao(double janelaTransmissao) {
        this.janelaTransmissao = janelaTransmissao;
    }

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


}
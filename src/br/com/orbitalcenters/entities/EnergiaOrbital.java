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
        this.emEclipse = emEclipse;
        this.percentualPainel = percentualPainel;
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

    @Override
    public double calcularDisponibilidade(){
        if (!ativa){
            return 0;
        }
        if (emEclipse){
            return 0;
        }
        return capacidadeInstalada * (percentualPainel / 100) * (eficiencia / 100);
    }


}
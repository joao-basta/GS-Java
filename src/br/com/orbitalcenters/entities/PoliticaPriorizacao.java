package br.com.orbitalcenters.entities;

public class PoliticaPriorizacao {
    private double thresholdMinimoEnergia;
    private double thresholdBloqueioTreinamento;
    private double thresholdDesperdicio;
    private double utilizacaoMinimaEsperada;

    public PoliticaPriorizacao() {
        // valores padrão conforme regras de negócio definidas
        this.thresholdMinimoEnergia = 15.0;
        this.thresholdBloqueioTreinamento = 70.0;
        this.thresholdDesperdicio = 80.0;
        this.utilizacaoMinimaEsperada = 40.0;
    }

    public PoliticaPriorizacao(double thresholdMinimoEnergia, double thresholdBloqueioTreinamento,
                               double thresholdDesperdicio, double utilizacaoMinimaEsperada) {
        this.thresholdMinimoEnergia = thresholdMinimoEnergia;
        this.thresholdBloqueioTreinamento = thresholdBloqueioTreinamento;
        this.thresholdDesperdicio = thresholdDesperdicio;
        this.utilizacaoMinimaEsperada = utilizacaoMinimaEsperada;
    }

    public double getThresholdMinimoEnergia() {
        return thresholdMinimoEnergia;
    }

    public void setThresholdMinimoEnergia(double thresholdMinimoEnergia) {
        this.thresholdMinimoEnergia = thresholdMinimoEnergia;
    }

    public double getThresholdBloqueioTreinamento() {
        return thresholdBloqueioTreinamento;
    }

    public void setThresholdBloqueioTreinamento(double thresholdBloqueioTreinamento) {
        this.thresholdBloqueioTreinamento = thresholdBloqueioTreinamento;
    }

    public double getThresholdDesperdicio() {
        return thresholdDesperdicio;
    }

    public void setThresholdDesperdicio(double thresholdDesperdicio) {
        this.thresholdDesperdicio = thresholdDesperdicio;
    }

    public double getUtilizacaoMinimaEsperada() {
        return utilizacaoMinimaEsperada;
    }

    public void setUtilizacaoMinimaEsperada(double utilizacaoMinimaEsperada) {
        this.utilizacaoMinimaEsperada = utilizacaoMinimaEsperada;
    }
}
package br.com.orbitalcenters.entities;

public class Relatorio {
    private int id;
    private String dataGeracao;
    private double energiaConsumida;
    private double energiaEconomizada;
    private int workloadsProcessados;
    private int workloadsDiferidos;
    private double reducaoCO2Estimada;
    private String resumoLocalProcessamento;

    public Relatorio() {}

    public Relatorio(int id, String dataGeracao, double energiaConsumida, double energiaEconomizada,
                     int workloadsProcessados, int workloadsDiferidos,
                     double reducaoCO2Estimada, String resumoLocalProcessamento) {
        this.id = id;
        this.dataGeracao = dataGeracao;
        this.energiaConsumida = energiaConsumida;
        this.energiaEconomizada = energiaEconomizada;
        this.workloadsProcessados = workloadsProcessados;
        this.workloadsDiferidos = workloadsDiferidos;
        this.reducaoCO2Estimada = reducaoCO2Estimada;
        this.resumoLocalProcessamento = resumoLocalProcessamento;
    }

    public void exibir() {
        System.out.println("=== RELATÓRIO ORBITAL CENTERS ===");
        System.out.println("Data: " + dataGeracao);
        System.out.println("Energia consumida: " + energiaConsumida + " kWh");
        System.out.println("Energia economizada: " + energiaEconomizada + " kWh");
        System.out.println("Workloads processados: " + workloadsProcessados);
        System.out.println("Workloads diferidos: " + workloadsDiferidos);
        System.out.println("Redução de CO2 estimada: " + reducaoCO2Estimada + " kg");
        System.out.println("Processamento: " + resumoLocalProcessamento);
        System.out.println("=================================");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public double getEnergiaConsumida() {
        return energiaConsumida;
    }

    public void setEnergiaConsumida(double energiaConsumida) {
        this.energiaConsumida = energiaConsumida;
    }

    public double getEnergiaEconomizada() {
        return energiaEconomizada;
    }

    public void setEnergiaEconomizada(double energiaEconomizada) {
        this.energiaEconomizada = energiaEconomizada;
    }

    public int getWorkloadsProcessados() {
        return workloadsProcessados;
    }

    public void setWorkloadsProcessados(int workloadsProcessados) {
        this.workloadsProcessados = workloadsProcessados;
    }

    public int getWorkloadsDiferidos() {
        return workloadsDiferidos;
    }

    public void setWorkloadsDiferidos(int workloadsDiferidos) {
        this.workloadsDiferidos = workloadsDiferidos;
    }

    public double getReducaoCO2Estimada() {
        return reducaoCO2Estimada;
    }

    public void setReducaoCO2Estimada(double reducaoCO2Estimada) {
        this.reducaoCO2Estimada = reducaoCO2Estimada;
    }

    public String getResumoLocalProcessamento() {
        return resumoLocalProcessamento;
    }

    public void setResumoLocalProcessamento(String resumoLocalProcessamento) {
        this.resumoLocalProcessamento = resumoLocalProcessamento;
    }
}
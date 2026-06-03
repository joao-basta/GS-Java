package br.com.orbitalcenters.entities;

public abstract class FonteDeEnergia{
    private int id;
    private double capacidadeInstalada;
    private double eficiencia;
    private boolean ativa;

    public FonteDeEnergia() {
    }

    public FonteDeEnergia(double capacidadeInstalada, double eficiencia, boolean ativa) {
        System.out.println("Defina a capacidade instalada:");
        this.capacidadeInstalada = capacidadeInstalada;
        System.out.println("Defina a capacidade instalada:");
        this.eficiencia = eficiencia;
        System.out.println("Defina a capacidade instalada:");
        this.ativa = ativa;
    }

    public abstract String tipo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapacidadeInstalada() {
        return capacidadeInstalada;
    }

    public void setCapacidadeInstalada(double capacidadeInstalada) {
        this.capacidadeInstalada = capacidadeInstalada;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public abstract double calcularDisponibilidade();

}
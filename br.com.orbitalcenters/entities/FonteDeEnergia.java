public abstract class FonteDeEnergia{
    private double capacidade;
    private int eficiencia;

    public FonteDeEnergia() {
    }

    public FonteDeEnergia(double capacidade, int eficiecia) {
        this.capacidade = capacidade;
        this.eficiencia = eficiecia;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public int getEficiecia() {
        return eficiencia;
    }

    public void setEficiecia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

}
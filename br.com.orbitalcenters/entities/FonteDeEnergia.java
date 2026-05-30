public abstract class FonteDeEnergia{
    private double capacidade;
    private int eficiecia;

    public FonteDeEnergia() {
    }

    public FonteDeEnergia(double capacidade, int eficiecia) {
        this.capacidade = capacidade;
        this.eficiecia = eficiecia;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public int getEficiecia() {
        return eficiecia;
    }

    public void setEficiecia(int eficiecia) {
        this.eficiecia = eficiecia;
    }

}
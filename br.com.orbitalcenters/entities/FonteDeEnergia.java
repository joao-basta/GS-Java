public abstract class FonteDeEnergia{
    private int id;
    private double capacidadeinstalada;
    private double eficiencia;
    private boolean ativa;

    public double getCapacidadeinstalada() {
        return capacidadeinstalada;
    }

    public void setCapacidadeinstalada(double capacidadeinstalada) {
        this.capacidadeinstalada = capacidadeinstalada;
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

    public double calcularDisponibilidade(){
        return null;
    }

    public String tipo(){
        return null;
    }


}
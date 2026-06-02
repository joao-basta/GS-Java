package br.com.orbitalcenters.entities;
import br.com.orbitalcenters.entities.enums.TipoEnergia;

public abstract class FonteDeEnergia{
    private int id;
    private double capacidadeInstalada; //trocado para camelCase
    private double eficiencia;
    private boolean ativa;

    public FonteDeEnergia (){
    }

    public FonteDeEnergia(int id, double capacidadeInstalada, double eficiencia, boolean ativa){
        this.id = id;
        this.capacidadeInstalada = capacidadeInstalada;
        this.eficiencia = eficiencia;
        this.ativa = ativa;

    }

    public double getCapacidadeInstalada() {
        return capacidadeInstalada;
    }

    public void setCapacidadeInstalada(double capacidadeinstalada) {
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

    public double calcularDisponibilidade(){
        return null;
    }

    public String tipo(){
        return null;
    }


}
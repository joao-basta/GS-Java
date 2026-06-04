package br.com.orbitalcenters.entities;

public class DataCenterRemoto {
    private int id;
    private String nome;
    private double latitude;
    private double longitude;
    private double capacidadeInstalada;
    private double consumoAtual;
    private FonteDeEnergia fonteEnergia;

    public DataCenterRemoto() {}

    public DataCenterRemoto(int id, String nome, double latitude, double longitude,
                            double capacidadeInstalada, double consumoAtual, FonteDeEnergia fonteEnergia) {
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacidadeInstalada = capacidadeInstalada;
        this.consumoAtual = consumoAtual;
        this.fonteEnergia = fonteEnergia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCapacidadeInstalada() {
        return capacidadeInstalada;
    }

    public void setCapacidadeInstalada(double capacidadeInstalada) {
        this.capacidadeInstalada = capacidadeInstalada;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public FonteDeEnergia getFonteEnergia() {
        return fonteEnergia;
    }

    public void setFonteEnergia(FonteDeEnergia fonteEnergia) {
        this.fonteEnergia = fonteEnergia;
    }
}
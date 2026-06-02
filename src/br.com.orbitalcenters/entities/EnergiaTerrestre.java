package br.com.orbitalcenters.entities;

public class EnergiaTerrestre extends FonteDeEnergia{
    private boolean gridEstavel;
    private String tipoFonte;

    public EnergiaTerrestre(String tipoFonte, boolean gridEstavel) {
        this.tipoFonte = tipoFonte;
        this.gridEstavel = gridEstavel;
    }

    public EnergiaTerrestre(int id, double capacidadeInstalada, double eficiencia, boolean ativa, boolean gridEstavel, String tipoFonte) {
        super(id, capacidadeInstalada, eficiencia, ativa);
        this.gridEstavel = gridEstavel;
        this.tipoFonte = tipoFonte;
    }

    public boolean isGridEstavel() {
        return gridEstavel;
    }

    public void setGridEstavel(boolean gridEstavel) {
        this.gridEstavel = gridEstavel;
    }

    public String getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(String tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    //Metodos
    @Override
    public double calcularDisponibilidade(){
        if(!isAtiva()){
            return 0;
        }
        if(!isGridEstavel()){
            return getCapacidadeInstalada() * 0.4;
        } else {
            return getCapacidadeInstalada() * (getEficiencia() / 100.0);
        }

    }

    public String tipo(){
        return null;
    }

    public String getCustoEstimado(){
        return null;
    }
}
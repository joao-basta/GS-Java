package br.com.orbitalcenters.entities;

public class EnergiaTerrestre extends FonteDeEnergia{
    private boolean gridEstavel;
    private String tipoFonte;

    public EnergiaTerrestre(boolean gridEstavel, String tipoFonte) {
        this.gridEstavel = gridEstavel;
        this.tipoFonte = tipoFonte;
    }

    public EnergiaTerrestre(double capacidadeInstalada, double eficiencia, boolean ativa, boolean gridEstavel, String tipoFonte) {
        super(capacidadeInstalada, eficiencia, ativa);
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
    public String tipo(){return "Terrestre";}

    @Override
    public double calcularDisponibilidade(){
        System.out.println(ativa);
        if(!ativa){
            return 0;
        }
        if(!isGridEstavel()){
            return capacidadeInstalada * 0.4;
        } else {
            return capacidadeInstalada * (eficiencia / 100.0);
        }

    }

    public String getCustoEstimado(){
        return null;
    }
}
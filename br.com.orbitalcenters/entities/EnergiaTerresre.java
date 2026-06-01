public class EnergiaTerrestre extends FonteDeEnergia{
    private String fornecedora;
    private double tensaoRede;
    private double limitePotencia;
    private double tarifaKwh;

    public String getFornecedora() {
        return fornecedora;
    }

    public void setFornecedora(String fornecedora) {
        this.fornecedora = fornecedora;
    }

    public double getTensaoRede() {
        return tensaoRede;
    }

    public void setTensaoRede(double tensaoRede) {
        this.tensaoRede = tensaoRede;
    }

    public double getLimitePotencia() {
        return limitePotencia;
    }

    public void setLimitePotencia(double limitePotencia) {
        this.limitePotencia = limitePotencia;
    }

    public double getTarifaKwh() {
        return tarifaKwh;
    }

    public void setTarifaKwh(double tarifaKwh) {
        this.tarifaKwh = tarifaKwh;
    }


    //Metodos
    public double calcularDisponibilidade(){
        return null;
    }

    public String tipo(){
        return null;
    }

    public double getCustoEstimado(){
        return null;
    }
}
package br.com.orbitalcenters.entities;

import br.com.orbitalcenters.entities.enums.NivelCriticidade;
import br.com.orbitalcenters.entities.enums.TipoWorkload;

public class WorkloadIA {
    private int id;
    private String nome;
    private TipoWorkload tipo;
    private NivelCriticidade criticidade;
    private double consumoEstimadoEmWatts;
    private double duracaoEstimadaEmHoras;
    private String deadline;

    public WorkloadIA(){}

    public WorkloadIA(int id, String nome, TipoWorkload tipo, NivelCriticidade criticidade,
                      double consumoEstimadoEmWatts, double duracaoEstimadaEmHoras, String deadline) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.criticidade = criticidade;
        this.consumoEstimadoEmWatts = consumoEstimadoEmWatts;
        this.duracaoEstimadaEmHoras = duracaoEstimadaEmHoras;
        this.deadline = deadline;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public TipoWorkload getTipo() {return tipo;}
    public void setTipo(TipoWorkload tipo) {this.tipo = tipo;}
    public NivelCriticidade getCriticidade() {return criticidade;}
    public void setCriticidade(NivelCriticidade criticidade) {this.criticidade = criticidade;}
    public double getConsumoEstimadoEmWatts() {return consumoEstimadoEmWatts;}
    public void setConsumoEstimadoEmWatts(double consumoEstimadoEmWatts)
    {this.consumoEstimadoEmWatts = consumoEstimadoEmWatts;}

    public double getDuracaoEstimadaEmHoras() {return duracaoEstimadaEmHoras;}
    public void setDuracaoEstimadaEmHoras(double duracaoEstimadaEmHoras)
    {this.duracaoEstimadaEmHoras = duracaoEstimadaEmHoras;}

    public String getDeadline() {return deadline;}
    public void setDeadline(String deadline) {this.deadline = deadline;}
}
package br.com.orbitalcenters.entities;

import br.com.orbitalcenters.entities.enums.LocalProcessamento;
import java.util.ArrayList;
import java.util.List;

public class Satelite {
    private int id;
    private String nome;
    private double capacidadeDeProcessamento;
    private EnergiaOrbital fonteEnergia;
    private List<WorkloadIA> filaDeTarefas;

    public Satelite() {
        this.filaDeTarefas = new ArrayList<>();
    }

    public Satelite(int id, String nome, double capacidadeDeProcessamento,
                    EnergiaOrbital fonteEnergia, List<WorkloadIA> filaDeTarefas) {
        this.id = id;
        this.nome = nome;
        this.capacidadeDeProcessamento = capacidadeDeProcessamento;
        this.fonteEnergia = fonteEnergia;
        this.filaDeTarefas = filaDeTarefas;
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

    public double getCapacidadeDeProcessamento() {
        return capacidadeDeProcessamento;
    }

    public void setCapacidadeDeProcessamento(double capacidadeDeProcessamento) {
        this.capacidadeDeProcessamento = capacidadeDeProcessamento;
    }

    public EnergiaOrbital getFonteEnergia() {
        return fonteEnergia;
    }

    public void setFonteEnergia(EnergiaOrbital fonteEnergia) {
        this.fonteEnergia = fonteEnergia;
    }

    public List<WorkloadIA> getFilaDeTarefas() {
        return filaDeTarefas;
    }

    public void setFilaDeTarefas(List<WorkloadIA> filaDeTarefas) {
        this.filaDeTarefas = filaDeTarefas;
    }
}
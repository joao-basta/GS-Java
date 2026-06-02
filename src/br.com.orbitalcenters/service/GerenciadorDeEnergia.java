package br.com.orbitalcenters.service;

import br.com.orbitalcenters.entities.*;
import br.com.orbitalcenters.entities.enums.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeEnergia {
    private WorkloadIA workload;
    private FonteDeEnergia fonte;
    private PoliticaPriorizacao priorizacao;

    public GerenciadorDeEnergia(PoliticaPriorizacao priorizacao) {
        this.priorizacao = new PoliticaPriorizacao();
    }

    public GerenciadorDeEnergia(WorkloadIA workload, FonteDeEnergia fonte, PoliticaPriorizacao priorizacao) {
        this.workload = workload;
        this.fonte = fonte;
        this.priorizacao = priorizacao;
    }

}
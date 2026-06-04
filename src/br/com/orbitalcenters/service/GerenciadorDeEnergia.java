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
    public List<WorkloadIA> priorizar(List<WorkloadIA> fila, double energiaDisponivel){
        List<WorkloadIA> selecionados = new ArrayList<>();
        double energiaRestante = energiaDisponivel;

        for (WorkloadIA w : fila) {
            if (w.getCriticidade() == NivelCriticidade.CRITICO) {
                selecionados.add(w);
                energiaRestante -= w.getConsumoEstimadoEmWatts();
            }
        }

        for (WorkloadIA w : fila) {
            if (w.getCriticidade() != NivelCriticidade.CRITICO) {
                if (energiaRestante >= w.getConsumoEstimadoEmWatts()) {
                    selecionados.add(w);
                    energiaRestante -= w.getConsumoEstimadoEmWatts();
                }
            }
        }

        System.out.println("[PRIORIZAÇÃO] " + selecionados.size() + " workloads selecionados de " + fila.size());
        return selecionados;
    }

}

package com.ruthnazario.marmoraria.observer;

import com.ruthnazario.marmoraria.model.Orcamento;

public class NotificadorEmail implements OrcamentoObserver {
    @Override
    public void aoGerarOrcamento(Orcamento o) {
        System.out.printf("[E-mail] Orçamento de %s (%s, %.2f m²) enviado: R$ %.2f.%n",
            o.getCliente(), o.getPedra().nome(), o.getAreaM2(), o.getValorFinal());
    }
}

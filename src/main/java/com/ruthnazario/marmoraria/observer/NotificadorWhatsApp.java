package com.ruthnazario.marmoraria.observer;

import com.ruthnazario.marmoraria.model.Orcamento;

public class NotificadorWhatsApp implements OrcamentoObserver {
    @Override
    public void aoGerarOrcamento(Orcamento o) {
        System.out.printf("[WhatsApp] Olá, %s! Seu orçamento ficou em R$ %.2f.%n", o.getCliente(), o.getValorFinal());
    }
}

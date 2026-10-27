package com.ruthnazario.marmoraria.observer;

import com.ruthnazario.marmoraria.model.Orcamento;

/** Padrão OBSERVER: quem quiser ser avisado de um novo orçamento implementa esta interface. */
public interface OrcamentoObserver {
    void aoGerarOrcamento(Orcamento orcamento);
}

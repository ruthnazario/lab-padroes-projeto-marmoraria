package com.ruthnazario.marmoraria.desconto;

import com.ruthnazario.marmoraria.model.Orcamento;

/** Padrão CHAIN OF RESPONSIBILITY: cada elo aplica seu desconto e passa adiante. */
public abstract class DescontoHandler {

    private DescontoHandler proximo;

    public DescontoHandler setProximo(DescontoHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public double aplicar(Orcamento orcamento, double valorAtual) {
        double novoValor = calcular(orcamento, valorAtual);
        return proximo != null ? proximo.aplicar(orcamento, novoValor) : novoValor;
    }

    protected abstract double calcular(Orcamento orcamento, double valorAtual);
}

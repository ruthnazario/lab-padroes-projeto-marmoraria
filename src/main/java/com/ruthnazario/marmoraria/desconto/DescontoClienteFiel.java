package com.ruthnazario.marmoraria.desconto;

import com.ruthnazario.marmoraria.model.Orcamento;

/** 10% para clientes fiéis. */
public class DescontoClienteFiel extends DescontoHandler {
    @Override
    protected double calcular(Orcamento o, double valor) {
        return o.isClienteFiel() ? valor * 0.90 : valor;
    }
}

package com.ruthnazario.marmoraria.desconto;

import com.ruthnazario.marmoraria.model.Orcamento;

/** 3% para pagamento à vista. */
public class DescontoAVista extends DescontoHandler {
    @Override
    protected double calcular(Orcamento o, double valor) {
        return o.isPagamentoAVista() ? valor * 0.97 : valor;
    }
}

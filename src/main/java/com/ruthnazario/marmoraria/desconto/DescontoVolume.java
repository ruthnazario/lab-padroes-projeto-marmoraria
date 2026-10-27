package com.ruthnazario.marmoraria.desconto;

import com.ruthnazario.marmoraria.model.Orcamento;

/** 5% para obras com 10 m² ou mais. */
public class DescontoVolume extends DescontoHandler {
    @Override
    protected double calcular(Orcamento o, double valor) {
        return o.getAreaM2() >= 10 ? valor * 0.95 : valor;
    }
}

package com.ruthnazario.marmoraria.strategy;

public class AcabamentoEscovado implements Acabamento {
    @Override public String getNome() { return "Escovado"; }
    @Override public double adicionalPorM2() { return 110.00; }
}

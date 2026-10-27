package com.ruthnazario.marmoraria.strategy;

public class AcabamentoFlameado implements Acabamento {
    @Override public String getNome() { return "Flameado"; }
    @Override public double adicionalPorM2() { return 60.00; }
}

package com.ruthnazario.marmoraria.strategy;

public class AcabamentoPolido implements Acabamento {
    @Override public String getNome() { return "Polido"; }
    @Override public double adicionalPorM2() { return 80.00; }
}

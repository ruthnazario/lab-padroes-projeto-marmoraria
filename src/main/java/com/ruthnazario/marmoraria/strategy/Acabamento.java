package com.ruthnazario.marmoraria.strategy;

/** Padrão STRATEGY: cada acabamento define seu adicional por m². */
public interface Acabamento {
    String getNome();
    double adicionalPorM2();
}

package com.ruthnazario.marmoraria.factory;

import com.ruthnazario.marmoraria.model.Pedra;
import com.ruthnazario.marmoraria.model.TipoPedra;

/** Padrão FACTORY METHOD: centraliza a criação das pedras. */
public class PedraFactory {

    private PedraFactory() { }

    public static Pedra criar(TipoPedra tipo) {
        return switch (tipo) {
            case MARMORE_CARRARA -> new Pedra("Mármore Carrara", 950.00);
            case GRANITO_PRETO_SAO_GABRIEL -> new Pedra("Granito Preto São Gabriel", 520.00);
            case GRANITO_VERDE_UBATUBA -> new Pedra("Granito Verde Ubatuba", 480.00);
            case GRANITO_CINZA_ANDORINHA -> new Pedra("Granito Cinza Andorinha", 350.00);
        };
    }
}

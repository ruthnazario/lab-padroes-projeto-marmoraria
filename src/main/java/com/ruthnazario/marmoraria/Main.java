package com.ruthnazario.marmoraria;

import com.ruthnazario.marmoraria.facade.OrcamentoFacade;
import com.ruthnazario.marmoraria.model.TipoPedra;
import com.ruthnazario.marmoraria.observer.NotificadorEmail;
import com.ruthnazario.marmoraria.observer.NotificadorWhatsApp;
import com.ruthnazario.marmoraria.repository.OrcamentoRepository;
import com.ruthnazario.marmoraria.strategy.AcabamentoEscovado;
import com.ruthnazario.marmoraria.strategy.AcabamentoFlameado;
import com.ruthnazario.marmoraria.strategy.AcabamentoPolido;

public class Main {

    public static void main(String[] args) {
        OrcamentoFacade facade = new OrcamentoFacade();
        facade.adicionarObserver(new NotificadorEmail());
        facade.adicionarObserver(new NotificadorWhatsApp());

        System.out.println("=== Orçamento 1: bancada de cozinha ===");
        facade.gerarOrcamento("Maria Silva", TipoPedra.GRANITO_PRETO_SAO_GABRIEL,
            new AcabamentoPolido(), 4.5, false, true);

        System.out.println("\n=== Orçamento 2: obra grande, cliente fiel ===");
        facade.gerarOrcamento("Construtora Alfa", TipoPedra.MARMORE_CARRARA,
            new AcabamentoEscovado(), 12.0, true, true);

        System.out.println("\n=== Orçamento 3: área externa ===");
        facade.gerarOrcamento("João Pereira", TipoPedra.GRANITO_CINZA_ANDORINHA,
            new AcabamentoFlameado(), 8.0, false, false);

        System.out.println("\n=== Histórico (Singleton) ===");
        OrcamentoRepository.getInstancia().listar().forEach(System.out::println);
    }
}

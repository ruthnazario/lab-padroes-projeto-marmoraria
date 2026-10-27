package com.ruthnazario.marmoraria.repository;

import com.ruthnazario.marmoraria.model.Orcamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Padrão SINGLETON: uma única instância guarda todos os orçamentos em memória. */
public class OrcamentoRepository {

    private static OrcamentoRepository instancia;
    private final List<Orcamento> orcamentos = new ArrayList<>();

    private OrcamentoRepository() { }

    public static synchronized OrcamentoRepository getInstancia() {
        if (instancia == null) {
            instancia = new OrcamentoRepository();
        }
        return instancia;
    }

    public void salvar(Orcamento orcamento) { orcamentos.add(orcamento); }

    public List<Orcamento> listar() { return Collections.unmodifiableList(orcamentos); }
}

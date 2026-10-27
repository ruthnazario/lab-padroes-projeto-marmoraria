package com.ruthnazario.marmoraria.facade;

import com.ruthnazario.marmoraria.desconto.DescontoAVista;
import com.ruthnazario.marmoraria.desconto.DescontoClienteFiel;
import com.ruthnazario.marmoraria.desconto.DescontoHandler;
import com.ruthnazario.marmoraria.desconto.DescontoVolume;
import com.ruthnazario.marmoraria.factory.PedraFactory;
import com.ruthnazario.marmoraria.model.Orcamento;
import com.ruthnazario.marmoraria.model.TipoPedra;
import com.ruthnazario.marmoraria.observer.OrcamentoObserver;
import com.ruthnazario.marmoraria.repository.OrcamentoRepository;
import com.ruthnazario.marmoraria.strategy.Acabamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Padrão FACADE: interface simples que esconde Factory, Builder, Strategy,
 * Chain of Responsibility, Observer e Singleton.
 */
public class OrcamentoFacade {

    private final List<OrcamentoObserver> observers = new ArrayList<>();
    private final DescontoHandler cadeiaDescontos;

    public OrcamentoFacade() {
        DescontoHandler volume = new DescontoVolume();
        volume.setProximo(new DescontoClienteFiel()).setProximo(new DescontoAVista());
        this.cadeiaDescontos = volume;
    }

    public void adicionarObserver(OrcamentoObserver observer) { observers.add(observer); }

    public Orcamento gerarOrcamento(String cliente, TipoPedra tipo, Acabamento acabamento,
                                    double areaM2, boolean clienteFiel, boolean aVista) {
        Orcamento orcamento = new Orcamento.Builder()
            .cliente(cliente)
            .pedra(PedraFactory.criar(tipo))
            .acabamento(acabamento)
            .areaM2(areaM2)
            .clienteFiel(clienteFiel)
            .pagamentoAVista(aVista)
            .build();

        double bruto = (orcamento.getPedra().precoM2() + acabamento.adicionalPorM2()) * areaM2;
        orcamento.setValorBruto(bruto);
        orcamento.setValorFinal(cadeiaDescontos.aplicar(orcamento, bruto));

        OrcamentoRepository.getInstancia().salvar(orcamento);
        observers.forEach(o -> o.aoGerarOrcamento(orcamento));
        return orcamento;
    }
}

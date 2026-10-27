package com.ruthnazario.marmoraria.model;

import com.ruthnazario.marmoraria.strategy.Acabamento;

/** Orçamento criado com o padrão BUILDER. */
public class Orcamento {

    private final String cliente;
    private final Pedra pedra;
    private final Acabamento acabamento;
    private final double areaM2;
    private final boolean clienteFiel;
    private final boolean pagamentoAVista;
    private double valorBruto;
    private double valorFinal;

    private Orcamento(Builder b) {
        this.cliente = b.cliente;
        this.pedra = b.pedra;
        this.acabamento = b.acabamento;
        this.areaM2 = b.areaM2;
        this.clienteFiel = b.clienteFiel;
        this.pagamentoAVista = b.pagamentoAVista;
    }

    public String getCliente() { return cliente; }
    public Pedra getPedra() { return pedra; }
    public Acabamento getAcabamento() { return acabamento; }
    public double getAreaM2() { return areaM2; }
    public boolean isClienteFiel() { return clienteFiel; }
    public boolean isPagamentoAVista() { return pagamentoAVista; }
    public double getValorBruto() { return valorBruto; }
    public double getValorFinal() { return valorFinal; }
    public void setValorBruto(double valorBruto) { this.valorBruto = valorBruto; }
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }

    @Override
    public String toString() {
        return String.format(
            "Orçamento{cliente='%s', pedra=%s, acabamento=%s, área=%.2f m², bruto=R$ %.2f, final=R$ %.2f}",
            cliente, pedra.nome(), acabamento.getNome(), areaM2, valorBruto, valorFinal);
    }

    public static class Builder {
        private String cliente;
        private Pedra pedra;
        private Acabamento acabamento;
        private double areaM2;
        private boolean clienteFiel;
        private boolean pagamentoAVista;

        public Builder cliente(String cliente) { this.cliente = cliente; return this; }
        public Builder pedra(Pedra pedra) { this.pedra = pedra; return this; }
        public Builder acabamento(Acabamento acabamento) { this.acabamento = acabamento; return this; }
        public Builder areaM2(double areaM2) { this.areaM2 = areaM2; return this; }
        public Builder clienteFiel(boolean clienteFiel) { this.clienteFiel = clienteFiel; return this; }
        public Builder pagamentoAVista(boolean pagamentoAVista) { this.pagamentoAVista = pagamentoAVista; return this; }

        public Orcamento build() {
            if (cliente == null || cliente.isBlank()) throw new IllegalArgumentException("Cliente é obrigatório");
            if (pedra == null) throw new IllegalArgumentException("Pedra é obrigatória");
            if (acabamento == null) throw new IllegalArgumentException("Acabamento é obrigatório");
            if (areaM2 <= 0) throw new IllegalArgumentException("Área deve ser maior que zero");
            return new Orcamento(this);
        }
    }
}

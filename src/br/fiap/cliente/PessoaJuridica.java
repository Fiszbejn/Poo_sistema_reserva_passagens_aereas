package br.fiap.cliente;

import br.fiap.desconto.Desconto;

import java.util.Random;

public class PessoaJuridica extends Cliente implements Desconto {
    private String cnpj;

    public PessoaJuridica(String nome, String contato, String cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        Random random = new Random();
        double valorDescontado;
        double percentualDesconto = random.nextDouble(0.90, 0.99);
        valorDescontado = valorOriginal * percentualDesconto;
        return valorDescontado;
    }

    @Override
    public String getIdentificador() {
        return this.cnpj;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "CNPJ: " + this.cnpj + "\n";
        return super.toString() + aux;
    }
}

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
        double valorComDesconto;
        valorComDesconto = valorOriginal - (valorOriginal * (random.nextInt(1, 10)/100));
        return valorComDesconto;
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

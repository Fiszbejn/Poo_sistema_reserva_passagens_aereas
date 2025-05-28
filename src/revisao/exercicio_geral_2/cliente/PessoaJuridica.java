package revisao.exercicio_geral_2.cliente;

import revisao.exercicio_geral_2.desconto.Desconto;

import java.util.Random;

public class PessoaJuridica extends Cliente implements Desconto {
    private String cnpj;

    public PessoaJuridica(String nome, String contato, String cpf) {
        super(nome, contato);
        this.cnpj = cpf;
    }

    @Override
    public String getIdentificador() {
        return cnpj;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        Random rd = new Random();
        double valorFinal;
        double porcentagem = rd.nextDouble(0.90, 0.99);
        valorFinal = valorOriginal * porcentagem;
        return valorFinal;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "CNPJ: " + cnpj + "\n";
        return super.toString() + aux;
    }
}

package br.fiap.reserva;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.desconto.Desconto;

import java.text.DecimalFormat;

public class Reserva {
    private Cliente cliente;
    private double valorOriginal;
    private double valorFinal;
    private Assento assento;

    public Reserva(Cliente cliente, double valorOriginal, Assento assento) {
        this.cliente = cliente;
        this.valorOriginal = valorOriginal;
        this.assento = assento;
        if(cliente instanceof Desconto) {
            this.valorFinal = ((PessoaJuridica) cliente).aplicarDesconto(valorOriginal);
        }else {
            this.valorFinal = valorOriginal;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Assento getAssento() {
        return assento;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("##0.00");
        String aux = "";
        aux +=  cliente.toString();
        aux +=  "Valor Final: R$" + df.format(this.valorFinal) + "\n";
        aux +=  "Assento: " + this.assento.getNumero() + "\n";
        aux += "\n";
        return aux;
    }
}

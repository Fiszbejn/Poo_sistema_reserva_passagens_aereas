package br.fiap.reserva;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.desconto.Desconto;

public class Reserva {
    private Cliente cliente;
    private double valorOriginal;
    private double valorFinal;
    private Assento assento;

    public Reserva(Cliente cliente, double valorOriginal, Assento assento) {
        this.cliente = cliente;
        this.valorOriginal = valorOriginal;
        this.assento = assento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString() {
        String aux = "";
        aux +=  cliente.toString();
        aux +=  "Valor Original: " + this.valorOriginal + "\n";
        if(cliente instanceof PessoaJuridica) {
            ((Desconto)cliente).aplicarDesconto(valorOriginal);
            aux +=  "Valor com desconto: " + this.valorFinal + "\n";
        }
        aux +=  "Assento: " + this.assento.getNumero() + "\n";
        return aux;
    }
}

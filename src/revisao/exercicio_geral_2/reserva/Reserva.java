package revisao.exercicio_geral_2.reserva;

import revisao.exercicio_geral_2.assento.Assento;
import revisao.exercicio_geral_2.cliente.Cliente;
import revisao.exercicio_geral_2.cliente.PessoaJuridica;
import revisao.exercicio_geral_2.desconto.Desconto;

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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        aux += cliente.toString();
        aux += assento.toString();
        aux += "Valor Final: R$" + df.format(valorFinal) + "\n";
        aux += "\n";
        return aux;
    }
}

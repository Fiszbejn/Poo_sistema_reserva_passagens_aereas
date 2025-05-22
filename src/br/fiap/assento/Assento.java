package br.fiap.assento;

public class Assento {
    private int numero;
    private boolean disponivel;

    public Assento(int numero) {
        this.numero = numero;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Número: " + this.numero + "\n";
        if(this.disponivel) {
            aux += "Status: Disponível";
        }else{
            aux += "Status: Ocupado";
        }
        return aux;
    }
}

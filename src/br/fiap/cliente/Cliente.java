package br.fiap.cliente;

public abstract class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public abstract String getIdentificador();

    public String toString() {
        String aux = "";
        aux += "Nome: " + nome + "\n";
        aux += "Contato: " + contato + "\n";
        return aux;
    }
}

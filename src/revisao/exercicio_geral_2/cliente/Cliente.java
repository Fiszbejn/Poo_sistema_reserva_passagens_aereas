package revisao.exercicio_geral_2.cliente;

public abstract class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public abstract String getIdentificador();

    @Override
    public String toString() {
        String aux = "";
        aux += "Nome: " + nome + "\n";
        aux += "Contato: " + contato + "\n";
        return aux;
    }
}

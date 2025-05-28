package revisao.exercicio_geral_2.cliente;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String contato, String cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "CPF: " + cpf + "\n";
        return super.toString() + aux;
    }
}

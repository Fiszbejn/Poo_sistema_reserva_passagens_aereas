package revisao.exercicio_geral_2.controle;

import revisao.exercicio_geral_2.assento.Assento;
import revisao.exercicio_geral_2.cliente.Cliente;
import revisao.exercicio_geral_2.cliente.PessoaFisica;
import revisao.exercicio_geral_2.cliente.PessoaJuridica;
import revisao.exercicio_geral_2.reserva.Reserva;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class Controle {
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.menu();
    }

    private static ArrayList<Assento> assentos = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            assentos.add(new Assento(i + 1));
        }
    }

    public void menu() {
        int opcao;
        while(true) {
            try {
                opcao = Integer.parseInt(showInputDialog("SISTEMA DE RESERVA DE PASSAGEM AÉREA\n1. Reservar\n2. Pesquisar reserva\n3. Cancelar reserva\n4. Finalizar"));
                switch (opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelarReserva();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Digite um número positivo!");
                        return;
                }
            }catch (NumberFormatException e) {
                showMessageDialog(null, "Digite um Número inteiro positivo! - Erro(" + e + ")");
            }

        }
    }

    private void cancelarReserva() {
        String identificador = showInputDialog("Digite o CPF/CNPJ a ter a reserva removida:");
        Reserva resultado = null;
        for (Reserva r : reservas) {
            if(r.getCliente().getIdentificador().equalsIgnoreCase(identificador)) {
                resultado = r;
                reservas.remove(r);
                r.getAssento().setDisponivel(true);
                showMessageDialog(null, "Reserva removida com sucesso!");
                return;
            }
        }
        if(resultado == null) {
            showMessageDialog(null, "Reserva não encontrada!");
        }
    }

    private void pesquisar() {
        String pesquisa = "";
        String identificador = showInputDialog("Digite o CPF ou CNPJ a ser pesquisado:");
        for (Reserva r : reservas) {
            if(r.getCliente().getIdentificador().equalsIgnoreCase(identificador)) {
                pesquisa = r.toString();
            }
        }
        if(pesquisa == "") {
            showMessageDialog(null, "Não possui nenhuma reserva com esse CPF/CNPJ!");
        }else {
            showMessageDialog(null, pesquisa);
        }
    }

    private void reservar() {
        Random rd = new Random();

        String nome = showInputDialog("Digite seu nome:");
        String contato = showInputDialog("Digite seu contato:");
        String tipoIdentificador = showInputDialog("Digite seu tipo de identificador: (CPF - F /CNPJ - J)");
        String identificador;
        while(!(tipoIdentificador.equalsIgnoreCase("f")) && !(tipoIdentificador.equalsIgnoreCase("j"))){
            tipoIdentificador = showInputDialog("Digite seu tipo de identificador corretamente: (CPF - F /CNPJ - J)");
        }
        if(tipoIdentificador.equalsIgnoreCase("f")) {
            identificador = showInputDialog("Digite seu CPF:");
        }else {
            identificador = showInputDialog("Digite seu CPNJ:");
        }

        //Verifica se a pessoa já tem reserva
        for (Reserva r : reservas) {
            if(r.getCliente().getIdentificador().equalsIgnoreCase(identificador)) {
                showMessageDialog(null, "Você já possui uma reserva!" , "Aviso", WARNING_MESSAGE);
            }
        }

        //carrega um valor aleatório
        double valorOriginal = 10000;

        //mostra assentos disponiveis e pergunta ao usuario o numero do assento, e verifica se digitou um número de um assento válido
        String assentosDisp = "";
        for (Assento a : assentos) {
            if(a.isDisponivel()) {
                assentosDisp += a.getNumero() + " ";
            }
        }

        int numAssento = Integer.parseInt(showInputDialog("Digite um dos assentos disponíveis:\n" + assentosDisp));
        Assento assento = assentos.get(numAssento - 1);
        if(!assento.isDisponivel()) {
            showMessageDialog(null, "Assento já escolhido! Selecione outro assento.");
            return;
        }

        //criando o objeto cliente
        if(tipoIdentificador.equalsIgnoreCase("f")){
            reservas.add(new Reserva(new PessoaFisica(nome, contato, identificador), valorOriginal, assento));
        }else {
            reservas.add(new Reserva(new PessoaJuridica(nome, contato, identificador), valorOriginal, assento));
        }
        assento.setDisponivel(false);

    }
}

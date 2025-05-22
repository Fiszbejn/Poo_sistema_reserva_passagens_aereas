package br.fiap.controle;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class Controle {

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Assento> assentos = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    static {
        Random random = new Random();
        clientes.add(new PessoaFisica("Davi", "11943497719", "1"));
        clientes.add(new PessoaJuridica("Vitor", "11951985195", "2"));
        clientes.add(new PessoaFisica("Nicolas", "11918585810", "3"));
        for (int i = 0; i < 10; i++) {
            assentos.add(new Assento(i + 1));
        }
        reservas.add(new Reserva(clientes.get(0), 1500, assentos.get(4)));
        assentos.get(4).setDisponivel(false);
        reservas.add(new Reserva(clientes.get(2), 2000, assentos.get(2)));
        assentos.get(2).setDisponivel(false);
        reservas.add(new Reserva(clientes.get(1), 3000, assentos.get(7)));
        assentos.get(7).setDisponivel(false);
    }

    public static void main(String[] args) {
        Controle controller = new Controle();
        controller.menuPrincipal();
    }

    public void menuPrincipal() {
        String aux = "SISTEMA DE RESERVA PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar\n";

        while(true) {
            try {
                int opcao = Integer.parseInt(showInputDialog(aux));
                switch (opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisarReserva();
                        break;
                    case 3:
                        cancelarReserva();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Digite uma das opções existentes!");

                }

            }catch (NumberFormatException e) {
                showMessageDialog(null, "Digite um número inteiro! " + e);
            }
        }
    }

    private void cancelarReserva() {
        String codIdentificador = showInputDialog("Digite o CPF/CNPJ da reserva a ser cancelada:");
        Reserva reserva = null;
        for (Reserva r : reservas) {
            if(codIdentificador.equalsIgnoreCase(r.getCliente().getIdentificador())) {
                reserva = r;
                showMessageDialog(null, "Reserva cancelada com sucesso!");
                r.getAssento().setDisponivel(true);
                reservas.remove(reserva);
                return;
            }
        }
        showMessageDialog(null, "Reserva não encontrada!");
    }

    private void pesquisarReserva() {
        String codIdentificador = showInputDialog("Digite o CPF/CNPJ da Reserva:");
        String resultado = "";
        for (Reserva r : reservas) {
            if(r.getCliente().getIdentificador().equalsIgnoreCase(codIdentificador)) {
                resultado = r.toString();
            }
        }
        if(resultado.equalsIgnoreCase("")) {
            showMessageDialog(null, "Nenhuma reserva encontrada!");
        }else {
            showMessageDialog(null, resultado);
        }
    }

    public void reservar() {
        Random random = new Random();

        String codIdentificador;
        String tipoCodIdentificador = showInputDialog("Digite se é CPF (F) / CNPJ (J):");
        while(!(tipoCodIdentificador.equalsIgnoreCase("f") || tipoCodIdentificador.equalsIgnoreCase("j"))) {
            tipoCodIdentificador = showInputDialog("Digite se é CPF (F) / CNPJ (J) corretamente:");
        }
        if(tipoCodIdentificador.equalsIgnoreCase("f")) {
            codIdentificador = showInputDialog("Digite seu CPF:");
        }else {
            codIdentificador = showInputDialog("Digite seu CNPJ:");
        }
        //verifica se ja possui reserva
        for (Reserva r : reservas) {
            if (r.getCliente().getIdentificador().equalsIgnoreCase(codIdentificador)) {
                showMessageDialog(null, "Você já possui uma reserva!" , "Aviso", WARNING_MESSAGE);
                return;
            }
        }

        String nome = showInputDialog("Digite seu nome:");
        String contato = showInputDialog("Digite seu contato:");
        double valorOriginal = random.nextInt(1000, 10000);
        Assento assento = assentos.get(random.nextInt(assentos.size()));
        Cliente cliente;

        if(tipoCodIdentificador.equalsIgnoreCase("f")) {
            cliente = new PessoaFisica(nome, contato, codIdentificador);
        }else {
            cliente = new PessoaJuridica(nome, contato, codIdentificador);
        }

        while(!(assento.isDisponivel())) {
            assento = assentos.get(random.nextInt(assentos.size()));
        }

        reservas.add(new Reserva(cliente, valorOriginal, assento));
        showMessageDialog(null, "Reserva concluída!");
    }






}

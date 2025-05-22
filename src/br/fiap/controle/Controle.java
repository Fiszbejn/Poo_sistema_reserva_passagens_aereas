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
        reservas.add(new Reserva(clientes.get(random.nextInt(clientes.size())), 1500, assentos.get(4)));
        assentos.get(4).setDisponivel(false);
        reservas.add(new Reserva(clientes.get(random.nextInt(clientes.size())), 1500, assentos.get(2)));
        assentos.get(2).setDisponivel(false);
        reservas.add(new Reserva(clientes.get(random.nextInt(clientes.size())), 1500, assentos.get(7)));
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

    }

    private void pesquisarReserva() {
        String codIdentificador = showInputDialog("Digite o CPF/CNPJ da Reserva:");
        String resultados = "";
        for (Reserva r : reservas) {
            if(r.getCliente().getIdentificador().equalsIgnoreCase(codIdentificador)) {
                resultados += r.toString();
            }
        }
        showMessageDialog(null, resultados);
    }

    public void reservar() {

    }






}



/* 
 * UNIVERSIDADE FEDERAL DO PAMPA - UNIPAMPA
 * PROGRAMAÇÃO ORIENTADA A OBJETOS
 * MATHEUS FAGUNDES DE OLIVEIRA  2110102636
 * GABRIEL BITENCURT CARDOSO 2110101630
 * TURMA EC11
*/

import java.util.Scanner;

public class Coffe{
    public static int menu(Scanner input) {
        int x;
        System.out.println("\n1 - Novo pedido");
        System.out.println("0 - Sair");
        System.out.print("Digite a opção desejada: ");
        x = input.nextInt();
        return x;
    }

    public static void novoPedido(Scanner input, double preco) {
        // limpa buffer
        input.nextLine();

        System.out.println("*** Cliente ***");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("CPF: ");
        String CPF = input.nextLine();

        System.out.print("Endereço: ");
        String endereco = input.nextLine();

        System.out.println("\n*** Pedido ***");
        System.out.print("Quantidade: ");
        int quantidade = input.nextInt();

        // limpa buffer
        input.nextLine();

        System.out.print("Data do pedido (dd/mm/aaaa): ");
        String data = input.nextLine();

        // instanciar os objetos
        Cliente cliente = new Cliente(nome, CPF, endereco);
        Produto produto = new Produto(preco);
        Data dataPedido = new Data(data);

        Pedido pedido = new Pedido(cliente, produto, dataPedido, quantidade);
        pedido.processaPedido();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nBem vindo ao sistema de pedidos!");
        System.out.println("Informe o valor de 1kg de café: ");
        double precoUn = input.nextDouble();

        int opcao = menu(input);
        do {
            switch (opcao) {
                case 1:
                    novoPedido(input, precoUn);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            opcao = menu(input);
        } while (opcao != 0);
    }
}
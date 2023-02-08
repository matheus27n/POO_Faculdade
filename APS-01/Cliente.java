
//package coffe.dado;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String CPF;
    private String endereco;

    public Cliente(String nome, String CPF, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
    }


    public String toString() {
        String toString = String.format("Nome: %s - CPF %s \nEndereço: %s", nome, CPF, endereco);
        return toString;

    }

 public static void main(String args[]) {
 Scanner ler = new Scanner(System.in);

 System.out.println("Informe seu nome: ");
 String nome = ler.nextLine();
 System.out.println("Informe seu CPF: ");
 String CPF = ler.nextLine();
 System.out.println("Informe seu endereço: ");
 String endereco = ler.nextLine();
 Cliente cliente = new Cliente(nome, CPF, endereco);

 System.out.println("----CLIENTE----");
 System.out.println(cliente);
 ler.close();
 }
}

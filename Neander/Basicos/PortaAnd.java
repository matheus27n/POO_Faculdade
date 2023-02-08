package Basicos;
import java.util.Scanner;

public class PortaAnd {
    private char Entrada1;
    private char Entrada2;

    public PortaAnd(char entrada1, char entrada2) {  //construtor da classe
        Entrada1 = entrada1;
        Entrada2 = entrada2;
    }

    public char GetSaida() //metodo que retorna o valor da saida
    {
        if (Entrada1 == '0' && Entrada2 == '0') {
            return '0';
        } else if (Entrada1 == '1' && Entrada2 == '0'){
            return '0';
        } else if (Entrada1 == '0' && Entrada2 == '1'){
            return '0';
        } else {
            return '1';
        }
    }

    public static void main(String[] args)
    {
        Scanner ler = new Scanner(System.in);
        char Entrada1, Entrada2;
        System.out.print("Digite o valor da Entrada 1: ");
        Entrada1 = ler.next().charAt(0);
        System.out.print("Digite o valor da Entrada 2: ");
        Entrada2 = ler.next().charAt(0);
        PortaAnd porta = new PortaAnd(Entrada1, Entrada2);
        System.out.println("Saida: " + porta.GetSaida());
        ler.close();
    }
}

package Basicos;
import java.util.Scanner;

public class PortaOr {
    private char Entrada1;
    private char Entrada2;


    public PortaOr(char entrada1, char entrada2) {  //construtor da classe
        Entrada1 = entrada1;
        Entrada2 = entrada2;
    }

    public char GetSaida() //metodo que retorna o valor da saida
    {
        if (Entrada1 == '1' || Entrada2 == '1') {
            return '1';
        } else {
            return '0';
        }
    }
   

   public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        char Entrada1, Entrada2;
        System.out.print("Digite o valor da Entrada 1: ");
        Entrada1 = ler.next().charAt(0);
        System.out.print("Digite o valor da Entrada 2: ");
        Entrada2 = ler.next().charAt(0);
        PortaOr porta = new PortaOr(Entrada1, Entrada2);
        System.out.println("Saida: " + porta.GetSaida());
        ler.close();
    }
}

package Basicos;
import java.util.Scanner;

public class FullAdder {
    private char A, B, Cin, Cout, Sout;
    private HalfAdder halfAdder, halfAdder2;
    private PortaOr portaOr;

    public FullAdder(char A, char B, char Cin) {
        this.A = A;
        this.B = B;
        this.Cin = Cin;
        processamento();
    }

    private void processamento(){
        halfAdder = new HalfAdder(A, B);
        halfAdder2 = new HalfAdder(halfAdder.SumOUT(), Cin);
        portaOr = new PortaOr(halfAdder.CarryOUT(), halfAdder2.CarryOUT());
        Cout = portaOr.GetSaida();
        Sout = halfAdder2.SumOUT();
    }
    
    public char SumOUT() {
        return Sout;
    }

    public char CarryOUT() {
        return Cout;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o valor de A: ");
        char A = ler.next().charAt(0);
        System.out.print("Digite o valor de B: ");
        char B = ler.next().charAt(0);
        System.out.print("Digite o valor de Cin: ");
        char Cin = ler.next().charAt(0);
        FullAdder fullAdder = new FullAdder(A, B, Cin);
        System.out.println("Soma: " + fullAdder.SumOUT());
        System.out.println("Carry: " + fullAdder.CarryOUT());
        ler.close();

    }
}


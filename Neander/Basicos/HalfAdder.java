package Basicos;
public class HalfAdder {
    private char A, B;
    private PortaAnd portaAnd;
    private PortaXor portaXor;

    public HalfAdder(char A, char B) {
        this.A = A;
        this.B = B;
    }

    public char SumOUT() {
        portaXor = new PortaXor(A, B);
        return portaXor.GetSaida();
    }

    public char CarryOUT() {
        portaAnd = new PortaAnd(A, B);
        return portaAnd.GetSaida();
    }
}
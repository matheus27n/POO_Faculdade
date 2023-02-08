package Basicos;
public class PortaXor {
    private char Entrada1;
    private char Entrada2;

    public PortaXor(char entrada1, char entrada2) {  //construtor da classe
        Entrada1 = entrada1;
        Entrada2 = entrada2;
    }

    public char GetSaida()
    {
        if (Entrada1 == '0' && Entrada2 == '0') {
            return '0';
        } else if (Entrada1 == '1' && Entrada2 == '0'){
            return '1';
        } else if (Entrada1 == '0' && Entrada2 == '1'){
            return '1';
        } else {
            return '0';
        }
    }
}

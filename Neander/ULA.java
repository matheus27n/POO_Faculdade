public class ULA {
    private Somador8bit somador = new Somador8bit();
    
    public ULA(){

    }

    public char[] soma(char[] A, char[] B) {
        somador.processamento(A, B);
        char R[] = somador.getResultado();
        return R;
    }

    public char[] not(char[] A) {
        char R[] = new char[8];
        for (int i = 0; i < 8; i++) {
            if (A[i] == '0') {
                R[i] = '1';
            } else {
                R[i] = '0';
            }
        }
        return R;
    }

    public boolean compNegativo(char[] A) {
        char zero = '0';
        if(A[0] == zero) {
            return false;
        } else {
            return true;
        }
    }
}

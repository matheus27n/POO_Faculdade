public class Conversor {
    
    public Conversor() {
    }

    public int binarioParaDecimal(char[] binario) {
        String binarioString = new String("");
        
        for (int i = 0; i < binario.length; i++) {
            binarioString += binario[i];
        }

        return Integer.parseInt(binarioString, 2);
    }

    public char[] decimalParaBinario(int decimal) {
        String binarioString = Integer.toBinaryString(decimal);
        char[] binario = new char[8];

        if (binarioString.length() < 8) {
            int diferenca = 8 - binarioString.length();
            for (int i = 0; i < diferenca; i++) {
                binarioString = "0" + binarioString;
            }
        }
        
        for (int i = 0; i < 8; i++) {
            binario[i] = binarioString.charAt(i);
        }
        
        return binario;
    }

    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        char[] binario = {'1', '1', '1', '0', '1', '0', '1', '1'}; 
        System.out.println(conversor.binarioParaDecimal(binario));
    }

}

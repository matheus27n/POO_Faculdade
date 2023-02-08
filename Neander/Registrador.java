public class Registrador {
    private char[] reg;
    private Conversor conversor = new Conversor();

    public Registrador() {
        reg = new char[8];
        for (int i = 0; i < reg.length; i++) {
            reg[i] = '0';
        }
    }

    public void setReg(char[] reg) {
        this.reg = reg;
    }

    public char[] getReg() {
        return reg;
    }

    public void setValor(char valor, int index) {
        reg[index] = valor;
    }

    public char getValor(int index) {
        return reg[index];
    }

    public String toString() {
        return "" + conversor.binarioParaDecimal(reg);
    }

    public static void main(String args[]){
        Registrador reg = new Registrador();
        System.out.println(reg.toString());
    }

}

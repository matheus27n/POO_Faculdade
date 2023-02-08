public class Memoria {
    private Registrador[] memDados = new Registrador[128];
    private Registrador[] memInstrucoes = new Registrador[128];

    public Memoria() {
        for (int i = 0; i < 128; i++) {
            memDados[i] = new Registrador();
            memInstrucoes[i] = new Registrador();
        }
    }

    public void setDado(int posicao, char[] valor) {
        memDados[posicao].setReg(valor);
    }

    public char[] getDado(int posicao) {
        return memDados[posicao].getReg();
    }

    public void setInstrucao(int posicao, char[] valor) {
        memInstrucoes[posicao].setReg(valor);
    }

    public char[] getInstrucao(int posicao) {
        return memInstrucoes[posicao].getReg();
    }

    public Registrador[] getMemDados() {
        return memDados;
    }

    public Registrador[] getMemInstrucoes() {
        return memInstrucoes;
    }

    public static void main(String args[]){
        Memoria memoria = new Memoria();
        System.out.println(memoria.toString());
    }
}

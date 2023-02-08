
public class Excecao_InstrutorNaoEncontrado extends Exception {
    public Excecao_InstrutorNaoEncontrado() {
        super("Instrutor não encontrado");
    }

    public Excecao_InstrutorNaoEncontrado(String msg) {
        super(msg);
    }

}

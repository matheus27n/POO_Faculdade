
public class Excecao_AlunoNaoEncontrado extends Exception {
    public Excecao_AlunoNaoEncontrado() {
        super("Aluno não encontrado");
    }

    public Excecao_AlunoNaoEncontrado(String msg) {
        super(msg);
    }

}

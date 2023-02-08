
public class Execao_CursoNaoEncontrado extends Exception {
    public Execao_CursoNaoEncontrado() {
        System.out.println("Curso nao encontrado");
    }

    public Execao_CursoNaoEncontrado(String message) {
        super(message);
    }
}


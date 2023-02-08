
public class Excecao_TurmaNaoEncontrada extends Exception {
    public Excecao_TurmaNaoEncontrada() {
        super("Turma não encontrada");
    }

    public Excecao_TurmaNaoEncontrada(String msg) {
        super(msg);
    }

}


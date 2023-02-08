import java.util.LinkedList;

public class Escola {
    private String nome;
    private String telefone;
    private LinkedList<Aluno> listaAlunos;
    private LinkedList<Instrutor> listaInstrutores;
    private LinkedList<Turma> listaTurma;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        listaAlunos = new LinkedList<Aluno>();
        listaInstrutores = new LinkedList<Instrutor>();
        listaTurma = new LinkedList<Turma>();
    }

    public String getNomeEscola() {
        return nome;
    }

    public String getTelefoneEscola() {
        return telefone;
    }

    public void adicionarAluno(Aluno al) {
        listaAlunos.add(al);
    }

    public LinkedList<Aluno> buscarAluno(long matAluno) throws Excecao_AlunoNaoEncontrado {
        LinkedList<Aluno> temp = new LinkedList<Aluno>();

        for (Aluno al : listaAlunos) {
            if (al.getMatricula() == matAluno) {
                temp.add(al);
            }
        }

        if (temp.isEmpty())
            throw new Excecao_AlunoNaoEncontrado();

        return temp;
    }

    public void adicionarInstrutor(Instrutor inst) {
        listaInstrutores.add(inst);
    }

    public LinkedList<Instrutor> buscarInstrutor(long codInstrutor) throws Excecao_InstrutorNaoEncontrado {
        LinkedList<Instrutor> temp = new LinkedList<Instrutor>();

        for (Instrutor inst : listaInstrutores) {
            if (inst.getCodigo() == codInstrutor) {
                temp.add(inst);
            }
        }

        if (temp.isEmpty())
            throw new Excecao_InstrutorNaoEncontrado();

        return temp;
    }

    public void adicionarTurma(Turma turm) {
        listaTurma.add(turm);
    }

    public LinkedList<Turma> buscarTurma(long codTurma) throws Excecao_TurmaNaoEncontrada {
        LinkedList<Turma> temp = new LinkedList<Turma>();

        for (Turma turm : listaTurma) {
            if (turm.getCodTurma() == codTurma) {
                temp.add(turm);
            }
        }

        if (temp.isEmpty())
            throw new Excecao_TurmaNaoEncontrada();

        return temp;
    }

    public void umaTurma(Turma turm) {
        System.out.println(turm);
    }

    public void listarTurmas() {
        System.out.println("\nLista de Turmas:");
        for (Turma turm : listaTurma) {
            System.out.println(turm);
        }
    }
}
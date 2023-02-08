public class Curso {
    private String nome;
    private long codCurso;
    private int cargaHoraria;
    private Turma turm;

    public Curso(String nome, long codCurso, int cargaHoraria) {
        this.nome = nome;
        this.codCurso = codCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public long getCodCurso() {
        return codCurso;
    }

}
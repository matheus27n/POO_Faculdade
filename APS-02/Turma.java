
import java.util.LinkedList;

public class Turma {
    private long codTurma;
    private String dataIni;
    private String dataFim;
    private LinkedList<Aluno> listaAlunos;
    private LinkedList<Instrutor> listaInstrutores;

    public Turma(long codTurma, String dataIni, String dataFim, LinkedList<Instrutor> listaInstrutores, LinkedList<Aluno> listaAlunos) {
        this.codTurma = codTurma;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.listaAlunos = listaAlunos;
        this.listaInstrutores = listaInstrutores;
    }

    public long getCodTurma() {
        return codTurma;
    }

    public String getDataIni() {
        return dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void ordenarAlunos() {
        Aluno temp;
        for (int i = 0; i < listaAlunos.size(); i++) {
            for (int j = 0; j < listaAlunos.size() - 1; j++) {
                if (listaAlunos.get(j).getNome().compareTo(listaAlunos.get(j + 1).getNome()) > 0) {
                    temp = listaAlunos.get(j);
                    listaAlunos.set(j, listaAlunos.get(j + 1));
                    listaAlunos.set(j + 1, temp);
                }
            }
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTurma " + codTurma);
        sb.append(" - " + dataIni);
        sb.append(" à " + dataFim);


        //sort instrutores by name
        Instrutor temp;
        for (int i = 0; i < listaInstrutores.size(); i++) {
            for (int j = 0; j < listaInstrutores.size() - 1; j++) {
                if (listaInstrutores.get(j).getNome().compareTo(listaInstrutores.get(j + 1).getNome()) > 0) {
                    temp = listaInstrutores.get(j);
                    listaInstrutores.set(j, listaInstrutores.get(j + 1));
                    listaInstrutores.set(j + 1, temp);
                }
            }
        }

        //print instrutores
        sb.append("\nInstrutores:");
        for (Instrutor inst : listaInstrutores) {
            sb.append(" | " + inst.getNome() + " | ");
        }
        
        //sort alunos by name
        Aluno temp2;
        for (int i = 0; i < listaAlunos.size(); i++) {
            for (int j = 0; j < listaAlunos.size() - 1; j++) {
                if (listaAlunos.get(j).getNome().compareTo(listaAlunos.get(j + 1).getNome()) > 0) {
                    temp2 = listaAlunos.get(j);
                    listaAlunos.set(j, listaAlunos.get(j + 1));
                    listaAlunos.set(j + 1, temp2);
                }
            }
        }

        //print alunos
        sb.append("\nAlunos:");
        for (Aluno alu : listaAlunos) {
            sb.append(" | " + alu.getNome() + " | ");
        }
        return sb.toString();
    }

    

}

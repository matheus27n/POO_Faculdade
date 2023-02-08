public class Pessoa implements Comparable {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Object o) {
        Pessoa p = (Pessoa) o;
        if (this.nome.compareTo(p.nome) > 0) {
            return 1;
        } else if (this.nome.compareTo(p.nome) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
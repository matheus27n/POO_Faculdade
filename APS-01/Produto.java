//package coffe.dado;
import java.util.Scanner;

public class Produto {
    private double valor;

    public Produto(double valor) {
        this.valor = valor;

    }

    public double getValor() {
        return valor;
    }
    
    public String toString() {
        String toString = String.format("Valor:R$ %.2f ", valor);
        return toString;
    }

    public static void main(String args[]){
     Scanner ler = new Scanner(System.in);
     System.out.println("Valor do produto: ");
     double valor = ler.nextDouble();
    
     Produto produto = new Produto(valor);
     System.out.println(produto);

     ler.close();
     }
}

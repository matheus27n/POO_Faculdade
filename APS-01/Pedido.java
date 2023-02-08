
import java.text.DecimalFormat;

public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private Data data;
    private int quantidade;

    public Pedido(Cliente cliente, Produto produto, Data data, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
    }

    public void processaPedido() {
        Embalagem[] embalagens = Embalagem.values();
        DecimalFormat df = new DecimalFormat("0.00");

        int qtdCalculo = quantidade;
        int grandes = 0;
        int medias = 0;
        int pequenas = 0;
        double valorTotal = 0;

        valorTotal += (quantidade * produto.getValor());

        // imprime o cliente
        System.out.println("\n");
        System.out.println(cliente);

        // imprime quantodade e valor
        System.out.println("Número de Pacotes de Café MyJava Encomendados: " + quantidade + " - R$" + df.format(valorTotal));

        // distribui entre as caixas através da regra do enunciado
        while (qtdCalculo != 0) {
            if (qtdCalculo >= embalagens[0].getLimitePacotes()) {
                grandes++;
                valorTotal += 3.00;
                qtdCalculo -= embalagens[0].getLimitePacotes();
            } else if (qtdCalculo >= embalagens[1].getLimitePacotes()) {
                medias++;
                valorTotal += 2.00;
                qtdCalculo -= embalagens[1].getLimitePacotes();
            } else {
                pequenas++;
                valorTotal += 1.20;
                qtdCalculo -= qtdCalculo;
            }
        }

        // imprime essa informação
        System.out.println("Embalagens usadas:");
        if (grandes != 0) {
            System.out.println(grandes + " Grandes - " + "R$" + df.format(grandes * 3.00));
        }
        if (medias != 0) {
            System.out.println(medias + " Médias - " + "R$" + df.format(medias * 2.00));
        }
        if (pequenas != 0) {
            System.out.println(pequenas + " Pequenas - " + "R$" + df.format(pequenas * 1.20));
        }

        // imprime o valor total
        System.out.println("Custo total: " + "R$" + df.format(valorTotal));

        // imprime datas
        System.out.println("Data do pedido: " + data);
        data.previsaoEntrega();
    }
}


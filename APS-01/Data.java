import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
    // atributos static para serem utilizados pelo LocalDate
    private static String data;

    public Data(String d) {
        data = d;
    }

    public String toString () {
        // formata a data para o formato dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        return date.format(formatter);
    }
    
    public void previsaoEntrega() {
        LocalDate dataP = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dataP = dataP.plusDays(14); // soma 14 dias na data do pedido
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Previsão de entrega: " + dataP.format(formatador));
    }
}
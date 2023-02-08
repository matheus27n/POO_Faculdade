import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        System.out.println("----------MENU BAR----------");
        System.out.println("1 - Bebibas");
        System.out.println("2 - Bebidas Alcoólicas");
        System.out.println("3 - Sair");
        System.out.print("opacao: ");
        int opcao = sc.nextInt();
        
        while(sair != true){
        switch (opcao){
                case 1:
                System.out.println("\n1 - Refrigerante");
                System.out.println("2 - Suco");
                System.out.print("opacao: ");
                int opcao1 = sc.nextInt();
                switch (opcao1){
                        case 1:
                        System.out.println("1 - Coca-Cola");
                        System.out.println("2 - Pepsi");
                        System.out.println("3 - Guaraná");
                        System.out.print("opacao: ");
                        int opcao2 = sc.nextInt();
                        switch (opcao2){
                                case 1:
                                System.out.println("Coca-Cola");
                                break;
                                case 2:
                                System.out.println("Pepsi");
                                break;
                                case 3:
                                System.out.println("Guaraná");
                                break;
                        }
                        break;
                        case 2:
                        System.out.println("1 - Laranja");
                        System.out.println("2 - Abacaxi");
                        System.out.println("3 - Maracujá");
                        int opcao3 = sc.nextInt();
                        switch (opcao3){
                                case 1:
                                System.out.println("Laranja");
                                break;
                                case 2:
                                System.out.println("Abacaxi");
                                break;
                                case 3:
                                System.out.println("Maracujá");
                                break;
                        }
                        break;
                }
                break;

                case 2:
                System.out.println("\n1 - Cachaça");
                System.out.println("2 - Vodka");
                System.out.println("3 - Rum");
                System.out.println("4 - voltar");
                System.out.print("opcao: ");
                int opcao4 = sc.nextInt();
                switch (opcao4){
                        case 1:
                        System.out.println("\n1- Acrescentar Limão");
                        System.out.println("2- Acrescentar Açucar");
                        System.out.println("3- Refrigerante");
                        System.out.print("opcao: ");
                        int opcao5 = sc.nextInt();
                        switch (opcao5){
                                case 1:
                                Cachaca cachaca = new Cachaca();
                                Limao limao = new Limao(cachaca);
                                System.out.println(limao.getNome() + " = " + limao.getPreco());

                                break;
                                
                                case 2:
                                Cachaca cachaca1 = new Cachaca();
                                Acucar acucar = new Acucar(cachaca1);
                                System.out.println(acucar.getNome() + " = " + acucar.getPreco());
                                break;

                                case 3:
                                Cachaca cachaca2 = new Cachaca();
                                Refrigerante refrigerante = new Refrigerante(cachaca2);
                                System.out.println(refrigerante.getNome() + " = " + refrigerante.getPreco());
                                break;

                        }
                
                        break;
                        

                        case 2:
                        System.out.println("\n1- Acrescentar Limão");
                        System.out.println("2- Acrescentar Açucar");
                        System.out.println("3- Refrigerante");
                        System.out.print("opcao: ");
                        int opcao6 = sc.nextInt();
                        switch (opcao6){
                                case 1:
                                Vodka vodka = new Vodka();
                                Limao limao = new Limao(vodka);
                                System.out.println(limao.getNome() + " = " + limao.getPreco());
                                break;
                                
                                case 2:
                                Vodka vodka1 = new Vodka();
                                Acucar acucar = new Acucar(vodka1);
                                System.out.println(acucar.getNome() + " = " + acucar.getPreco());
                                break;

                                case 3:
                                Vodka vodka2 = new Vodka();
                                Refrigerante refrigerante = new Refrigerante(vodka2);
                                System.out.println(refrigerante.getNome() + " = " + refrigerante.getPreco());
                                break;
                        }
                        break;

                        case 3:
                        System.out.println("\n1- Acrescentar Limão");
                        System.out.println("2- Acrescentar Açucar");
                        System.out.println("3- Refrigerante");
                        System.out.print("opcao: ");
                        int opcao7 = sc.nextInt();
                        switch (opcao7){
                                case 1:
                                Rum rum = new Rum();
                                Limao limao = new Limao(rum);
                                System.out.println(limao.getNome() + " = " + limao.getPreco());
                                break;
                                
                                case 2:
                                Rum rum1 = new Rum();
                                Acucar acucar = new Acucar(rum1);
                                System.out.println(acucar.getNome() + " = " + acucar.getPreco());
                                break;

                                case 3:
                                Rum rum2 = new Rum();
                                Refrigerante refrigerante = new Refrigerante(rum2);
                                System.out.println(refrigerante.getNome() + " = " + refrigerante.getPreco());
                                break;
                        }

                        case 4:
                        System.out.println("\nVoltando");
                        break;
                 }
                 break;
        
                case 3: 
                System.out.println("\nSAINDO");
                sair = true;
                break;

                default:
                System.out.println("\nOpcao invalida");
                break;
        }
}

        

        /*Coquetel meuCoquetel = new Cachaca();
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());

        meuCoquetel = new Refrigerante(meuCoquetel);
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());

        meuCoquetel = new Vodka();
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());
       
        meuCoquetel = new Refrigerante(meuCoquetel);
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());

        meuCoquetel = new Limao(meuCoquetel);
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());

        meuCoquetel = new Limao(meuCoquetel);
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());
	}*/
    }
}
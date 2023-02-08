/* 
 * UNIVERSIDADE FEDERAL DO PAMPA - UNIPAMPA
 * PROGRAMAÇÃO ORIENTADA A OBJETOS
 * MATHEUS FAGUNDES DE OLIVEIRA  2110102636
 * GABRIEL BITENCURT CARDOSO 2110101630
 * TURMA EC11
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void novoAluno(Scanner input, Escola escola) {
        System.out.print("\nDigite o nome do aluno: ");
        String nome = input.nextLine();
        System.out.print("Digite a matrícula do aluno: ");
        long matricula = input.nextLong();
        input.nextLine();
        Aluno al = new Aluno(nome, matricula);

        escola.adicionarAluno(al);
        System.out.print("Aluno adicionado com sucesso!\n");
    }

    public static void novoInstrutor(Scanner input, Escola escola) {
        System.out.print("\nDigite o nome do instrutor: ");
        String nome = input.nextLine();
        System.out.print("Digite o código do instrutor: ");
        long codigo = input.nextLong();
        input.nextLine();
        Instrutor inst = new Instrutor(nome, codigo);

        escola.adicionarInstrutor(inst);
        System.out.println("Instrutor(a) adicionado com sucesso!\n");
    }

    public static void novaTurma(Scanner input, Escola escola) {
        System.out.print("Digite o código da turma: ");
        long codTurma = input.nextLong();
        input.nextLine();
        System.out.print("Digite a data de início da turma: ");
        String dataIni = input.nextLine();
        System.out.print("Digite a data de término da turma: ");
        String dataFim = input.nextLine();

        // informa os instrutores da turma
        System.out.println("\nInforme os instrutores(as) desta turma");
        LinkedList<Instrutor> listaInstrutores = new LinkedList<Instrutor>();

        // loopa até o usuario digitar que é o ultimo instrutor
        do {
            try {
                System.out.print("Digite o código do instrutor: ");
                long codInstrutor = input.nextLong();
                input.nextLine();

                LinkedList<Instrutor> temp;
                temp = escola.buscarInstrutor(codInstrutor);
                listaInstrutores.add(temp.get(0));
                System.out.println("Instrutor(a)" + temp.get(0).getNome() + " adicionado com sucesso!\n");

            } catch (Excecao_InstrutorNaoEncontrado e) {
                System.out.println("Instrutor(a) não encontrado! Tente novamente.");
            }
            System.out.print("\nDeseja informar outro instrutor? (s/n): ");
        } while (input.nextLine().equals("s"));

        // informa os alunos da turma
        System.out.println("\nInforme os alunos desta turma");
        LinkedList<Aluno> listaAlunos = new LinkedList<Aluno>();

        // loopa até o usuario digitar que é o ultimo aluno
        do {
            try {
                System.out.print("Digite a matrícula do aluno: ");
                long matAluno = input.nextLong();
                input.nextLine();

                LinkedList<Aluno> temp;
                temp = escola.buscarAluno(matAluno);
                listaAlunos.add(temp.get(0));
                System.out.println("Alun@ " + temp.get(0).getNome() + " adicionado com sucesso!\n");

            } catch (Excecao_AlunoNaoEncontrado e) {
                System.out.println("Aluno não encontrado! Tente novamente.");
            }
            System.out.print("\nDeseja informar outro aluno? (s/n): ");
        } while (input.nextLine().equals("s"));

        Turma turma = new Turma(codTurma, dataIni, dataFim, listaInstrutores, listaAlunos);
        escola.adicionarTurma(turma);
        System.out.println("Turma adicionada com sucesso!\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o nome da escola: ");
        String nomeEscola = input.nextLine();
        System.out.print("Informe o celular da escola: ");
        String celEscola = input.nextLine();


        Escola escola = new Escola(nomeEscola, celEscola);

        int opcao = 0;

        do {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Escola " + escola.getNomeEscola() + " / Contato: " + escola.getTelefoneEscola());
            System.out.print("1 - Novo Aluno");
            System.out.print("\t\t| 4 - Buscar Instrutor(a)\n");
            System.out.print("2 - Buscar Aluno");
            System.out.print("\t| 5 - Nova Turma\n");
            System.out.print("3 - Novo Instrutor(a)");
            System.out.print("\t| 6 - Buscar Turma\n");
            System.out.print("\n7 - Ordenar e Listar turmas\n");
            System.out.println("8 - Sair");
            System.out.print("--------------------------------------------------\n");
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    novoAluno(input, escola);
                    break;
                case 2:
                    System.out.print("Digite a matrícula d@ alun@: ");
                    long matricula = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Aluno> alunos = escola.buscarAluno(matricula);
                        for (Aluno al : alunos) {
                            System.out.println("\nNome: " + al.getNome());
                            System.out.println("Matrícula: " + al.getMatricula());
                        }
                    } catch (Excecao_AlunoNaoEncontrado e) {
                        System.out.println("Alun@ não encontrad@!\n");
                    }

                    break;
                case 3:
                    novoInstrutor(input, escola);
                    break;
                case 4:
                    System.out.print("Digite o código do instrutor(a): ");
                    long codigo = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Instrutor> instrutores = escola.buscarInstrutor(codigo);
                        for (Instrutor inst : instrutores) {
                            System.out.println("\nNome: " + inst.getNome());
                            System.out.println("Código: " + inst.getCodigo());
                        }
                    } catch (Excecao_InstrutorNaoEncontrado e) {
                        System.out.println("Instrutor(a) não encontrado!\n");
                    }
                    break;
                case 5:
                    novaTurma(input, escola);
                    break;
                case 6:
                    System.out.print("Digite o código da turma: ");
                    long codTurma = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Turma> turmas = escola.buscarTurma(codTurma);
                        for (Turma turma : turmas) {
                            escola.umaTurma(turma);
                        }
                    } catch (Excecao_TurmaNaoEncontrada e) {
                        System.out.println("Turma não encontrada!\n");
                    }
                    break;
                case 7:
                    escola.listarTurmas();
                    break;

                default:
                    if (opcao == 8) {
                        System.out.println("Saindo do programa!");
                        break;
                    } else
                        System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 8);
        input.close();
    }
}
/*Universidade Federal do Pampa – UNIPAMPA
Campus Bagé - Curso de Engenharia de Computação
Programação Orientada a Objetos
Aluno : Matheus Fagundes de Oliveira e Gabriel dos Santos Fredes
Matricula: 2110102636, 2110102628
Data: 10/01/202*/


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conteiner extends JFrame {
    private static final int LARGURA = 700;;
    private static final int ALTURA = 500;
    private JTextField textFieldADD, textFieldDEL;
    private JButton buttonADD, buttonDEL, buttonPRE, buttonPOS, buttonIN;
    //ARVORE COMEÇA COM VALOR 10
    private ArvoreAVL arvore = new ArvoreAVL(new Elemento(10));

    public Conteiner(){
        super("Arvore AVL");
        setSize(LARGURA, ALTURA);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);   
   
    }

    public void init(){
        textFieldADD = new JTextField();
        textFieldADD.setBounds(200, 330, 100, 20);
        this.getContentPane().add(textFieldADD);


        textFieldDEL = new JTextField();
        textFieldDEL.setBounds(200, 360, 100, 20);
         this.getContentPane().add(textFieldDEL);

        buttonADD = new JButton("ADD");
        buttonADD.setBounds(300, 330, 100, 20);
        this.getContentPane().add(buttonADD);
        setVisible(true);

        buttonDEL = new JButton("DEL");
        buttonDEL.setBounds(300, 360, 100, 20);
        this.getContentPane().add(buttonDEL);
        setVisible(true);

        buttonADD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                arvore = arvore.inserir(new Elemento(Integer.parseInt(textFieldADD.getText())));
                arvore.calcularBalanceamento();
                arvore = arvore.verificaBalanceamento();
                System.out.println(arvore.printArvore(0));
               
            }
        });

        buttonDEL.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                arvore = arvore.remover((Integer.parseInt(textFieldDEL.getText())));
                arvore.calcularBalanceamento();
                arvore = arvore.verificaBalanceamento();
                System.out.println(arvore.printArvore(0));
            }
        });
      
      buttonPRE = new JButton("PRE");
      buttonPRE.setBounds(400, 330, 100, 20);
      this.getContentPane().add(buttonPRE);
      buttonPRE.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            arvore.imprimirPreOrdem();

        }
    });

      buttonPOS = new JButton("POS");
      buttonPOS.setBounds(400, 360, 100, 20);
      this.getContentPane().add(buttonPOS);
        buttonPOS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                arvore.imprimirPosOrdem();
    
            }
        });

      buttonIN = new JButton("IN");
      buttonIN.setBounds(500, 330, 100, 20);
      this.getContentPane().add(buttonIN);
        buttonIN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                arvore.imprimirInOrdem();
            }
        });
        setVisible(true);

       
    }

    
}
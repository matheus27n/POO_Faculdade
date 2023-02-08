import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    
    // Componentes da GUI
    private GridLayout gridLayout = new GridLayout(1, 3);
    private JPanel panel, dadosPanel, instrPanel;
    private JScrollPane scrollI, scrollD;
    private JLabel ACLabel,PCLabel;
    private JTextField ACField, PCField;
    private JLabel dataLabel, instrLabel;
    private JTextField dataField, instrField;
    private JList<Registrador> listaInstr, listaDados;
    private JList<String> listaInstrIndex, listaDadosIndex;
    private String[] instrIndex, dadosIndex;
    private JButton Passo, Executar;
    private JTextArea mnemonicos1, mnemonicos2;
    
    // Componentes do Neander
    private int PC = 0;
    private Registrador AC = new Registrador(); 
    private Conversor conversor = new Conversor();
    private Memoria memoria = new Memoria();
    private ULA ula = new ULA();
    
    public GUI(){ 
        Container janela = getContentPane();
        setTitle("Simulador de Processador Neander");
        setSize(600, 650);
        setLayout(gridLayout);

        //Painel de memoria de instruções
        listaInstr = new JList<>(memoria.getMemInstrucoes()); //Cria uma Jlist com o vetor de regs
        listaInstr.setFixedCellWidth(80);
        listaInstr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        listaInstr.setSelectedIndex(0);

        instrIndex = new String[128]; //Cria um vetor de strings para o indice
        for (int i = 0; i < 128; i++) {
            instrIndex[i] = Integer.toString(i);
        }
        listaInstrIndex = new JList<>(instrIndex); //que também sera um JList
        listaInstrIndex.setFixedCellWidth(50);
        listaInstrIndex.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaInstrIndex.setSelectedIndex(0);
        
        
        listaInstr.addMouseListener(new MouseAdapter() { //Evento pra ele selecionar os dois itens das JList quando clicar em apenas um e mudar o label la do meio
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int i = listaInstr.locationToIndex(e.getPoint());
                    listaInstrIndex.setSelectedIndex(i);
                    instrLabel.setText("Instrução [" + i + "]: ");
                    janela.validate();
                }
            }
        });
        
        listaInstrIndex.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int i = listaInstrIndex.locationToIndex(e.getPoint());
                    listaInstr.setSelectedIndex(i);
                    instrLabel.setText("Instrução [" + i + "]: ");
                    janela.validate();
                }
            }
        });

        instrPanel = new JPanel(); //Cria o painel pra adicionar as duas JList
        instrPanel.add(listaInstrIndex);
        instrPanel.add(listaInstr);


        scrollI = new JScrollPane(instrPanel); //Cria o scroll pra adicionar o painel
        scrollI.setColumnHeaderView(new JLabel("Endereco // Instrucoes"));
        scrollI.setBorder(BorderFactory.createTitledBorder("Memória de Instruções"));

        janela.add(scrollI);
        //////////////////////////
        
        //Painel central
        panel = new JPanel(); //Cria o painel pra adicionar os componentes
        panel.setLayout(new GridLayout(6, 2));
        
        PCLabel = new JLabel("PC: "); //Label do PC
        String pcString = Integer.toString(PC);
        PCField = new JTextField(pcString);
        PCField.addActionListener(new ActionListener() { //TextField do PC com evento pra mudar o valor do PC no ENTER
            public void actionPerformed(ActionEvent e) {
                String pcString = PCField.getText();
                int pcInt = Integer.parseInt(pcString);
                PC = pcInt;
            }
        });
        panel.add(PCLabel);
        panel.add(PCField);
        
        ACLabel = new JLabel("AC: "); //Label do AC
        int ac = conversor.binarioParaDecimal(AC.getReg());
        String acString = Integer.toString(ac);
        ACField = new JTextField(acString);
        ACField.addActionListener(new ActionListener() { //TextField do AC com evento pra mudar o valor do AC no ENTER
            public void actionPerformed(ActionEvent e) {
                String acString = ACField.getText();
                int acInt = Integer.parseInt(acString);
                char[] acBin = conversor.decimalParaBinario(acInt);
                AC.setReg(acBin);
            }
        });
        panel.add(ACLabel);
        panel.add(ACField);

        mnemonicos1 = new JTextArea( //TextArea com os mnemonicos
            "Mnemonicos\n\n"+
            "NOP  0\n"+
            "STA  16 end\n"+
            "LDA  32 end\n"+
            "ADD  48 end"
        );
        mnemonicos1.setEditable(false);
        panel.add(mnemonicos1);

        mnemonicos2 = new JTextArea(
            "----------\n\n"+
            "NOT  96\n"+
            "JMP  128 end\n"+
            "JN    144 end\n"+
            "HLT  240"
        );
        mnemonicos2.setEditable(false);
        panel.add(mnemonicos2);

        instrLabel = new JLabel("Instrução [0]: "); //Label da instrução
        instrField = new JTextField("0");
        instrField.addActionListener(new ActionListener() { //TextField da instrução com evento pra mudar o valor da instrução selecionada da JLits no ENTER
            public void actionPerformed(ActionEvent e) {
                String instrucao = instrField.getText();
                int instrucaoInt = Integer.parseInt(instrucao);
                char[] instrucaoBin = conversor.decimalParaBinario(instrucaoInt);
                memoria.setInstrucao(listaInstr.getSelectedIndex(), instrucaoBin);

                listaInstr.setListData(memoria.getMemInstrucoes());
                int proxIndex = listaInstr.getAnchorSelectionIndex()+1;
                listaInstr.setSelectedIndex(proxIndex);
                listaInstrIndex.setSelectedIndex(proxIndex);

                instrField.setText("0");
                janela.validate();
            }
        }); 
        panel.add(instrLabel);
        panel.add(instrField);

        dataLabel = new JLabel("Dado [0]: ");
        dataField = new JTextField("0");
        dataField.addActionListener(new ActionListener() { //TextField do dado com evento pra mudar o valor do dado selecionado da JLits no ENTER
            public void actionPerformed(ActionEvent e) {
                String dado = dataField.getText();
                int dadoInt = Integer.parseInt(dado);
                char[] dadoBin = conversor.decimalParaBinario(dadoInt);
                memoria.setDado(listaDados.getSelectedIndex(), dadoBin);

                listaDados.setListData(memoria.getMemDados());
                int proxIndex = listaDados.getAnchorSelectionIndex()+1;
                listaDados.setSelectedIndex(proxIndex);
                listaDadosIndex.setSelectedIndex(proxIndex);

                dataField.setText("0");
                janela.validate();
            }
        }); 
        panel.add(dataLabel);
        panel.add(dataField);

        Passo = new JButton("Passo");
        Passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] instrucao = memoria.getInstrucao(PC);
                int instrucaoInt = conversor.binarioParaDecimal(instrucao);
                int opcode = instrucaoInt/16; 
                int endI = listaInstr.getAnchorSelectionIndex()+1;
                int end = (conversor.binarioParaDecimal(memoria.getInstrucao(endI)))%16;
                switch (opcode) { 
                    case 0: //NOP
                        PC++;
                        break;
                    case 1: //STA
                        memoria.setDado(end, AC.getReg());
                        PC+=2;
                        break;
                    case 2: //LDA
                        AC.setReg(memoria.getDado(end));
                        PC+=2;
                        break;
                    case 3: //ADD
                        AC.setReg(ula.soma(AC.getReg(), memoria.getDado(end)));
                        PC+=2;
                        break;
                    case 6: //NOT
                        AC.setReg(ula.not(AC.getReg()));
                        PC++;
                        break;
                    case 8: //JMP
                        PC=end;
                        break;
                    case 9: //JN
                        if (ula.compNegativo(AC.getReg())) {
                            PC=end;
                        } else {
                            PC+=2;
                        }
                        break;
                    case 15:  //HLT
                        break;
                    default:
                        break;
                }
                PCField.setText(Integer.toString(PC));
                int acInt = conversor.binarioParaDecimal(AC.getReg());
                ACField.setText(Integer.toString(acInt));
                listaInstr.setSelectedIndex(PC);
                listaInstrIndex.setSelectedIndex(PC);
                listaDados.setSelectedIndex(end);
                listaDadosIndex.setSelectedIndex(end);
                janela.validate();
            }
        });
        panel.add(Passo);

        Executar = new JButton("Executar");
        Executar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (PC < 128 && PC == 0) { 
                    char[] instrucao = memoria.getInstrucao(PC);
                    int instrucaoInt = conversor.binarioParaDecimal(instrucao);
                    int opcode = instrucaoInt/16;
                    int end = instrucaoInt%16; 
                    switch (opcode) {
                        case 0:
                            PC++;
                            break;
                        case 1:
                            memoria.setDado(end, AC.getReg());
                            PC+=2;
                            break;
                        case 2:
                            AC.setReg(memoria.getDado(end));
                            PC+=2;
                            break;
                        case 3:
                            AC.setReg(ula.soma(AC.getReg(), memoria.getDado(end)));
                            PC+=2;
                            break;
                        case 5:
                            //PC.setReg(conversor.decimalParaBinario(end));
                            PC=0;
                            break;
                        default:
                            break;
                    }
                    PCField.setText(Integer.toString(PC));
                    int acInt = conversor.binarioParaDecimal(AC.getReg());
                    ACField.setText(Integer.toString(acInt));
                    listaInstr.setSelectedIndex(PC);
                    listaInstrIndex.setSelectedIndex(PC);
                    listaDados.setSelectedIndex(end);
                    listaDadosIndex.setSelectedIndex(end);
                    janela.validate();
                }
            }
        });
        panel.add(Executar);
        janela.add(panel);
        ////////////////////////// 

        //Painel de memoria de dados
        listaDados = new JList<>(memoria.getMemDados());
        listaDados.setFixedCellWidth(80);
        listaDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDados.setSelectedIndex(0);

        dadosIndex = new String[128];
        for (int i = 0; i < 128; i++) {
            dadosIndex[i] = Integer.toString(i+128);
        }
        listaDadosIndex = new JList<>(dadosIndex);
        listaDadosIndex.setFixedCellWidth(50);
        listaDadosIndex.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDadosIndex.setSelectedIndex(0);

        listaDados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int i = listaDados.locationToIndex(e.getPoint());
                    listaDadosIndex.setSelectedIndex(i);
                    dataLabel.setText("Dado [" + i + "]: ");
                    janela.validate();
                }
            }
        });

        listaDadosIndex.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int i = listaDadosIndex.locationToIndex(e.getPoint());
                    listaDados.setSelectedIndex(i);
                    dataLabel.setText("Dado [" + i + "]: ");
                    janela.validate();
                }
            }
        });

        dadosPanel = new JPanel();
        dadosPanel.add(listaDadosIndex);
        dadosPanel.add(listaDados);

        scrollD = new JScrollPane(dadosPanel);
        scrollD.setColumnHeaderView(new JLabel("Endereco // Dados"));
        scrollD.setBorder(BorderFactory.createTitledBorder("Memória de Dados"));
        janela.add(scrollD);
        //////////////////////////
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }

}

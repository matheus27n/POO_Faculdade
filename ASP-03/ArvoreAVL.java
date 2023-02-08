public class ArvoreAVL{
    private Elemento ele;
    private ArvoreAVL esq;
    private ArvoreAVL dir;
    private int bal;

    public ArvoreAVL(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
        this.bal = 0;
    }

    public ArvoreAVL(Elemento elem){
        this.ele = elem;
        this.esq = null;
        this.dir = null;
        this.bal = 0;
    }

    //metodos de controle
    public boolean isEmpty (){
        return (this.ele == null);
    }
    
    public int calularAltura(){
          if(this.esq == null && this.dir == null){ // sem filho
              return 1;
          }
          else if(this.esq != null && this.dir == null){ // só filho à esquerda
              return 1 + this.esq.calularAltura();
          }
          else if(this.esq == null && this.dir != null){ // só filho à direita
              return 1 + this.dir.calularAltura();
          }
          else{ // tem os 2 filhos
              return 1 + Math.max(this.esq.calularAltura(), this.dir.calularAltura());
          }
    }

    public void calcularBalanceamento(){
        if(this.dir == null && this.esq == null){
            this.bal = 0;
        }
        else if( this.esq == null && this.dir != null){
            this.bal =  this.dir.calularAltura() - 0; 
        }
        else if( this.esq != null && this.dir == null){
            this.bal = 0 - this.esq.calularAltura();
        }else{
            this.bal = this.dir.calularAltura() - this.esq.calularAltura();
        }
        if(this.dir != null) this.dir.calcularBalanceamento();
        if(this.esq != null) this.esq.calcularBalanceamento();
        }
    
    //metodos de verificação e rotacao
    public ArvoreAVL verificaBalanceamento(){
      if(this.bal >= 2 || this.bal <= -2){
        if(this.bal >= 2){
            if(this.bal * this.dir.getBalanceamento()>0){
                System.out.println("Rotacao Simples Direita");
                return rotacaoSimplesDireita();
            }
            else{
                System.out.println("Rotacao Dupla Direita");
                return rotacaoDuplaDireita();
            }
        }
        else{
            if(this.bal * this.esq.getBalanceamento() > 0){
                System.out.println("Rotacao Simples Esquerda");
                return rotacaoSimplesEsquerda();
            }
            else{
                System.out.println("Rotacao Dupla Esquerda");
                return rotacaoDuplaEsquerda();
            }
        }
      }
      this.calcularBalanceamento();
      if(this.esq != null) this.esq = this.esq.verificaBalanceamento();
      return this;
}

     
    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoDoFilho = null;

        filhoEsq = this.getEsquerda();
        if(this.esq != null){
            if(this.esq.getDireita()!= null){
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDireita(this);
        this.setEsquerda(filhoDoFilho);
        
        return filhoEsq;  
    }

    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;

        filhoDir = this.getDireita();
        if(this.dir != null){
            if(this.dir.getEsquerda()!= null){
                filhoDoFilho = filhoDir.getEsquerda();
            }
        }
        filhoDir.setEsquerda(this);
        this.setDireita(filhoDoFilho);
        
        return filhoDir;   
    }


    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore       = this;
        ArvoreAVL filhoEsq     = this.getEsquerda();
        ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
        ArvoreAVL noInserido   = filhoDoFilho.getEsquerda();

        //parte 1
        filhoEsq.setDireita(noInserido);
        filhoDoFilho.setEsquerda(filhoEsq);
        this.setEsquerda(filhoDoFilho);

        //parte 2: tomar filho a direita a nova raiz
        ArvoreAVL novoFilhoEsquerda= this.getEsquerda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);
        return novoFilhoEsquerda;
    }

    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore       = this;
        ArvoreAVL filhoDir     = this.getDireita();
        ArvoreAVL filhoDoFilho = filhoDir.getEsquerda();
        ArvoreAVL noInserido   = filhoDoFilho.getDireita();

        //parte 1
        filhoDir.setEsquerda(noInserido);
        filhoDoFilho.setDireita(filhoDir);
        this.setDireita(filhoDoFilho);

        //parte 2: tomar filho a direita a nova raiz
        ArvoreAVL novoFilhoDireita = this.getDireita();
        arvore.setDireita(null);
        novoFilhoDireita.setEsquerda(arvore);
        return novoFilhoDireita;
    }


    public void imprimirPreOrdem(){
        if(!isEmpty()){
            System.out.println(this.ele.getValor() + " ");
            if(this.esq != null){
                this.esq.imprimirPreOrdem();
            }
            if(this.dir != null){
                this.dir.imprimirPreOrdem();
            }
        }
    }

    public void imprimirInOrdem(){
        if(!isEmpty()){
            if(this.esq != null){
                this.esq.imprimirInOrdem();
            }
            System.out.println(this.ele.getValor() + " ");
            if(this.dir != null){
                this.dir.imprimirInOrdem();
            }
        }
    }

    public void imprimirPosOrdem(){
        if(!isEmpty()){
            if(this.esq != null){
                this.esq.imprimirPosOrdem();
            }
            if(this.dir != null){
                this.dir.imprimirPosOrdem();
            }
            System.out.println(this.ele.getValor() + " ");
        }
    } 

    public ArvoreAVL inserir(Elemento novo){
        //se o valor ja existir na arovore na hora de inserir 
        //ele nao sera inserido
        if(!isEmpty()){
            if(novo.getValor() == this.ele.getValor()){
                System.out.println("Valor ja existente na arvore");
                return this;
            }
        }
        if(isEmpty()){
            this.ele = novo;
    }
    else{
        ArvoreAVL novaArvore = new ArvoreAVL(novo);
        if(novo.getValor() < this.ele.getValor()){
            if(this.esq == null){
                this.esq = novaArvore;
            }
            else{
               this.esq = this.esq.inserir(novo);
            }
        }
        else if(novo.getValor() > this.ele.getValor()){
            if(this.dir == null){
                this.dir = novaArvore;
            }
            else{
                this.dir = this.dir.inserir(novo);
            }
        }
     }
    return this;
}

     public ArvoreAVL remover(int elemento){
        //caso 1 - achei elemento e ele não tem filhos
        if(this.ele.getValor() == elemento){
            //ele é um folha
            if(this.esq == null && this.dir == null){
                return null;
            }
            //agora, ele tem filhos
            else{
                //só tem filhos à esquerda
                if(this.esq != null && this.dir == null){
                    return this.esq;
                }
                //só tem filhos à direita
                else if(this.esq == null && this.dir != null){
                    return this.dir;
                }
                //te, os 2 filhos
                else{
                    //busca o maior elemento da subarvore esquerda
                    ArvoreAVL aux = this.dir;
                    while(aux.esq != null){
                        aux = aux.esq;
                    }
                    //troca o elemento a ser removido pelo maior elemento da subarvore esquerda
                    this.setElemento(aux.getElemento());
                    aux.getElemento().setValor(elemento);
                    //arvore da direita recebar a remocao do elemento
                    this.dir = this.dir.remover(elemento);
                }
             }
          }else{
            //caso 2 - elemento não é o que estou procurando
            if(elemento < this.ele.getValor()){
                //elemento está na subarvore esquerda
                if(this.esq != null){
                    this.esq = this.esq.remover(elemento);
                }
            }else{
                //elemento está na subarvore direita
                if(this.dir != null){
                    this.dir = this.dir.remover(elemento);
                }
             }
          }

            return this;
    }

    public boolean busca(int valor){
        if(isEmpty()){
            return false;
        }
        if(this.ele.getValor() == valor){
                return true;
        }
         else{
            if(valor < this.ele.getValor()){
                 if(this.esq == null){
                        return false;
                    }
                    else{
                        return this.esq.busca(valor);
                    }
                }
                else{
                    if(this.dir == null){
                        return false;
                    }
                    else{
                        return this.dir.busca(valor);
                    }
                    
                }
               // return false;
          }
    }
  
    //gets e sets
    public void setBalanceamento(int bal){
        this.bal = bal;
    }
    public void setElemento(Elemento ele){
        this.ele = ele;
    }
    public void setDireita(ArvoreAVL dir){
        this.dir = dir;
    }
    public void setEsquerda(ArvoreAVL esq){
        this.esq = esq;
    }

    public int getBalanceamento(){
        return this.bal;
    }
    public ArvoreAVL getDireita(){
        return this.dir;
    }
    public ArvoreAVL getEsquerda(){
        return this.esq;
    }
    public Elemento getElemento(){
        return this.ele;
    }

    //metado de depuração

    public String printArvore(int level){
           String str = this.ToString()+"\n";
           for(int i = 0; i < level; i++){
               str += "\t";
           }
           if(this.esq != null){
                str += "Esq: " + this.esq.printArvore(level+1);
           }else{
                str += "+-ESQ: NULL";
           }
           str += "\n";

           for(int i = 0; i < level; i++){
               str += "\t";
           }
            if(this.dir != null){
                 str += "Dir: " + this.dir.printArvore(level+1);
            }else{
                 str += "+-DIR: NULL";
            }
            str += "\n";
            return str; 
    }

    public String ToString(){
        return "["+this.ele.getValor()+"] ("+this.bal+")";
    }


  
  
  
  
  
    }





  
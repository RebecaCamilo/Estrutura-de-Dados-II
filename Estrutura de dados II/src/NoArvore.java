import java.io.PrintStream;
import java.util.Vector;

public class NoArvore{
	
	int			valor;
	NoArvore	direita;
	NoArvore	esquerda;
	boolean isnull = true;
	
    public NoArvore(){
        this.valor = 0;
        this.direita = null;
        this.esquerda = null;
        this.isnull = true;
    }
    
    public NoArvore(int novovalor){
        this.valor = novovalor;
        this.direita = null;
        this.esquerda = null;
        this.isnull = false;
    }
	
	
	
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}
	
	
	public boolean getIsNull() {
		return isnull;
	}

	public void setIsNull(boolean isnull) {
		this.isnull = isnull;
	}

	public void imprimeIn(NoArvore a) {
		if(a != null) {
			imprimeIn(a.esquerda);
			System.out.print(a.valor + " ");
			imprimeIn(a.direita);
		}
	}
	
	public void imprimePre(NoArvore a) {
		if(a != null) {
			System.out.print(a.valor + " ");
			imprimePre(a.esquerda);
			imprimePre(a.direita);
		}
	}
	
	
	public void imprimePos(NoArvore a) {
		if(a != null) {
			imprimePre(a.esquerda);
			imprimePre(a.direita);
			System.out.print(a.valor + " ");
		}
	}
	
	public NoArvore busca(NoArvore no, int valorprocurado) {
		if(no == null)
			return null;
		
		if(no.valor > valorprocurado)
			return busca(no.esquerda, valorprocurado);
		else if(no.valor < valorprocurado)
			return busca(no.direita, valorprocurado);
		else
			return no;
	}
	
	public NoArvore inserir(NoArvore no, int novovalor) {
		if(no == null) {
			no = new NoArvore();
			no.valor = novovalor;
			no.esquerda = no.direita = null;
		}
		else if(novovalor < no.valor)
			no.esquerda = inserir(no.esquerda, novovalor);
		else if(novovalor > no.valor)
			no.direita = inserir(no.direita, novovalor);
	
		return no;
	}
	
	
	
	public NoArvore remove(NoArvore raiz, int valoraremover) {
		// faz a busca pelo valor a ser removido
		if (raiz == null) {
			return null;
		}
			
		else if (raiz.valor > valoraremover)
			raiz.esquerda = remove(raiz.esquerda, valoraremover);
		else if (raiz.valor < valoraremover)
			raiz.direita = remove(raiz.direita, valoraremover);
		else {	// passar por aqui significa que achou o nó com o
				// valora remover procurado e agora vai removê-lo
				// segundo as 4 situações a seguir:
			// Não ter filhos (esquerda e direita == null)
			if (raiz.esquerda == null && raiz.direita == null) {
				raiz.setIsNull(true);
				raiz = null;
			}
			// Ter filho apenas à direita (esquerda == null)
			else if (raiz. esquerda == null) {
				raiz = raiz.direita;
			}
			// Ter filho apenas à esquerda (direita == null)
			else if (raiz.direita == null) {
				raiz = raiz.esquerda;
			}
			// Ter dois filhos (esquerda e direita != null)
			else {
				NoArvore sub_esquerda = raiz.esquerda;
				// encontrar o no com maior valor na subárvore esquerda
				while (sub_esquerda.direita != null) {
					sub_esquerda = sub_esquerda.direita;
				}
				// aqui a sub_esquerda.valor tem o maior valor
				raiz.valor = sub_esquerda.valor;
				sub_esquerda.valor = valoraremover;
				raiz.esquerda = remove(raiz.esquerda, valoraremover);
			}
		}
		return raiz;		
	}

	
	
	public int alturaArvore(NoArvore a){
	    if (a == null)
	        return 0;
	    else{
	        return 1 +
	        Math.max(alturaArvore(a.esquerda),
	        alturaArvore(a.direita));
	    }
	}
	
	
	
    boolean isBalanced(NoArvore node){
        int subesq; 
        int subdir; 
 
        if (node == null || node.getIsNull() == true)
            return true;
 
        subesq = alturaArvore(node.esquerda);
        subdir = alturaArvore(node.direita);
 
        if (Math.abs(subesq - subdir) <= 1
            && isBalanced(node.esquerda)
            && isBalanced(node.direita))
            return true;
 
        return false;
    }
    
    
	
	
	public void traversePreOrder(StringBuilder sb, String padding, String pointer, NoArvore node) {
	    if (node != null) {
	        sb.append(padding);
	        sb.append(pointer);
	        sb.append(node.getValor());
	        sb.append("\n");

	        StringBuilder paddingBuilder = new StringBuilder(padding);
	        paddingBuilder.append("|   ");

	        String paddingForBoth = paddingBuilder.toString();
	        String pointerForRight = "\\--";
	        String pointerForLeft = (node.getDireita() != null) ? "|--" : "\\--";

	        traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getEsquerda());
	        traversePreOrder(sb, paddingForBoth, pointerForRight, node.getDireita());
	    }
	}
	
	public void print(PrintStream os, NoArvore a) {
	    StringBuilder sb = new StringBuilder();
	    traversePreOrder(sb, "", "", a);
	    os.print(sb.toString());
	}


	
	
}

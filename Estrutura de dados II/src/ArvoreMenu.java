import java.util.Scanner;
import java.lang.Character;


public class ArvoreMenu implements Runnable {
    //----------------------------------------Fim do Menu
	
	//public static Scanner entrada = new Scanner(System.in);
	NoArvore abb = new NoArvore();


	
    public ArvoreMenu() {
    }
	

    public static void main(String[] args) {
    	
        System.out.println("Árvore Binária de Busca");
        
        ArvoreMenu menu = new ArvoreMenu();
        menu.run();
    }
    
    @Override
    public void run() {
        menuPrincipal();
    } //----------------------------------------Fim do método run


    private void menuPrincipal() {
        char comando;
        char fimDoMenuComando = '7';
        do {
            comando = exibirMenuPrincipal();
            switch(comando) {	
                case '1':
                    inserirNumero();
                    break;
                case '2':
                    submenuDeletar();
                    break;
                case '3':
                    localizarNumero();
                    break;
                case '4':
                	submenuArvore();
                    break;
                case '5':
                	submenuMetricasArvore();
                    break;
                case '6':
                	mostrarCreditos();
                    break;
                case '7':
                	fimDoPrograma();
                    break;
                default:
                    System.out.println("Escolha errada!");
            }
		
        } while(comando != fimDoMenuComando);
    }
    
    public static char exibirMenuPrincipal() {
        String msg;
        System.out.println("\n--------------------------------------------------");
        System.out.println("= Arvore");
        System.out.println("= Escolha uma opção");
        System.out.println("--------------------------------------------------");
        System.out.println("= 1: Inserir Número");
        System.out.println("= 2: Deletar Número");
        System.out.println("= 3: Localizar Número");
        System.out.println("= 4: Mostrar Arvore");
        System.out.println("= 5: Métricas");
        System.out.println("= 6: Créditos");
        System.out.println("= 7: Sair do Programa");
        System.out.println("--------------------------------------------------\n");

        //recebendo entrada para decidir o menu
        msg = new Scanner(System.in).next();
        return msg.charAt(0);
    }


    private void submenuMetricasArvore() {
        char comando;
        char fimDoMenuComando = '3';
        do {
            comando = exibirSubmenuMetricas();
            switch(comando) {
                case '1':
                	
                	if(abb == null || abb.getIsNull() == true) {
                		System.out.println("Árvore vazia");
                	}
                	else {
                		isBalanceada();
                	}
                    break;	
                case '2':
                	alturaArvore();
                    break;	
                case '3':
                    voltarMenuPrincipalAcao();
                    break;
                default:
                    System.out.println("Escolha errada!");
                    break;
            }
        } while(comando != fimDoMenuComando);
    }
    
    
    
    private void submenuDeletar() {
        char comando;
        char fimDoMenuComando = '3';
        do {
            comando = exibirSubmenuDeletar();
            switch(comando) {
                case '1':
                	if(abb == null || abb.getIsNull() == true) {
                		System.out.println("Árvore vazia");
                	}
                	else {
                		deletarNumero();
                	}
                    break;	
                case '2':
                	if(abb == null || abb.getIsNull() == true) {
                		System.out.println("Árvore vazia");
                	}
                	else {
                		deletarArvore();
                	}
                    break;	
                case '3':
                    voltarMenuPrincipalAcao();
                    break;
                default:
                    System.out.println("Escolha errada!");
                    break;
            }
        } while(comando != fimDoMenuComando);
    }
    
    
    
    
    private void submenuArvore() {
        char comando;
        char fimDoMenuComando = '3';
        do {
            comando = exibirSubmenuArvore();
            switch(comando) {
                case '1':
                	
                	if(abb == null || abb.getIsNull() == true) {
                		System.out.println("Árvore vazia");
                	}
                	else {
                    	System.out.println("Exibindo Ordens\n");
                    	System.out.print("Pré-Ordem\n\t");
                        mostrarPreOrdemAcao();
                    	System.out.print("\nEm Ordem\n\t");
                        mostrarEmOrdemAcao();
                    	System.out.print("\nPós-Ordem\n\t");
                        mostrarPosOrdemAcao();
                	}
                    break;	
                case '2':
                	mostrarGraficamenteAcao();
                    break;	
                case '3':
                    voltarMenuPrincipalAcao();
                    break;
                default:
                    System.out.println("Escolha errada!");
                    break;
            }
        } while(comando != fimDoMenuComando);
    }
    
    //Método SubMenu
    public static char exibirSubmenuArvore() {
        String msg;
        System.out.println("\n--------------------------------------------------");
        System.out.println("= Mostrar Arvore");
        System.out.println("= Escolha uma opção");
        System.out.println("--------------------------------------------------");
        System.out.println("= 1: Exibir Ordens");
        System.out.println("= 2: Exibir Graficamente");
        System.out.println("= 3: Voltar ao Menu Principal");
        System.out.println("--------------------------------------------------\n");
		
        //recebendo entrada para decidir o escholhaDeArvore
        msg = new Scanner(System.in).next();
        return msg.charAt(0);
		
    }//----------------------------------------Fim do SubMenu
    
    
    //Método SubMenu
    public static char exibirSubmenuDeletar() {
        String msg;
        System.out.println("\n--------------------------------------------------");
        System.out.println("= Deletar Número ou Arvore");
        System.out.println("= Escolha uma opção");
        System.out.println("--------------------------------------------------");
        System.out.println("= 1: Deletar Número");
        System.out.println("= 2: Deletar Árvore");
        System.out.println("= 3: Voltar ao Menu Principal");
        System.out.println("--------------------------------------------------\n");
		
        //recebendo entrada para decidir o escholhaDeArvore
        msg = new Scanner(System.in).next();
        return msg.charAt(0);
		
    }//----------------------------------------Fim do SubMenu
    
    
    //Método SubMenu
    public static char exibirSubmenuMetricas() {
        String msg;
        System.out.println("\n--------------------------------------------------");
        System.out.println("= Métricas da Arvore");
        System.out.println("= Escolha uma opção");
        System.out.println("--------------------------------------------------");
        System.out.println("= 1: Verificar balanceamento");
        System.out.println("= 2: Altura");
        System.out.println("= 3: Voltar ao Menu Principal");
        System.out.println("--------------------------------------------------\n");
		
        //recebendo entrada para decidir a metricas
        msg = new Scanner(System.in).next();
        return msg.charAt(0);
		
    }//----------------------------------------Fim do SubMenu

    private void inserirNumero() {
    	Scanner entrada = new Scanner(System.in);
    	int num;
    	System.out.println("Insirir número: ");
    	
    	
    	while(entrada.hasNextInt()) {
    		num = entrada.nextInt();
    		
    		if(abb == null) {
    			abb = new NoArvore();
    			abb.valor = num;
    			abb.setIsNull(false);
    		}
    		else if(abb.getIsNull() == true) {
    			//System.out.println("Arvore nula? " + abb.getIsNull());
    			abb.valor = num; 
    			abb.setIsNull(false);
    			//System.out.println("Arvore nula? " + abb.getIsNull());
    		}
    			   		
        	else {
        		//System.out.println("Arvore nula? " + abb.getIsNull());
        		abb.inserir(abb, num);
        		//System.out.println("Arvore nula? " + abb.getIsNull());
        	}
        		abb.inserir(abb, num);
        	
        	System.out.println("Número " + num + " inserido na árvore.");        	
        	System.out.println("Inserir novo número? (Digite 'S' para sair) ");
    	}  
    	
    	//entrada.close();
        
    }
    
    private void deletarNumero() {
    	Scanner entrada = new Scanner(System.in);
    	int num;
    	
   	
    	if(abb == null || abb.getIsNull() == true) {
    		System.out.println("Árvore vazia.");
    	}
    	else if(abb.getIsNull() == false) {
    		System.out.println("\nDeletar número: ");
        	while(entrada.hasNextInt()) {
        		num = entrada.nextInt();
        		
        		if(abb.busca(abb, num) != null) {
		    		abb.remove(abb, num);
		    		System.out.println("\nNúmero " + num + " deletado da árvore.");
		    		
		    		if(abb == null || abb.getIsNull() == true) {
		    			abb = null;
		    			System.out.println("Árvore vazia.");
		    			break;
		    		}
		    		
		    		System.out.println("Deletar novo número? (Digite qualquer caracter para sair)"); 
		    		
		    	}
		    	else {
		    		System.out.println("Número não encontrado.");
		    		break;
		    	}
		    }
    	}
    	else
    		System.out.println("Árvore vazia.");
    	//entrada.close();
    }
    
    private void deletarArvore(){
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Deseja realmente deletar a árvore? (S/n)");
    	String str = entrada.nextLine();

    	if(str.equals("S") || str.equals("Sim") || str.equals("s") || str.equals("sim")) {
    		abb = null;
    		System.out.println("Árvore vazia.");
    		
    	}
    		
    }



    private void localizarNumero() {
    	Scanner entrada = new Scanner(System.in);
    	int num;
    	if(abb == null || abb.getIsNull() == true) {
    		System.out.println("Árvore vazia.");
    	}
    	else if(abb.getIsNull() == false) {
    		System.out.println("Localizar número: ");
    		num = entrada.nextInt();
    		if(abb.busca(abb, num) != null)
    			System.out.println("Valor encontrado: " + num);
        	else
        		System.out.println("Número não encontrado.");
    	}
    	//entrada.close();
    }


    private void carregarDados() {
        System.out.println("Carregar Dados");
    }
   

    private void mostrarPreOrdemAcao() {
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }
        else 
        	abb.imprimePre(abb);
    }

    private void mostrarEmOrdemAcao() {
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }
        else 
        	abb.imprimeIn(abb);
    }


    private void mostrarPosOrdemAcao() {
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }
        else 
        	abb.imprimePos(abb);
    }


    private void mostrarGraficamenteAcao() {
        System.out.println("Mostrar graficamente.");
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }
        else 
        	abb.print(System.out, abb);
    	
    }


    private void voltarMenuPrincipalAcao() {
        System.out.println("Voltando ao Menu Principal");
    }



    private void isBalanceada() {
        System.out.println("Verificando balanceamento");
        
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }        
        else if (abb.isBalanced(abb))
            System.out.println("A árvore está balanceada");
        else
            System.out.println("A árvore não está balanceada");
    }
    
    
    private void alturaArvore() {
        System.out.println("Mostrar altura da árvore");
        
        if(abb == null || abb.getIsNull() == true) {
        	System.out.println("Árvore vazia.");
        }        
        else
            System.out.println("A altura da árvore é: " + abb.alturaArvore(abb));
    }


    private void exportarDados() {
        System.out.println("Exportar Dados");
    }

    private void mostrarCreditos() {
        System.out.println("\nCréditos");
        System.out.println("Equipe:");
        System.out.println("\tHayla Perazzo");
        System.out.println("\tKleber Barros");
        System.out.println("\tRebeca Camilo");
        System.out.println("\nProfessor:");
        System.out.println("\tWalter T. Sarinho");
    }
    

    private void fimDoPrograma() {
        System.out.println("Fim do Programa!");
    }

} //----------------------------------------Fim da classe ArvoreMenu

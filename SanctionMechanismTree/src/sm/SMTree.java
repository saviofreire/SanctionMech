package sm;

import jamder.Actions;
import jamder.Norms;

public class SMTree {

	//Raiz da arvore - meta g0
	No raiz;

	//Construtor cria a raiz
	public SMTree(Norms norma, Operador operador){
		this.raiz = new No(norma, operador);
	}

	//inserir em um no um valor
	public void inserir_delegacao(Norms norma_local, Norms norma_inserir, Operador operador){
		this.buscar_no_inserir(this.raiz, norma_local, norma_inserir, operador);
	}

	//buscar um no com valor
	public void buscar_um_no(Norms norma_local){
		buscar_no(this.raiz, norma_local);
	}


	protected void buscar_no(No no, Norms norma_local){
		if(no.generico != false && no.norma.getAction().getCod() == norma_local.getAction().getCod()){
			System.out.print("N� ENCONTRADO: \t");
			show_linha(no);
			System.out.print("\nSEU PAI: \t");
			show_linha(no.pai);
		}else 
		{	
			if(no.esquerda != null)
				buscar_no(no.esquerda, norma_local);
			if(no.direita != null)
				buscar_no(no.direita, norma_local);
		}	
	}

	protected void buscar_no_inserir(No no, Norms norma_local, Norms norma_inserir, Operador operador){

		if(no.generico !=false && no.norma.getAction().getCod() == norma_local.getAction().getCod()){
			this.inserir(no, norma_local, norma_inserir, operador);
		}else 
		{	
			if(no.esquerda != null)
				buscar_no_inserir(no.esquerda, norma_local, norma_inserir, operador);
			if(no.direita != null)
				buscar_no_inserir(no.direita, norma_local, norma_inserir, operador);
		}		
	}

	protected void inserir(No no, Norms norma_local, Norms norma_inserir, Operador operador) {

		if(no.esquerda == null){

			no.esquerda = new No(norma_inserir, operador);
			no.esquerda.pai = no;

		}else if(no.direita == null){

			no.direita = new No(norma_inserir, operador);
			no.direita.pai = no;

		}else if(no.direita.generico == true){

			No temp = no.direita;
			No gr = new No(no.operador);//Criacao do no generico
			gr.pai = no;
			gr.esquerda = temp;
			gr.esquerda.pai = gr;
			gr.direita = new No(norma_inserir, operador);
			gr.direita.pai = gr;
			no.direita = gr;


		}else if(no.direita.generico == false){

			inserir(no.direita, norma_local, norma_inserir, operador);
		}

	}

	//Exibir a estrutura da �rvore
	public void show( int level, No no){

		if(level == 0)
			System.out.print("(RAIZ) \t\t");
		show_linha(no);

		System.out.print("\n");
		level++;

		if(no.esquerda != null){
			System.out.print("(NIVEL"+level + " - ESQ)\t");
			show(level, no.esquerda);
		}
		if(no.direita != null){
			System.out.print("(NIVEL"+level + " - DIR)\t");
			show(level, no.direita);
		}


	}

	public void show_linha(No no){
		if(no.generico == false){
			System.out.print("#		#			g�	(NO GENERICO)");
		}else{
			System.out.print(no.norma.getAgente().getName());
			System.out.print("\t\t");
			System.out.print(no.norma.getAgente().getPapel().getName());
			System.out.print("\t\t");
			System.out.print(no.norma.getAction().getCod());
			System.out.print("\t");
			System.out.print(no.norma.getAction().getNome());
			System.out.print("\t");
			if(no.pai != null && no.pai.operador !=null)
				System.out.print(no.pai.operador.getValor());

		}
	}

	public No getRaiz() {
		return raiz;
	}

	public void calcular_custos_das_sancoes(Norms norma){
		bs_no_sc(this.raiz, norma);
	}

	protected void bs_no_sc(No no, Norms norma){

		if(no.generico != false && no.norma.getAction().getCod() == norma.getAction().getCod()){
			System.out.print(no.norma.getAction().getCod()+ "\t");
			System.out.print("Cvmf = " + calcular_Cvmf(no) +"\n");
		}else 
		{	
			if(no.esquerda != null)
				bs_no_sc(no.esquerda, norma);

			if(no.direita != null)
				bs_no_sc(no.direita, norma);

		}	
	}

	protected int calcular_Cvmf(No no){
		int Cvmf = 0;       //Custo de viol�ao da acao final
		int Cvi = 0;        //Custo de viola��o individual
		int Cvc = 0;        //Custo de viola�ao coletiva	
		int Cvg = 0;        //Custo de viola�ao gerencial
		
		if(no.cumprido == false){
			if(no.esquerda !=null || no.direita !=null){ 	//Verifica se o n� possui uma meta gerencial, que define sub-metas
				//Cvi += -2;
				Cvc += 0;
				Cvg += -1;
			}
			if(no.pai !=null){
				if (no.pai.operador == Operador.PARALELO){ //meta organizada em paralelo
	
					Cvi += -2;
					if ( no_irmao(no).cumprido == true) //Verifica se a meta irm� a esta foi cumprida
						Cvc += -1;  
					Cvg += 0;            
				}
				else if(no.pai.operador == Operador.ESCOLHA){ //metas em escolha
					if( no_irmao(no).cumprido == false )  
						Cvi += -2;
					Cvc += 0;
					Cvg += 0;
				}
				else if(no.pai.operador == Operador.SEQUENCIA){//metas em sequencia
					Cvi += -2;                  
					if( no_irmao(no).cumprido == true) //Verifica se a meta pr�xima a esta foi cumprida
						Cvc += -1;
					Cvg += 0;
				}	    	
			}
		}
		
		Cvmf = (Cvi + Cvc + Cvg);
		return Cvmf;
	}

	protected No no_irmao(No no){
		No no_proximo = null;
		if(no.pai.esquerda != no)
			no_proximo = no.pai.esquerda;
		else if(no.pai.direita != no)
			no_proximo = no.pai.direita;

		return no_proximo;
	}

	//Executar metas
	public void executar_metas(No no){

		if(no.esquerda == null ){
			System.out.print("Executando meta " + no.norma.getAction().getCod());

			if(no.norma.getAction().getCod() == "g12"){
				no.cumprido = false;
				
			}else{
				no.cumprido = true;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t Executou: " + no.cumprido);

		}else{
			executar_metas(no.esquerda);
			if(no.esquerda.cumprido == true){
				executar_metas(no.direita);
			}
			if(no.esquerda.cumprido == true && no.direita.cumprido == true){
				System.out.print("Executando meta " + no.norma.getAction().getCod());
				no.cumprido = true;
				System.out.println("\t Executou: " + no.cumprido);
			}else{
				System.out.print("Executando meta " + no.norma.getAction().getCod());
				no.cumprido = false;
				System.out.println("\t Executou: " + no.cumprido);
			}

		}
	}

}

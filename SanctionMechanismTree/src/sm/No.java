package sm;

import jamder.Actions;
import jamder.Agent;
import jamder.AgentRole;
import jamder.Norms;

public class No {

	
	boolean generico = true;	//Se for um no generico (= false)
	
	No pai = null;											
    No esquerda = null;  
    No direita = null;  
    
    Norms norma;
    Operador operador;
    boolean cumprido = false;
    
    public No(Norms norma, Operador operador) {
        this.norma = norma;
        this.generico = true;
        this.operador = operador;
    }
    
    public No(Operador operador) {
    	this.norma = null;
        this.generico = false; 
        this.operador = operador;
    }
    
}

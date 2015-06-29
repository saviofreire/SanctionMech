package jamder.norms;

import java.util.Hashtable;

public abstract class NormAction {
	protected NormResource normResource;
	protected Hashtable<String, Norm> norms = new Hashtable<String, Norm>();
	protected boolean run=false;//Indica se a NormAction foi executada. Tem que ser implementado. :-B
	
	/**Cria uma ação de norma */
	public NormAction(NormResource normResource){
		this.setNormResource(normResource);
	}
	
	// Norms
	public Norm getNorm(String key) {
		return norms.get(key);
	}
	public void addNorm(String key, Norm norm) {
		norms.put(key, norm);
	}
	public Norm removeNorm(String key) {
		return norms.remove(key);
	}
	public void removeAllNorms() {
		norms.clear();
	}
	public Hashtable<String, Norm> getAllNorms() {
		return norms;
	}
	
	
	// Gets e sets
	public NormResource getNormResource() {
		return normResource;
	}
	//Modificado por  Israel 14/06/2012
	public void setNormResource(NormResource normResource) {
		this.normResource=normResource;
		/*Dar suporte à verificação das ação vinculadas ao resource. Problema: 
		  * Só está tratando ações e planos.*/
		if (this.normResource.getAction()!=null){
			this.normResource.getAction().addNormAction(this);
		}else{
			if (this.normResource.getPlan()!=null){
				this.normResource.getPlan().addNormAction(this);
			}
		}
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	
}
	

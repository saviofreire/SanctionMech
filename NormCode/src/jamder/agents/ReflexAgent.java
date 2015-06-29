/**
 * 
 */
package jamder.agents;

import jamder.Environment;
import jamder.behavioural.Action;
import jamder.behavioural.Sensor;
import jamder.norms.Norm;
import jamder.norms.NormType;
import jamder.roles.AgentRole;

import java.util.Hashtable;


/**
 * @author Yrleyjander Salmito
 * 
 */
public abstract class ReflexAgent extends GenericAgent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Sensor perception = new Sensor(this, 1000L);
	private boolean normative = false;

	// Perceive List
	protected Hashtable<String, Action> perceives = new Hashtable<String, Action>();
	//chamar método do ambiente para pegar o que ele quer.
	// hashtable de name e value 
	//criar um comportamento que chama o ambiente de em tempo em tempo

	// Precondition List
	// na verdade é uma lista de açoes que tem pre e pos condicoes
	
	protected ReflexAgent(String name, Environment environment, AgentRole agentRole) {
		super(name, environment, agentRole);
	}
	
	/**
	 * Indicates when a Reflex Agent is normative or not.
	 * @author Israel
	 * @version 1
	 */
	public boolean isNormative() {
		return normative;
	}

	public void setNormative(boolean normative) {
		this.normative = normative;
	}


	// Perceives
	protected Action getPerceive(String perceive) {
		return perceives.get(perceive);
	}
	protected void addPerceive(String perceive, Action action) {
		perceives.put(perceive, action);
	}
	protected Action removePerceive(String perceive) {
		return perceives.remove(perceive);
	}
	protected void removeAllPerceives() {
		perceives.clear();
	}
	protected Hashtable<String, Action> getAllPerceives() {
		return perceives;
	}
	
	// Put agent initializations here
	protected void setup() {
		super.setup();
		
		// Papel de agente
		// Agente Reativo simples, possui somente comportamento

	}

	// Put agent clean-up operations here
	protected void takeDown() {

	}

	public void percept(Object perception) {
		Action action=null;
		if (perception instanceof String && perceives.containsKey((String)perception)){
			action = perceives.get(perception);
			addBehaviour(action);
		}
	}
	
	public Norm containsNorm(Action ac, NormType nt){
		for (Norm nor: getAllRestrictNorms().values()){
			Action a=nor.getAction().getNormResource().getAction();
			boolean valida=a!=null && 
					a.getName().equalsIgnoreCase(ac.getName()) && 
					nor.getNormType()==nt && 
					nor.isActive();
			if (valida){
				return nor;
			}
		}
		return null;
	}
	public Norm containsNormDiferent(Action ac, NormType nt){
		for (Norm nor: getAllRestrictNorms().values()){
			Action a=nor.getAction().getNormResource().getAction();
			boolean valida=a!=null && 
					!a.getName().equalsIgnoreCase(ac.getName()) && 
					nor.getNormType()==nt && 
					nor.isActive();
			if (valida){
				return nor;
			}
		}
		return null;
	}
}

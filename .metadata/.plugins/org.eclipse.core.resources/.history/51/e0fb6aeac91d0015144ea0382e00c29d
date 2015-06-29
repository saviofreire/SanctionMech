package jamder.behavioural;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jamder.agents.GenericAgent;
import jamder.agents.ReflexAgent;
import jamder.monitoring.Monitor;
import jamder.norms.AtomicAction;
import jamder.norms.AtomicActionType;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormType;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Action extends Behaviour{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String name;
	private Hashtable<String, Condition> pre_conditions = new Hashtable<String, Condition>();
	private Hashtable<String, Condition> pos_conditions = new Hashtable<String, Condition>();
	private List<NormAction> norm_actions = new ArrayList<NormAction>();//Israel - Avisar a NormAction que a ação foi executada.
	private boolean done = false;
	private NormType normType=null;
	private Monitor monitor=null;
	private boolean isCyclic=false; //Indica se a ação é ciclica(continua executando até que as pre_conditions sejam verdadeiras). Israel
	
	// Default constructor
	public Action(String name) { 
		this.name = name;
	}
	
	// Constructor with conditions
	public Action(String name, Condition pre_condition, Condition pos_condition) {
		this.name = name;
		this.setBehaviourName(name);
		if (pre_condition != null) {
			pre_conditions.put(pre_condition.getName(), pre_condition);
		}
		
		if (pos_condition != null) {
			pos_conditions.put(pos_condition.getName(), pos_condition);
		}
	}
	
	public Action(String name, Condition pre_condition, Condition pos_condition, NormType normType) {
		this.name = name;
		this.normType=normType;
		this.setBehaviourName(name);
		if (pre_condition != null) {
			pre_conditions.put(pre_condition.getName(), pre_condition);
		}
		
		if (pos_condition != null) {
			pos_conditions.put(pos_condition.getName(), pos_condition);
		}
	}
	
	// Name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//NormType
	public NormType getNormType(){
		return this.normType;
	}
	public void setNormType(NormType normType) {
		this.normType = normType;
	}
	
	// Pre-conditions
	public Condition getPreCondition(String key) {
		return pre_conditions.get(key);
	}
	public void addPreCondition(String key, Condition condition) {
		pre_conditions.put(key, condition);
	}
	public Condition removePreCondition(String key) {
		return pre_conditions.remove(key);
	}
	public void removeAllPreConditions() {
		pre_conditions.clear();
	}
	public Hashtable<String, Condition> getAllPreConditions() {
		return pre_conditions;
	}
	
	// Pos-conditions
	public Condition getPosCondition(String key) {
		return pos_conditions.get(key);
	}
	public void addPosCondition(String key, Condition condition) {
		pos_conditions.put(key, condition);
	}
	public Condition removePosCondition(String key) {
		return pos_conditions.remove(key);
	}
	public void removeAllPosConditions() {
		pos_conditions.clear();
	}
	public Hashtable<String, Condition> getAllPosConditions() {
		return pos_conditions;
	}
	
	//NormActions
	
	public void removeNormAction(NormAction action) {
		norm_actions.remove(action);
	}
	
	public void removeAllNormActions() {
		norm_actions.clear();
	}
	
	public void addNormAction(NormAction action) {
		this.norm_actions.add(action);
	}
	
	//Cyclic
	
	public boolean isCyclic() {
		return isCyclic;
	}

	public void setCyclic(boolean isCyclic) {
		this.isCyclic = isCyclic;
	}

	public void execute(){
		// Checks if all pre-conditions are true
		// execute();
		// else done
		{
			done = true;
			return;
		}
	}
	// Manager
	public void setMonitor(Monitor monitor) {//Gerente do agente que está executando a ação.
		this.monitor = monitor;
	}
	
	private void exe(){
		execute();
		
		// Israel - Manda um sinal para todas as NormActions vinculadas a esta Action.
		for (NormAction ac: norm_actions){
			if (ac instanceof AtomicAction){
				AtomicAction aa=(AtomicAction) ac;
				if (aa.getType()==AtomicActionType.AtomicExecute)
					aa.setRun(true);
			}
		}
		//Manda um sinal para o monitor junto com a ação (this).
		if (this.monitor!=null  && getAgent() instanceof GenericAgent){//Apenas para o agente reflexivo.
			this.monitor.percept(getAgent(), this);
		}
	}

	@Override
	final public void action() { //Só executa e manda o sinal de que executou quando as pré-condições forem atendidas.
		/*Tornar este método como final obriga o usuário a utilizar o método execute e o proibi de modificar action.
		 * Assim será possível aplicar sanções ao agente caso ele execute uma ação vinculada a uma norma.
		 */
		boolean validates=true;
		for (Condition cond:pre_conditions.values()){
			if (!cond.getValue()){
				validates=false;
				break;
			}
		}
		Agent ag=getAgent();
		if (ag instanceof ReflexAgent && ((ReflexAgent)ag).isNormative()){
			ReflexAgent ra=(ReflexAgent)ag;
			Norm n1=ra.containsNorm(this , NormType.OBLIGATION);
			if (n1!=null){
				//System.out.println(n1.getName()+"1");
				this.setNormType(NormType.OBLIGATION);
				exe();
			}else{
				Norm n2=ra.containsNormDiferent(this, NormType.OBLIGATION);
				if (n2==null){
					Norm n3=ra.containsNorm(this, NormType.PROHIBITION);
					if(n3==null){
						if (validates || pre_conditions.size()==0){ //Só executa e manda o sinal de que executou quando as pré-condições forem atendidas.
							//System.out.println("2"+this.getName());
							this.setNormType(NormType.PERMISSION);
							exe();
						}
					}else this.setNormType(NormType.PROHIBITION);
				}
			}
		}else{
			if (validates || pre_conditions.size()==0){ //Só executa e manda o sinal de que executou quando as pré-condições forem atendidas.
				exe();
			}
		}
		if(!isCyclic) done=true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean done() {
		if (done) {
			return done;
		} else {
			// Checks if all pos-conditions are true 
			return false;
		}
	}
}

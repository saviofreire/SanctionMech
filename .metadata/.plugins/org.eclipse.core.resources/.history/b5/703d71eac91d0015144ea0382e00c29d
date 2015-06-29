package jamder.roles;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.behavioural.Action;
import jamder.monitoring.Monitor;
import jamder.norms.Norm;
import jamder.norms.NormType;

import java.util.Hashtable;
//import jamder.behavioural.Right;

public class AgentRole {

	protected Organization owner;
	private String name;
	protected GenericAgent player;
	private AgentRoleStatus status;
	private Hashtable<String, Behaviour> protocols = new Hashtable<String, Behaviour>();
	protected Hashtable<String, Norm> restrictNorms = new Hashtable<String, Norm>();
	protected Hashtable<String, Action> actions = new Hashtable<String, Action>();
	protected Monitor monitor=null;
	
	// Organization
	public Organization getOwner() {
		return owner;
	}

	// Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Player
	public GenericAgent getPlayer() {
		return player;
	}
	
	// Agent Role Status
	public AgentRoleStatus getAgentRoleStatus() {
		return status;
	}
	
	public AgentRole(String name, Organization owner, GenericAgent player) {
		this.owner = owner;
		this.name = name;
		this.player = player;
		// Ownership the role to the owner
		this.owner.addAgentRole(name, this);
		
		if (player != null) {
			if (player instanceof Organization) {
				Organization suborg = (Organization) player;
				suborg.setSuperOrganization(owner);
				suborg.getSuperOrganization().addSubOrganization(suborg.getName(), suborg);
			}
			player.addAgentRole(name, this);
			status.ACTIVATE.setStatus(true);
		}
	}
	

	

	
	// Protocols
	public Behaviour getProtocol(String key) {
		return protocols.get(key);
	}
	public void addProtocol(String key, Behaviour protocol) {
		protocols.put(key, protocol);
	}
	public Behaviour removeProtocol(String key) {
		return protocols.remove(key);
	}
	public void removeAllProtocols() {
		protocols.clear();
	}
	public Hashtable<String, Behaviour> getAllProtocols() {
		return protocols;
	}
	
	//RestrictNorms
	
	protected Norm getRestrictNorm(String key) {
		return restrictNorms.get(key);
	}
	public void addRestrictNorm(String key, Norm restrictNorm) {
		restrictNorms.put(key, restrictNorm);
	}
	public Norm removeRestrictNorm(String key) {
		return restrictNorms.remove(key);
	}
	protected void removeAllRestrictNorms() {
		restrictNorms.clear();
	}
	protected Hashtable<String, Norm> getAllRestrictNorms() {
		return restrictNorms;
	}
	
	// Actions
	public Action getAction(String key) {
		return actions.get(key);
	}
	public void addAction(String key, Action action) {
		actions.put(key, action);
	}
	public Action removeAction(String key) {
		return actions.remove(key);
	}
	public void removeAllActions() {
		actions.clear();
	}
	public Hashtable<String, Action> getAllActions() {
		return actions;
	}
	public boolean containAction(String key){
		return actions.containsKey(key);
	}	
	
	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	/** 
	 * Checking what actions are restricted by norms.
	 * @author Israel
	 * @version 1
	 *  */
	public void checkingNorms(){
		for (Action aca: this.actions.values()){
			aca.setNormType(null);
		}
		for (Norm nor: this.restrictNorms.values()){
			if (nor.isActive() && nor.getAction()!=null){
				 Action acb=nor.getAction().getNormResource().getAction();
				if (acb!=null && this.actions.containsKey(acb.getName())){//Uma norma vinculada a uma ação.
					Action acc = this.actions.get(acb.getName());
					acc.setNormType(nor.getNormType());//Descobre que ação são proibidas, obrigadas e permitidas.
				}
			}
		}
	}
	/** 
	 * Performs all actions permitted (old rights) and required (old duties) linked to the role of agent.
	 * @author Israel
	 * @version 3.02
	 *  */
	public void initialize() {
		checkingNorms();
		ParallelBehaviour allActions = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		for (Action action : this.actions.values()) {
			if (action.getNormType() != null){//Apenas ações vinculadas ao conceito deôntico.
				if (this.monitor!=null)
					action.setMonitor(this.monitor);
				if (action.getNormType() == NormType.OBLIGATION /* duties */){
					if (player.containAction(action.getName())) {
						allActions.addSubBehaviour(player.getAction(action.getName()));
					} else {
						System.out.println("This agent does not contain all required actions: " + player.getName());
						return;
					}
				}else{
					if (action.getNormType() == NormType.PERMISSION /* rights */){
						if (player.containAction(action.getName())) {
							allActions.addSubBehaviour(player.getAction(action.getName()));
						}
					}else{
						if (action.getNormType() == NormType.PROHIBITION){
							if (player.containAction(action.getName())){
								System.out.println("This agent contain a prohibited action: " + player.getName());
								//return;
							}
						}
					}
				}
			}
			
		}
		// Associate all actions to the agent or sub-organization to be played
		player.addBehaviour(allActions);
	}
	
	/** 
	 * Restarts the agent role.
	 * @author Israel
	 * @version 3
	 *  */
	public void activeRole() {
		this.status = AgentRoleStatus.ACTIVATE;
		for (Action action : this.actions.values()) {
			action.reset();
		}
	}
	
	/** 
	 * Changes the status of the agent role.
	 * @author Israel
	 * @version 3
	 *  */
	public void changeDeactiveRole(AgentRoleStatus status) {
		this.status = status;
		for (Action action : this.actions.values()) {
			action.block();
		}
	}
	
}

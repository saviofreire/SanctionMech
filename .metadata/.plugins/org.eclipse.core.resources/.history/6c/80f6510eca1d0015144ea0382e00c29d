package jamder.roles;

import jade.core.behaviours.ParallelBehaviour;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.behavioural.Action;
import jamder.norms.NormType;

public class ReflexAgentRole extends AgentRole {

	private String name;
	//private MAS_Agent entity; It nests the agent (entity)

	
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

	
	public ReflexAgentRole(String name, Organization owner, GenericAgent player) {
		super(name, owner, player);
		initialize();
	}
	
	/** 
	 * Performs all actions permitted (old rights) and required (old duties) linked to the role of agent.
	 * @author Israel
	 * @version 3.02
	 *  */
	public void initialize() {ParallelBehaviour allActions = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		checkingNorms();
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
	
}

package jamder.agents;

import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.Location;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jamder.Environment;
import jamder.Organization;
import jamder.behavioural.Action;
import jamder.monitoring.Monitor;
import jamder.norms.Norm;
import jamder.norms.NormType;
import jamder.roles.AgentRole;
import jamder.roles.AgentRoleStatus;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract class GenericAgent extends Agent {

	private static final long serialVersionUID = 2L;
	private Hashtable<String, AgentRole> agentRoles = new Hashtable<String, AgentRole>();
	private Hashtable<String, Organization> organizations = new Hashtable<String, Organization>();
	private Environment environment ;
	private Hashtable<String, Action> actions = new Hashtable<String, Action>();
	private List<ACLMessage> sentMessages = new ArrayList<ACLMessage>();
	private String name;
	protected Hashtable<String, Norm> restrictNorms = new Hashtable<String, Norm>();
	private Monitor monitor=null;
	
	
	protected GenericAgent(String name, Environment environment, AgentRole agentRole) {
		super();
		this.environment = environment;
		this.name = name;
		/*
		organizations.put(organization.getName(), organization);
		this.doMove(organization.getContainerID());
		*/
		if (agentRole != null){
			agentRoles.put(agentRole.getName(), agentRole);
		}
		//this.environment.addAgent(name, this);
		
	}
	
	// Name
	
	public void setName(String name) {
		this.name = name;
	}

	// Environment
	public Environment getEnvironment() {
		return environment;
	}
		
	//Manager
	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	// AgentRoles
	public AgentRole getAgentRole(String name) {
		return agentRoles.get(name);
	}
	/**Adiciona um AgentRole
	 * @author Yrleijander, Israel
	 * @version 3.01
	 * */
	public void addAgentRole(String name, AgentRole role) {
		boolean found = false;
		role.checkingNorms();
		for (Action action : role.getAllActions().values()) {
				if (action.getNormType()==NormType.OBLIGATION){//Se é um dever...
					String actionName = action.getClass().getName();
					for (Action actionAgent : getAllActions().values()) {
						if (actionAgent.getClass().getName().equals(actionName)) {
							found = true;
							break;
						}
					}
					if (!found){
						System.out.println("This agent " + getName() 
								+ " does not contain any action defined for the role " 
								+ name);
						break;
					}
					if (found || (role.getAllActions().size() == 0)) {
						agentRoles.put(name, role);
					}
				}
		}
		
	}
	// @When the agent don't have the role, then this role is deleted from agent
	public AgentRole removeAgentRole(String name) {
		
		return agentRoles.remove(name);
	}
	public void removeAllAgentRoles() {
		// When the agent don't have the role, then this role is deleted from agent
		agentRoles.clear();
	}
	public Hashtable<String, AgentRole> getAllAgentRoles() {
		return agentRoles;
	}
	
	// Organizations
	protected Organization getOrganization(String key) {
		return organizations.get(key);
	}
	protected void addOrganization(String key, Organization organization) {
		organizations.put(key, organization);
	}
	protected Organization removeOrganization(String key) {
		return organizations.remove(key);
	}
	protected void removeAllOrganizations() {
		organizations.clear();
	}
	protected Hashtable<String, Organization> getAllOrganizations() {
		return organizations;
	}
	
	// Actions
	public Action getAction(String key) {
		return actions.get(key);
	}
	protected void addAction(String key, Action action) {
		if (this.monitor!=null)
			action.setMonitor(this.monitor);
		actions.put(key, action);
	}
	protected Action removeAction(String key) {
		return actions.remove(key);
	}
	protected void removeAllActions() {
		actions.clear();
	}
	public Hashtable<String, Action> getAllActions() {
		return actions;
	}
	public boolean containAction(String key){
		return actions.containsKey(key);
	}
	
	//RestrictNorms
	
	public Norm getRestrictNorm(String key) {
		return restrictNorms.get(key);
	}
	public void addRestrictNorm(String key, Norm restrictNorm) {
		restrictNorms.put(key, restrictNorm);
	}
	public Norm removeRestrictNorm(String key) {
		return restrictNorms.remove(key);
	}
	public void removeAllRestrictNorms() {
		restrictNorms.clear();
	}
	public Hashtable<String, Norm> getAllRestrictNorms() {
		return restrictNorms;
	}

	// Put agent initializations here
	protected void setup() {
		super.setup();
		this.setEnabledO2ACommunication(true, 0);

		// Ambiente
		this.getAID().getName(); // PlatformID

		// Organizaï¿½ï¿½o
		this.getAID().getName(); // ContainerID

		// Papel de Agente (muda crenï¿½as e objetivos dos agentes)
		// Algum behaviour

		// Agente Reativo simples, possui somente comportamento

	}
	
	@Override
	public void addBehaviour(Behaviour b) {
		if (b instanceof Action ){
			Action ac=(Action)b;
			if (!this.actions.containsKey(ac.getName()))
				addAction(ac.getName(), ac);
			if (monitor!=null)
				ac.setMonitor(monitor);
		}
			
		super.addBehaviour(b);
	}

	// Put agent clean-up operations here
	protected void takeDown() {

	}
	
	@Override
	protected void beforeMove() {
		super.beforeMove();
		// When the agent is moved, its behaviours for this organization are blocked.
		AgentRole[] roles = (AgentRole[]) this.getAllAgentRoles().values().toArray();
		AgentRole role = null;
		for (int i = 0 ; i < roles.length ; i++) {
			role = (AgentRole) roles[i];
			if (role.getAgentRoleStatus().name().equals(AgentRoleStatus.ACTIVATE) ) {
				role.changeDeactiveRole(AgentRoleStatus.CHANGE);
			}
		}
		
		/*
		Set<AgentRole> set = this.getBehaviours();
		Iterator<AgentRole> iterator = set.iterator(); 
		while(iterator.hasNext()) {
			iterator.next().block();
		}
		*/
	}
	
	@Override
	public void doMove(Location location) {
		// Checks if agent contains this location to move
		if (location instanceof ContainerID) {
			boolean containsOrg = false;
			for (Organization organization : organizations.values()) {
				if (organization.getContainerID().getID() == location.getID()) {
					containsOrg = true;
					break;
				}
			}
			
			if (containsOrg) {
				super.doMove(location);	
			} else {
				System.out.println("This Agent cannot move to this organization.");
				return;
			}
		} else {
		
			// If location is PlatformID, then it can move
			this.removeAllOrganizations();
			super.doMove(location);
		}
		// TODO: adicionar os papéis da organização principal e a própria
	}
	
	@Override
	protected void afterMove() {
		super.afterMove();
		
		// If the agent is in the same organization of role, the agent will be reseted
		// but this role must be blocked before.
		AgentRole[] roles = (AgentRole[]) this.getAllAgentRoles().values().toArray();
		AgentRole role = null;
		for (int i = 0 ; i < roles.length ; i++) {
			role = (AgentRole) roles[i];
			if (here().getID().equals(role.getOwner().getContainerID().getID()) &&
					role.getAgentRoleStatus().name().equals(AgentRoleStatus.CHANGE) ) {
				role.activeRole();
			}
		}
		
		
		/*String containerName = null;
		try {
			containerName = this.getContainerController().getContainerName();
		} catch (ControllerException e) {
			e.printStackTrace();
		}*/
	}
	
	
	
	public void sendMessage(ACLMessage message) {
		sentMessages.add(message);
		send(message);
	}
	
	public void percept(Object perception) {
		// This method only will be used by ReflexAgents, ModelAgent, GoalAgent and UtilityAgent 
	}
	
	
}

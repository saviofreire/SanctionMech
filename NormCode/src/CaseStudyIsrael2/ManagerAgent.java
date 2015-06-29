package CaseStudyIsrael2;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.monitoring.Monitor;
import jamder.roles.AgentRole;

public class ManagerAgent extends Monitor {
	
	
	private static final long serialVersionUID = 5670776386732896828L;

	public ManagerAgent(String name, Environment environment, Organization owner) {
		super(name, environment, owner);
		Action ac=new ActionMonitorCyclic("ActionMonitorCyclic");
		addAction("ActionMonitorCyclic",ac);
		AgentRole ar=new AgentRole("management", owner, this);//Em qualquer organização o papel de um gerente é gerenciar. Damm
		ar.addAction("ActionMonitorCyclic",ac);
		addAgentRole("management", ar);
		ar.initialize();
	}

	@Override
	public void percept(Object perception1, Object perception2) {
		if (perception1 instanceof ReflexAgent && perception2 instanceof Action){
			addBehaviour(new ActionMonitorReflex("ActionMonitor", (ReflexAgent)perception1, (Action)perception2));
		}
	}
}


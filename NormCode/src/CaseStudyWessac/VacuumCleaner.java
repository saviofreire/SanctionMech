package CaseStudyWessac;

import jamder.Environment;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.behavioural.Condition;
import jamder.monitoring.Monitor;
import jamder.norms.NormType;
import jamder.roles.AgentRole;

public class VacuumCleaner extends ReflexAgent{
	private static final long serialVersionUID = 1L;
	
	private Condition cleft=new Condition("cleft", null, false);
	private Condition cright=new Condition("cright", null, false);
	private Condition csuck=new Condition("csuck", null, false);
	private int points=0;
	
	protected VacuumCleaner(String name, Environment environment, AgentRole agentRole, Monitor monitor) {
		super(name, environment, agentRole);
		Action letleft=new Left("LetLeft");
		letleft.setCyclic(true);//A ação é ciclica. Ela continua verificando se a pré-condição é verdadeira.
		letleft.addPreCondition(cleft.getName(), cleft);
		letleft.setNormType(NormType.PERMISSION);
		Action letrigth=new Right("LetRight");
		letrigth.setCyclic(true);
		letrigth.addPreCondition(cright.getName(), cright);
		letrigth.setNormType(NormType.PERMISSION);
		Action letsuck=new Suck("LetSuck");
		letsuck.setCyclic(true);
		letsuck.addPreCondition(csuck.getName(), csuck);
		letsuck.setNormType(NormType.PERMISSION);
		
		Action setup=new NextAction("setup", cleft, cright, csuck);
		setup.setNormType(NormType.OBLIGATION);
		setup.setCyclic(true);
		
		setMonitor(monitor);
		addAction("setup", setup);
		addAction(letleft.getName(), letleft);
		addAction(letrigth.getName(), letrigth);
		addAction(letsuck.getName(), letsuck);
		
		addPerceive("setup", setup);
	}
	
	public void setPoints(int points) {
		this.points = points;
	}


	public int getPoints() {
		return points;
	}
	
	@Override
	public void addAgentRole(String name, AgentRole role) {
		super.addAgentRole(name, role);
		role.initialize();
	}
	
	
}

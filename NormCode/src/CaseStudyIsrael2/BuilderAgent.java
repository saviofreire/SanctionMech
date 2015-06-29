package CaseStudyIsrael2;

import jamder.Environment;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.behavioural.Condition;
import jamder.monitoring.Monitor;
import jamder.norms.NormType;
import jamder.roles.AgentRole;

public class BuilderAgent extends ReflexAgent {

	private static final long serialVersionUID = 1L;
	
	private Table table;
	private Condition c=new Condition("c", null, true);
	private int points=0;

	public BuilderAgent(String name, Environment environment, AgentRole agentRole, Monitor monitor) {
		super(name, environment, agentRole);
		
		Object obj=getEnvironment().getObject("Table");
		if (obj instanceof Table)
			this.table=(Table)obj;
		Action moveab=new MoveAB("MoveAB", table);
		moveab.setCyclic(true);//A ação é ciclica. Ela continua verificando se a pré-condição é verdadeira.
		moveab.addPreCondition(c.getName(), c);
		moveab.setNormType(NormType.PERMISSION);
		
		Action moveac=new MoveAC("MoveAC", table);
		moveac.setCyclic(true);
		moveac.addPreCondition(c.getName(), c);
		moveac.setNormType(NormType.PERMISSION);
		
		Action moveba=new MoveBA("MoveBA", table);
		moveba.setCyclic(true);
		moveba.addPreCondition(c.getName(), c);
		moveba.setNormType(NormType.PERMISSION);
		
		Action movebc=new MoveBC("MoveBC", table);
		movebc.setCyclic(true);
		movebc.addPreCondition(c.getName(), c);
		movebc.setNormType(NormType.PERMISSION);
		
		Action moveca=new MoveCA("MoveCA", table);
		moveca.setCyclic(true);
		moveca.addPreCondition(c.getName(), c);
		moveca.setNormType(NormType.PERMISSION);
		
		Action movecb=new MoveCB("MoveCB", table);
		movecb.setCyclic(true);
		movecb.addPreCondition(c.getName(), c);
		movecb.setNormType(NormType.OBLIGATION);
		
		addAction(moveab.getName(), moveab);
		addAction(moveac.getName(), moveac);
		addAction(moveba.getName(), moveba);
		addAction(movebc.getName(), movebc);
		addAction(moveca.getName(), moveca);
		addAction(movecb.getName(), movecb);
		
		setMonitor(monitor);
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

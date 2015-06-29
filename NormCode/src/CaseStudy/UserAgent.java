package CaseStudy;

import java.util.List;

import jamder.Environment;
import jamder.agents.GenericAgent;
import jamder.agents.GoalAgent;
import jamder.roles.AgentRole;
import jamder.structural.Belief;
import jamder.structural.Goal;
import jamder.behavioural.*;

public class UserAgent extends GoalAgent {

	private static final long serialVersionUID = 1L;

	
	protected UserAgent(String name, Environment environment, AgentRole agentRole) {
		super(name, environment, agentRole);
		
		Action SubmitPapers = new Action("Submit Papers"){
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("teste");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		addAction("Submit Papers", SubmitPapers);
	}


	@Override
	protected Goal formulateGoalFunction(Belief belief) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected List<Action> formulateProblemFunction(Belief belief, Goal goal) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected Plan planning(List<Action> actions) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected Belief nextFunction(Belief belief, String perception) {
		// TODO Auto-generated method stub
		return null;
	}	
}

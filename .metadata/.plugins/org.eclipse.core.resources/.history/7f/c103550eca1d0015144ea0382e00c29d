package jamder.behavioural;

import jade.core.behaviours.SequentialBehaviour;
import jamder.agents.GenericAgent;
import jamder.norms.AtomicAction;
import jamder.norms.AtomicActionType;
import jamder.norms.CompositeAction;
import jamder.norms.CompositeActionType;
import jamder.norms.NormAction;
import jamder.structural.Goal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Plan extends SequentialBehaviour{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private List<NormAction> norm_actions = new ArrayList<NormAction>();//Avisar a NormAction que a ação foi executada.

	private Hashtable<String, Action> actions = new Hashtable<String, Action>();
	// TODO: Pq precisa ter goal, ja que goal tem plan
	private Goal goal;
	
	// Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Goal getGoal() {
		return goal;
	}
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	// Constructors
	public Plan(String name, Goal goal) {
		super();
		this.name = name;
		this.setBehaviourName(name);
		this.goal = goal;
	}
	
	public Plan(String name, Goal goal, GenericAgent agent) {
		super(agent);
		this.name = name;
		this.setBehaviourName(name);
		this.goal = goal;
	}
	
	protected void execute(){
		for (Action action : actions.values()) {
			if (action != null) {
				addSubBehaviour(action);
			}
		}
		for (NormAction acti : norm_actions){
			if (acti instanceof CompositeAction){
				CompositeAction aa=(CompositeAction) acti;
				if (aa.getType()==CompositeActionType.PLAN_EXECUTE)
					aa.setRun(true);
			}else 
				if (acti instanceof AtomicAction){
					AtomicAction aa=(AtomicAction) acti;
					if (aa.getType()==AtomicActionType.AtomicExecute)
						aa.setRun(true);
				}
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		execute();
	}
	
}

package jamder;

import java.util.List;

public class AgentRole {
	String name;
	List<Actions> actions;
	
	
	public AgentRole(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Actions> getActions() {
		return actions;
	}
	public void addAction(Actions ac) {
		this.actions.add(ac);
	}
	
	
}

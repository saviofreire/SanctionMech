package jamder;

public class Agent {
	String name;
	AgentRole papel;
	
	
	public Agent(String name, AgentRole papel) {
		super();
		this.name = name;
		this.papel = papel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AgentRole getPapel() {
		return papel;
	}
	public void setPapel(AgentRole papel) {
		this.papel = papel;
	}
	
	
}

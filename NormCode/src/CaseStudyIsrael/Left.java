package CaseStudyIsrael;

import jamder.agents.GenericAgent;
import jamder.behavioural.Action;

public class Left extends Action {
	
	
	public Left(String name) {
		super(name);
	}

	public void execute() {
		Place room;
		Object obj=((GenericAgent)getAgent()).getEnvironment().getObject("Place");
		if (obj instanceof Place){
			room=(Place)obj;
			room.next();
			System.out.println("Left");
		}
	}
}

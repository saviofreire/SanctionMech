package CaseStudyIsrael;

import jamder.agents.GenericAgent;
import jamder.behavioural.Action;
import jamder.behavioural.Condition;
import jamder.norms.NormType;

public class Right extends Action {
	
	
	public Right(String name) {
		super(name);
	}

	public void execute() {
		Place room;
		Object obj=((GenericAgent)getAgent()).getEnvironment().getObject("Place");
		if (obj instanceof Place){
			room=(Place)obj;
			room.next();
			System.out.println("Right");
		}
	}

}

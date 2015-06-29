package CaseStudy;

import jade.core.behaviours.Behaviour;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.behavioural.Action;

public class ConferenceChair extends Organizer {
	public ConferenceChair(String name, Organization owner, GenericAgent player) {
		super(name, owner, player);	
		
		addAction("extendSubmissionDeadline", new Action("extendSubmissionDeadline"));
		
		Behaviour protocol = new Behaviour() {
			
			@Override
			public boolean done() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				
			}
		};
		
		addProtocol("authorNotificationProtocol", protocol);
		
		initialize();
	}
}

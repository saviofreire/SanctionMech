package jamder;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jamder.agents.GenericAgent;
import jamder.agents.MASMLAgent;

public class PerceptionFunction extends TickerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8998516906340376582L;

	public PerceptionFunction(Agent a, long period) {
		super(a, period);
	}

	@Override
	protected void onTick() {
		try {
			ACLMessage message = this.myAgent.receive(MessageTemplate.MatchConversationId("perception"));
			if (this.myAgent instanceof MASMLAgent){
				this.myAgent.removeBehaviour(this);
				System.out.println("You can not use PerceptionFunction in a MASMLAgent!");
			}
			GenericAgent a = (GenericAgent) this.myAgent;
			if (message != null && message.hasByteSequenceContent()) {
				Object percept =  message.getContentObject();
				if (percept != null) {
					a.percept(percept);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

package CaseStudyIsrael2;

import jade.core.Agent;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.monitoring.ATN;
import jamder.monitoring.ATNState;
import jamder.norms.Norm;

import java.util.ArrayList;
import java.util.List;


/**Inspeciona um agente que acabou de executar uma ação.
 * @author Israel*/
public class ActionMonitorReflex extends Action{
	
	private static final long serialVersionUID = 1L;
	private ReflexAgent agent;//Agente que será inspecionado.
	private Action action;//Ação notificada.
	private List<StateInTheCall> statesInTheCall=new ArrayList<StateInTheCall>();
	
	public ActionMonitorReflex(String name, ReflexAgent agent, Action action) {
		super(name);
		this.agent=agent;
		this.action=action;
		for (Norm nor : this.agent.getAllRestrictNorms().values()) {
			this.statesInTheCall.add( new StateInTheCall(nor));
		}
	}
	
	@Override
	public void execute() {
		Agent ag=getAgent();
		if (ag instanceof ManagerAgent){
			ManagerAgent ma = (ManagerAgent)ag;
			for (StateInTheCall stateInTheCall: this.statesInTheCall){
				if (stateInTheCall.isActive()){
					Action ac=stateInTheCall.getNorm().getAction().getNormResource().getAction();
					if (ac!=null && ac.getName().equalsIgnoreCase(action.getName())){
						switch (stateInTheCall.getNorm().getNormType()) {
						case PROHIBITION:
							ma.punish(stateInTheCall.getNorm());//Se não tiver sanção ele não faz nada.
							break;
						case OBLIGATION:
							ma.reward(stateInTheCall.getNorm());//Se não tiver sanção ele não faz nada.
							break;
						case PERMISSION:
							break;
						default:
							break;
						}
						ATN atn = ma.getAllAtns().get(stateInTheCall.getNorm().getName());
						if (atn != null && atn.getState()!=ATNState.COMPLIANCE_OR_INFRINGEMENT){
							atn.setState(ATNState.COMPLIANCE_OR_INFRINGEMENT);
						}
					}
				}
			}
			if (this.agent instanceof BuilderAgent){//Em um ambiente sem normas.
				BuilderAgent vc=(BuilderAgent)this.agent;
				if (this.action.getName().equalsIgnoreCase("MoveBA") || this.action.getName().equalsIgnoreCase("MoveCA") || this.action.getName().equalsIgnoreCase("MoveCB")){
						vc.setPoints(vc.getPoints()+1);
						System.out.println(vc.getPoints());
				}else {
						vc.setPoints(vc.getPoints()-1);
						System.out.println(vc.getPoints());
				}
			}
		}
		//System.out.println("kjhkj");
		super.execute();
	}
	
}


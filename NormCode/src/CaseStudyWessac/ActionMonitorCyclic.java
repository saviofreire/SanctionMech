package CaseStudyWessac;

import jade.core.Agent;
import jamder.behavioural.Action;
import jamder.monitoring.ATN;
import jamder.monitoring.ATNState;
import jamder.monitoring.Monitor;
import jamder.norms.NormType;
/**Varifica se uma norma de obrigação espirou sem que fosse cumprida.
 * @author Israel
 * */
public class ActionMonitorCyclic extends Action{

	private static final long serialVersionUID = 1L;
	
	public ActionMonitorCyclic(String name) {
		super(name);
		setNormType(NormType.OBLIGATION);//Sempre deve ser cumprido pelo agente de gerenciamento;
	}

	@Override
	public void execute() {
		Agent agnt=getAgent();
		if (agnt instanceof Monitor){
			Monitor ag=(Monitor) agnt;
			for (ATN atn: ag.getAllAtns().values()){
				boolean valida=atn.getState()==ATNState.ACTIVE &&
						!atn.getNorm().isActive() &&
						atn.getNorm().getNormType()==NormType.OBLIGATION;//Se o estado anterior era ativo e a norma é de obrigação e não foi cumprida.
				if (valida){
					atn.setState(ATNState.COMPLIANCE_OR_INFRINGEMENT);
					//Aplicar a punição ao agente que não fez o que tinha de fazer.
					ag.punish(atn.getNorm());
				}else{
					boolean valida2=atn.getState()==ATNState.ACTIVE &&
							!atn.getNorm().isActive() &&
							atn.getNorm().getNormType()==NormType.PROHIBITION;//Se o estado anterior era ativo e a norma é de obrigação e não foi cumprida.
					if (valida2){
						atn.setState(ATNState.COMPLIANCE_OR_INFRINGEMENT);
						//Aplicar a recompensa ao agente que não fez o que não podia fazer.
						ag.reward(atn.getNorm());
					}else
						if (atn.getState()==ATNState.INACTIVE && atn.getNorm().isActive()){
							atn.setState(ATNState.ACTIVE);
						}
				}
			}
		}
	}
	@Override
	public final boolean done() {
		return false;
	}
}

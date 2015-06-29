package CaseStudyIsrael;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.monitoring.Monitor;
import jamder.norms.AtomicAction;
import jamder.norms.AtomicActionType;
import jamder.norms.Between;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormConstraint;
import jamder.norms.NormResource;
import jamder.norms.NormType;
import jamder.roles.AgentRole;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class ManagerAgent extends Monitor {
	
	
	private static final long serialVersionUID = 5670776386732896828L;

	public ManagerAgent(String name, Environment environment, Organization owner) {
		super(name, environment, owner);
		Action ac=new ActionMonitorCyclic("ActionMonitorCyclic");
		addAction("ActionMonitorCyclic",ac);
		
		//------Defini��o de papel-----
		AgentRole ar=new AgentRole("management", owner, this);//Em qualquer organiza��o o papel de um gerente � gerenciar. Damm
		ar.addAction("ActionMonitorCyclic",ac);
		
		Calendar date1a=new GregorianCalendar(2014, GregorianCalendar.JANUARY, 29, 15, 8, 20);
		Calendar date2b=new GregorianCalendar(2014, GregorianCalendar.MARCH, 29, 15, 9, 40);
		NormConstraint cond=new Between(date1a, date2b);
		Hashtable<String, NormConstraint> constraints=new Hashtable<String, NormConstraint>();
		constraints.put("cond", cond);
		
		NormResource nre= new NormResource(ac);
		NormAction noa= new AtomicAction(AtomicActionType.AtomicExecute, nre);
		
		Norm no=new Norm("N1", NormType.OBLIGATION, ar, owner, noa, constraints);
		ar.addRestrictNorm(no.getName(), no);
		
		//Inicializa��o
		addAgentRole("management", ar);
		ar.initialize();
	}

	@Override
	public void percept(Object perception1, Object perception2) {
		if (perception1 instanceof ReflexAgent && perception2 instanceof Action){
			addBehaviour(new ActionMonitorReflex("ActionMonitor", (ReflexAgent)perception1, (Action)perception2));
		}
	}
}


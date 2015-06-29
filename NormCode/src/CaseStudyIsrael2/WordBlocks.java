package CaseStudyIsrael2;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.ReflexAgent;
import jamder.behavioural.Action;
import jamder.norms.AtomicAction;
import jamder.norms.AtomicActionType;
import jamder.norms.Between;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormConstraint;
import jamder.norms.NormResource;
import jamder.norms.NormType;
import jamder.roles.ReflexAgentRole;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import CaseStudyIsrael.ManagerAgent;
import CaseStudyIsrael.N2;

public class WordBlocks extends Environment {

	public WordBlocks(String name, String host, String port) {
		super(name, host, port);
		Table table=new Table();
		addObject("Table", table);
		
		Organization builderOrg=new BuilderOrg("BuilderOrg", this, null);
		addOrganization("BuilderOrg", builderOrg);
		
		ManagerAgent gerente=new ManagerAgent("Gerente",this, builderOrg);
		
		ReflexAgent builderAgent=new BuilderAgent("BuilderAgent", this, null, gerente);
		builderAgent.setNormative(true);
		
		ReflexAgentRole role=new ReflexAgentRole("builder", builderOrg, builderAgent);
		for (Action action : builderAgent.getAllActions().values()) {
			role.addAction(action.getName(), action);
		}
		
		builderAgent.addAgentRole("Builder", role);
		
		NormResource nr= new NormResource(builderAgent.getAction("MoveAB"));
		NormAction na= new AtomicAction(AtomicActionType.AtomicExecute, nr);
		NormResource nr2= new NormResource(builderAgent.getAction("MoveAC"));
		NormAction na2= new AtomicAction(AtomicActionType.AtomicExecute, nr2);
		NormResource nr3= new NormResource(builderAgent.getAction("MoveBC"));
		NormAction na3= new AtomicAction(AtomicActionType.AtomicExecute, nr3);
		NormResource nr4= new NormResource(builderAgent.getAction("MoveCA"));
		NormAction na4= new AtomicAction(AtomicActionType.AtomicExecute, nr4);
		
		Calendar dat1=new GregorianCalendar(2013, GregorianCalendar.NOVEMBER, 29, 0, 5, 20);
		Calendar dat2=new GregorianCalendar(2013, GregorianCalendar.DECEMBER, 29, 17, 7, 59);
		NormConstraint cond2A=new Between(dat1, dat2);
		Hashtable<String, NormConstraint> constraints2=new Hashtable<String, NormConstraint>();
		constraints2.put("condA", cond2A);
		
		Norm N1=new N1("N1", NormType.PROHIBITION, builderAgent, builderOrg, na, constraints2);
		Norm N2=new N2("N2", NormType.PROHIBITION, builderAgent, builderOrg, na2, constraints2);
		Norm N3=new N3("N3", NormType.PROHIBITION, builderAgent, builderOrg, na3, constraints2);
		Norm N4=new N4("N4", NormType.PROHIBITION, builderAgent, builderOrg, na4, constraints2);
		
		N1.apply();
		N2.apply();
		N3.apply();
		N4.apply();
		
		gerente.addAgent("BuilderAgent", builderAgent);
		
		addAgent("Gerente", gerente);
		addAgent("BuilderAgent", builderAgent);
		
	}
	public static void main(String[] args) {
		new WordBlocks("WordBlocks","localhost", "8888");
	}
}

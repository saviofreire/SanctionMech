package CaseStudySanctionMechanism;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.GoalAgent;
import jamder.behavioural.Action;
import jamder.norms.AtomicAction;
import jamder.norms.AtomicActionType;
import jamder.norms.IfConditional;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormConstraint;
import jamder.norms.NormResource;
import jamder.norms.NormType;
import jamder.norms.Operator;
import jamder.roles.AgentRole;
import jamder.roles.ProactiveAgentRole;
import jamder.structural.Property;

import java.util.Hashtable;

import CaseStudyIsrael.ManagerAgent;

public class WorldUniversity extends Environment {

	public WorldUniversity(String name, String host, String port) {
		super(name, host, port);
		
		//Organizacao Laboratory
		Organization Laboratory = new Laboratory ("Laboratory", this, null);
		addOrganization("Laboratory", Laboratory);
		
		//Agentes e Papeis de Agentes
		
		
		
	}
	
	public static void main(String args[]){
		
		WorldUniversity teste = new WorldUniversity("University","localhost", "8888");
			System.out.println("Executou");
	  	}
}

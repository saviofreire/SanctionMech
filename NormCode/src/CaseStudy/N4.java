package CaseStudy;

import java.util.Hashtable;

import jamder.Organization;
import jamder.norms.*;
import jamder.roles.AgentRole;


public class N4 extends Norm{
	//Construtor
	
	public N4 (String name, NormType normType, AgentRole restrictAgentRoleClass, Organization contextOrganizationClass, NormAction action,Hashtable<String, NormConstraint> normConstraint ){
		
		super(name, normType, restrictAgentRoleClass, contextOrganizationClass, action, normConstraint);
		
	}
}

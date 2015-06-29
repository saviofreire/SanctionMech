package CaseStudyWessac;

import java.util.Hashtable;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormConstraint;
import jamder.norms.NormType;
import jamder.roles.AgentRole;

public class N2 extends Norm {

	public N2(String name, NormType normType, GenericAgent restrictAgentClass,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentClass, contextOrganizationClass,
				action, normConstraint);
	}


}

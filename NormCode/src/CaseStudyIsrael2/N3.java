package CaseStudyIsrael2;

import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.norms.Norm;
import jamder.norms.NormAction;
import jamder.norms.NormConstraint;
import jamder.norms.NormType;

import java.util.Hashtable;

public class N3 extends Norm {

	

	public N3(String name, NormType normType, GenericAgent restrictAgentClass,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentClass, contextOrganizationClass,
				action, normConstraint);
	}

	

}
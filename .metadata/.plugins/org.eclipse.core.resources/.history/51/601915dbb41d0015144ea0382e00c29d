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

public class N4 extends Norm {
	
	VacuumCleaner vacuumCleaner=null;

	public N4(String name, NormType normType,
			Organization restrictOrganization,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictOrganization, contextOrganizationClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType,
			Organization restrictOrganization,
			Environment contextEnvironmentClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictOrganization, contextEnvironmentClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType, GenericAgent restrictAgentClass,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentClass, contextOrganizationClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType, GenericAgent restrictAgentClass,
			Environment contextEnvironmentClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentClass, contextEnvironmentClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType,
			Environment restrictEnvironmentCalss,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictEnvironmentCalss,
				contextOrganizationClass, action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType,
			Environment restrictEnvironmentCalss,
			Environment contextEnvironmentClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictEnvironmentCalss,
				contextEnvironmentClass, action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType, AgentRole restrictAgentRoleClass,
			Organization contextOrganizationClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentRoleClass, contextOrganizationClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public N4(String name, NormType normType, AgentRole restrictAgentRoleClass,
			Environment contextEnvironmentClass, NormAction action,
			Hashtable<String, NormConstraint> normConstraint) {
		super(name, normType, restrictAgentRoleClass, contextEnvironmentClass,
				action, normConstraint);
		// TODO Auto-generated constructor stub
	}

	public VacuumCleaner getVacuumCleaner() {
		return vacuumCleaner;
	}

	public void setVacuumCleaner(VacuumCleaner vacuumCleaner) {
		this.vacuumCleaner = vacuumCleaner;
	}
	@Override
	public void apply() {
		if (this.vacuumCleaner!=null){
			vacuumCleaner.setPoints(vacuumCleaner.getPoints()+2);
			System.out.println(vacuumCleaner.getPoints());
		}
		super.apply();
	}
	
	
}

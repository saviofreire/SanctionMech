package jamder.norms;
import jamder.Environment;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.roles.AgentRole;

import java.util.Hashtable;

public class Norm {

	private String name;
	private NormType normType;
	
	private Organization restrictOrganization=null;
	private GenericAgent restrictAgentClass=null;
	private Environment restrictEnvironmentCalss=null;
	private AgentRole restrictAgentRoleClass=null;
	
	protected Organization contextOrganizationClass=null;
	protected Environment contextEnvironmentClass=null;
	
	public NormAction action;
	
	/*Sugestão: Seria interessante se tivéssemos uma
	 *  Hashtable de Hashtables de NormConstraint (ClausuleConstraint). 
	 *  Cada Hashtable de NormConstraint seria 
	 *  uma Cláusula de Horn (r1 ^ r2 ^ ... ^ rn)->Qi.
	 *   Uma norma seria válida se Q1 v Q2 v ... v Qn
	 *    como na linguagem Prolog. Ficaria bem mais poderoso. 
	 *    Com ^, v e negação podemos descrever mais coisas. Israel*/
	private Hashtable<String, NormConstraint> normConstraint = new Hashtable<String, NormConstraint>();
	
	//Posso ter uma lista de sanções ou punições
	private Hashtable<String, Norm> sactionReward = new Hashtable<String, Norm>();
	private Hashtable<String, Norm> sactionPunishment = new Hashtable<String, Norm>();
	private boolean isApply=false;//Se a norma foi aplicada (posta em vigor). A principio ela foi apenas criada e arquivada.

	/**Restringindo uma Organização no contexto de uma organização */
	public Norm(String name, NormType normType, Organization restrictOrganization, 
				Organization contextOrganizationClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){				
		
				setName(name);
				this.normType = normType;
				this.restrictOrganization = restrictOrganization;
				this.contextOrganizationClass = contextOrganizationClass;
				this.action = action;
				this.normConstraint = normConstraint;	
	}

	/**Restringindo uma Organização no contexto de um Ambiente*/
	public Norm(String name, NormType normType, Organization restrictOrganization, 
				Environment contextEnvironmentClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){
				
				setName(name);
				this.normType = normType;
				this.restrictOrganization = restrictOrganization;
				this.contextEnvironmentClass = contextEnvironmentClass;
				this.action = action;
				this.normConstraint = normConstraint;					
	}
//#################################################################################################
	/**Restringindo um Agente no contexto de uma organização*/
	public Norm(String name, NormType normType, GenericAgent restrictAgentClass, 
				Organization contextOrganizationClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){				
				
				setName(name);
				this.normType = normType;
				this.restrictAgentClass = restrictAgentClass;
				this.contextOrganizationClass = contextOrganizationClass;
				this.action = action;
				this.normConstraint = normConstraint;		
	}

	/** Restringindo um Agente no contexto de um Ambiente*/
	public Norm(String name, NormType normType, GenericAgent restrictAgentClass, 
				Environment contextEnvironmentClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){
				
				setName(name);
				this.normType = normType;
				this.restrictAgentClass = restrictAgentClass;
				this.contextEnvironmentClass = contextEnvironmentClass;
				this.action = action;
				this.normConstraint = normConstraint;					
	}	
	
//#################################################################################################
	/** Restringindo um Ambiente no contexto de uma organização*/
	public Norm(String name, NormType normType, Environment restrictEnvironmentCalss, 
				Organization contextOrganizationClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){				
				
				setName(name);
				this.normType = normType;
				this.restrictEnvironmentCalss = restrictEnvironmentCalss;
				this.contextOrganizationClass = contextOrganizationClass;
				this.action = action;
				this.normConstraint = normConstraint;		
	}

	/** Restringindo um Ambiente no contexto de um Ambiente*/
	public Norm(String name, NormType normType, Environment restrictEnvironmentCalss, 
				Environment contextEnvironmentClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){
				
				setName(name);
				this.normType = normType;
				this.restrictEnvironmentCalss = restrictEnvironmentCalss;
				this.contextEnvironmentClass = contextEnvironmentClass;
				this.action = action;
				this.normConstraint = normConstraint;					
	}	
//#################################################################################################
	/**Restringindo um Papel Agente no contexto de uma organização*/
	public Norm(String name, NormType normType, AgentRole restrictAgentRoleClass, 
				Organization contextOrganizationClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){				
				
				setName(name);
				this.normType = normType;
				this.restrictAgentRoleClass = restrictAgentRoleClass;
				this.contextOrganizationClass = contextOrganizationClass;
				this.action = action;
				this.normConstraint = normConstraint;		
	}

	/** Restringindo um Papel Agente no contexto de um Ambiente*/
	public Norm(String name, NormType normType, AgentRole restrictAgentRoleClass, 
				Environment contextEnvironmentClass, NormAction action, 
				Hashtable<String, NormConstraint> normConstraint){
				
				setName(name);
				this.normType = normType;
				this.restrictAgentRoleClass = restrictAgentRoleClass;
				this.contextEnvironmentClass = contextEnvironmentClass;
				this.action = action;
				this.normConstraint = normConstraint;					
	}		
	
	/******************gets and sets*****************/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NormType getNormType() {
		return normType;
	}

	public void setNormType(NormType normType) {
		this.normType = normType;
	}

	public Organization getRestrictOrganization() {
		return restrictOrganization;
	}

	public void setRestrictOrganization(Organization restrictOrganization) {
		this.restrictOrganization = restrictOrganization;
	}

	public GenericAgent getRestrictAgentClass() {
		return restrictAgentClass;
	}

	public void setRestrictAgentClass(GenericAgent restrictAgentClass) {
		this.restrictAgentClass = restrictAgentClass;
	}

	public Environment getRestrictEnvironmentCalss() {
		return restrictEnvironmentCalss;
	}

	public void setRestrictEnvironmentCalss(Environment restrictEnvironmentCalss) {
		this.restrictEnvironmentCalss = restrictEnvironmentCalss;
	}

	public AgentRole getRestrictAgentRoleClass() {
		return restrictAgentRoleClass;
	}

	public void setRestrictAgentRoleClass(AgentRole restrictAgentRoleClass) {
		this.restrictAgentRoleClass = restrictAgentRoleClass;
	}

	public Organization getContextOrganizationClass() {
		return contextOrganizationClass;
	}

	public void setContextOrganizationClass(Organization contextOrganizationClass) {
		this.contextOrganizationClass = contextOrganizationClass;
	}

	public Environment getContextEnvironmentClass() {
		return contextEnvironmentClass;
	}

	public void setContextEnvironmentClass(Environment contextEnvironmentClass) {
		this.contextEnvironmentClass = contextEnvironmentClass;
	}

	public NormAction getAction() {
		return action;
	}

	public void setAction(NormAction action) {
		this.action = action;
	}

	public Hashtable<String, NormConstraint> getNormConstraint() {
		return normConstraint;
	}

	public void setNormConstraint(Hashtable<String, NormConstraint> normConstraint) {
		this.normConstraint = normConstraint;
	}

	public Hashtable<String, Norm> getSactionReward() {
		return sactionReward;
	}

	public void setSactionReward(Hashtable<String, Norm> sactionReward) {
		this.sactionReward = sactionReward;
	}

	public Hashtable<String, Norm> getSactionPunishment() {
		return sactionPunishment;
	}

	public void setSactionPunishment(Hashtable<String, Norm> sactionPunishment) {
		this.sactionPunishment = sactionPunishment;
	}
	
	public Object getRestrict(){
		if (this.restrictOrganization!=null)
			return this.restrictOrganization;
		if (this.restrictAgentClass!=null)
			return this.restrictAgentClass;
		if (this.restrictEnvironmentCalss!=null)
			return this.restrictEnvironmentCalss;
		if (this.restrictAgentRoleClass!=null)
			return this.restrictAgentRoleClass;
		return null;
	}
	
	public void setRestrict(Object restrict){
		this.restrictOrganization = null;
		this.restrictAgentClass = null;
		this.restrictEnvironmentCalss = null;
		this.restrictAgentRoleClass = null;
		if (restrict instanceof Organization)
			 this.restrictOrganization = (Organization)restrict;
		if (restrict instanceof GenericAgent)
			this.restrictAgentClass = (GenericAgent)restrict;
		if (restrict instanceof Environment)
			this.restrictEnvironmentCalss = (Environment)restrict;
		if (restrict instanceof AgentRole)
			this.restrictAgentRoleClass = (AgentRole)restrict;
	}
	
	public Object getContext(){
		if (this.contextOrganizationClass!=null)
			return this.contextOrganizationClass;
		if (this.contextEnvironmentClass!=null)
			return this.contextEnvironmentClass;
		return null;
	}
	
	public void setContext(Object context){
		this.contextOrganizationClass =null;
		this.contextEnvironmentClass = null;
		if (context instanceof Organization)
			this.contextOrganizationClass = (Organization)context;
		if (context instanceof Environment)
			this.contextEnvironmentClass = (Environment)context;
	}
	
	public boolean isApply() {
		return isApply;
	}

	/** Checks if a norm is active.
	 * @author Israel
	 * @version 1.01
	 * @return boolean - If norm is active return true. Else return false.
	 *  */
	public boolean isActive(){
		for (NormConstraint constraint: normConstraint.values()){
			if (!constraint.isTrue())
				return false;
		}
		return true; //Se todas as restrições forem atendidas retorna verdadeiro. (r1 ^ r2 ^ ... ^ rn)->Q. Uma Cláusula de Horn.
	}
	/**Aplica (põe em vigor) uma norma que antes estava apenas arquivada. Importante na hora de aplicar sanções.
	 * @author Israel
	 * */
	public void apply(){
		//Quem é restringido.
		if (this.restrictOrganization!=null)
			this.restrictOrganization.addRestrictNorm(getName(), this);
		else
			if (this.restrictAgentClass!=null){
				this.restrictAgentClass.addRestrictNorm(getName(), this);
				if (this.restrictAgentClass.getMonitor()!=null)
					this.restrictAgentClass.getMonitor().addATN(this);
			}else
				if (this.restrictEnvironmentCalss!=null)
					this.restrictEnvironmentCalss.addRestrictNorm(getName(), this);
				else
					if (this.restrictAgentRoleClass!=null)
						this.restrictAgentRoleClass.addRestrictNorm(getName(), this);
		//Seu contexto.
		if (this.contextOrganizationClass!=null)
			this.contextOrganizationClass.addContextNorm(getName(), this);
		else
			if (this.contextEnvironmentClass!=null)
				this.contextEnvironmentClass.addContextNorm(getName(), this);
		isApply=true;
	}
	/**Desaplica (tira de vigor) uma norma. Importante na hora de aplicar sanções.
	 * @author Israel
	 * */
	public void disapply(){
				//Quem é restringido.
				if (this.restrictOrganization!=null)
					this.restrictOrganization.removeRestrictNorm(getName());
				else
					if (this.restrictAgentClass!=null){
						this.restrictAgentClass.removeRestrictNorm(getName());
						if (this.restrictAgentClass.getMonitor()!=null)
							this.restrictAgentClass.getMonitor().removeATN(this.getName());
					}else
						if (this.restrictEnvironmentCalss!=null)
							this.restrictEnvironmentCalss.removeRestrictNorm(getName());
						else
							if (this.restrictAgentRoleClass!=null)
								this.restrictAgentRoleClass.removeRestrictNorm(getName());
				//Seu contexto.
				if (this.contextOrganizationClass!=null)
					this.contextOrganizationClass.removeContextNorm(getName());
				else
					if (this.contextEnvironmentClass!=null)
						this.contextEnvironmentClass.removeContextNorm(getName());
				isApply=false;
	}
	
}
package jamder.norms;

import jade.lang.acl.ACLMessage;
import jamder.Environment;
import jamder.Protocol;
import jamder.agents.GenericAgent;
import jamder.behavioural.Action;
import jamder.behavioural.Method;
import jamder.behavioural.Plan;
import jamder.roles.AgentRole;

public class NormResource {
	private Action action=null;
	private Plan plan=null;
	private Protocol protocol=null;
	private GenericAgent agent=null;
	private Environment environment=null;
	private AgentRole agentRole=null;
	private ACLMessage message=null;
	private NormAction normAction=null;
	private Object object=null;
	private Method method=null;
	
	/*
	* Dúvidas
	* 2. Como representa uma classe Operation (método)?
	*/
	
	/*
	* Definição dos construtores relacionados com as características Estruturais e Comportamentais.
	*/
	
	public NormResource(){}

	/** Cria um recurso de norma do tipo: Ação.*/
	public NormResource(Action action){
		setAction(action);
	}
	
	/** Cria um recurso de norma do tipo: Plano*/
	public NormResource(Plan plan){
		setPlan(plan);
	}
	
	/** Cria um recurso de norma do tipo: Protocolo*/
	public NormResource(Protocol protocol){
		setProtocol(protocol);
	}
	/** Cria um recurso de norma do tipo: Método*/
	public NormResource(Method method){
		setMethod(method);
	}	
	
	/*
	* Definição dos construtores relacionados com os Classificadores.
	*/
	
	//Cria um recurso de norma do tipo: Agente e Organização
	public NormResource(GenericAgent agent){
		setAgent(agent);
	}	
	
	//Cria um recurso de norma do tipo: Ambiente
	public NormResource(Environment environment){
		setEnvironment(environment);
	}	
	
	//Cria um recurso de norma do tipo: Papel de Agente
	public NormResource(AgentRole agentRole){
		setAgentRole(agentRole);
	}

	//Cria um recurso de norma do tipo: Objeto
	public NormResource(Object object){
		setObject(object);
	}	
	
	/*
	* Definição do construtor relacionado com Mensagem.
	*/
	
	public NormResource(ACLMessage message){
		setMessage (message);
	}
	
	/******************gets and sets*****************/

	
	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Protocol getProtocol() {
		return protocol;
	}


	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}


	public GenericAgent getAgent() {
		return agent;
	}


	public void setAgent(GenericAgent agent) {
		this.agent = agent;
	}


	public Environment getEnvironment() {
		return environment;
	}


	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}


	public AgentRole getAgentRole() {
		return agentRole;
	}


	public void setAgentRole(AgentRole agentRole) {
		this.agentRole = agentRole;
	}


	public ACLMessage getMessage() {
		return message;
	}


	public void setMessage(ACLMessage message) {
		this.message = message;
	}


	public NormAction getNormAction() {
		return normAction;
	}


	public void setNormAction(NormAction normAction) {
		this.normAction = normAction;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	
}	

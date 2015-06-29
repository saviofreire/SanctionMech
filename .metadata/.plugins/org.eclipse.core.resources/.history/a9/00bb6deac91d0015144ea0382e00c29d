package jamder.monitoring;

import jamder.Environment;
import jamder.Organization;
import jamder.agents.GenericAgent;
import jamder.behavioural.Action;
import jamder.norms.Norm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract class Monitor extends GenericAgent {
	private static final long serialVersionUID = 1L;
	private Hashtable<String, ATN> atns=new Hashtable<String, ATN>();//Redes de transição aumentada (uma abstração de normas).
	private Hashtable<String, GenericAgent> agents=new Hashtable<String, GenericAgent>();//Agentes que serão monitorados.
	
	
	public Monitor(String name, Environment environment, Organization owner) {
		super(name, environment, null);
		if (owner!=null && owner.getName()!=null)
			addOrganization(owner.getName(), owner);
	}

	public Hashtable<String, GenericAgent> getAgents() {
		return agents;
	}

	public void addAgent(String key, GenericAgent agent) {
		this.agents.put(key, agent);
		for (Norm nor: agent.getAllRestrictNorms().values()){
			ATN atn=new ATN(nor, nor.getName());//Para cada norma é feito uma ATN
			atns.put(atn.getName(), atn);
		}
	}
	
	public void addATN(Norm nor){//Quando uma nova norma passa a restringir um agente devemos inserir a nova ATN.
		if (!atns.containsKey(nor.getName())){
			ATN atn=new ATN(nor, nor.getName());
			atns.put(atn.getName(), atn);
		}
	}
	
	public void removeATN(String key){
		atns.remove(key);
	}

	public Hashtable<String, ATN> getAllAtns() {
		return atns;
	}
	
	public void punish(Norm norm){
		Hashtable<String, Norm> punishments=norm.getSactionPunishment();
		for (Norm punishment: punishments.values()){//Se não tiver sanção nem entra aqui.
			if (punishment.isApply())
				punishment.disapply();
			Object context= norm.getContext();
			Object restrict=norm.getRestrict();
			punishment.setContext(context);
			punishment.setRestrict(restrict);
			//Checagem do conflito de normas. Primeira etapa.
			/*List<Norm> listNormsDis=new ArrayList<Norm>();
			Action normAction=punishment.getAction().getNormResource().getAction();
			if (normAction!=null){
				GenericAgent agent= (GenericAgent)normAction.getAgent();
				for ( Norm nor:agent.getAllRestrictNorms().values()){
					Action a1=punishment.getAction().getNormResource().getAction();
					Action a2=nor.getAction().getNormResource().getAction();
					if (a1!=null && a2!=null && a1.getName().equalsIgnoreCase(a2.getName())){
						if (nor.getContext().equals(punishment.getContext())){
							listNormsDis.add(nor);
							//nor.disapply();
						}
					}
				}
			}
			for (Norm no: listNormsDis){
				no.disapply();
				System.out.println("teste1");
			}*/
			punishment.apply();
		}
	}
	
	public void reward(Norm norm){
		Hashtable<String, Norm> rewards=norm.getSactionReward();
		for (Norm reward: rewards.values()){//Se não tiver sanção nem entra aqui.
			if (reward.isApply())
				reward.disapply();
			Object context= norm.getContext();
			Object restrict=norm.getRestrict();
			reward.setContext(context);
			reward.setRestrict(restrict);
			//Checagem do conflito de normas. Primeira etapa. Para ações.
			/*List<Norm> listNormsDis=new ArrayList<Norm>();
			Action normAction=reward.getAction().getNormResource().getAction();
			if (normAction!=null){//Se o recurso for uma ação.
				GenericAgent agent= (GenericAgent)normAction.getAgent();
				for ( Norm nor : agent.getAllRestrictNorms().values()){
					Action a1=reward.getAction().getNormResource().getAction();
					Action a2=nor.getAction().getNormResource().getAction();
					if (a1!=null && a2!=null && a1.getName().equalsIgnoreCase(a2.getName())){
						if (nor.getContext().equals(reward.getContext())){
							listNormsDis.add(nor);
							//nor.disapply(); Não se pode modificar o conteúdo de uma collection dentro do loop do iterador.
						}
					}
				}
			}
			for (Norm no: listNormsDis){
				no.disapply();
				System.out.println(no.getName());
			}*/
			reward.apply();
			//System.out.println(reward.getName());
		}
	}
	
	
	public abstract void percept(Object perception1, Object perception2);
	
	
}
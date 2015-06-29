package CaseStudyIsrael;

import jamder.norms.Norm;

/*Classe para armazenar o estado de uma norma quando uma ação
*de monitoramento for adicionada na fila do agente gerenciador.
*A avaliação será feita quando o gerente puder, mas com dados do
*momento do envio da notificação para o gerente.*/
public class StateInTheCall{
	private Norm nor;
	private boolean isActive;
	
	public StateInTheCall(Norm nor) {
		this.nor=nor;
		if (this.nor.isActive())
			this.isActive=true;
		else this.isActive=false;
	}
	public Norm getNorm() {
		return nor;
	}
	public void setNorm(Norm nor) {
		this.nor = nor;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}

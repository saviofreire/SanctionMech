package sm;

public class Custos {
	private int Cvmf;       //Custo de viol�ao da acao final
	private int Cvi;        //Custo de viola��o individual
	private int Cvc;        //Custo de viola�ao coletiva	
	private int Cvg;        //Custo de viola�ao gerencial
	
	public Custos() {
		super();
		Cvmf = 0;
		Cvi = 0;
		Cvc = 0;
		Cvg = 0;
	}

	public int getCvi() {
		return Cvi;
	}


	public void setCvi(int cvi) {
		Cvi += cvi;
	}


	public int getCvc() {
		return Cvc;
	}


	public void setCvc(int cvc) {
		Cvc += cvc;
	}


	public int getCvg() {
		return Cvg;
	}


	public void setCvg(int cvg) {
		Cvg += cvg;
	}
	
	public void setCvmf(){
		this.Cvmf = this.Cvc + this.Cvg + this.Cvi;
	}
	public int getCvmf(){
		return this.Cvmf;
	}
	
}

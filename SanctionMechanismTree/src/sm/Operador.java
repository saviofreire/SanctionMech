package sm;

public enum Operador {
	SEQUENCIA("(SEQ)"), PARALELO("(PARAL)"), ESCOLHA("(ESC)");
	
	public String valor;
	Operador(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	
}

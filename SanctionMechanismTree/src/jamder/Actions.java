package jamder;

public class Actions {
	
	String cod;
	String nome;
	AgentRole papel;
	
	public Actions(String cod, String nome, AgentRole papel) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.papel = papel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
	
}

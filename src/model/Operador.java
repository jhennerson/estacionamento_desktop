package model;

public class Operador extends Usuario {
	
	private String bloco;

	public Operador(Integer id, String username, String password, String bloco) {
		super(id, username, password);
		this.bloco = bloco;
	}

	public Operador(String username, String password, String bloco) {
		super(username, password);
		this.bloco = bloco;
	}

	public Operador(String username, String password) {
		super(username, password);
	}

	public Operador() {
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

}

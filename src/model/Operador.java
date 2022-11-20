package model;

public class Operador extends Usuario {
	
	private Integer bloco;

	public Operador(Integer id, String username, String password, Integer bloco) {
		super(id, username, password);
		this.bloco = bloco;
	}

	public Operador(String username, String password, Integer bloco) {
		super(username, password);
		this.bloco = bloco;
	}

	public Operador(String username, String password) {
		super(username, password);
	}

	public Operador() {
	}

	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}

}

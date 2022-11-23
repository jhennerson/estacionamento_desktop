package model;

public class Operador extends Usuario {

	public Operador(Integer id, String username, String password, String bloco) {
		super(id, username, password, bloco);
	}

	public Operador(String username, String password, String bloco) {
		super(username, password,bloco);
	}

	public Operador(String username, String password) {
		super(username, password);
	}

	public Operador() {
	}

}

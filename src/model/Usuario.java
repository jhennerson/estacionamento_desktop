package model;

public abstract class Usuario {
	private Integer id;
	private String username;
	private String password;
	private String bloco;
	
	public Usuario(Integer id, String username, String password, String bloco) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.bloco = bloco;
	}
	
	public Usuario(String username, String password, String bloco) {
		super();
		this.username = username;
		this.password = password;
		this.bloco = bloco;
	}
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	public Usuario() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
}

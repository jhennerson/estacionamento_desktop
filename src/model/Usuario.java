package model;

public class Usuario {
	
	private Integer id;
	private String username;
	private String password;
	private Integer tipo;
	
	public Usuario(String username, String password, Integer tipo) {
		super();
		this.username = username;
		this.password = password;
		this.tipo = tipo;
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
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}

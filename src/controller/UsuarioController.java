package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Operador;
import model.Usuario;

public class UsuarioController {
	
	private Statement statement;
	
	public UsuarioController() {
		try {
			this.statement = new DBConnection().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//QUERY COM RESULTSET
	public ResultSet query(String sql) {
		try {
			ResultSet rs = statement.executeQuery(sql);
			return (rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//CREATE / READ / UPDATE / DELETE
	public int execute(String sql) {
		try {
			int rs = statement.executeUpdate(sql);
			return (rs);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//salva o usuário no banco de dados
	public void create(Operador operador) {		
		String nome = operador.getUsername();
		String senha = operador.getPassword().toString();
		String bloco = operador.getBloco();
		String senhaCriptografada = Cripto.Criptografar(senha);
		
		if(nome == null || nome.isBlank() || senha == null || senha.isBlank()){
			throw new IllegalArgumentException("Digite todos os campos.");
		}
		if(nome.length() < 5 || nome.length() > 16){
			throw new IllegalArgumentException("O nome deve possuir entre 5 e 16 caracteres.");
		}
		if(senha.length() < 5 || senha.length() > 32){
			throw new IllegalArgumentException("A senha deve possuir entre 5 e 32 caracteres.");
		}
		
		String sql = "INSERT INTO usuarios (username, password, bloco) VALUES ('" + nome + "', '" + senhaCriptografada + "', '" + bloco + "')";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//recupera usuario e senha do usuário passado como parâmetro (mais usual em caso de confirmação de login
	public ResultSet read(Operador operador) {		
		String nome = operador.getUsername();
		String senha = operador.getPassword();
		String senhaCriptografada = Cripto.Criptografar(senha);
		
		if(nome == null || nome.isBlank() || senha == null || senha.isBlank()){
			throw new IllegalArgumentException("Digite todos os campos.");
		}
		if(nome.length() < 5 || nome.length() > 16){
			throw new IllegalArgumentException("O nome deve possuir entre 5 e 16 caracteres.");
		}
		if(senha.length() < 5 || senha.length() > 32){
			throw new IllegalArgumentException("A senha deve possuir entre 5 e 32 caracteres.");
		}
		
		String sql = "SELECT username, password FROM usuarios WHERE username = '" + nome + "' AND password = '" + senhaCriptografada + "'";
		
		return query(sql);
	}
	
	//altera os dados do usuário com id igual ao passado como parâmetro e usa o nome e senha do mesmo como novos dados
	public void update(Operador operador) {
		Integer id = operador.getId();
		String nome = operador.getUsername();
		String senha = operador.getPassword().toString();
		String bloco = operador.getBloco();
		String senhaCriptografada = Cripto.Criptografar(senha);
		
		if(nome == null || nome.isBlank() || senha == null || senha.isBlank() || bloco == null || bloco.isBlank()){
			throw new IllegalArgumentException("Digite todos os campos.");
		}
		if(nome.length() < 5 || nome.length() > 16){
			throw new IllegalArgumentException("O nome deve possuir entre 5 e 16 caracteres.");
		}
		if(senha.length() < 5 || senha.length() > 32){
			throw new IllegalArgumentException("A senha deve possuir entre 5 e 32 caracteres.");
		}
		
		String sql = "UPDATE usuarios SET username = '" + nome + "', password = '" + senhaCriptografada + "', bloco = '" + bloco + "' WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//apaga o usuário pelo ID
	public void delete(Integer id) {
		
		String sql = "DELETE FROM usuarios WHERE id = '" + id + "'";
		
		try {
			if(id != 1)	this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//retorna uma lista de todos os usuários cadastrados no banco de dados
	public List<Usuario> getList() {		
		List<Usuario> operadores = new ArrayList<Usuario>();
		ResultSet rset = null;		
		String sql = "SELECT * FROM usuarios ORDER BY id";
		
		//ADICIONAR REGRAS
		
		try {					
			rset = query(sql);
			
			while(rset.next()) {
				Operador operador = new Operador();
				
				operador.setId(rset.getInt("id"));
				operador.setUsername(rset.getString("username"));
				operador.setPassword(rset.getString("password"));
				operador.setBloco(rset.getString("bloco"));
				
				operadores.add(operador);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return operadores;
	}
	
	//retorna uma lista de usernames sem repetição ordenados pelo username
	public List<String> distinctList() {
		List<String> nomes = new ArrayList<String>();
		ResultSet rset = null;
		
		//ADICIONAR REGRAS
		
		String sql = "SELECT DISTINCT username FROM usuarios ORDER BY username ASC";
		
		try {			
			rset = query(sql);
			while(rset.next()) {
				if(!rset.getString("username").equalsIgnoreCase("admin")) nomes.add(rset.getString("username"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return nomes;
	}
}

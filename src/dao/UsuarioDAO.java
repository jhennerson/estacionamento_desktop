package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
import database.DBQuery;
import model.Usuario;

public class UsuarioDAO {
	
	private Statement statement =  null;
	
	public UsuarioDAO() {
		try {
			this.statement = new DBConnection().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql) { // select
		try {
			ResultSet rs = statement.executeQuery(sql);
			return (rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void save(Usuario usuario) {
		
		String nome = usuario.getUsername();
		String senha = usuario.getPassword().toString();
		String tipo = usuario.getTipo().toString();
		
		//To-do criptografia
		
		String[] values = new String[] {nome, senha, tipo};
		DBQuery query = new DBQuery("usuarios","username,password,tipo","1");
		query.insert(values);
	}
	
	public ResultSet check(Usuario usuario) {
		
		String nome = usuario.getUsername();
		String senha = usuario.getPassword().toString();
		String tipo = usuario.getTipo().toString();
		
		String where = "*" + nome + " = username and " + senha + " = password";
		DBQuery query = new DBQuery("usuarios","username,password","1");
		return query.select(where);
	}
}

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Bloco;
import model.Vaga;


public class BlocoController {

	private Statement statement;
	
	public BlocoController() {
		try {
			this.statement = new DBConnection().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	
	//salva o bloco no banco de dados
	public void create(Bloco bloco) {
		Integer vagasCarros = 0;
		Integer vagasMotos = 0;
		Integer vagasDeficientes = 0;
		String descricao = bloco.getDescricao();
		String operador = bloco.getOperador();
		
		for(Vaga v : bloco.getVagas()) {
			if (v.getCategoria() == 1) vagasCarros += 1;
			if (v.getCategoria() == 2) vagasMotos += 1;
			if (v.getCategoria() == 3) vagasDeficientes += 1;
		}
		
		String sql = "INSERT INTO blocos (descricao, operador, vagas_carros, vagas_motos, vagas_deficientes) "
				   + "VALUES ('" + descricao + "', '" + operador + "', '" + vagasCarros + "', '" + vagasMotos + "', '" + vagasDeficientes + "')";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//recupera informações do bloco pelo id
	public ResultSet read(Bloco bloco) {		
		Integer id = bloco.getId();
		
		String sql = "SELECT * FROM blocos WHERE id = '" + id + "'";
		
		return query(sql);
	}
	
	//altera os dados do bloco com id igual ao passado como parâmetro
	public void update(Bloco bloco) {
		Integer id = bloco.getId();
		String descricao = bloco.getDescricao();
		String operador = bloco.getOperador();
		Integer vagasCarros = bloco.getVagasCarros();
		Integer vagasMotos = bloco.getVagasMotos();
		Integer vagasDeficientes = bloco.getVagasDeficientes();
		
		String sql = "UPDATE blocos SET descricao = '" + descricao + "', operador = '" + operador + "', vagas_carros = '" + vagasCarros + "', vagas_motos = '"
				+ vagasMotos + "', vagas_deficientes = '" + vagasDeficientes + "' WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//apaga o bloco pelo ID
	public void delete(Integer id) {
		
		String sql = "DELETE FROM blocos WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//retorna uma lista de todos os blocos do estacionamento
	public List<Bloco> getList() {		
		List<Bloco> blocos = new ArrayList<Bloco>();
		ResultSet rset = null;		
		String sql = "SELECT * FROM blocos ORDER BY id";
		
		try {					
			rset = query(sql);
			
			while(rset.next()) {
				Bloco bloco = new Bloco();
				
				bloco.setId(rset.getInt("id"));
				bloco.setDescricao(rset.getString("descricao"));
				bloco.setOperador(rset.getString("operador"));
				bloco.setVagasCarros(rset.getInt("vagas_carros"));
				bloco.setVagasMotos(rset.getInt("vagas_motos"));
				bloco.setVagasDeficientes(rset.getInt("vagas_deficientes"));
				
				blocos.add(bloco);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return blocos;
	}

}

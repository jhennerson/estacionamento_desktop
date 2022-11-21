package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Operador;
import model.Vaga;

public class VagaController {

	private Statement statement;
	
	public VagaController() {
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
	
	//salva a vaga no banco de dados
	public void create(Vaga vaga) {
		Integer categoria = vaga.getCategoria();
		String bloco = vaga.getBloco();
		Integer estado = vaga.getEstado();
		
		String sql = "INSERT INTO vagas (categoria, bloco, estado) "
				   + "VALUES ('" + categoria + "', '" + bloco + "', '" + estado + "')";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//recupera informações da vaga pelo id
	public ResultSet read(Vaga vaga) {		
		Integer id = vaga.getId();
		
		String sql = "SELECT * FROM vagas WHERE id = '" + id + "'";
		
		return query(sql);
	}
	
	//altera os dados da vaga com id igual ao passado como parâmetro
	public void update(Vaga vaga) {
		Integer id = vaga.getId();
		Integer categoria = vaga.getCategoria();
		String bloco = vaga.getBloco();
		Integer estado = vaga.getEstado();
		
		String sql = "UPDATE vagas SET categoria = '" + categoria + "', bloco = '" + bloco + "', estado = '" + estado + "' WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//apaga a vaga pelo ID
	public void delete(Integer id) {
		
		String sql = "DELETE FROM vagas WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//retorna uma lista de todas as vagas do bloco
	public List<Vaga> getList() {		
		List<Vaga> vagas = new ArrayList<Vaga>();
		ResultSet rset = null;		
		String sql = "SELECT * FROM vagas ORDER BY id";
		
		try {					
			rset = query(sql);
			
			while(rset.next()) {
				Vaga vaga = new Vaga();
				
				vaga.setId(rset.getInt("id"));
				vaga.setCategoria(rset.getInt("categoria"));
				vaga.setBloco(rset.getString("bloco"));
				vaga.setEstado(rset.getInt("estado"));
				
				vagas.add(vaga);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public List<Vaga> getList(Operador operador) {		
		List<Vaga> vagas = new ArrayList<Vaga>();
		ResultSet rset = null;		
		String sql = "SELECT * FROM vagas WHERE bloco = " + operador.getUsername() + " ORDER BY id";
		
		try {					
			rset = query(sql);
			
			while(rset.next()) {
				Vaga vaga = new Vaga();
				
				vaga.setId(rset.getInt("id"));
				vaga.setCategoria(rset.getInt("categoria"));
				vaga.setBloco(rset.getString("bloco"));
				vaga.setEstado(rset.getInt("estado"));
				
				vagas.add(vaga);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public String alteraEstado(Vaga vaga) {
		
		if(vaga.getEstado() == 0) {
			vaga.setEstado(1);
			return "Estado alterado para OCUPADO!";
		} else {
			vaga.setEstado(0);
			return "Estado alterado para LIVRE!";
		}
	}

}

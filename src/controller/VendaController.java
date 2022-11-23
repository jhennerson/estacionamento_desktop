package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Venda;

public class VendaController {

private Statement statement;
	
	public VendaController() {
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
	
	//salva a venda no banco de dados
	public void create(Venda venda) {
		Float valor = venda.getValor();
		
		String sql = "INSERT INTO vendas (valor) "
				   + "VALUES ('" + valor + "')";
		
		try {
			if(valor > 0) this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//recupera informações da venda pelo id
	public ResultSet read(Venda venda) {		
		Integer id = venda.getId();
		
		String sql = "SELECT * FROM vendas WHERE id = '" + id + "'";
		
		return query(sql);
	}
	
	//altera os dados da venda com id igual ao passado como parâmetro
	public void update(Venda venda) {
		Integer id = venda.getId();
		Float valor = venda.getValor();
		
		//ADICIONAR REGRAS
		
		String sql = "UPDATE vendas SET valor = '" + valor + "' WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//apaga a venda pelo ID
	public void delete(Integer id) {
		
		String sql = "DELETE FROM vendas WHERE id = '" + id + "'";
		
		try {
			this.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//retorna uma lista de todas as vendas
	public List<Venda> getList() {		
		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rset = null;		
		String sql = "SELECT * FROM vendas ORDER BY id";
		
		try {					
			rset = query(sql);
			
			while(rset.next()) {
				Venda venda = new Venda();
				
				venda.setId(rset.getInt("id"));
				venda.setValor(rset.getFloat("valor"));
				venda.setTimestamp(rset.getTimestamp("timestamp"));
				
				vendas.add(venda);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return vendas;
	}

}

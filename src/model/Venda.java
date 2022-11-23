package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Venda {

	private Integer id;
	private Float valor;
	private String timestamp;

	public Venda(Integer id, Float valor, String timestamp) {
		super();
		this.id = id;
		this.valor = valor;
		this.timestamp = timestamp;
	}
	
	public Venda(Float valor) {
		super();
		this.valor = valor;
	}
	
	public Venda() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		this.timestamp = df.format(timestamp);		
	}

}

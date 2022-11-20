package model;

public class Vaga {
	
	private Integer id;
	private Integer categoria;
	private Integer bloco;
	private Integer estado = 0;
	
	public Vaga(Integer id, Integer categoria, Integer bloco, Integer estado) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.bloco = bloco;
		this.estado = estado;
	}
	
	public Vaga(Integer categoria, Integer bloco) {
		super();
		this.categoria = categoria;
		this.bloco = bloco;
	}

	public Vaga() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}

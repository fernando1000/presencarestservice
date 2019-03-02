package br.com.x10d.presencarest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name="v_percentual_presenca")
public class ViewPercentualPresenca implements Serializable{
	
	@Id
	private Long id;
	
	private String nome;
	private String evento;
	private String congregacao;
	//@Column(name = "total_presenca")
	private Long total_presenca;
	private Double percentual_presenca;
	
	@Transient
	private List<ViewPercentualPresenca> lista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(String congregacao) {
		this.congregacao = congregacao;
	}

	public List<ViewPercentualPresenca> getLista() {
		return lista;
	}

	public void setLista(List<ViewPercentualPresenca> lista) {
		this.lista = lista;
	}

	public Long getTotal_presenca() {
		return total_presenca;
	}

	public void setTotal_presenca(Long total_presenca) {
		this.total_presenca = total_presenca;
	}

	public Double getPercentual_presenca() {
		return percentual_presenca;
	}

	public void setPercentual_presenca(Double percentual_presenca) {
		this.percentual_presenca = percentual_presenca;
	}

	
}
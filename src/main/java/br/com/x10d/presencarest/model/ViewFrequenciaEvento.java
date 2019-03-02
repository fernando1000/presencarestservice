package br.com.x10d.presencarest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="v_frequencia_evento")
public class ViewFrequenciaEvento implements Serializable{
	
	@Id
	private Long id;	
	private String nome;
	private String evento;
	private String congregacao;
	private String cargo;	
	private Long presenca_28_01;
	private Long presenca_29_01;
	private Long presenca_30_01;
	
	@Transient
	private List<ViewFrequenciaEvento> lista;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getPresenca_28_01() {
		return presenca_28_01;
	}

	public void setPresenca_28_01(Long presenca_28_01) {
		this.presenca_28_01 = presenca_28_01;
	}

	public Long getPresenca_29_01() {
		return presenca_29_01;
	}

	public void setPresenca_29_01(Long presenca_29_01) {
		this.presenca_29_01 = presenca_29_01;
	}

	public Long getPresenca_30_01() {
		return presenca_30_01;
	}

	public void setPresenca_30_01(Long presenca_30_01) {
		this.presenca_30_01 = presenca_30_01;
	}

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

	public List<ViewFrequenciaEvento> getLista() {
		return lista;
	}

	public void setLista(List<ViewFrequenciaEvento> lista) {
		this.lista = lista;
	}
	
}
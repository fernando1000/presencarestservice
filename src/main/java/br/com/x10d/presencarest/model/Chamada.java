package br.com.x10d.presencarest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Chamada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer id;
	private String codigoBarras;
	private Date data;
	private String nomePalestra;	
	private String mensagem;	
	@Transient
	private List<Chamada> chamadas;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNomePalestra() {
		return nomePalestra;
	}
	public void setNomePalestra(String nomePalestra) {
		this.nomePalestra = nomePalestra;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<Chamada> getChamadas() {
		return chamadas;
	}
	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}
	
}

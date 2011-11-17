package br.com.todi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "todi_cenarios_odi")
public class CenarioODI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cenario_odi")
	private Long ID;
	
	@Column
	private Long idODI;
	
	@Column(length = 20)
	private String versaoAtual;
	
	@Column(length = 150)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;
	
	public CenarioODI() {
		
	}
	
	public CenarioODI(String nome, String versaoAtual, Long idODI) {
		this.nome = nome;
		this.versaoAtual = versaoAtual;
		this.idODI = idODI;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Long getIdODI() {
		return idODI;
	}

	public void setIdODI(Long idODI) {
		this.idODI = idODI;
	}

	public String getVersaoAtual() {
		return versaoAtual;
	}

	public void setVersaoAtual(String versaoAtual) {
		this.versaoAtual = versaoAtual;
	}
}

package br.com.todi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "todi_projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_projeto")
	private Long ID;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 1000)
	private String descricao;
	
	@Column(length = 200)
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ForeignKey(name = "FK_PROJETO_REPOSITORIO")
	private RepositorioInfo repositorioInfo;
	
	@OneToMany(mappedBy="projeto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Testador> testadores;
	
	@Transient
	private List<Artefato> artefatos;
	
	@Transient
	private Boolean isAutenticadoUserSession = false;
	
	public Projeto() {
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public RepositorioInfo getRepositorioInfo() {
		return repositorioInfo;
	}

	public void setRepositorioInfo(RepositorioInfo repositorioInfo) {
		this.repositorioInfo = repositorioInfo;
	}

	public List<Testador> getTestadores() {
		return testadores;
	}

	public void setTestadores(List<Testador> testadores) {
		this.testadores = testadores;
	}

	public List<Artefato> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(List<Artefato> artefatos) {
		this.artefatos = artefatos;
	}

	public Boolean getIsAutenticadoUserSession() {
		return isAutenticadoUserSession;
	}

	public void setIsAutenticadoUserSession(Boolean isAutenticadoUserSession) {
		this.isAutenticadoUserSession = isAutenticadoUserSession;
	}
}

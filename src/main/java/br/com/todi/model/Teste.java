package br.com.todi.model;

import java.util.Date;
import java.util.List;

public class Teste {
	
	private int ID;
	private Date dataCriacao;
	private Date dataMoficacao;
	private String descricao;
	private CenarioODI artefato;
	private List<ExecucaoTeste> execucoes;
	
	public Teste() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataMoficacao() {
		return dataMoficacao;
	}

	public void setDataMoficacao(Date dataMoficacao) {
		this.dataMoficacao = dataMoficacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CenarioODI getArtefato() {
		return artefato;
	}

	public void setArtefato(CenarioODI artefato) {
		this.artefato = artefato;
	}

	public List<ExecucaoTeste> getExecucoes() {
		return execucoes;
	}

	public void setExecucoes(List<ExecucaoTeste> execucoes) {
		this.execucoes = execucoes;
	}
}

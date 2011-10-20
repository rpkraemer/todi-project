package br.com.todi.model;

import java.util.List;

public class Suite {
	
	private int ID;
	private String nome;
	private String descricao;
	private List<Teste> testes;
	private List<ExecucaoSuite> execucoes;
	
	public Suite() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
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

	public List<Teste> getTestes() {
		return testes;
	}

	public void setTestes(List<Teste> testes) {
		this.testes = testes;
	}

	public List<ExecucaoSuite> getExecucoes() {
		return execucoes;
	}

	public void setExecucoes(List<ExecucaoSuite> execucoes) {
		this.execucoes = execucoes;
	}
	
	

}

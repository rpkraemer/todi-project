package br.com.todi.model;

import java.util.Date;

public class ExecucaoSuite {
	
	private int ID;
	private char status;
	private Date dataHora;
	
	public ExecucaoSuite() {
	
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}

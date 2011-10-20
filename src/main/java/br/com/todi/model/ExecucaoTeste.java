package br.com.todi.model;

import java.util.Date;

public class ExecucaoTeste {
	
	private int ID;
	private char status;
	private Date dataHora;
	
	public ExecucaoTeste() {
		
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
package br.com.todi.persistence.repository;

import java.util.List;

import br.com.todi.model.CenarioODI;
import br.com.todi.model.Projeto;

public interface ODIRepository {

	public List<CenarioODI> buscarCenariosODI(Projeto projeto);
	
}

package br.com.todi.persistence.dao;

import java.util.List;

import br.com.todi.model.CenarioODI;

public interface CenarioODIDAO extends DAO<CenarioODI> {

	public void saveList(List<CenarioODI> cenariosODI);
	
}

package br.com.todi.persistence.repository;

import java.util.List;
import br.com.todi.model.CenarioODI;

public interface CenarioODIRepository extends Repository<CenarioODI> {
	
	public void saveList(List<CenarioODI> cenariosODI);

}

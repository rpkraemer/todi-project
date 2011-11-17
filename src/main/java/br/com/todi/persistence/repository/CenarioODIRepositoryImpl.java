package br.com.todi.persistence.repository;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.CenarioODI;
import br.com.todi.persistence.dao.CenarioODIDAO;

@Component
public class CenarioODIRepositoryImpl implements CenarioODIRepository {

	private CenarioODIDAO cenarioODIDAO;
	
	public CenarioODIRepositoryImpl(CenarioODIDAO cenarioODIDAO) {
		this.cenarioODIDAO = cenarioODIDAO;
	}
	
	@Override
	public void salvar(CenarioODI obj) {
		cenarioODIDAO.salvar(obj);
	}

	@Override
	public CenarioODI pegarPorID(long id) {
		return cenarioODIDAO.pegarPorID(id);
	}

	@Override
	public List<CenarioODI> listarTodos() {
		return cenarioODIDAO.listarTodos();
	}

	@Override
	public void deletar(long id) {
		cenarioODIDAO.deletar(id);
	}

	@Override
	public long totalCadastrados() {
		return cenarioODIDAO.totalCadastrados();
	}

	@Override
	public void saveList(List<CenarioODI> cenariosODI) {
		cenarioODIDAO.saveList(cenariosODI);
	}

}

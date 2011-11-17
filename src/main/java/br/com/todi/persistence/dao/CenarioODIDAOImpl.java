package br.com.todi.persistence.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.CenarioODI;

@Component
public class CenarioODIDAOImpl extends GDAO<CenarioODI> implements CenarioODIDAO {

	private Session session;
	
	public CenarioODIDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public void saveList(List<CenarioODI> cenariosODI) {
		for (CenarioODI cenarioODI : cenariosODI)
			session.save(cenarioODI);		
	}

}

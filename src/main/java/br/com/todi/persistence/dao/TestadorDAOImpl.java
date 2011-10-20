package br.com.todi.persistence.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.Testador;

@Component
public class TestadorDAOImpl extends GDAO<Testador> implements TestadorDAO {

	public TestadorDAOImpl(Session session) {
		super(session);
	}

}

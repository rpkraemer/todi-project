package br.com.todi.persistence.dao;


import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.Projeto;

@Component
public class ProjetoDAOImpl extends GDAO<Projeto> implements ProjetoDAO {

	public ProjetoDAOImpl(Session session) {
		super(session);
	}
	
}

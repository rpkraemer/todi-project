package br.com.todi.persistence.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.Projeto;
import br.com.todi.util.Utilidades;

@Component
public class ProjetoDAOImpl extends GDAO<Projeto> implements ProjetoDAO {
	
	private Session session;
	
	public ProjetoDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public boolean autenticarProjeto(Long idProjeto, String senha) {
		Query query = session.createQuery("from Projeto where ID = ? and senha = ?").
			setParameter(0, idProjeto).setParameter(1, senha);
		boolean autenticado = query.uniqueResult() != null ? true : false; 
		return autenticado;
		
	}
	
}

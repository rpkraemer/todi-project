package br.com.todi.persistence.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.Testador;

@Component
public class TestadorDAOImpl extends GDAO<Testador> implements TestadorDAO {
	
	private Session session;

	public TestadorDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public boolean testadorExistente(String usuario, String senha) {
		Testador testador = (Testador) session.
								createQuery("from Testador where usuario = ? and senha = ?").
								setString(0, usuario).setString(1, senha).
								uniqueResult();
		
		boolean autenticado = false;
		if (testador != null)
			autenticado = true;
		return autenticado;
	}

}

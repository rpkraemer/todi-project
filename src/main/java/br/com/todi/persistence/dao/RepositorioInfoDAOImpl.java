package br.com.todi.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.todi.model.RepositorioInfo;
import br.com.todi.util.Utilidades;

@Component
public class RepositorioInfoDAOImpl extends GDAO<RepositorioInfo> implements RepositorioInfoDAO {

	private Session session;
	
	public RepositorioInfoDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public String pegarSenhaAtual(Long idRepoInfo, String tipoSenha) {
		Query query = null;
		String coluna = "";
		
		if ("DB".equals(tipoSenha)) coluna = "loginDBPass"; 
		else if ("ODI".equals(tipoSenha)) coluna = "loginPass";
		
		query = session.createQuery("select " + coluna + " from RepositorioInfo where ID = ?").
			setLong(0, idRepoInfo);
		
		return (String) query.uniqueResult();
		
	}

	@Override
	public boolean salvarNovaSenha(String novaSenha, String tipoSenha,
			Long idRepoInfo) {
		Query query = null;
		String coluna = "";
		
		if ("DB".equals(tipoSenha)) coluna = "loginDBPass"; 
		else if ("ODI".equals(tipoSenha)) coluna = "loginPass";
		
		query = session.createQuery("update RepositorioInfo set " + coluna + " = ? where ID = ?").
					setString(0, novaSenha).
					setLong(1, idRepoInfo);
		if (query.executeUpdate() > 0)
			return true;
		return false;
	}

	
}

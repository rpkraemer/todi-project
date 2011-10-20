package br.com.todi.modificators;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.util.hibernate.SessionFactoryCreator;

@Component
@ApplicationScoped
public class DatabaseModificator {

	private SessionFactoryCreator sessionFactoryCreator;
	private Session session;
	
	public DatabaseModificator(SessionFactoryCreator sessionFactoryCreator) {
		this.sessionFactoryCreator = sessionFactoryCreator;
	}
	
	
	@PostConstruct
	public void getSession() {
		session = sessionFactoryCreator.getInstance().openSession();
		executeDBScripts();
	}
	
	public void executeDBScripts() {
		
		String DROP_FK_PROJETO_REPOSITORIO = "ALTER TABLE todi.todi_projeto DROP FOREIGN KEY FK_PROJETO_REPOSITORIO";
		String FK_PROJETO_REPOSITORIO = " ALTER TABLE todi.todi_projeto " +
										" ADD CONSTRAINT FK_PROJETO_REPOSITORIO FOREIGN KEY " + 
										" (repositorioInfo_id_repositorio_info) " +
										" REFERENCES todi_repositorio_info (id_repositorio_info) ON DELETE SET NULL";
		
		session.createSQLQuery(DROP_FK_PROJETO_REPOSITORIO).executeUpdate();
		session.createSQLQuery(FK_PROJETO_REPOSITORIO).executeUpdate();
	}
	
	@PreDestroy
	public void closeSession() {
		session.close();
	}
}

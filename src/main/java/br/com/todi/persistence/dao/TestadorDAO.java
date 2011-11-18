package br.com.todi.persistence.dao;

import br.com.todi.model.Testador;

public interface TestadorDAO extends DAO<Testador> {

	public boolean testadorExistente(String usuario, String senha);
	
}

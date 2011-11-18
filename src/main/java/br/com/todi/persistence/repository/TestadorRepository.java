package br.com.todi.persistence.repository;

import br.com.todi.model.Testador;

public interface TestadorRepository extends Repository<Testador> {

	public void salvar(final Testador testador, Long idProjeto);
	public boolean testadorExistente(String usuario, String senha);
	
}

package br.com.todi.persistence.dao;

import br.com.todi.model.Projeto;

public interface ProjetoDAO extends DAO<Projeto> {

	public boolean autenticarProjeto(Long idProjeto, String senha);
}

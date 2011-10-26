package br.com.todi.persistence.repository;

import br.com.todi.model.Projeto;

public interface ProjetoRepository extends Repository<Projeto> {

	public boolean autenticarProjeto(Long idProjeto, String senha);
}

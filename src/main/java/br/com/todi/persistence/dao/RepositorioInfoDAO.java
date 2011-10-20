package br.com.todi.persistence.dao;

import br.com.todi.model.RepositorioInfo;

public interface RepositorioInfoDAO extends DAO<RepositorioInfo> {

	public String pegarSenhaAtual(Long idRepoInfo, String tipoSenha);
	public boolean salvarNovaSenha(String novaSenha, String tipoSenha, Long idRepoInfo);
	
}

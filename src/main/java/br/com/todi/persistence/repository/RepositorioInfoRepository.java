package br.com.todi.persistence.repository;

import java.util.List;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.todi.model.RepositorioInfo;

public interface RepositorioInfoRepository extends Repository<RepositorioInfo> {

	public List<RepositorioInfo> processarArquivo(UploadedFile xml, Long idProjeto);
	public void salvar(final RepositorioInfo repoInfo, Long idProjeto);
	public boolean salvarNovaSenha(String novaSenha, String senhaAtual, String tipoSenha, Long idRepoInfo);
	
}

package br.com.todi.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.todi.annotation.ProjetoAutenticado;
import br.com.todi.annotation.Restrito;
import br.com.todi.model.Projeto;
import br.com.todi.model.RepositorioInfo;
import br.com.todi.model.Testador;
import br.com.todi.persistence.repository.ProjetoRepository;
import br.com.todi.persistence.repository.RepositorioInfoRepository;
import br.com.todi.persistence.repository.TestadorRepository;

@Resource
@Restrito(role="supervisor")
public class SupervisorController {

	private Result result;
	private ProjetoRepository projetoRepository;
	private TestadorRepository testadorRepository;
	private RepositorioInfoRepository repositorioInfoRepository;
	
	public SupervisorController(Result result, ProjetoRepository projetoRepository, 
							    TestadorRepository testadorRepository, RepositorioInfoRepository repositorioInfoRepository) {
		this.result = result;
		this.projetoRepository = projetoRepository;
		this.testadorRepository = testadorRepository;
		this.repositorioInfoRepository = repositorioInfoRepository;
	}
	
	@Get
	@Path("/supervisor")
	public void home() {
		result.include("projetoList", projetoRepository.listarTodos());
	}

	@Get
	@Path("/supervisor/projetos/novo")
	public void novoProjeto() { }
	
	@Post
	@Path("/supervisor/projetos")
	@ProjetoAutenticado
	public void salvarProjeto(Projeto projeto) {
		projetoRepository.salvar(projeto);
		result.redirectTo(this).home();
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/editar")
	@ProjetoAutenticado
	public void editarProjeto(Long idProjeto) {
		Projeto projeto = projetoRepository.pegarPorID(idProjeto);
		result.include("projeto", projeto);
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/deletar")
	@ProjetoAutenticado
	public void deletarProjeto(Long idProjeto) {
		projetoRepository.deletar(idProjeto);
		result.redirectTo(this).home();
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/testadores")
	@ProjetoAutenticado
	public void testadoresProjeto(Long idProjeto) {
		result.include("projeto", projetoRepository.pegarPorID(idProjeto));
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/testadores/novo")
	@ProjetoAutenticado
	public void novoTestador(Long idProjeto) {
		result.include("idProjeto", idProjeto);
	}
	
	@Post
	@Path("/supervisor/projetos/{idProjeto}/testadores/salvar")
	@ProjetoAutenticado
	public void salvarTestador(Testador testador, Long idProjeto) {
		testadorRepository.salvar(testador, idProjeto);
		result.redirectTo(this).testadoresProjeto( testador.getProjeto().getID() );
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/testadores/editar/{idTestador}")
	@ProjetoAutenticado
	public void editarTestador(Long idProjeto, Long idTestador) {
		Testador testador = testadorRepository.pegarPorID(idTestador);
		result.include("testador", testador);
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/testadores/deletar/{idTestador}")
	@ProjetoAutenticado
	public void deletarTestador(Long idProjeto, Long idTestador) {
		//TODO Mais adiante, verificar possibilidade de o testador já possuir testes ao tentar ser excluído
		testadorRepository.deletar(idTestador);
		result.redirectTo(this).testadoresProjeto(idProjeto);
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/informacao-repositorio-odi")
	@ProjetoAutenticado
	public void informacoesRepositorioODI(Long idProjeto) {
		Projeto projeto = projetoRepository.pegarPorID(idProjeto);
		result.include("repositorioInfo", projeto.getRepositorioInfo());
		result.include("idProjeto", idProjeto);
	}
	
	@Post
	@Path("/supervisor/projetos/salvar/informacao-projeto-odi") //REVER ESTE PATH!!!
	@ProjetoAutenticado
	public void salvarInformacaoRepositorioODI(RepositorioInfo repoInfo, Long idProjeto) {
		repositorioInfoRepository.salvar(repoInfo, idProjeto);
		result.redirectTo(this).informacoesRepositorioODI(idProjeto);
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/informacao-repositorio-odi/excluir/{idRepositorioInfo}")
	@ProjetoAutenticado
	public void deletarInformacaoRepositorioODI(Long idProjeto, Long idRepositorioInfo) {
		repositorioInfoRepository.deletar(idRepositorioInfo);
		result.redirectTo(this).informacoesRepositorioODI(idProjeto);
	}
	
	@Get
	@Path("/supervisor/projetos/{idProjeto}/informacao-repositorio-odi/{idRepoInfo}/trocar-senha")
	@ProjetoAutenticado
	public void trocarSenhaRepositorioInfo(Long idProjeto, Long idRepoInfo) {
		result.include("idProjeto", idProjeto).
			   include("idRepoInfo", idRepoInfo);
	}
	
	@Post
	@Path("/supervisor/projetos/{idProjeto}/informacao-repositorio-odi/trocar-senha")
	@ProjetoAutenticado
	public void salvarSenhaRepositorioInfo(Long idProjeto, Long idRepoInfo, String novaSenha,
			String senhaAtual, String tipoSenha) {
		if (repositorioInfoRepository.salvarNovaSenha(novaSenha, senhaAtual, tipoSenha, idRepoInfo))
			result.include("status", "A senha foi trocada com sucesso!");
		else
			result.include("status", "Não foi possível realizar a troca da senha. Tente novamente.");
		result.redirectTo(this).trocarSenhaRepositorioInfo(idProjeto, idRepoInfo);
	}	

	@Post
	@Path("/supervisor/projetos/upload/odi-xml")  //REVER ESTE PATH
	@ProjetoAutenticado
	public void odiXmlUploaded(UploadedFile xml, Long idProjeto) {
		if ("SNPS_LOGIN_WORK.xml".equalsIgnoreCase(xml.getFileName())) {
			List<RepositorioInfo> projetosODI = repositorioInfoRepository.processarArquivo(xml, idProjeto);
			result.include("projetosODI", projetosODI);
			result.redirectTo(this).informacoesRepositorioODI(idProjeto);
		}
		result.forwardTo(this).informacoesRepositorioODI(idProjeto);
	}
}

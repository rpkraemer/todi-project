package br.com.todi.persistence.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.Validations;
import br.com.todi.controller.SupervisorController;
import br.com.todi.model.Projeto;
import br.com.todi.model.RepositorioInfo;
import br.com.todi.persistence.dao.ProjetoDAO;
import br.com.todi.persistence.dao.RepositorioInfoDAO;
import br.com.todi.util.Utilidades;

@Component
public class RepositorioInfoRepositoryImpl implements RepositorioInfoRepository {

	private RepositorioInfoDAO repositorioInfoDAO;
	private ProjetoDAO projetoDAO;
	private Validator validator;
	private String TMP_PATH;
	private Logger logger;

	public RepositorioInfoRepositoryImpl(RepositorioInfoDAO repositorioInfoDAO, ProjetoDAO projetoDAO,
			Validator validator, RequestInfo requestInfo) {
		this.repositorioInfoDAO = repositorioInfoDAO;
		this.projetoDAO = projetoDAO;
		this.validator = validator;
		this.TMP_PATH = requestInfo.getServletContext().getRealPath("/tmp");
		logger =  Logger.getLogger(this.getClass().getName());
	}

	@Override
	public void salvar(final RepositorioInfo repoInfo, Long idProjeto) {
			validator.validate(repoInfo);
			validator.checking(new Validations(){{
				that(!repoInfo.getLoginPass().isEmpty() || repoInfo.getLoginPass() == null, "", "repositorioinfo.loginpass.invalido");
				that(!repoInfo.getLoginDBPass().isEmpty() || repoInfo.getLoginDBPass() == null, "", "repositorioinfo.logindbpass.invalido");
			}});
			
			validator.onErrorForwardTo(SupervisorController.class).informacoesRepositorioODI(idProjeto);
			
			repoInfo.setLoginPass( Utilidades.md5(repoInfo.getLoginPass()) );
			repoInfo.setLoginDBPass( Utilidades.md5(repoInfo.getLoginDBPass()) );
			Projeto projeto = projetoDAO.pegarPorID(idProjeto);
			projeto.setRepositorioInfo(repoInfo);
			
			repositorioInfoDAO.salvar(repoInfo);
			projetoDAO.salvar(projeto);
	}

	@Override
	public RepositorioInfo pegarPorID(long id) {
		return repositorioInfoDAO.pegarPorID(id);
	}

	@Override
	public List<RepositorioInfo> listarTodos() {
		return repositorioInfoDAO.listarTodos();
	}

	@Override
	public void deletar(long id) {
		repositorioInfoDAO.deletar(id);
	}

	@Override
	public long totalCadastrados() {
		return repositorioInfoDAO.totalCadastrados();
	}

	@Override
	public List<RepositorioInfo> processarArquivo(UploadedFile xml, Long idProjeto) {
		
		try {
			String nomeArquivoSalvo = salvarArquivoSnpsLoginWork(xml, idProjeto);
			List<RepositorioInfo> projetosODI = extrairProjetosODIdoArquivo(nomeArquivoSalvo);
			
			return projetosODI;
			
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "ERRO AO SALVAR/PROCESSAR O ARQUIVO SNPS_LOGIN_WORK.xml");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "ERRO AO SALVAR/PROCESSAR O ARQUIVO SNPS_LOGIN_WORK.xml");
		} catch(JDOMException e) {
			logger.log(Level.SEVERE, "ERRO AO SALVAR/PROCESSAR O ARQUIVO SNPS_LOGIN_WORK.xml");
		}
		return null;
	}

	private List<RepositorioInfo> extrairProjetosODIdoArquivo(String nomeArquivo)
			throws JDOMException, IOException {
		List<RepositorioInfo> projetosODI = new ArrayList<RepositorioInfo>();
		
		SAXBuilder builder = new SAXBuilder();
		Document snpsLoginWork = builder.build(new File(TMP_PATH, nomeArquivo));
		
		Element snpsLogin = snpsLoginWork.getRootElement();
		List<Element> projetos = snpsLogin.getChildren();
		Iterator it = projetos.iterator();
		
		while (it.hasNext()) {
			Element projeto = (Element) it.next();
			List<Element> fields = projeto.getChildren();
			RepositorioInfo repoInfo = new RepositorioInfo(
				((Element) fields.get(1)).getTextTrim(),
				((Element) fields.get(2)).getTextTrim(),
				null,
				((Element) fields.get(5)).getTextTrim(),
				null,
				((Element) fields.get(7)).getTextTrim(),
				((Element) fields.get(8)).getTextTrim(),
				((Element) fields.get(9)).getTextTrim()
			);
			projetosODI.add(repoInfo);
		}

		return projetosODI;
	}

	private String salvarArquivoSnpsLoginWork(UploadedFile repoInfo,
			Long idProjeto) throws FileNotFoundException, IOException {

		if (repoInfo != null) {
			String nomeXML = repoInfo.getFileName();
			int ext = nomeXML.lastIndexOf(".");
			String extensao = (ext > 0) ? nomeXML.substring(ext) : ".xml";

			nomeXML = idProjeto + extensao;
			IOUtils.copy(repoInfo.getFile(), new FileOutputStream(new File(
					TMP_PATH, nomeXML)));

			return nomeXML;
		}
		return null;
	}

	@Override
	public void salvar(RepositorioInfo obj) {
		// TODO NÃO UTILIZAR
		
	}

	@Override
	public boolean salvarNovaSenha(String novaSenha, String senhaAtual, String tipoSenha, Long idRepoInfo) {
		senhaAtual = Utilidades.md5(senhaAtual);
		novaSenha = Utilidades.md5(novaSenha);
		
		if (senhaAtual.equals(repositorioInfoDAO.pegarSenhaAtual(idRepoInfo, tipoSenha))) {
			if (repositorioInfoDAO.salvarNovaSenha(novaSenha, tipoSenha, idRepoInfo))
				return true;
			return false;
		} else
			return false;
	}

}

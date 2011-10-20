package br.com.todi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.todi.persistence.dao.ProjetoDAOImpl;

@Resource
public class ProjetoController {
	
	private String TMP_PATH;
	private Result result;
	private ProjetoDAOImpl dao;
	
	public ProjetoController(Result result, ProjetoDAOImpl dao, RequestInfo reqInfo) {
		this.result = result;
		this.dao = dao;
		this.TMP_PATH = reqInfo.getServletContext().getRealPath("/tmp");
	}
	
	/*
	 * Criação do Projeto na visão do SUPERVISOR - Início *********************************
	 */
	
	
	@Post
	@Path("/supervisor/projetos/repoInfo/etapa2")
	public void salvarInformacaoRepositorioEtapa2(int ID, UploadedFile repoInfo) {
		if (repoInfo != null) {
			String nomeXML = repoInfo.getFileName();
			int ate = nomeXML.lastIndexOf(".");
			String extensao = (ate > 0) ? nomeXML.substring(ate) : ".xml";
			
			nomeXML = ID + extensao;
			
			try {
				IOUtils.copy(repoInfo.getFile(), new FileOutputStream(new File(TMP_PATH, nomeXML)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		result.redirectTo(SupervisorController.class).home();
	}
	
	/*
	 * Criação do Projeto na visão do SUPERVISOR - Final ***********************************
	 */

}

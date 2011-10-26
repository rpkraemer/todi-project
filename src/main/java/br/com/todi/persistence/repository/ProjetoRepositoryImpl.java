package br.com.todi.persistence.repository;

import java.util.List;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.Validations;
import br.com.todi.controller.SupervisorController;
import br.com.todi.model.Projeto;
import br.com.todi.persistence.dao.ProjetoDAO;
import br.com.todi.util.Utilidades;

@Component
public class ProjetoRepositoryImpl implements ProjetoRepository {

	private Validator validator;
	private ProjetoDAO projetoDAO;
	
	public ProjetoRepositoryImpl(Validator validator, ProjetoDAO projetoDAO) {
		this.validator = validator;
		this.projetoDAO = projetoDAO;
	}

	public void salvar(final Projeto projeto) {
		validator.validate(projeto);
		validator.checking(new Validations(){{
			that(!projeto.getNome().isEmpty(), "", "projeto.nome.invalido");
			that(!projeto.getDescricao().isEmpty(), "", "projeto.descricao.invalida");
			that(!projeto.getSenha().isEmpty(), "", "projeto.senha.invalida");
		}});
		if (projeto.getID() == null)
			validator.onErrorUsePageOf(SupervisorController.class).novoProjeto();
		else
			validator.onErrorUsePageOf(SupervisorController.class).editarProjeto( projeto.getID() );
		
		//Gera o hash para a senha caso seja o cadastro inicial
		if (projeto.getID() == null)
			projeto.setSenha( Utilidades.md5(projeto.getSenha()) );
		projetoDAO.salvar(projeto);
		
	}

	public List<Projeto> listarTodos() {
		return projetoDAO.listarTodos();
	}

	public void deletar(long id) {
		projetoDAO.deletar(id);
	}

	public long totalCadastrados() {
		return projetoDAO.totalCadastrados();
	}

	public Projeto pegarPorID(long id) {
		return projetoDAO.pegarPorID(id);
	}

	@Override
	public boolean autenticarProjeto(Long idProjeto, String senha) {
		return projetoDAO.autenticarProjeto(idProjeto, Utilidades.md5(senha));
	}
}

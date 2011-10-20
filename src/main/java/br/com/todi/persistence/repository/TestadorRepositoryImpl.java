package br.com.todi.persistence.repository;

import java.util.List;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.Validations;
import br.com.todi.controller.SupervisorController;
import br.com.todi.model.Testador;
import br.com.todi.persistence.dao.TestadorDAO;
import br.com.todi.util.Utilidades;

@Component
public class TestadorRepositoryImpl implements TestadorRepository {
	
	private Validator validator;
	private TestadorDAO testadorDAO;
	
	public TestadorRepositoryImpl(Validator validator, TestadorDAO testadorDAO) {
		this.validator = validator;
		this.testadorDAO = testadorDAO;
	}

	@Override
	public void salvar(final Testador testador, Long idProjeto) {
		Long idTestador = testador.getID();
		
		validator.validate(testador);
		validator.checking(new Validations(){{
			that(!testador.getNome().isEmpty(), "", "testador.nome.invalido");
			that(!testador.getUsuario().isEmpty(), "", "testador.usuario.invalido");
		}});
		if (idTestador == null) 
			validator.onErrorUsePageOf(SupervisorController.class).novoTestador( idProjeto );
		else
			validator.onErrorUsePageOf(SupervisorController.class).
				editarTestador(idProjeto, testador.getID());
		
		//Seta a senha padrão para login no cadastro do testador
		if (testador.getID() == null) testador.setSenha( Utilidades.md5("TODI") );
		testadorDAO.salvar(testador);
	}

	@Override
	public Testador pegarPorID(long id) {
		return testadorDAO.pegarPorID(id);
	}

	@Override
	public List<Testador> listarTodos() {
		return testadorDAO.listarTodos();
	}

	@Override
	public void deletar(long id) {
		testadorDAO.deletar(id);
	}

	@Override
	public long totalCadastrados() {
		return testadorDAO.totalCadastrados();
	}

	@Override
	public void salvar(Testador obj) {
		// TODO Não utilizar
		
	}

}

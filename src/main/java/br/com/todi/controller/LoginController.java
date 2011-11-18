package br.com.todi.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.todi.persistence.repository.TestadorRepository;
import br.com.todi.session.UsuarioSession;

@Resource
public class LoginController {
	
	private Result result;
	private TestadorRepository testadorRepository;
	private UsuarioSession usuarioSession;
	
	public LoginController(Result result, UsuarioSession usuarioSession, TestadorRepository testadorRepository) {
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.testadorRepository = testadorRepository;
	}
	
	@Post
	@Path("/login")
	public void login(String usuario, String senha) {
		if (usuario.equals("SUPERVISOR") && senha.equals("TODI")) {
			usuarioSession.setUsuario(usuario);
			result.redirectTo(SupervisorController.class).home();
		} else if (testadorRepository.testadorExistente(usuario, senha)){
			usuarioSession.setUsuario(usuario);
			result.redirectTo(TestadorController.class).home();
		} else {
			result.include("erro", "Login ou senha errados! Tente novamente").
				   include("usuario", usuario);
			result.redirectTo(this).formLogin();
		}
	}
	
	@Get
	@Path("/")
	public void formLogin() { }
	
	@Get
	@Path("/logout")
	public void logout() {
		usuarioSession.matarSessao();
		result.redirectTo(this).formLogin();
	}

}

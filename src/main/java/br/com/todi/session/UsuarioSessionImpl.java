package br.com.todi.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioSessionImpl implements UsuarioSession, Serializable {

	private static final long serialVersionUID = -2304113732674652684L;
	
	private boolean supervisor;
	private Object[] usuarioInfo;
	private HttpSession httpSession;
	private List<Long> projetosAutenticados;
	
	public UsuarioSessionImpl(HttpSession httpSession) {
		this.httpSession = httpSession;
		this.supervisor = false;
		this.projetosAutenticados = new ArrayList<Long>();
	}

	@Override
	public void setUsuario(String usuario) {
		if ("SUPERVISOR".equals(usuario)) supervisor = true;
		usuarioInfo = new Object[] {usuario, supervisor};
		httpSession.setAttribute("usuarioCorrente", usuarioInfo);
	}

	@Override
	public Object[] getUsuario() {
		return (Object[]) httpSession.getAttribute("usuarioCorrente");
	}

	@Override
	public void matarSessao() {
		usuarioInfo = null;
		httpSession.invalidate();
	}

	@Override
	public void setProjetoAutenticado(Long idProjeto) {
		projetosAutenticados.add(idProjeto);
	}

	@Override
	public boolean isProjetoAutenticado(Long idProjeto) {
		return projetosAutenticados.contains(idProjeto);
	}	
}

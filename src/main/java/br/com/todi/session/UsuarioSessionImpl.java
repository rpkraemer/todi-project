package br.com.todi.session;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioSessionImpl implements UsuarioSession {

	private boolean supervisor;
	private Object[] usuarioInfo;
	private HttpSession httpSession;
	
	public UsuarioSessionImpl(HttpSession httpSession) {
		this.httpSession = httpSession;
		this.supervisor = false;
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
	
	
}

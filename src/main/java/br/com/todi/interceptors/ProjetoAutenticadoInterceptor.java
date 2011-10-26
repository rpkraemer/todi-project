package br.com.todi.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.todi.annotation.ProjetoAutenticado;
import br.com.todi.controller.PagesController;
import br.com.todi.session.UsuarioSession;

@Intercepts
public class ProjetoAutenticadoInterceptor implements Interceptor {
	
	private final Result result;
	private final UsuarioSession usuarioSession;
	private final RequestInfo requestInfo;
	
	public ProjetoAutenticadoInterceptor(Result result, UsuarioSession usuarioSession, 
										 RequestInfo requestInfo) {
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.requestInfo = requestInfo;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return method.getMethod().isAnnotationPresent(ProjetoAutenticado.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		
		if (usuarioSession != null) {
			if ((Boolean) usuarioSession.getUsuario()[1]) {
				String URI = requestInfo.getRequestedUri();
				String idProjeto = URI.substring(URI.indexOf("projetos/") + 9, URI.indexOf("/", URI.indexOf("projetos/") + 9));
				if (usuarioSession.isProjetoAutenticado(Long.parseLong(idProjeto)))
					stack.next(method, resourceInstance);
				else
					result.forwardTo(PagesController.class).acessoNegado();
			} else {
				result.forwardTo(PagesController.class).acessoNegado();
			}
		}
	}
}

package br.com.todi.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.todi.annotation.Restrito;
import br.com.todi.controller.LoginController;
import br.com.todi.session.UsuarioSession;

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Class<?> controller;
	private final Result result;
	private final UsuarioSession usuarioSession;

	public LoginInterceptor(Result result, UsuarioSession usuarioSession) {
		this.result = result;
		this.usuarioSession = usuarioSession;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		// Verifica todas as actions requisitadas menos as de Login
		if (method.getMethod().getDeclaringClass() != LoginController.class)
			return true;
		return false;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		controller = method.getMethod().getDeclaringClass();

		if (usuarioSession.getUsuario() == null)
			result.redirectTo(LoginController.class).formLogin();
		else {
			if (controller.isAnnotationPresent(Restrito.class)) {
				Restrito restrito = controller.getAnnotation(Restrito.class);
				if ("SUPERVISOR".equalsIgnoreCase(restrito.role()))
					if ((Boolean) usuarioSession.getUsuario()[1])
						stack.next(method, resourceInstance);
			} else {
				if (method.getMethod().isAnnotationPresent(Restrito.class)) {
					Restrito restrito = method.getMethod().getAnnotation(Restrito.class);
					if ("SUPERVISOR".equalsIgnoreCase(restrito.role()))
						if ((Boolean) usuarioSession.getUsuario()[1])
							stack.next(method, resourceInstance);
				} else
					stack.next(method, resourceInstance);
			}
		}
		// TODO CRIAR PAGINAS FORBIDDEN, NOT FOUND ETC
	}
}

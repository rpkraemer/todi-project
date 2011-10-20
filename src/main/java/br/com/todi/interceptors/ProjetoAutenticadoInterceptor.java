package br.com.todi.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.todi.annotation.ProjetoAutenticado;

public class ProjetoAutenticadoInterceptor implements Interceptor {

	@Override
	public boolean accepts(ResourceMethod method) {
		return method.getMethod().isAnnotationPresent(ProjetoAutenticado.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		
		
		
	}

}

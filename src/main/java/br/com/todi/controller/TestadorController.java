package br.com.todi.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.todi.annotation.Restrito;

@Resource
@Restrito(role = "testador")
public class TestadorController {

	private Result result;
	
	public TestadorController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/testador")
	public void home() {
		
	}
	
}

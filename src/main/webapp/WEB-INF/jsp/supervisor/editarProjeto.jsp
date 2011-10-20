<div class="page-header">
	<h2> Editar Projeto </h2>
</div>

<div class="container">
	<div class="hero-unit" style="padding:6px; margin-top:0px">
		<a href="<c:url value="/supervisor"/>">
			<div class="btn primary medium" id="voltar" style="margin-right: 10px">Voltar</div> 
		</a>
		<a href="<c:url value="/supervisor/projetos/${projeto.ID}/testadores"/>">
			<div class="btn primary medium" id="testadores" style="margin-right:10px">Testadores</div> 
		</a>
		<a href="<c:url value="/supervisor/projetos/${projeto.ID}/informacao-repositorio-odi"/>">
			<div class="btn primary medium" id="testadores" style="margin-right:10px">Repositório ODI</div> 
		</a>
		<a onclick="return confirm('Deseja excluir ${projeto.nome}?')" 
		   href="<c:url value="/supervisor/projetos/${projeto.ID}/deletar"/>">
			<div class="btn danger medium" id="novoProjeto" style="float:right">Excluir Projeto</div> 
		</a>
	</div>
</div>

<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<form action="<c:url value="/supervisor/projetos"/>" method="post">
	<fieldset>
		<input type="hidden" name="projeto.ID" value="${projeto.ID}"/>
		<input type="hidden" name="projeto.senha" value="${projeto.senha}"/>
		
		<div class="clearfix">
	    	<label for="projeto.nome"> Nome </label>
	      	<div class="input">
	        	<input class="xmedium" id="projeto.nome" name="projeto.nome" type="text" value="${projeto.nome}"/>
	      	</div>
	    </div>
	  	<div class="clearfix">
	        <label for="projeto.descricao"> Descrição </label>
	        <div class="input">
	        	<textarea class="xxlarge" id="projeto.descricao" name="projeto.descricao">${projeto.descricao}</textarea>
	          	<span class="help-block">
	            	Digite aqui uma breve descrição do projeto.
	          	</span>
	        </div>
		</div>
	</fieldset>
	<div class="actions">
		<input type="submit" class="btn primary" value="Salvar Alterações"> &nbsp; 
		<button type="reset" class="btn"> Limpar </button> &nbsp;
		<a href="<c:url value="/supervisor"/>">
			<button type="button" class="btn"> Cancelar </button>
		</a>
	</div>
</form>
<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<div class="page-header">
	<h2> Novo Projeto </h2>
</div>

<form action="<c:url value="/supervisor/projetos"/>" method="post">
	<fieldset>
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
		<div class="clearfix">
	    	<label for="projeto.senha"> Senha </label>
	      	<div class="input">
	        	<input class="xmedium" id="projeto.senha" name="projeto.senha" type="password"/>
	      	</div>
	    </div>
	</fieldset>
	<div class="actions">
		<input type="submit" class="btn primary" value="Criar Projeto"> &nbsp; 
		<button type="reset" class="btn"> Limpar </button> &nbsp;
		<a href="<c:url value="/supervisor"/>">
			<button type="button" class="btn"> Cancelar </button>
		</a>
	</div>
</form>
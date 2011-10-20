<div class="page-header">
	<h2> Editar Testador </h2>
</div>

<div class="container">
	<div class="hero-unit" style="padding:6px; margin-top:0px">
		<a href="<c:url value="/supervisor/projetos/${testador.projeto.ID}/testadores"/>">
			<div class="btn primary medium" id="voltar" style="margin-right: 10px">Voltar</div> 
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

<form action="<c:url value="/supervisor/projetos/${testador.projeto.ID}/testadores/salvar"/>" method="post">
	<fieldset>
		<input type="hidden" name="testador.projeto.ID" value="${testador.projeto.ID}" />
		<input type="hidden" name="testador.ID" value="${testador.ID}" />
		<input type="hidden" name="testador.senha" value="${testador.senha}" />
		<div class="clearfix">
			<label for="testador.nome"> Nome </label>
			<div class="input">
				<input class="xmedium" id="testador.nome" name="testador.nome"
					type="text" value="${testador.nome}" />
			</div>
		</div>
		<div class="clearfix">
			<label for="testador.nome"> Usuário </label>
			<div class="input">
				<input class="xmedium" id="testador.usuario" name="testador.usuario"
					type="text" value="${testador.usuario}" />
			</div>
		</div>
	</fieldset>
	<div class="actions">
		<input type="submit" class="btn primary" value="Salvar Alterações">
		&nbsp;
		<button type="reset" class="btn">Limpar</button>
		&nbsp;
		<a href="<c:url value="/supervisor/projetos/${testador.projeto.ID}/testadores"/>">
			<button type="button" class="btn"> Voltar </button>
		</a>
	</div>
</form>
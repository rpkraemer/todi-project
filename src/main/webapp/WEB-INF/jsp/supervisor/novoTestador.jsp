<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<div class="page-header">
	<h2>Novo Testador</h2>
</div>

<form id="formTestadorAdd"
	action="<c:url value="/supervisor/projetos/${idProjeto}/testadores/salvar"/>"
	method="post">
	<fieldset>
	<input type="hidden" name="testador.projeto.ID" value="${idProjeto}" />
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
		<input type="submit" class="btn primary" value="Cadastrar Testador">
		&nbsp;
		<button type="reset" class="btn">Limpar</button>
		&nbsp;
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/testadores"/>">
			<button type="button" class="btn"> Voltar </button>
		</a>
	</div>
</form>
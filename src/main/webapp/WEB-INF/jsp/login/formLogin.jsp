<div id="login_container">

	<div class="page-header">
		<h2> Login </h2>
	</div>
	
	<c:if test="${erro != null}">
		<div class="alert-message error">
			${erro}
		</div>
	</c:if>
	
	<form action="<c:url value="/login"/>" method="post">
		<fieldset>
			<div class="clearfix">
				<label for="usuario"> Usuário </label>
				<div class="input">
					<input class="xmedium" id="usuario" name="usuario" type="text" value="${usuario}" />
				</div>
			</div>
			<div class="clearfix">
				<label for="usuario"> Senha </label>
				<div class="input">
					<input class="xmedium" id="senha" name="senha" type="password" />
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<input type="submit" class="btn primary" value="Logar">
			&nbsp;
			<button type="reset" class="btn">Limpar</button>
		</div>
	</form>
</div>
<script>
	$(function() {
		$('#troca').change(function() {
			var tipoSenha = $(this).find('option:selected').val();
			$('#tipoSenha').attr('value', tipoSenha);
		});
	});
</script>

<div class="page-header">
	<h2>Informações do Repositório do Oracle Data Integrator</h2>
</div>

<div class="clearfix">
	<label for="usuario">Trocar a senha do</label>
	<div class="input">
		<select name="troca" id="troca">
			<option value="DB" selected="selected">Usuário de Banco</option>
			<option value="ODI">Usuário do Oracle Data Integrator</option>
		</select>
	</div>
</div>

<hr/>

<p> <h3>Troca de Senhas</h3> </p>

<c:if test="${status != null}">
	<c:set var="sucesso" value="sucesso"/>
	<c:if test="${fn:contains(status, sucesso)}"> 
		<div class="alert-message success">
			${status}
		</div>
	</c:if>
	<c:if test="${!fn:contains(status, sucesso)}"> 
		<div class="alert-message error">
			${status}
		</div>
	</c:if>
</c:if>

<form id="formTrocaSenha" 
	action="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi/trocar-senha"/>" 
	method="post"">
	
	<input type="hidden" name="idRepoInfo" id="idRepoInfo" value="${idRepoInfo}"/>
	<input type="hidden" name="tipoSenha" id="tipoSenha" value="DB"/>
	<div class="clearfix">
        <label for="senhaAtual"> Senha atual </label>
        <div class="input">
        	<input class="xmedium" name="senhaAtual" type="password"/>
        	<span class="help-block">
            	Por favor, informe a senha atual do projeto.
          	</span>
        </div>
	</div>
	<div class="clearfix">
        <label for="novaSenha"> Nova senha </label>
        <div class="input">
        	<input class="xmedium" name="novaSenha" type="password"/>
        </div>
	</div>
	
	<div class="actions">
		<input type="submit" class="btn primary" value="Trocar Senha"> &nbsp; 
		<button type="reset" class="btn"> Limpar </button> &nbsp;
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi"/>">
			<button type="button" class="btn"> Cancelar </button>
		</a>
	</div>
</form>
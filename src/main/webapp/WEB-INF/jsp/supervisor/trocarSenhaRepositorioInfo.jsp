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

<div class="container">
	<div class="hero-unit" style="padding:6px; margin-top:0px">
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi"/>">
			<div class="btn primary medium" id="voltar" style="margin-right: 10px">Voltar</div> 
		</a>
	</div>
</div>

<div class="clearfix">
	<label for="usuario">Trocar a senha do</label>
	<div class="input">
		<select name="troca" id="troca" style="width:290px">
			<option value="DB_M" selected="selected">Usuário de Banco - Master</option>
			<option value="DB_W">Usuário de Banco - Work</option>
			<option value="ODI">Usuário do Oracle Data Integrator - Master</option>
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
	<input type="hidden" name="tipoSenha" id="tipoSenha" value="DB_M"/>
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
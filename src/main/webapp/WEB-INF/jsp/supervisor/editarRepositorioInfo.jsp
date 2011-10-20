<div class="container">
	<div class="hero-unit" style="padding:6px; margin-top:0px">
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/editar"/>">
			<div class="btn primary medium" id="voltar" style="margin-right: 10px">Voltar</div> 
		</a>
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi/${repositorioInfo.ID}/trocar-senha"/>">
			<div class="btn primary medium" id="voltar" style="margin-right: 10px">Trocar Senhas do Projeto ODI</div> 
		</a>
		<a onclick="return confirm('Deseja excluir o projeto ODI ${projeto.nome}?')" 
		   href="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi/excluir/${repositorioInfo.ID}"/>">
			<div class="btn danger medium" id="novoProjeto" style="float:right">Excluir informações do Projeto ODI</div> 
		</a>
	</div>
</div>
<form action="<c:url value="/supervisor/projetos/salvar/informacao-projeto-odi"/>" method="post">
	<fieldset>
		<input type="hidden" name="idProjeto" value="${idProjeto}"/>
		<input type="hidden" name="repoInfo.ID" value="${repositorioInfo.ID}"/>
		<input type="hidden" name="repoInfo.loginPass" value="${repositorioInfo.loginPass}"/>
		<input type="hidden" name="repoInfo.loginDBPass" value="${repositorioInfo.loginDBPass}"/>
		
		<div class="clearfix">
	    	<label for="repoInfo.loginName"> Projeto ODI </label>
	      	<div class="input">
	        	<input class="xmedium" id="repoInfo.loginName" name="repoInfo.loginName" type="text" value="${repositorioInfo.loginName}"/>
	      	</div>
	    </div>
	  	<div class="clearfix">
	        <label for="repoInfo.loginUser"> Usuário ODI para conexão </label>
	        <div class="input">
	        	<input class="xmedium" id="repoInfo.loginUser" name="repoInfo.loginUser" type="text" value="${repositorioInfo.loginUser}"/>
	        </div>
		</div>
		<div class="clearfix">
	        <label for="repoInfo.loginDBUser"> Usuário ODI do Banco de Dados </label>
	        <div class="input">
	        	<input class="xmedium" id="repoInfo.loginDBUser" name="repoInfo.loginDBUser" type="text" value="${repositorioInfo.loginDBUser}"/>
	        </div>
		</div>
		<div class="clearfix">
	        <label for="repoInfo.loginDBDriver"> Driver JDBC utilizado para conexão ao ODI </label>
	        <div class="input">
	        	<input class="xmedium" id="repoInfo.loginDBDriver" name="repoInfo.loginDBDriver" type="text" value="${repositorioInfo.loginDBDriver}"/>
	        </div>
		</div>
		<div class="clearfix">
	        <label for="repoInfo.loginDBURL"> URL de conexão ao ODI </label>
	        <div class="input">
	        	<input class="xmedium" id="repoInfo.loginDBURL" name="repoInfo.loginDBURL" type="text" value="${repositorioInfo.loginDBURL}"/>
	        </div>
		</div>
		<div class="clearfix">
	        <label for="repoInfo.loginWorkRepository"> Work Repository do ODI </label>
	        <div class="input">
	        	<input class="xmedium" id="repoInfo.loginWorkRepository" name="repoInfo.loginWorkRepository" type="text" value="${repositorioInfo.loginWorkRepository}"/>
	        </div>
		</div>
	</fieldset>
	<div class="actions">
		<input type="submit" class="btn primary" value="Salvar Alterações"> &nbsp; 
		<button type="reset" class="btn"> Limpar </button> &nbsp;
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/editar"/>">
			<button type="button" class="btn"> Cancelar </button>
		</a>
	</div>
</form>
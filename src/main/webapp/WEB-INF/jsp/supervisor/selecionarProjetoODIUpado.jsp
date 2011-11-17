<div class="page-header">
	<h3>Por favor, selecione o seu projeto na lista abaixo.</h3>
</div>

<c:forEach items="${projetosODI}" var="projeto">
	<form action="<c:url value="/supervisor/projetos/salvar/informacao-projeto-odi"/>" method="post">
		<input type="hidden" name="idProjeto" value="${idProjeto}" />
		<input type="hidden" name="repoInfo.loginName" value="${projeto.loginName}" />
		<input type="hidden" name="repoInfo.loginUser" value="${projeto.loginUser}" />
		<input type="hidden" name="repoInfo.loginDBUser" value="${projeto.loginDBUser}" />
		<input type="hidden" name="repoInfo.loginDBDriver" value="${projeto.loginDBDriver}" />
		<input type="hidden" name="repoInfo.loginDBURL" value="${projeto.loginDBURL}" />
		<input type="hidden" name="repoInfo.loginWorkRepository" value="${projeto.loginWorkRepository}" />
		
		<div class="well">
			<h3> ${projeto.loginName} </h3> <br/>
			
			<table>
				<tr> 
					<td> <strong>Login do usuário (ODI):</strong> </td> 
					<td> ${projeto.loginUser} </td>
				</tr>
				<tr>
					<td> <strong>Senha - Repositório ODI:</strong> </td>
					<td> <input class="span3" id="repoInfo.loginPass" name="repoInfo.loginPass" type="password" placeholder="Preencha a senha"> </td>
				</tr>
				<tr>
					<td> <strong>Login do usuário de Banco de Dados:</strong> </td> 
					<td> ${projeto.loginDBUser} </td>
				</tr>
				<tr>
					<td> <strong>Senha - Usuário de banco do Repositório ODI:</strong> </td>
					<td> <input class="span3" id="repoInfo.loginBDPass" name="repoInfo.loginDBPass" type="password" placeholder="Preencha a senha"> </td>
				</tr>
				<tr>
					<td> <strong>Driver JDBC utilizado para conexão:</strong> </td>
					<td> ${projeto.loginDBDriver} </td>
				</tr>
				<tr>
					<td> <strong>URL de conexão ao Banco de Dados do Repositório ODI:</strong> </td> 
					<td> ${projeto.loginDBURL} </td>
				</tr>
				<tr>
					<td> <strong>Nome do Repositório ODI (Work):</strong> </td> 
					<td> ${projeto.loginWorkRepository} </td>
				</tr>
				<tr>
					<td> <strong>Login do usuário de Banco de Dados do Repositório ODI (Work):</strong> </td> 
					<td> <input class="span3" id="repoInfo.loginWorkUser" name="repoInfo.loginWorkUser" type="text" placeholder="Preencha o usuário"> </td>
				</tr>
				<tr>
					<td> <strong>Senha - Usuário de Banco de Dados do Repositório ODI (Work):</strong> </td> 
					<td> <input class="span3" id="repoInfo.loginWorkPass" name="repoInfo.loginWorkPass" type="password" placeholder="Preencha a senha"> </td>
				</tr>
				<tr>
					<td colspan="2"> 
						<input type="submit" class="btn success" value="Utilizar este Projeto">
					</td>
				</tr>
			</table>
		</div>
	</form>
</c:forEach>
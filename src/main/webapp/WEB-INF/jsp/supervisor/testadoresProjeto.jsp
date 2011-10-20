<div class="page-header">
	<h2>Testadores do Projeto</h2>
</div>

<div class="container">
	<div class="hero-unit" style="padding: 6px; margin-top: 0px">
		<a href="<c:url value="/supervisor/projetos/${projeto.ID}/editar"/>">
			<div class="btn primary medium" id="voltar"
				style="margin-right: 10px">
				Voltar
			</div> 
		</a>
		<a href="<c:url value="/supervisor/projetos/${projeto.ID}/testadores/novo"/>">
			<div class="btn primary medium" id="novoTestador"
				style="margin-right: 10px">
				Novo Testador
			</div> 
		</a>
	</div>
</div>

<c:if test="${empty projeto.testadores}">
	<div class="alert-message warning">Não há testadores cadastrados.</div>
</c:if>

<c:if test="${!empty projeto.testadores}">
	<table id="listaTestadores" class="zebra-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Usuário</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projeto.testadores}" var="testador">
				<tr>
					<td>${testador.ID}</td>
					<td>${testador.nome}</td>
					<td>${testador.usuario}</td>
					<td align="center">
						<a href="<c:url value="/supervisor/projetos/${testador.projeto.ID}/testadores/editar/${testador.ID}"/>">
							<img alt="Editar" src="<c:url value="/img/editar.png"/>" border="0">
						</a>
					</td>
					<td align="center">
						<a onclick="return confirm('Deseja desvincular o testador ${testador.nome}?')" 
						   href="<c:url value="/supervisor/projetos/${projeto.ID}/testadores/deletar/${testador.ID}"/>">
							<img alt="Desvincular" src="<c:url value="/img/excluir.png"/>" border="0">
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<div class="page-header">
	<h2> Projetos </h2>
</div>

<c:if test="${empty projetoList}">
	<div class="alert-message warning"> 
		Não há projetos cadastrados. 
	</div>
</c:if>

<c:if test="${!empty projetoList}">
   <table class="zebra-striped">
			<thead>
				<tr>
					<th> ID </th>
					<th> Nome </th>
					<th> Editar </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projetoList}" var="projeto"> 
					<tr>
						<td> ${projeto.ID} </td>
						<td> ${projeto.nome} </td>
						<td align="center">
							<a href="<c:url value="/supervisor/projetos/editar/${projeto.ID}"/>">
								<img alt="Editar" src="<c:url value="/img/editar.png"/>" border="0">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</c:if>
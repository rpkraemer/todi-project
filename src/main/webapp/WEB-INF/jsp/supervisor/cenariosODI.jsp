<div class="page-header">
	<h2>Cenários do Oracle Data Integrator</h2>
</div>

<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<div class="container">
	<div class="hero-unit" style="padding: 6px; margin-top: 0px">
		<a href="<c:url value="/supervisor/projetos/${idProjeto}/editar"/>">
			<div class="btn primary medium" id="voltar"
				style="margin-right: 10px">
				Voltar
			</div> 
		</a>
		<c:if test="${empty cenariosODI}">
			<a href="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi/buscar-cenarios"/>" 
			   class="btn success"> BUSCAR CENÁRIOS ODI </a>
		</c:if>
		<c:if test="${!empty cenariosODI}">
			<button class="btn success" id="importarCenarios"> IMPORTAR CENÁRIOS ODI </button>
		</c:if>
	</div>
</div>
  
<script>
$(document).ready(function() {
	$('#marcarTodos').click(function() {
		var chkMarcarTodos = $(this);
		var chks = $('#formCenarios input:checkbox');
		if (chkMarcarTodos.is(':checked')) chks.attr('checked', 'checked');
		else chks.removeAttr('checked');
	});

	$('#marcarNovos').click(function() {
		var chkMarcarNovos = $(this);
		var chks = $('.cenarios.novo input:checkbox');
		if (chkMarcarNovos.is(':checked')) chks.attr('checked', 'checked');
		else chks.removeAttr('checked');
	});

	$('#marcarExistentes').click(function() {
		var chkMarcarExistentes = $(this);
		var chks = $('.cenarios.existente input:checkbox');
		if (chkMarcarExistentes.is(':checked')) chks.attr('checked', 'checked');
		else chks.removeAttr('checked');
	});
	
	$('#importarCenarios').click(function() {
		$('#formCenarios').submit();
	});
});
</script>

<c:if test="${!empty cenariosODI}">
	<fieldset>
		<div class="clearfix">
			<div class="input">
				<span> Selecionar Todos </span>
				<input type="checkbox" id="marcarTodos" class="checkbox_cenarios"/>
			
				<span> Selecionar Novos </span>
				<input type="checkbox" id="marcarNovos" class="checkbox_cenarios"/>
			
				<span> Selecionar Existentes </span>
				<input type="checkbox" id="marcarExistentes" class="checkbox_cenarios"/>
			</div>
		</div>
	</fieldset>
</c:if>

<c:if test="${!empty cenariosODI}">
	<form id="formCenarios" 
		action="<c:url value="/supervisor/projetos/${idProjeto}/informacao-repositorio-odi/importar-cenarios"/>"
		method="post">
		<c:forEach var="cenario" items="${cenariosODI}" varStatus="current">
			<div class="cenarios novo">
				<input type="checkbox" name="cenariosODI[${current.index}]" value="${cenario.nome}%${cenario.idODI}%${cenario.versaoAtual}" class="checkbox_maior"/>
				<span> ${cenario.nome} (${cenario.idODI}) </span>
				<span style="float:right"> 
					Versão ${cenario.versaoAtual} 
				</span>
			</div>
			<br/>
		</c:forEach>
	</form>		
</c:if>

<c:if test="${empty cenariosExistentes and empty cenariosODI}">
	<div class="alert-message warning">Não há cenarios ODI importados.</div>
</c:if>

<c:if test="${!empty cenariosExistentes}">
	<div class="container">
	<table id="listaCenariosExistentes" class="zebra-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>ID no Oracle Data Integrator</th>
				<th>Nome</th>
				<th>Versão Atual</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cenariosExistentes}" var="cenario">
				<tr>
					<td>${cenario.ID}</td>
					<td>${cenario.idODI}</td>
					<td>${cenario.nome}</td>
					<td>${cenario.versaoAtual}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
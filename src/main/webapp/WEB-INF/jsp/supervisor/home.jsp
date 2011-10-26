<script>
		function setarIdProjeto(idProjeto) {
			$('#idProjeto').val(idProjeto);
		}
</script>

<div id="autenticarProjeto" class="modal hide fade">
	<div class="modal-header">
    	<a href="#" class="close">&times;</a>
    	<h3>Autenticar Projeto</h3>
  	</div>
  	<form action="<c:url value="/supervisor/projetos/autenticar"/>" method="post">
	  	<div class="modal-body">
	    	<div class="clearfix">
		    	<label for="senha"> Senha do projeto </label>
		      	<div class="input">
		      		<input type="hidden" id="idProjeto" name="idProjeto"/>
		        	<input class="xmedium" id="senha" name="senha" type="password"/>
		      	</div>
		    </div>
	  	</div>
	  	<div class="modal-footer">
	    	<input type="submit" class="btn primary" value="Autenticar Projeto">
	  	</div>
  	</form>
</div>


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
							<c:if test="${projeto.isAutenticadoUserSession eq false}"> 
								<a  data-controls-modal="autenticarProjeto" onclick="javascript: setarIdProjeto(${projeto.ID});"
								 	data-backdrop="static" 
								 	data-keyboard="true" 
								 	href="<c:url value="/supervisor/projetos/${projeto.ID}/editar"/>">
									<img alt="Editar" src="<c:url value="/img/editar.png"/>" border="0">
								</a>
							</c:if>
							<c:if test="${projeto.isAutenticadoUserSession eq true}">
								<a  href="<c:url value="/supervisor/projetos/${projeto.ID}/editar"/>">
									<img alt="Editar" src="<c:url value="/img/editar.png"/>" border="0">
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</c:if>
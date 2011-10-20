<div class="page-header">
	<h2>Informações do Repositório do Oracle Data Integrator</h2>
</div>

<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<!-- CASO EXISTA UM REPOSITÓRIO CADASTRADO PARA O PROJETO, MOSTRA TELA PARA EDIÇÃO -->
<c:if test="${repositorioInfo != null}">
	<%@ include file="editarRepositorioInfo.jsp" %>
</c:if>

<!-- CASO NÃO EXISTA UM REPOSITÓRIO CADASTRADO PARA O PROJETO, EXECUTA ESTAS TELAS -->
<c:if test="${repositorioInfo == null}">
	
	<!-- REALIZA INCLUDE DO FORMULÁRIO DE UPLOAD DO PROJETO ODI -->
	<c:if test="${empty projetosODI}">
		<%@ include file="uploadArquivoXML.jsp" %>
	</c:if>
	
	<c:if test="${!empty projetosODI}">
		<%@ include file="selecionarProjetoODIUpado.jsp" %>
	</c:if>
</c:if>
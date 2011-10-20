<div class="page-header">
	<h2>Informa��es do Reposit�rio do Oracle Data Integrator</h2>
</div>

<c:if test="${!empty errors}">
	<div class="alert-message error">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message} <br/>
		</c:forEach>
	</div>
</c:if>

<!-- CASO EXISTA UM REPOSIT�RIO CADASTRADO PARA O PROJETO, MOSTRA TELA PARA EDI��O -->
<c:if test="${repositorioInfo != null}">
	<%@ include file="editarRepositorioInfo.jsp" %>
</c:if>

<!-- CASO N�O EXISTA UM REPOSIT�RIO CADASTRADO PARA O PROJETO, EXECUTA ESTAS TELAS -->
<c:if test="${repositorioInfo == null}">
	
	<!-- REALIZA INCLUDE DO FORMUL�RIO DE UPLOAD DO PROJETO ODI -->
	<c:if test="${empty projetosODI}">
		<%@ include file="uploadArquivoXML.jsp" %>
	</c:if>
	
	<c:if test="${!empty projetosODI}">
		<%@ include file="selecionarProjetoODIUpado.jsp" %>
	</c:if>
</c:if>
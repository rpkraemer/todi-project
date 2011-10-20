<form enctype="multipart/form-data"
	action="<c:url value="/supervisor/projetos/upload/odi-xml"/>"
	method="post">
	<fieldset>
		<input type="hidden" name="idProjeto" value="${idProjeto}" />

		<div class="clearfix">
			<label for="xml"> Arquivo </label>
			<div class="input">
				<input class="input-file" id="xml" name="xml" type="file"> <span
					class="help-block"> Por favor, faça upload do arquivo <strong>SNPS_LOGIN_WORK</strong>
					da instalação do ODI. </span>
			</div>
		</div>
	</fieldset>
	<div class="actions">
		<input type="submit" class="btn primary" value="Enviar">
		&nbsp;
		<button type="reset" class="btn">Limpar</button>
		&nbsp; <a href="<c:url value="/supervisor/projetos/${idProjeto}/editar"/>">
			<button type="button" class="btn">Cancelar</button> </a>
	</div>
</form>
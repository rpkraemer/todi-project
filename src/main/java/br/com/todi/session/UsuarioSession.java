package br.com.todi.session;

import java.util.List;

public interface UsuarioSession {
	public void setUsuario(String usuario);
	public Object[] getUsuario();
	public void setProjetoAutenticado(Long idProjeto);
	public boolean isProjetoAutenticado(Long idProjeto);
	public void matarSessao();
}

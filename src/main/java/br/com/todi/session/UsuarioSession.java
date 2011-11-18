package br.com.todi.session;


public interface UsuarioSession {
	public void setUsuario(String usuario);
	public Object[] getUsuario();
	public void setProjetoAutenticado(Long idProjeto);
	public boolean isProjetoAutenticado(Long idProjeto);
	public void matarSessao();
}

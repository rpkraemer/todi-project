package br.com.todi.session;

public interface UsuarioSession {
	public void setUsuario(String usuario);
	public Object[] getUsuario();
	public void matarSessao();
}

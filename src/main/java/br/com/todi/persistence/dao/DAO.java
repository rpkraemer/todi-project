package br.com.todi.persistence.dao;

import java.util.List;

public interface DAO<T> {

	public void salvar(T obj);
	public T pegarPorID(long id);
	public List<T> listarTodos();
	public void deletar(long id);
	public long totalCadastrados();
	
}

package br.com.todi.persistence.repository;

import java.util.List;

public interface Repository<T> {
	
	public void salvar(final T obj);
	public T pegarPorID(long id);
	public List<T> listarTodos();
	public void deletar(long id);
	public long totalCadastrados();

}

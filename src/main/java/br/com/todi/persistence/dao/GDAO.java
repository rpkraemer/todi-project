package br.com.todi.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public class GDAO<T> {
	
	private Session session;
	private Class<? extends Object> objClass;
	
	public GDAO(Session session) {
		this.session = session;
		this.objClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(T obj) {
		this.session.saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	public T pegarPorID(long id) {
		return (T) this.session.get(objClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listarTodos() {
		return this.session.createCriteria(objClass).list();
	}

	public void deletar(long id) {
		T obj = _load(id);
		this.session.delete(obj);
	}

	@SuppressWarnings("unchecked")
	private T _load(long id) {
		return (T) this.session.load(objClass, id);
	}

	public long totalCadastrados() {
		return (Long) this.session.createCriteria(objClass)
		.setProjection(Projections.rowCount()).uniqueResult();
	}

}

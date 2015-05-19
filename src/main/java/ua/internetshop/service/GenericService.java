package ua.internetshop.service;

import java.util.List;

public interface GenericService<PK, T> {
	void add(T entity);

	List<T> getAll();

	T findById(PK id);

	T saveOrUpdate(T entity);

	void delete(T entity);

	void refresh(T entity);
}

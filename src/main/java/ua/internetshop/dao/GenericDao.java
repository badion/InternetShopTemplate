package ua.internetshop.dao;

import java.util.List;

public interface GenericDao<PK, M> {
	void add(M entity);

	List<M> getAll();

	M findById(PK id);

	M saveOrUpdate(M entity);

	void delete(M entity);

	void refresh(M entity);
}

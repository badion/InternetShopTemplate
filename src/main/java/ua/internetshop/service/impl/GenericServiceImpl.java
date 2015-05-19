package ua.internetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.internetshop.dao.GenericDao;
import ua.internetshop.service.GenericService;

@Service
public class GenericServiceImpl<PK, T> implements GenericService<PK, T> {

	@Autowired
	@Qualifier("genericDaoImpl")
	private GenericDao<PK, T> genericDao;

	public GenericServiceImpl() {
	}

	public void setGenericDao(GenericDao<PK, T> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericDao<PK, T> getGenericDao() {
		return this.genericDao;
	}

	@Override
	public List<T> getAll() {
		return genericDao.getAll();
	}

	@Override
	public void add(T entity) {
		genericDao.add(entity);
	}

	@Override
	public T findById(PK id) {
		return genericDao.findById(id);
	}

	@Override
	public T saveOrUpdate(T entity) {
		if (entity != null) {
			entity = genericDao.saveOrUpdate(entity);
		}
		return entity;
	}

	@Override
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	@Override
	public void refresh(T entity) {
		genericDao.refresh(entity);
	}
}
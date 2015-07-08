package ua.internetshop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.internetshop.dao.CategoryDao;
import ua.internetshop.model.Category;
import ua.internetshop.service.CategoryManager;

@Service
public class CategoryManagerImpl implements CategoryManager {

	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public void add(Category category) {
		System.out.println(category.getId() + " " + category.getName());
		categoryDao.add(category);
	}

	public List<Category> getAllCategory() {
		return categoryDao.getAllCategory();
	}

	public Category getCategoryById(Long id) {
		return categoryDao.getCategoryById(id);
	}

	@Transactional
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Transactional
	public Category saveOrUpdate(Category category) {
		return categoryDao.saveOrUpdate(category);
	}

}

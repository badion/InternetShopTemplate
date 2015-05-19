package ua.internetshop.service;

import java.util.List;

import ua.internetshop.model.Category;

public interface CategoryManager {

	Category saveOrUpdate(Category category);

	void add(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(Long id);

	void delete(Category id);
	
}

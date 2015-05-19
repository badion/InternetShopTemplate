package ua.internetshop.dao;

import java.util.List;

import ua.internetshop.model.Category;

public interface CategoryDao {

	void add(Category category);

	Category saveOrUpdate(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(Long id);

	void delete(Category category);

}

package ua.internetshop.rest.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.internetshop.exceptions.AbsentCategories;
import ua.internetshop.exceptions.CategoryInDatabaseIsEmpty;
import ua.internetshop.model.Category;
import ua.internetshop.repository.CategoryRepository;

@RestController
@RequestMapping(value = CategoryControllerRest.REST)
public class CategoryControllerRest {

	static final String REST = "/rest";

	private static final String ID = "id";

	private static final String CATEGORY = "/category";

	private static final String CATEGORY_ID = "/category/{id}";

	private static final String CATEGORY_DELETE_ID = "/category/delete/{id}";

	private static final String ACCEPT_APPLICATION_JSON = "accept=application/json";

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = CATEGORY, method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
	public @ResponseBody List<Category> getAllCategories() {
		List<Category> categories = (List<Category>) categoryRepository
				.findAll();
		Hibernate.initialize(categories);
		if (categories.isEmpty())
			throw new AbsentCategories();
		return categories;
	}

	@RequestMapping(value = CATEGORY_ID, method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
	public @ResponseBody Category getCategoryById(@PathVariable(ID) Long id) {
		Category category = categoryRepository.findOne(id);
		if (category == null)
			throw new CategoryInDatabaseIsEmpty(id);
		return category;
	}

	@RequestMapping(value = CATEGORY_DELETE_ID, method = RequestMethod.DELETE)
	public void delete(@PathVariable(ID) Long categoryId) {
		Category category = categoryRepository.findOne(categoryId);
		if (category == null)
			throw new CategoryInDatabaseIsEmpty(categoryId);
		categoryRepository.delete(category);
	}

}

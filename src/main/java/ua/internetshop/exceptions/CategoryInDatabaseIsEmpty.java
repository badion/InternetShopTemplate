package ua.internetshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = CategoryInDatabaseIsEmpty.THIS_CATEGORY_IS_NOT_FOUND_IN_DATABASE)
public class CategoryInDatabaseIsEmpty extends RuntimeException {

	static final String THIS_CATEGORY_IS_NOT_FOUND_IN_DATABASE = "This category is not found in database";

	private static final String NOT_FOUND_IN_DATABASE = " of category is not found in database";

	private static final long serialVersionUID = 1L;

	public CategoryInDatabaseIsEmpty(Long id) {
		System.out.println(id + NOT_FOUND_IN_DATABASE);
	}
}

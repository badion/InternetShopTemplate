package ua.internetshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = AbsentCategories.CATEGORY_IS_ABSENT_IN_DATABASE)
public class AbsentCategories extends RuntimeException {

	static final String CATEGORY_IS_ABSENT_IN_DATABASE = "Category is absent in database";

	private static final long serialVersionUID = 1L;

}

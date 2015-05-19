package ua.internetshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = GoodInDatabaseIsEmpty.THIS_GOOD_IS_NOT_FOUND_IN_DATABASE)
public class GoodInDatabaseIsEmpty extends RuntimeException {

	private static final String NOT_FOUND_IN_DATABASE = " of good is not found in database";

	static final String THIS_GOOD_IS_NOT_FOUND_IN_DATABASE = "This good is not found in database";

	private static final long serialVersionUID = 1L;

	public GoodInDatabaseIsEmpty(Long id) {
		System.out.println(id + NOT_FOUND_IN_DATABASE);
	}

}

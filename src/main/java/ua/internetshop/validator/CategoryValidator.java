package ua.internetshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.internetshop.model.Category;

@Component
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Category.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"name.required");
	}

}

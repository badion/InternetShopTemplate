package ua.internetshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.internetshop.model.Good;

@Component
public class GoodValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Good.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"good.name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity",
				"good.quantity.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price",
				"good.price.required");
	}
}

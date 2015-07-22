package ua.internetshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuantityValidator implements ConstraintValidator<Quantity, String> {

	@Override
	public void initialize(Quantity constraintAnnotation) {

	}

	@Override
	public boolean isValid(String quantity, ConstraintValidatorContext context) {
		if (quantity == null) {
			return false;
		} else if (quantity.matches("\\d{5}"))
			return true;
		else
			return false;
	}

}

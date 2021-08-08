package org.zk.spring.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AcceptValuesValidator implements ConstraintValidator<AcceptValues, String> {

	private List<String> acceptValues;

	@Override
	public void initialize(AcceptValues constraintAnnotation) {
		acceptValues = Arrays.asList(constraintAnnotation.acceptValues());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!StringUtils.hasText(value)) {
			return true;
		}
		return acceptValues.contains(value);
	}
}

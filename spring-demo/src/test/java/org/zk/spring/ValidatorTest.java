package org.zk.spring;

import org.hibernate.validator.constraints.NotBlank;
import org.junit.Test;
import org.zk.spring.validator.AcceptValues;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorTest {

	static class ValidatorDemo {
		@NotBlank(message = "用户名不能为空")
		private String username;

		@Size(max = 2, message = "产品名称长度大于2")
		@NotBlank(message = "产品名称不能为空")
		private String productName;

		@Pattern(regexp = "^([1-9]\\d{0,8}|0)(\\.\\d{1,2})?$", message = "amount金额不合法")
		private String amount;

		@Digits(integer = 5, fraction = 2, message = "amount2金额错误")
		private String amount2;

		@AcceptValues(message = "单位不合法", acceptValues = {"个", "箱"})
		private String unit;

	}

	@Test
	public void test1() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		ValidatorDemo demo = new ValidatorDemo();
		demo.username = "ss";
		demo.productName = "aa";
		demo.amount = "1";
		demo.amount2 = "1234.12";
		demo.unit = "个";
		Set<ConstraintViolation<Object>> result = validator.validate(demo);
		String str = result.stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining("；"));
		System.out.println(str);
	}
}

package com.emts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.emts.model.PopUp;

@Component
public class PopUpValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return PopUp.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message",
		"error.message.empty");
		*/
	}


}

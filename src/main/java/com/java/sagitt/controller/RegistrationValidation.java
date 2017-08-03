package com.java.sagitt.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.java.sagitt.model.Registration;

@Component("registrationValidator")
public class RegistrationValidation {

	public boolean supports(Class<?> kClass) {
		return Registration.class.isAssignableFrom(kClass);
	}

	public void validate(Object targret, Errors errors) {
		Registration registration = (Registration) targret;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Tên đăng nhập không được để trống","Tên đăng nhập không được"
				+ "để trống");
		
		String userName = registration.getUserName();
	}
}

package com.java.sagitt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.sagitt.helper.ConstantManager;
import com.java.sagitt.model.UserSA;

@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;

	public void setRegistrationValidation(RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		model.addAttribute("userSA", new UserSA());
		return ConstantManager.REGISTER_PAGE;
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userSA") UserSA userSA, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		return ConstantManager.LOGIN_PAGE_SUCCESS;
	}
}

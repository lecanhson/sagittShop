package com.java.sagitt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.java.sagitt.DAO.LoginDAO;
import com.java.sagitt.form.LoginForm;

@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@Autowired
	public LoginDAO loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model) {
		if (result.hasErrors()) {
			return "loginform";
		}
		boolean userExists = loginService.checkLogin(loginForm.getUsername(), loginForm.getPassword());
		if (userExists) {
			model.put("loginForm", loginForm);
			return "loginsuccess";
		} else {
			result.rejectValue("userName", "invaliduser");
			return "loginform";
		}
	}
}

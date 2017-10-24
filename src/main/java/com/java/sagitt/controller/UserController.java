package com.java.sagitt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.java.sagitt.DAO.LoginDAO;
import com.java.sagitt.form.LoginForm;
import com.java.sagitt.model.User;

@Controller
@RequestMapping("/account")
public class UserController {

	@Autowired
	public LoginDAO loginService;

	@RequestMapping(value="/loginPage", method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginPage = new LoginForm();
		model.put("loginPage", loginPage);
		return "account/loginPage";
	}

	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, @ModelAttribute(value="user") User user,
			ModelMap model) {
	/*	if (result.hasErrors()) {
			return "loginPage";
		}*/
		boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword());
		if (userExists) {
			model.put("loginPage", loginForm);
			return "loginsuccess";
		} else {
			//result.rejectValue("userName", "invaliduser");
			return "loginPage";
		}
	}
}

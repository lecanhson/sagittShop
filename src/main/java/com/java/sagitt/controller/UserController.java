package com.java.sagitt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.java.sagitt.DAO.LoginDAO;
import com.java.sagitt.form.LoginForm;
import com.java.sagitt.helper.ConstantManager;
import com.java.sagitt.model.User;
import com.mysql.jdbc.log.LogUtils;

@Controller
public class UserController {

	@Autowired
	public LoginDAO loginService;

	@RequestMapping(value = { "/account/login", "/account/process-login" }, method = RequestMethod.GET)
	public String showFormLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return ConstantManager.LOGIN_PAGE;
	}

	@RequestMapping(value = "/account/process-login", method = RequestMethod.POST)
	public String processFormLogin(@Valid LoginForm loginForm, Map model) {
		try {

			boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword());
			if (userExists) {
				model.put("loginPage", loginForm);
				return "loginsuccess";
			} else {

				return ConstantManager.LOGIN_PAGE;
			}
		} catch (Exception e) {

		}
		return ConstantManager.LOGIN_PAGE;
	}
}

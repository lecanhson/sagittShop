package com.java.sagitt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.sagitt.enties.User;
import com.java.sagitt.helper.ConstantManager;
import com.java.sagitt.model.UserSA;

@Controller
public class UserController extends AbstractController {

	@RequestMapping(value = { "/account/login", "/account/process-login" }, method = RequestMethod.GET)
	public String showFormLogin(ModelMap model) {
		model.addAttribute("userSA", new UserSA());
		return ConstantManager.LOGIN_PAGE;
	}

	@RequestMapping(value = "/account/process-login", method = RequestMethod.POST)
	public String processFormLogin(@ModelAttribute("userSA") UserSA userSA, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		try {
			String userName = userSA.getUser();
			String password = userSA.getPassword();
			User user = null;
			user = userMgr.login(userName, null, password);

			if (user != null) {
				return ConstantManager.LOGIN_PAGE_SUCCESS;
			} else {
				return ConstantManager.LOGIN_PAGE;
			}
		} catch (Exception e) {

		}
		return ConstantManager.LOGIN_PAGE;
	}

	@RequestMapping(value = { "/account/register", "/account/process-reg" }, method = RequestMethod.GET)
	public String showFormRegister(ModelMap model) {
		model.addAttribute("userSA", new UserSA());
		return ConstantManager.REGISTER_PAGE;
	}

}

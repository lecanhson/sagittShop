package com.java.sagitt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public ModelAndView home() {
		String message = "Chào mừng, bạn đã đăng nhập thành công";
		return new ModelAndView("homePage", "message", message);
	}

}

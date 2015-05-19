package ua.internetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePage {

	private static final String HOME = "home";

	@RequestMapping(value = "/")
	public String homePage(ModelAndView model) {
		return HOME;
	}
}

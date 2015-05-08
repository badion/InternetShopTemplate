package ua.internetshop.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.internetshop.model.Good;
import ua.internetshop.service.GoodManager;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		GoodManager goodManager = (GoodManager) ctx.getBean("goodManagerImpl");
		List<Good> list = goodManager.getAllGoods();
		System.out.println("Goods " + list);
		return "home";
	}

}

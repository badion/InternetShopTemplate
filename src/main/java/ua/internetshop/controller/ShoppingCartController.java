package ua.internetshop.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.internetshop.model.Customer;
import ua.internetshop.model.Good;
import ua.internetshop.model.ShoppingCart;
import ua.internetshop.model.enumeration.OrderedStatus;
import ua.internetshop.repository.CategoryRepository;
import ua.internetshop.repository.GoodsRepository;
import ua.internetshop.repository.ShoppingCartRepository;

@Controller
@Scope("session")
public class ShoppingCartController {

	@Autowired
	private GoodsRepository goodRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ShoppingCart shoppingCart;

	@Autowired
	private Customer customer;

	private List<Good> goods;

	
	@RequestMapping(value = "/categories/{id}/goods/{idGood}/shopping-cart", method = RequestMethod.GET)
	public ModelAndView shoppingCartForCurrentGood(@PathVariable("id") Long id,
			@PathVariable("idGood") Long idGood, ModelAndView modelAndView,
			HttpServletRequest request) {

		Good good = goodRepository.findOne(idGood);

		if (isShoppingCartIsEmpty(request)) { // null shoppingCart in session
			if (isUserEmptyInSession(request)) { // null customer in session
				goods = new ArrayList<>();
				goods.add(good);
				shoppingCart.setCustomer(customer);
				shoppingCart.setCount(1);
				shoppingCart.setDate(new Timestamp(new Date().getTime()));
				shoppingCart.setGoods(goods);
				shoppingCart.setOrderedStatus(OrderedStatus.PROCESSED);
				request.getSession().setAttribute("shoppingCart", shoppingCart);
			} else {
				customer = (Customer) request.getSession().getAttribute(
						"customer");
				goods = new ArrayList<>();
				goods.add(good);
				shoppingCart.setCustomer(customer);
				shoppingCart.setCount(1);
				shoppingCart.setDate(new Timestamp(new Date().getTime()));
				shoppingCart.setGoods(goods);
				shoppingCart.setOrderedStatus(OrderedStatus.PROCESSED);
				request.getSession().setAttribute("shoppingCart", shoppingCart);
			}
		} else {
			shoppingCart = (ShoppingCart) request.getSession().getAttribute(
					"shoppingCart");
			shoppingCart.setCount(shoppingCart.getCount() + 1);
			shoppingCart.getGoods().add(good);
			request.getSession().setAttribute("shoppingCart", shoppingCart);
		}

		modelAndView.setViewName("shopping_cart");

		return modelAndView;
	}
	
	private boolean isShoppingCartIsEmpty(HttpServletRequest request) {
		return request.getSession().getAttribute("shoppingCart") == null ? true
				: false;
	}

	private boolean isUserEmptyInSession(HttpServletRequest request) {
		return request.getSession().getAttribute("customer") == null ? true
				: false;
	}

}

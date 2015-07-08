package ua.internetshop.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.internetshop.model.Customer;
import ua.internetshop.model.Good;
import ua.internetshop.model.ShoppingCart;
import ua.internetshop.model.enumeration.OrderedStatus;
import ua.internetshop.repository.GoodsRepository;
import ua.internetshop.utils.JspNamesUtil;

@Controller
@RequestMapping(value = ShoppingCartController.SHOPPING_CART_MAP_PAGE)
@Scope("session")
public class ShoppingCartController implements Serializable {

	static final String SHOPPING_CART_MAP_PAGE = "/shopping-cart";

	private static final String ID = "id";

	private static final String DELETE_ID = "/delete/{id}";

	private static final String ORDER_NOW_ID = "/orderNow/{id}";

	private static final String TOTAL_SUM = "totalSum";

	private static final String SHOPPING_CART = "shoppingCart";

	private static final long serialVersionUID = 1L;

	@Autowired
	private GoodsRepository goodRepository;

	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping(method = RequestMethod.GET)
	public String getShoppingCartFromSession() {
		return JspNamesUtil.SHOPPING_CART_PAGE;
	}

	@RequestMapping(value = ORDER_NOW_ID, method = RequestMethod.GET)
	public String orderNow(@PathVariable(ID) Long id, ModelMap modelMap, HttpServletRequest request) {
		if (request.getSession().getAttribute(SHOPPING_CART) == null) {
			List<Good> goods = new ArrayList<>();
			goods.add(goodRepository.findOne(id));
			checkCustomer(request);
			shoppingCart.setGoods(goods);
			shoppingCart.setDate(new Timestamp(new Date().getTime()));
			shoppingCart.setCount(1);
			shoppingCart.setOrderedStatus(OrderedStatus.PROCESSED);
			request.getSession().setAttribute(SHOPPING_CART, shoppingCart);
		} else {
			shoppingCart = (ShoppingCart) request.getSession().getAttribute(SHOPPING_CART);
			shoppingCart.getGoods().add(goodRepository.findOne(id));
			shoppingCart.setCount(shoppingCart.getCount() + 1);
			request.getSession().setAttribute(SHOPPING_CART, shoppingCart);
		}

		modelMap.addAttribute(TOTAL_SUM, priceTotalSum());

		return JspNamesUtil.SHOPPING_CART_PAGE;
	}

	@RequestMapping(value = DELETE_ID, method = RequestMethod.GET)
	public String deleteProductFromCart(@PathVariable(ID) Long id, ModelMap modelMap, HttpServletRequest request) {
		shoppingCart = (ShoppingCart) request.getSession().getAttribute(SHOPPING_CART);
		shoppingCart.getGoods().removeIf(good -> good.getId().equals(id));
		modelMap.addAttribute(TOTAL_SUM, priceTotalSum());
		return JspNamesUtil.SHOPPING_CART_PAGE;
	}

	private void checkCustomer(HttpServletRequest request) {
		if (request.getSession().getAttribute("customer") != null) {
			shoppingCart.setCustomer((Customer) request.getSession().getAttribute("customer"));
		}
	}

	private double priceTotalSum() {
		return shoppingCart.getGoods().stream().mapToDouble(good -> good.getPrice()).sum();
	}
}

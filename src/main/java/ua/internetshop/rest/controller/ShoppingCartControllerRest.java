package ua.internetshop.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.internetshop.model.ShoppingCart;
import ua.internetshop.repository.ShoppingCartRepository;

@RestController
@RequestMapping(value = ShoppingCartControllerRest.REST)
public class ShoppingCartControllerRest {

	static final String REST = "/rest";

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@RequestMapping(value = "/shopping-cart", method = RequestMethod.GET, headers = "accept=application/json")
	public @ResponseBody List<ShoppingCart> getAllShoppingCart() {
		List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) shoppingCartRepository
				.findAll();
		if (shoppingCarts.isEmpty()) {

		}
		return shoppingCarts;
	}

}

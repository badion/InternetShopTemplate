package ua.internetshop.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.internetshop.exceptions.AbsentGoods;
import ua.internetshop.exceptions.GoodInDatabaseIsEmpty;
import ua.internetshop.model.Category;
import ua.internetshop.model.Good;
import ua.internetshop.service.CategoryManager;
import ua.internetshop.service.GoodManager;

@RestController
@RequestMapping(value = GoodControllerRest.REST)
public class GoodControllerRest {

	static final String REST = "/rest";

	private static final String ID = "id";

	private static final String GOODS_DELETE_ID = "goods/delete{id}";

	private static final String GOODS_ID = "/goods/{id}";

	private static final String GOODS = "/goods";

	private static final String ACCEPT_APPLICATION_JSON = "accept=application/json";

	@Autowired
	private GoodManager goodManager;

	@Autowired
	private CategoryManager categoryManager;

	@RequestMapping(value = GOODS, method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
	public @ResponseBody List<Good> getAllGoods() {
		List<Good> goods = goodManager.getAllGoods();
		if (goods.isEmpty())
			throw new AbsentGoods();
		return goods;
	}

	@RequestMapping(value = GOODS_ID, method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
	public @ResponseBody Good getGoodById(@PathVariable(ID) Long id, Model model) {
		return getGood(id);
	}

	@RequestMapping(value = GOODS_DELETE_ID, method = RequestMethod.DELETE)
	public void deleteGood(@PathVariable(ID) Long goodId) {
		Good good = goodManager.getGoodById(goodId);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(goodId);
		goodManager.delete(good);
	}

	@RequestMapping(value = "/category/{id}/goods/{idGood}/", method = RequestMethod.GET)
	public @ResponseBody Good getGoodByIdCategory(@PathVariable("id") Long id,
			@PathVariable("idGood") Long idGood) {
		return getGood(idGood);
	}

	@RequestMapping(value = "/category/{id}/goods/{idGood}/delete", method = RequestMethod.DELETE)
	public void deleteGoodByCategory(@PathVariable("id") Long id,
			@PathVariable("idGood") Long idGood) {
		Good good = goodManager.getGoodById(idGood);
		Category category = categoryManager.getCategoryById(id);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(idGood);

		removeGoodFromCategory(good, category);

		categoryManager.saveOrUpdate(category); // save deleted element in
												// category.getGoods() & delete
												// element of good in goods
												// table
	}

	private void removeGoodFromCategory(Good good, Category category) {
		new ArrayList<Good>(category.getGoods()).forEach((goodForDelete) -> {
			if (goodForDelete.getId() == good.getId())
				category.getGoods().remove(goodForDelete);
		});
	}

	private Good getGood(Long id) {
		Good good = goodManager.getGoodById(id);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(id);
		return good;
	}
}

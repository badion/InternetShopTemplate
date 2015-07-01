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
import ua.internetshop.repository.CategoryRepository;
import ua.internetshop.repository.GoodsRepository;

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
	private GoodsRepository goodRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = GOODS, method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
	public @ResponseBody List<Good> getAllGoods() {
		List<Good> goods = (List<Good>) goodRepository.findAll();
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
		Good good = goodRepository.findOne(goodId);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(goodId);
		goodRepository.delete(good);
	}

	@RequestMapping(value = "/category/{id}/goods/{idGood}/", method = RequestMethod.GET)
	public @ResponseBody Good getGoodByIdCategory(@PathVariable("id") Long id,
			@PathVariable("idGood") Long idGood) {
		return getGood(idGood);
	}

	@RequestMapping(value = "/category/{id}/goods/{idGood}/delete", method = RequestMethod.DELETE)
	public void deleteGoodByCategory(@PathVariable("id") Long id,
			@PathVariable("idGood") Long idGood) {
		Good good = goodRepository.findOne(idGood);
		Category category = categoryRepository.findOne(id);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(idGood);

		removeGoodFromCategory(good, category);

		categoryRepository.save(category);
	}

	private void removeGoodFromCategory(Good good, Category category) {
		new ArrayList<Good>(category.getGoods()).forEach((goodForDelete) -> {
			if (goodForDelete.getId() == good.getId())
				category.getGoods().remove(goodForDelete);
		});
	}

	private Good getGood(Long id) {
		Good good = goodRepository.findOne(id);
		if (good == null)
			throw new GoodInDatabaseIsEmpty(id);
		return good;
	}
}

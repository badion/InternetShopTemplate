package ua.internetshop.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import ua.internetshop.exceptions.AbsentCategories;
import ua.internetshop.model.Category;
import ua.internetshop.model.Good;
import ua.internetshop.repository.CategoryRepository;
import ua.internetshop.repository.GoodsRepository;
import ua.internetshop.utils.JspNamesUtil;
import ua.internetshop.utils.UrlRestUtil;
import ua.internetshop.validator.GoodValidator;

@Controller
public class GoodsByCategoryListGontroller {

	private static final String ID = "id";

	private static final String GOOD = "good";

	private static final String GOODS = "/goods/";

	private static final String ID_GOOD = "idGood";

	private static final String DELETE = "/delete";

	private static final String CATEGORY = "category";

	private static final String CATEGORIES_ID_GOODS = "/categories/{id}/goods";

	private static final String CATEGORIES_ID_GOODS_ADD = "/categories/{id}/goods/add";

	private static final String CATEGORIES_ID_GOODS_ADD_DO = "/categories/{id}/goods/add.do";

	private static final String CATEGORIES_ID_GOODS_ID_GOOD = "/categories/{id}/goods/{idGood}";

	private static final String CATEGORIES_ID_GOODS_ID_GOOD_DELETE = "/categories/{id}/goods/{idGood}/delete";

	@Autowired
	private GoodsRepository goodRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private GoodValidator goodValidator;

	private final RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = CATEGORIES_ID_GOODS, method = RequestMethod.GET)
	public ModelAndView goodsByCategory(@PathVariable(ID) Integer id,
			ModelAndView model) {

		List<Category> categories = Arrays.asList(restTemplate.getForObject(
				UrlRestUtil.CATEGORY_ID + id, Category.class));
		if (!categories.isEmpty()) {
			model.addObject(CATEGORY, categories);
			model.addObject(GOOD, new Good());
			model.setViewName(JspNamesUtil.GOODS_BY_CATEGORY);
		} else
			throw new AbsentCategories();
		return model;
	}

	@RequestMapping(value = CATEGORIES_ID_GOODS_ADD, method = RequestMethod.GET)
	public String addGood(Model model) {
		model.addAttribute(GOOD, new Good());
		return JspNamesUtil.GOODS_BY_CATEGORY_NEW;
	}

	@RequestMapping(value = CATEGORIES_ID_GOODS_ADD_DO, method = RequestMethod.POST)
	public String addGoodAction(@Valid @ModelAttribute Good good,
			@PathVariable(ID) Integer id, BindingResult bindingResult,
			Model model) {

		goodValidator.validate(good, bindingResult);
		if (bindingResult.hasErrors()) {
			return JspNamesUtil.GOODS_BY_CATEGORY;
		} else {
			Category category = restTemplate.getForObject(
					UrlRestUtil.LIST_OF_CATEGORIES + "/" + id, Category.class);

			// need to modify

			good.setCategory(category);
			good.setId(null); // null because good has already id from id
								// parameter

			category.getGoods().add(good);
			categoryRepository.save(category); // add good in
												// category.getGoods() and
												// add good in table

			model.addAttribute(GOOD, good);
		}
		return "redirect:/categories/" + id + "/goods/";
	}

	@RequestMapping(value = CATEGORIES_ID_GOODS_ID_GOOD, method = RequestMethod.GET)
	public ModelAndView getGoodPage(@PathVariable(ID) Long id,
			@PathVariable(ID_GOOD) Long idGood, ModelAndView modelAndView) {
		Good good = goodRepository.findOne(idGood);
		Category category = categoryRepository.findOne(id);
		modelAndView.addObject(GOOD, good);
		modelAndView.addObject(CATEGORY, category);
		modelAndView.setViewName(JspNamesUtil.GOOD_BY_CATEGORY_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = CATEGORIES_ID_GOODS_ID_GOOD_DELETE, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(ID) Long id,
			@PathVariable(ID_GOOD) Long idGood, Model model) {
		restTemplate.delete(UrlRestUtil.LIST_OF_CATEGORIES + id + GOODS
				+ idGood + DELETE);
		model.addAttribute("ca", categoryRepository.findOne(id));
		return JspNamesUtil.REDIRECT_CATEGORIES + id + GOODS;
	}
}

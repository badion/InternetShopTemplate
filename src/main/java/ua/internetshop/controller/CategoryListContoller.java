package ua.internetshop.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import ua.internetshop.model.Category;
import ua.internetshop.repository.CategoryRepository;
import ua.internetshop.utils.JspNamesUtil;
import ua.internetshop.utils.UrlRestUtil;
import ua.internetshop.validator.CategoryValidator;

@Controller
public class CategoryListContoller implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String ID = "id";

	private static final String CATEGORY = "category";

	private static final String CATEGORIES = "/categories";

	private static final String CATEGORIES_ADD = "/categories/add";

	private static final String CATEGORIES_ADD_DO = "/categories/add.do";

	private static final String CATEGORIES_DELETE_ID = "/categories/delete/{id}";

	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryValidator categoryValidator;

	@RequestMapping(value = CATEGORIES)
	public ModelAndView getCategories(ModelAndView model) {
		List<Category> categories = Arrays.asList(restTemplate.getForObject(
				UrlRestUtil.LIST_OF_CATEGORIES, Category[].class));
		model.addObject(CATEGORY, categories);
		model.setViewName(JspNamesUtil.CATEGORIES);
		return model;
	}

	@RequestMapping(value = CATEGORIES_ADD, method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute(CATEGORY, new Category());
		return JspNamesUtil.CATEGORIES_NEW;
	}

	@RequestMapping(value = CATEGORIES_ADD_DO, method = RequestMethod.POST)
	public String addCategoryAction(@Valid Category category,
			BindingResult bindingResult, Model model) {

		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors()) {
			return JspNamesUtil.CATEGORIES_NEW;
		} else {
			model.addAttribute(CATEGORY, category);
			categoryRepository.save(category);
		}
		return JspNamesUtil.REDIRECT_HOME;
	}

	@RequestMapping(value = CATEGORIES_DELETE_ID, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(ID) Long id) {
		restTemplate.delete(UrlRestUtil.DELETE_CATEGORY + id);
		return JspNamesUtil.REDIRECT_HOME;
	}
}

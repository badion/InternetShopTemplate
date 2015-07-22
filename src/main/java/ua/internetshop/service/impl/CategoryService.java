package ua.internetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.internetshop.model.Category;
import ua.internetshop.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public static final int NUMBER_OF_PERSONS_PER_PAGE = 3;

	public List<Category> categories(int pageIndex) {
		Page requestedPage = categoryRepository.findAll(constructPageSpecification(pageIndex));
		System.out.println(requestedPage.getContent());
		return requestedPage.getContent();
	}

	private Pageable constructPageSpecification(int pageIndex) {
		Pageable pageSpecification = new PageRequest(pageIndex - 1, NUMBER_OF_PERSONS_PER_PAGE);
		return pageSpecification;
	}

	@SuppressWarnings("unused")
	private Sort sortByLastNameAsc() {
		return new Sort(Sort.Direction.ASC, "name");
	}
}

package ua.internetshop.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.internetshop.repository.CategoryRepository;

@Service
public class CategoryRepoService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
}

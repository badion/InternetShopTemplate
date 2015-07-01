package ua.internetshop.repository;

import org.springframework.data.repository.CrudRepository;

import ua.internetshop.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}

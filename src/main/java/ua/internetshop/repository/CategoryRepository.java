package ua.internetshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.internetshop.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}

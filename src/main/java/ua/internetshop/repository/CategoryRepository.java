package ua.internetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.internetshop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

package ua.internetshop.repository;

import org.springframework.data.repository.CrudRepository;

import ua.internetshop.model.Good;

public interface GoodsRepository extends CrudRepository<Good, Long> {

}

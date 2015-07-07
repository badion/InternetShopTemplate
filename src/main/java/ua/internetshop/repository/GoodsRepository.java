package ua.internetshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.internetshop.model.Good;

@Repository
public interface GoodsRepository extends CrudRepository<Good, Long> {

}

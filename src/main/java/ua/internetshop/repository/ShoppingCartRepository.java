package ua.internetshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.internetshop.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends
		CrudRepository<ShoppingCart, Long> {

}

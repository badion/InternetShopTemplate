package ua.internetshop.dao;

import java.util.List;

import ua.internetshop.model.Good;

public interface GoodDao {

	void add(Good good);

	Good saveOrUpdate(Good good);

	List<Good> getAllGoods();

	Good getGoodById(Long id);

	void delete(Good id);

}

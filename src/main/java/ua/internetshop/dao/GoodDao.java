package ua.internetshop.dao;

import java.util.List;

import ua.internetshop.model.Good;

public interface GoodDao {

	void insertGood(Good good);

	List<Good> getAllGoods();

	Good getGoodById(Integer id);
	
	void delete(Good id);

}

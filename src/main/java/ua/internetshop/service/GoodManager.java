package ua.internetshop.service;

import java.util.List;

import ua.internetshop.model.Good;

public interface GoodManager {

	void add(Good good);

	Good saveOrUpdate(Good good);

	List<Good> getAllGoods();

	Good getGoodById(Long id);

	void delete(Good good);
	
	void refresh(Good good);

}

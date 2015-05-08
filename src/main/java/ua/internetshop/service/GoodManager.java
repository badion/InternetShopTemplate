package ua.internetshop.service;

import java.util.List;

import ua.internetshop.model.Good;

public interface GoodManager {

	void insertGood(Good good);

	List<Good> getAllGoods();

}

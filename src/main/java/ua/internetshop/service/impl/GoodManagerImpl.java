package ua.internetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.internetshop.dao.GoodDao;
import ua.internetshop.model.Good;
import ua.internetshop.service.GoodManager;

@Service
public class GoodManagerImpl implements GoodManager {

	@Autowired
	private GoodDao goodDao;

	@Transactional
	public void insertGood(Good good) {
		goodDao.insertGood(good);
	}

	public List<Good> getAllGoods() {
		return goodDao.getAllGoods();
	}

}

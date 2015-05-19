package ua.internetshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import ua.internetshop.dao.GoodDao;
import ua.internetshop.model.Good;
import ua.internetshop.service.GoodManager;

@Service
public class GoodManagerImpl implements GoodManager {

	@Autowired
	private GoodDao goodDao;

	public List<Good> getAllGoods() {
		return goodDao.getAllGoods();
	}

	public Good getGoodById(Long id) {
		return goodDao.getGoodById(id);
	}

	@Transactional
	public void delete(Good good) {
		goodDao.delete(good);
	}

	@Transactional
	public void add(Good good) {
		goodDao.add(good);
	}

	@Transactional
	public Good saveOrUpdate(Good good) {
		return goodDao.saveOrUpdate(good);
	}

	@Override
	public void refresh(Good good) {
		goodDao.refresh(good);
	}

}

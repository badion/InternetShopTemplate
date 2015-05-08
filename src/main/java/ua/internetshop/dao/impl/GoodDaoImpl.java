package ua.internetshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ua.internetshop.dao.GoodDao;
import ua.internetshop.model.Good;

@Repository
public class GoodDaoImpl implements GoodDao {

	@PersistenceContext
	private EntityManager em;

	public List<Good> getAllGoods() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Good> cq = builder.createQuery(Good.class);
		Root<Good> root = cq.from(Good.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}

	public void insertGood(Good good) {
		em.persist(good);
	}

}

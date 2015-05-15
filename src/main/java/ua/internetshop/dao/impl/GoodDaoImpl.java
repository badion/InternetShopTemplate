package ua.internetshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.internetshop.dao.GoodDao;
import ua.internetshop.model.Good;

@Repository
public class GoodDaoImpl implements GoodDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public List<Good> getAllGoods() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Good> cq = builder.createQuery(Good.class);
		Root<Good> root = cq.from(Good.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}

	@Transactional(readOnly = false)
	public Good saveOrUpdate(Good good) {
		if (good != null) {
			em.merge(good);
			em.flush();
		}
		return good;
	}

	public void delete(Good good) {
		em.remove(em.merge(good));
	}

	@Transactional(readOnly = false)
	@Override
	public void add(Good good) {
		em.persist(good);
		em.flush();
	}

	@Override
	public Good getGoodById(Long id) {
		return em.find(Good.class, id);
	}

}

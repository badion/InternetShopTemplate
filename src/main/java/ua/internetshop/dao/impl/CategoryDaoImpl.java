package ua.internetshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ua.internetshop.dao.CategoryDao;
import ua.internetshop.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public Category saveOrUpdate(Category category) {
		if (category != null) {
			em.merge(category);
		}
		return category;
	}

	public List<Category> getAllCategory() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = builder.createQuery(Category.class);
		Root<Category> root = cq.from(Category.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}

	public void delete(Category category) {
		em.remove(em.merge(category));
	}

	public void add(Category category) {
		em.persist(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		return em.find(Category.class, id);
	}

}

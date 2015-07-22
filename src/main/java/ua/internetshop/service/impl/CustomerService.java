package ua.internetshop.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.internetshop.model.Customer;
import ua.internetshop.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;

	// SELECT * FROM CUSTOMER WHERE access_token = ?
	public Customer getCustomerByFacebookId(String facebookId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = cb.createQuery(Customer.class);
		Root<Customer> customer = criteria.from(Customer.class);
		ParameterExpression<String> p = cb.parameter(String.class);
		Predicate predicate = cb.equal(customer.get("access_token"), p);
		criteria.select(customer).where(predicate);
		return entityManager.createQuery(criteria).getSingleResult();
	}
}

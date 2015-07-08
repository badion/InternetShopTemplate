package ua.internetshop.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.internetshop.model.enumeration.OrderedStatus;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint")
	private Long id;

	@Column(name = "count")
	private Integer count;

	@Column(name = "ordered_date")
	private Timestamp date;

	@OneToMany(mappedBy = "shoppingCart", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Good> goods;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
	private Customer customer;

	@Enumerated(EnumType.STRING)
	private OrderedStatus orderedStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderedStatus getOrderedStatus() {
		return orderedStatus;
	}

	public void setOrderedStatus(OrderedStatus orderedStatus) {
		this.orderedStatus = orderedStatus;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", count=" + count + ", date=" + date + ", goods=" + goods + ", customer=" + customer + ", orderedStatus=" + orderedStatus + "]";
	}

}

package ua.internetshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category_of_products")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigserial")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private List<Good> goods;

	@JsonManagedReference
	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", goods=" + goods
				+ "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addGood(Good good) {
		this.goods.add(good);
		good.setCategory(this);
		// if (!goods.contains(good)) {
		// goods.add(good);
		// }
	}
}

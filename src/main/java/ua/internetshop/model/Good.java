package ua.internetshop.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "goods")
public class Good implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigserial")
	private Long id;

	// @NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "short_description")
	private String shortDescription;

	// @NotNull
	@Column(name = "quantity")
	private Integer quantity;

	// @NotNull
	@Column(name = "price")
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@JsonBackReference
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		if (sameCategory(category)) {
			return;
		}
		Category oldCategory = this.category;
		this.category = category;

		if (oldCategory != null) {
			category.addGood(this);
		}
		this.category = category;
	}

	private boolean sameCategory(Category newCategory) {
		return category == null ? newCategory == null : category
				.equals(newCategory);
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

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

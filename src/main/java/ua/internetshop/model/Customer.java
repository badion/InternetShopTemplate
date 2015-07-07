package ua.internetshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.internetshop.model.enumeration.UserRoleType;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint")
	private Long id;

	@Column(name = "locked")
	private Boolean locked;

	@Column(name = "f_name")
	private String firstName;

	@Column(name = "l_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRoleType role;

	@Column(name = "email_confirmation")
	private Boolean emailConfirmed;

	@Column(name = "phone")
	private String phone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

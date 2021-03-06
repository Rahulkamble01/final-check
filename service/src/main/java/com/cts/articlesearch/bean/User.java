package com.cts.articlesearch.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "User Name cannot be empty")
	@Size(max = 70, message = "Name must not exceed 70 characters")
	@Column(name = "us_name")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Size(max = 255, message = "Email must not exceed 255 characters")
	@Column(name = "us_email")
	private String email;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 50, message = "Password must be 6 to 50 characters")
	@Column(name = "us_password")
	private String password;

	@Column(name = "us_status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_ur_id")
	private Role role;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favourite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
	@JoinColumn(name = "fa_art_id") })
	private List<Article> article;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_lang_id")
	private Language language;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public User(int id, String name, String email, String password,	String status, Role role, List<Article> article, Language language) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
		this.article = article;
		this.language = language;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", role=" + role + ", article=" + article + ", language=" + language + "]";
	}

}

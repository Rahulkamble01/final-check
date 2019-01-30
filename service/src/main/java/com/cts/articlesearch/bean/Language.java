package com.cts.articlesearch.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lang_id")
	private int id;
	
	@Column(name="lang_name")
	private String name;
	
	@Column(name="lang_code")
	private String languageCode;

	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Language(int id, String name, String languageCode) {
		super();
		this.id = id;
		this.name = name;
		this.languageCode = languageCode;
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

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", languageCode=" + languageCode + "]";
	}

	

}

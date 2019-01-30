package com.cts.articlesearch.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="art_id")
	private int id;
	
	@Column(name="art_name")
	private String name;
	
	@Column(name="art_title")
	private String title;
	
	@Column(name="art_desc")
	private String description;
	
	@Column(name="art_content")
	private String content;
	
	@Column(name="art_author")
	private String author;
	
	@Column(name="art_url")
	private String url;
	
	@Column(name="art_urltoimage")
	private String urlToImage;
	
	@Column(name="art_publishedat")
	private String publishedAt;
	
	@Transient
	private String email;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int id, String name, String title, String description, String content, String author, String url,
			String urlToImage, String publishedAt, String email) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.content = content;
		this.author = author;
		this.url = url;
		this.urlToImage = urlToImage;
		this.publishedAt = publishedAt;
		this.email = email;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description
				+ ", content=" + content + ", author=" + author + ", url=" + url + ", urlToImage=" + urlToImage
				+ ", publishedAt=" + publishedAt + ", email=" + email + "]";
	}
	
	

}

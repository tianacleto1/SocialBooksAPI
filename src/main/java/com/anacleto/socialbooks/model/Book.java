package com.anacleto.socialbooks.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Book {

	private Long id;
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private Date publicationDate;
	
	@JsonInclude(Include.NON_NULL)
	private String publishing;
	
	@JsonInclude(Include.NON_NULL)
	private String summary;
	
	@JsonInclude(Include.NON_NULL)
	private List<Review> reviews;
	
	@JsonInclude(Include.NON_NULL)
	private String author;

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
	
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getPublishing() {
		return publishing;
	}
	
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}

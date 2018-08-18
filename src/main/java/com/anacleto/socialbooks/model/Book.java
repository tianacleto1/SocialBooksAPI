package com.anacleto.socialbooks.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookName;
	
	@JsonInclude(Include.NON_NULL)
	private Date publicationDate;
	
	@JsonInclude(Include.NON_NULL)
	private String publisher;
	
	@JsonInclude(Include.NON_NULL)
	private String summary;
	
	@OneToMany(mappedBy = "book")
	@JsonInclude(Include.NON_NULL)
	private List<Review> reviews;
	
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Author author;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
}

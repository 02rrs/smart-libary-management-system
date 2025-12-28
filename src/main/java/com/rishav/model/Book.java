package com.rishav.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String title;
	
	private String author;
	
	private String genre;
	
	@Column(name="published_year")
	private Integer publishedYear;
	
	private Double price;
	
	@Column(name="available_copies", nullable = false)
	private Integer availableCopies;
	
	@Column(name="total_copies", nullable = false)
	private Integer totalCopies;
	
	@OneToMany(mappedBy = "book", fetch=FetchType.LAZY)
	private List<BorrowRecord> borrowRecords;
	
	public Book() {}

	public Book(String title, String author, String genre, Integer publishedYear, Double price,
			Integer availableCopies, Integer totalCopies) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publishedYear = publishedYear;
		this.price = price;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}

	public List<BorrowRecord> getBorrowRecords() {
		return borrowRecords;
	}

	public void setBorrowRecords(List<BorrowRecord> borrowRecords) {
		this.borrowRecords = borrowRecords;
	}
	
}

package com.rishav.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.rishav.enums.BorrowStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="borrow_records")
public class BorrowRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@CreationTimestamp
	@Column(name="borrow_date", nullable = false, updatable = false)
	private LocalDateTime borrowDate;
	
	@Column(name="due_date", nullable = false)
	private LocalDateTime dueDate;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@Column(name="fine_amount")
	private Double fineAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BorrowStatus status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id", nullable = false)
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id", nullable=false)
	private Member member;
	
	public BorrowRecord() {}

	public BorrowRecord(Integer id, LocalDateTime borrowDate, LocalDateTime dueDate, Double fineAmount,
			BorrowStatus status, Book book, Member member) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.fineAmount = fineAmount;
		this.status = status;
		this.book = book;
		this.member = member;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	
	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public Double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(Double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public BorrowStatus getStatus() {
		return status;
	}

	public void setStatus(BorrowStatus status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}

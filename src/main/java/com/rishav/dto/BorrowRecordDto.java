package com.rishav.dto;

import java.time.LocalDateTime;

import com.rishav.enums.BorrowStatus;

public class BorrowRecordDto {
	private Integer id;
	private LocalDateTime borrowDate;
	private LocalDateTime dueDate;
	private LocalDateTime returnDate;
	private Double fineAmount;
	private BorrowStatus status;
	
	private BookDto bookDto;
	private MemberDto memberDto;
	
	
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
	public BookDto getBookDto() {
		return bookDto;
	}
	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}
	public MemberDto getMemberDto() {
		return memberDto;
	}
	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	
}

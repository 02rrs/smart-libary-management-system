package com.rishav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.dto.BorrowRecordDto;
import com.rishav.resource.ResponseStructure;
import com.rishav.service.BorrowRecordService;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordController {
	private final BorrowRecordService borrowRecordService;
	
	public BorrowRecordController(BorrowRecordService borrowRecordService) {
		this.borrowRecordService=borrowRecordService;
	}
	
	//Borrow book
	@PostMapping
	public ResponseEntity<ResponseStructure<String>> borrowBook(@RequestParam Integer memberId, @RequestParam Integer bookId) {
		return borrowRecordService.borrowBook(memberId, bookId);
	}
	
	//Ruturn book
	@PostMapping("/return/{boorrowRecordId}")
	public ResponseEntity<ResponseStructure<String>> returnBook(@PathVariable Integer boorrowRecordId) {
		return borrowRecordService.returnBook(boorrowRecordId);
	}
	
	//Member borrow Record
	@GetMapping("/member/{memberId}")
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getMemberBorrowRecord(@PathVariable Integer memberId) {
		return borrowRecordService.getBorrowRecordByMember(memberId);
	}
	
	//Over Due Books
	@GetMapping("/overdue")
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getOverDueBook() {
		return borrowRecordService.getOverDueBooks();
	}
}

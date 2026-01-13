package com.rishav.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rishav.dto.BorrowRecordDto;
import com.rishav.resource.ResponseStructure;

public interface BorrowRecordService {
	public ResponseEntity<ResponseStructure<String>> borrowBook(Integer memberId, Integer bookId);
	public ResponseEntity<ResponseStructure<String>> returnBook(Integer borrowRecordId);
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getBorrowRecordByMember(Integer memberId);
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getOverDueBooks();
}

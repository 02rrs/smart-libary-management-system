package com.rishav.service;

import org.springframework.http.ResponseEntity;

import com.rishav.resource.ResponseStructure;

public interface BorrowRecordService {
	public ResponseEntity<ResponseStructure<String>> borrowBook(Integer memberId, Integer bookId);
}

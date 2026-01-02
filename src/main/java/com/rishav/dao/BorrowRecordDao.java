package com.rishav.dao;

import org.springframework.stereotype.Repository;

import com.rishav.repository.BorrowRecordRepository;

@Repository
public class BorrowRecordDao {
	public final BorrowRecordRepository repo;
	
	public BorrowRecordDao(BorrowRecordRepository repo) {
		this.repo=repo;
	}
	
	
	
}

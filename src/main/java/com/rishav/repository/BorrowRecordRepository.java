package com.rishav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishav.model.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer>{
	
}

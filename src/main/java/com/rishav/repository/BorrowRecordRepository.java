package com.rishav.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishav.model.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer>{
	public List<BorrowRecord> findByMemberId(Integer memberId);
	public List<BorrowRecord> findByDueDateBeforeAndReturnDateIsNull(LocalDateTime now);
}

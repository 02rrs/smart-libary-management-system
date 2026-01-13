package com.rishav.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rishav.exception.BorrowRecordIdNotFoundException;
import com.rishav.model.BorrowRecord;
import com.rishav.repository.BorrowRecordRepository;

@Repository
public class BorrowRecordDao {
	public final BorrowRecordRepository repo;
	
	public BorrowRecordDao(BorrowRecordRepository repo) {
		this.repo=repo;
	}
	
	public BorrowRecord save(BorrowRecord record) {
		return repo.save(record);
	}
	
	public BorrowRecord findById(Integer id) {
		Optional<BorrowRecord> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new BorrowRecordIdNotFoundException("No Borrow record found!!");
		}
	}
	
	public List<BorrowRecord> findByMemberId(Integer memberId) {
		return repo.findByMemberId(memberId);
	}
	
	public List<BorrowRecord> findOverdueRecords() {
        return repo.findByDueDateBeforeAndReturnDateIsNull(LocalDateTime.now());
    }
}

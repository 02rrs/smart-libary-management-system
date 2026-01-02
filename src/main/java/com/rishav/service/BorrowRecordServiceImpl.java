package com.rishav.service;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.rishav.dao.BookDao;
import com.rishav.dao.BorrowRecordDao;
import com.rishav.dao.MemberDao;
import com.rishav.exception.MemberInactiveException;
import com.rishav.model.Member;
import com.rishav.resource.ResponseStructure;

public class BorrowRecordServiceImpl implements BorrowRecordService {
	
	public final BorrowRecordDao borrowDao;
	public final BookDao bookDao;
	public final MemberDao memberDao;
	
	public BorrowRecordServiceImpl(BorrowRecordDao borrowDao, BookDao bookdao, MemberDao memberDao) {
		this.borrowDao=borrowDao;
		this.bookDao=bookdao;
		this.memberDao=memberDao;
	}

	
	@Override
	@Transactional
	public ResponseEntity<ResponseStructure<String>> borrowBook(Integer memberId, Integer bookId) {
		Member member=memberDao.findById(memberId);
		if(!member.getActive()) {
			throw new MemberInactiveException("Member is inactive!!!");
		}
	}
	
}

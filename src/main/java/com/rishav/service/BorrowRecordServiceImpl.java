package com.rishav.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rishav.dao.BookDao;
import com.rishav.dao.BorrowRecordDao;
import com.rishav.dao.MemberDao;
import com.rishav.dto.BorrowRecordDto;
import com.rishav.enums.BorrowStatus;
import com.rishav.exception.BookAlreadyReturnedException;
import com.rishav.exception.MemberInactiveException;
import com.rishav.exception.NoCopiesAvailableException;
import com.rishav.mapper.BorrowRecordMapper;
import com.rishav.model.Book;
import com.rishav.model.BorrowRecord;
import com.rishav.model.Member;
import com.rishav.resource.ResponseStructure;

@Service

public class BorrowRecordServiceImpl implements BorrowRecordService {
	
	public final BorrowRecordDao borrowDao;
	public final BookDao bookDao;
	public final MemberDao memberDao;
	
	public BorrowRecordServiceImpl(BorrowRecordDao borrowDao, BookDao bookdao, MemberDao memberDao) {
		this.borrowDao=borrowDao;
		this.bookDao=bookdao;
		this.memberDao=memberDao;
	}

	
	//Borrow Book
	@Override
	@Transactional
	public ResponseEntity<ResponseStructure<String>> borrowBook(Integer memberId, Integer bookId) {
		Member member=memberDao.findById(memberId);
		if(!member.getActive()) {
			throw new MemberInactiveException("Member is inactive!!!");
		}
		
		Book book=bookDao.getBookById(bookId);
		if(book.getAvailableCopies()<=0) {
			throw new NoCopiesAvailableException("No Copies avaiable for the book id "+bookId);
		}
		
		BorrowRecord record=new BorrowRecord();
		record.setBook(book);
		record.setMember(member);
		record.setStatus(BorrowStatus.BORROWED);
		record.setDueDate(LocalDateTime.now().plusDays(14));
		
		borrowDao.save(record);
		
		book.setAvailableCopies(book.getAvailableCopies()-1);
		bookDao.updateBook(book);
		
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Book borrow Successfully!!");
		response.setData("Book with book id "+bookId+" is borrowed by member with member id "+memberId);
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.CREATED);
		
	}
	
	//Return Book
	@Override
	@Transactional
	public ResponseEntity<ResponseStructure<String>> returnBook(Integer borrowRecordId) {
		 BorrowRecord record=borrowDao.findById(borrowRecordId);
		 if(record.getReturnDate()!=null) {
			 throw new BookAlreadyReturnedException("Book already exits");
		 }
		 
		 record.setReturnDate(LocalDateTime.now());
		 record.setStatus(BorrowStatus.RETURNED);
		 
		 if(record.getReturnDate().isAfter(record.getDueDate())) {
			 double daysLate=ChronoUnit.DAYS.between(record.getDueDate(), record.getReturnDate());
			 record.setFineAmount(daysLate*10);
		 }
		 borrowDao.save(record);
		 
		 Book book=record.getBook();
		 book.setAvailableCopies(book.getAvailableCopies()+1);
		 bookDao.updateBook(book);
		 
		 ResponseStructure<String> response=new ResponseStructure<String>();
		 response.setStatus(HttpStatus.OK.value());
		 response.setMessage("Book returned sucessfully");
		 response.setData("Fine calculated if applicable");
		 
		 return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
	}
	
	//Get member borrow Record
	@Override
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getBorrowRecordByMember(Integer memberId) {
		List<BorrowRecord> records=borrowDao.findByMemberId(memberId);
		
		List<BorrowRecordDto> dtoList=new ArrayList<BorrowRecordDto>();
		for (BorrowRecord borrowRecord : records) {
			dtoList.add(BorrowRecordMapper.toDto(borrowRecord));
		}
		
		ResponseStructure<List<BorrowRecordDto>> response=new ResponseStructure<List<BorrowRecordDto>>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Borrow records retived successfully");
		response.setData(dtoList);
		
		return new ResponseEntity<ResponseStructure<List<BorrowRecordDto>>>(response,HttpStatus.OK);
	}
	
	//Overdue Books
	public ResponseEntity<ResponseStructure<List<BorrowRecordDto>>> getOverDueBooks() {
		List<BorrowRecord> record=borrowDao.findOverdueRecords();
		
		List<BorrowRecordDto> dtoList=new ArrayList<BorrowRecordDto>();
		for (BorrowRecord borrowRecord : record) {
			dtoList.add(BorrowRecordMapper.toDto(borrowRecord));
		}
		
		ResponseStructure<List<BorrowRecordDto>> response=new ResponseStructure<List<BorrowRecordDto>>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Overdue books retrieved successfully");
		response.setData(dtoList);
		
		return new ResponseEntity<ResponseStructure<List<BorrowRecordDto>>>(response,HttpStatus.OK);
	}
}

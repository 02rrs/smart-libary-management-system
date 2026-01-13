package com.rishav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rishav.resource.ResponseStructure;

@ControllerAdvice
public class GlobleExceptionHanddler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BookIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handdleBookIdNotFoundException(BookIdNotFoundException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Book Id not found!!!");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MemberAlreadyExistsException.class)
	public ResponseEntity<ResponseStructure<String>> handdleMemberAlreadyExixtsException(MemberAlreadyExistsException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Member already exists!!!");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MemberIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handdleMemberIdNotFoundException(MemberIdNotFoundException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Member id not available");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MemberInactiveException.class)
	public ResponseEntity<ResponseStructure<String>> handdleMemberInactiveException(MemberInactiveException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Member is Inactive!!!");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoCopiesAvailableException.class)
	public ResponseEntity<ResponseStructure<String>> handdleNoCopiesAvailableException(NoCopiesAvailableException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("No more available Copies available");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BorrowRecordIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handdleBorrowRecordIdNotFoundException(BorrowRecordIdNotFoundException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Entered Borrow id doesn't exists!!");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookAlreadyReturnedException.class)
	public ResponseEntity<ResponseStructure<String>> handdleBookAlreadyReturnedException(BookAlreadyReturnedException e) {
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage("Book already exists");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
}

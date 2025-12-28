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
}

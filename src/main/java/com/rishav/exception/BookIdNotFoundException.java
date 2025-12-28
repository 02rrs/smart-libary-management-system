package com.rishav.exception;

public class BookIdNotFoundException extends RuntimeException{
	public BookIdNotFoundException(String msg) {
		super(msg);
	}
}

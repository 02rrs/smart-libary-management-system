package com.rishav.exception;

public class BookAlreadyReturnedException extends RuntimeException{
	public BookAlreadyReturnedException(String msg) {
		super(msg);
	}
}

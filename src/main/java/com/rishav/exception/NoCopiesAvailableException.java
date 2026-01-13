package com.rishav.exception;

public class NoCopiesAvailableException extends RuntimeException{
	public NoCopiesAvailableException(String msg) {
		super(msg);
	}
}

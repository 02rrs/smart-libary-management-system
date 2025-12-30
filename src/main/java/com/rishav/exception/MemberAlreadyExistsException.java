package com.rishav.exception;

public class MemberAlreadyExistsException extends RuntimeException{
	public MemberAlreadyExistsException(String msg) {
		super(msg);
	}
}

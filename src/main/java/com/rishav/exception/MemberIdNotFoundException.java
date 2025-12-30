package com.rishav.exception;

public class MemberIdNotFoundException extends RuntimeException{
	public MemberIdNotFoundException(String msg) {
		super(msg);
	}
}

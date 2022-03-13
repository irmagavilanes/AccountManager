package com.att.data.account.service;

public class AOMException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657615464662880095L;
	
	public AOMException() {
		super();
	}
	
	public AOMException(String message) {
		super(message);
	}
	
	public AOMException(String message, Throwable e) {
		super(message, e);
	}

}

package com.onlinemarketplace.exception;

public class InvalidEnumException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEnumException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidEnumException(String arg0) {
		super(arg0);
	}

}

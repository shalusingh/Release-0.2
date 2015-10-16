package com.onlinemarketplace.exception;

/**
 * 
 */
public class UnauthorizedAccess extends Exception {

	/**
	 *  Serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedAccess() {
		
		super("UnAuthorizedAccess : Please login to add new address");
	}

	public UnauthorizedAccess(String message, Throwable cause) {
		super("UnAuthorizedAccess :"+message, cause);
	}

	public UnauthorizedAccess(String message) {
		super(message);
	}
}

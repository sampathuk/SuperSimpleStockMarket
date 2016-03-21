package com.jpmc.sssm.exception;

public class SimpleStockMarketBusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8062649343608667178L;

	String errorMessage;
	String errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public SimpleStockMarketBusinessException() {
		super();
	}

	public SimpleStockMarketBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public SimpleStockMarketBusinessException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public SimpleStockMarketBusinessException(String message, String errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public SimpleStockMarketBusinessException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public SimpleStockMarketBusinessException(Throwable cause) {
		super(cause);

	}

}

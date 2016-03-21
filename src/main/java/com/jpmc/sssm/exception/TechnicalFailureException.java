package com.jpmc.sssm.exception;

public class TechnicalFailureException extends Exception {
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

	public TechnicalFailureException() {
		super();
	}

	public TechnicalFailureException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public TechnicalFailureException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public TechnicalFailureException(String message, String errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public TechnicalFailureException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public TechnicalFailureException(Throwable cause) {
		super(cause);
	}
}

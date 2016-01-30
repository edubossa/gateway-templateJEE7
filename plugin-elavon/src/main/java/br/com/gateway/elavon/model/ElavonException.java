package br.com.gateway.elavon.model;

public class ElavonException extends Exception {

	private static final long serialVersionUID = -110958715815793100L;

	public ElavonException() {
		super();
	}

	public ElavonException(String message) {
		super(message);
	}
	
	public ElavonException(Throwable cause) {
		super(cause);
	}
	
	public ElavonException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ElavonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}

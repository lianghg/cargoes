package cargoes.web.exception;

@SuppressWarnings("serial")
public class UserActivationException extends RuntimeException {

	private String message;

	public UserActivationException() {
		super();
	}

	public UserActivationException(String message) {
		super(message);
		this.message = message;
	}

	public UserActivationException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public UserActivationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package cargoes.exception;

@SuppressWarnings("serial")
public class ResourceNotFound extends RuntimeException {

	private String message;

	public ResourceNotFound() {
		super();
	}

	public ResourceNotFound(String message) {
		super(message);
		this.message = message;
	}

	public ResourceNotFound(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public ResourceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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

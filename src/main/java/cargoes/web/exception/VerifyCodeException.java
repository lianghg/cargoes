package cargoes.web.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class VerifyCodeException extends AuthenticationException {

	public VerifyCodeException(String msg) {
		super(msg);
	}

	public VerifyCodeException(String msg, Throwable t) {
		super(msg, t);
	}

}

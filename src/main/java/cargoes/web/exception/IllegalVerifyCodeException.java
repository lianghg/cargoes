package cargoes.web.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class IllegalVerifyCodeException extends AuthenticationException {
		public IllegalVerifyCodeException(String msg) {
			super(msg);
		}

		public IllegalVerifyCodeException(String msg, Throwable t) {
			super(msg, t);
		}
	}

package cargoes.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Value("${app.login.view.url}")
	private String loginViewUrl;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute(CustomAuthenticationProvider.AUTHENTICATION_FAILURE_COUNT);
		Boolean isShowedVerifyCodeImage = (Boolean) session.getAttribute(CustomAuthenticationProvider.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE);
		
		if(count == null){
			count = 0;
		}
		
		++count;
		
		if(isShowedVerifyCodeImage == null){
			session.setAttribute(CustomAuthenticationProvider.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE,false);
		}
		
		if(count > CustomAuthenticationProvider.AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE){
			session.setAttribute(CustomAuthenticationProvider.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE,true);
		}
		
		session.setAttribute(CustomAuthenticationProvider.AUTHENTICATION_FAILURE_COUNT,count);
		
		session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		session.setAttribute("error", true);
		
		redirectStrategy.sendRedirect(request, response, loginViewUrl);
		
	}
	
}

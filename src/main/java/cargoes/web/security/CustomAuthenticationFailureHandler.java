package cargoes.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import cargoes.web.mvc.MvcConfiguration;


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		
		updateFailureCount(session);
		
		redirectStrategy.sendRedirect(request, response, MvcConfiguration.LOGIN_PAGE_URL+"?error=true");
		
	}

	private void updateFailureCount(HttpSession session) {
		
		if(MvcConfiguration.AUTHENTICATION_VERIFYCODE_ENABLED){
			
			Integer failureCount = (Integer) session.getAttribute(MvcConfiguration.AUTHENTICATION_FAILURE_COUNT);
			Boolean isShowedVerifyCodeImage = (Boolean) session.getAttribute(MvcConfiguration.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY);
			
			if(failureCount == null){
				failureCount = 0;
			}
			
			if(isShowedVerifyCodeImage == null){
				session.setAttribute(MvcConfiguration.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY,false);
			}
			
			if(CustomWebAuthenticationDetails.checkFailuerCountMoreThanAllowedValue(failureCount)){
				session.setAttribute(MvcConfiguration.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY,true);
			}
			failureCount++;
			
			session.setAttribute(MvcConfiguration.AUTHENTICATION_FAILURE_COUNT,failureCount);
		}
	}
	
}

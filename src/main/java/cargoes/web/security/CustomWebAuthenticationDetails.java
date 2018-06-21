package cargoes.web.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

@SuppressWarnings("serial")
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	
	private final String verifyCode;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        verifyCode = request.getParameter("verifyCode");
    }

    public String getVerifyCode() {
        return verifyCode;
    }
    
}
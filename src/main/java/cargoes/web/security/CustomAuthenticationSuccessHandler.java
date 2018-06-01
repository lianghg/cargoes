package cargoes.web.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cargoes.model.po.OperationLog;
import cargoes.service.OperationLogService;
import cargoes.web.configuration.mvc.MvcConfiguration;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private OperationLogService operationLogService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {
		
		String ip = request.getRemoteAddr();
		String url = request.getRequestURL().toString();
		String requestType = request.getMethod();
		String username = request.getParameter("username");
		
		OperationLog operationLog = new OperationLog();
		operationLog.setUserId(username);
		operationLog.setIp(ip);
		operationLog.setRequestType(requestType);
		operationLog.setOperationDesc("登录认证");
		operationLog.setOperationStatus(OperationLog.OPERATION_STATUS_SUCCESS);
		operationLog.setRequestUrl(url);
		operationLog.setOperationTime(new Date());
		
		operationLogService.insert(operationLog);
		
		redirectStrategy.sendRedirect(request, response, MvcConfiguration.LOGIN_SUCCESS_URL); 
	}

}

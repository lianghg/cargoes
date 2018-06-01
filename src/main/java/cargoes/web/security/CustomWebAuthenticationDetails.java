package cargoes.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.google.code.kaptcha.Constants;

import cargoes.web.configuration.mvc.MvcConfiguration;

@SuppressWarnings("serial")
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	
	/** 提交的验证码**/
	private final String verifyCode;
	
	/** 系统生成的验证码 **/
	private final String verifyCodeInSession;
	
	/** 登录认证失败次数 **/
	private Integer failureCount;
	
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        HttpSession session = request.getSession();
        verifyCode = request.getParameter("verifyCode");
        verifyCodeInSession = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        failureCount = (Integer) session.getAttribute(MvcConfiguration.AUTHENTICATION_FAILURE_COUNT);
    }
    
    /**
     * 校验验证码
     * @return
     */
    public boolean checkVerifyCodeSameAsOneInSession(){
    	
    	if(verifyCode != null && verifyCode.equals(verifyCodeInSession)){
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * 检查登录失败次数：若失败次数超过允许上限或错误次数上限值小于1
	 * @param count
	 * @return true:
	 */
	public static boolean checkFailuerCountMoreThanAllowedValue(Integer failureCount) {
		
		if(MvcConfiguration.AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE < 1){
			return true;
		}
		
		if(failureCount != null && failureCount >= MvcConfiguration.AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE){
			return true;
		}
		
		return false;
	}
	
	 public Integer getFailureCount(){
	    	
	    	return failureCount;
	    }
	    
	    public String getVerifyCode() {
	        return verifyCode;
	    }
    
}
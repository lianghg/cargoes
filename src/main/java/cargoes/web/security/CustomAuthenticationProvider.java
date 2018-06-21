package cargoes.web.security;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.code.kaptcha.Constants;
import com.sboot.core.customException.VerifyCodeException;
import com.sboot.core.util.CustomStringUtil;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	/** 标识是否显示验证码-在session中的key **/
	public static final String AUTHENTICATION_SHOW_VERIFYCODE_IMAGE = "AUTHENTICATION_SHOW_VERIFYCODE_IMAGE";
	/** 认证失败次数-在session中的key **/
	public static final String AUTHENTICATION_FAILURE_COUNT = "AUTHENTICATION_FAILURE_COUNT";
	/** 可容忍认证失败的次数 **/
	public static final Integer AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE = 2;
	
	@Autowired
	private SecurityUserService securityUserService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//校验验证码
		if(!checkVerifyCode(authentication)){
			throw new VerifyCodeException("验证码错误");
		}
		
		String errorMsg = "用户不存在或密码错误";
		
		//数据库查询用户信息
		String username = authentication.getPrincipal().toString();
		UserDetails user = securityUserService.loadUserByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException(errorMsg);
		}
		
		//生密码加密
		String salt = ".efvhu5";
		String encPass = user.getPassword();
		String rawPass = authentication.getCredentials().toString();
		String password = CustomStringUtil.md5PasswordEncoder(rawPass, salt);
		
		//密码校验
		boolean isSamePassword = encPass.equals(password);
		
		if(isSamePassword){
			return new UsernamePasswordAuthenticationToken(username,encPass,user.getAuthorities());
		}else{
			throw new AuthenticationCredentialsNotFoundException(errorMsg);
		}

	}

	/**
	 * 校验验证码
	 * @param authentication
	 * @return
	 */
	private boolean checkVerifyCode(Authentication authentication) {
		
		HttpServletRequest req = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = req.getSession();
		Integer failureCount = (Integer) session.getAttribute(CustomAuthenticationProvider.AUTHENTICATION_FAILURE_COUNT);
		
		//判断是否达到错误次数
		if(checkFailureCountAllowed(failureCount)){
			
			CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();  
			String verifyCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
			String verifyCodeCopy = details.getVerifyCode();
			
			if(verifyCode == null || !verifyCode.equals(verifyCodeCopy)){
				return false;//验证码不相同
			}
		}
		return true;
	}
	
	
	
	/**
	 * 认证失败的次数是否达到上限
	 * @param count
	 * @return
	 */
	private boolean checkFailureCountAllowed(Integer failureCount) {
		
		if(failureCount != null && failureCount > CustomAuthenticationProvider.AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

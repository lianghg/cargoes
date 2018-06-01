package cargoes.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cargoes.model.po.SysUser;
import cargoes.web.configuration.i18n.MessageSourceUtils;
import cargoes.web.configuration.mvc.MvcConfiguration;
import cargoes.web.exception.VerifyCodeException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AuthenticationService securityUserService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 校验验证码
		checkVerifyCode(authentication);

		// 数据库查询用户信息
		String username = authentication.getPrincipal().toString();
		UserDetails user = securityUserService.loadUserByUsername(username);

		// 原生密码加密
		String salt = ((SysUser) user).getSalt();
		String encPass = user.getPassword();
		String rawPass = authentication.getCredentials().toString();
		String password = PasswordUtil.md5PasswordEncoder(rawPass, salt);

		// 密码校验
		if (encPass != null && encPass.equals(password)) {

			if (!user.isAccountNonExpired()) {
				throw new AccountExpiredException(MessageSourceUtils.getMessage("error.user.Expired"));//账号已过期
			}
			if (!user.isAccountNonLocked()) {
				throw new LockedException(MessageSourceUtils.getMessage("error.user.locked"));//账号已锁定
			}
			if (!user.isCredentialsNonExpired()) {
				throw new CredentialsExpiredException(MessageSourceUtils.getMessage("error.user.credentials-expired"));//"密码已过期
			}
			if (!user.isEnabled()) {
				throw new DisabledException(MessageSourceUtils.getMessage("error.user.disabled"));//账号已禁用
			}

			return new UsernamePasswordAuthenticationToken(username, encPass, user.getAuthorities());
		} else {
			throw new AuthenticationCredentialsNotFoundException(MessageSourceUtils.getMessage("error.user.authentication-credentials.not-found"));//账号不存在或密码错误
		}

	}

	/**
	 * 校验验证码
	 * 
	 * @param authentication
	 * @return
	 */
	private void checkVerifyCode(Authentication authentication) throws VerifyCodeException {

		if (!MvcConfiguration.AUTHENTICATION_VERIFYCODE_ENABLED) {
			return;
		}

		CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
		Integer failureCount = details.getFailureCount();
		// 认证次数是否超过允许上限
		if (CustomWebAuthenticationDetails.checkFailuerCountMoreThanAllowedValue(failureCount)) {
			// 校验验证码是否相同
			if (!details.checkVerifyCodeSameAsOneInSession()) {
				throw new VerifyCodeException(MessageSourceUtils.getMessage("error.verify-code.error"));//"验证码错误"
			}
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

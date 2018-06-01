package cargoes.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cargoes.dao.SysUserMapper;
import cargoes.model.po.SysUser;
import cargoes.web.configuration.i18n.MessageSourceUtils;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username == null || "".equals(username.trim())) {
			throw new UsernameNotFoundException(MessageSourceUtils.getMessage("error.user.input-username"));//"请输入账号"
		}

		SysUser user = sysUserMapper.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(MessageSourceUtils.getMessage("error.user.authentication-credentials.not-found"));
		}

		return user;

	}

}

package cargoes.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cargoes.dao.SysUserMapper;
import cargoes.model.po.SysUser;
import cargoes.util.MessageSourceUtils;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username == null || "".equals(username.trim())) {
			throw new UsernameNotFoundException(MessageSourceUtils.getMessage("请输入账号"));//"请输入账号"
		}

		SysUser user = sysUserMapper.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(MessageSourceUtils.getMessage("账号不存在或密码错误"));
		}

		return user;

	}

}

package cargoes.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sboot.core.model.po.User;
import com.sboot.usercenter.core.dao.UserMapper;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || "".equals(username)){
			throw new UsernameNotFoundException("请输入账号");
		}
		User user = userMapper.loadUserByUsername(username);
		if(user == null){
			return null;
		}

		org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(
				user.getUsername(), //
				user.getPassword(), //
				user.isEnabled(), //账号是否可用，true:可用
				user.isAccountNonExpired(), //账号是否过期，true:未过期
				user.isCredentialsNonExpired(), //密码是否过期，true:未过期
				user.isAccountNonLocked(), //账号是否锁住，true:未锁住
				user.getAuthorities()//
				);
		return authUser;

	}

}

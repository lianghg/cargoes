package cargoes.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.exception.ResourceNotFound;
import cargoes.exception.UserActivationException;
import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;
import cargoes.service.UserService;
import cargoes.util.MessageSourceUtils;
import cargoes.web.security.PasswordUtil;

@Service
public class UserServiceImpl extends AbstractServiceImpl<SysUser, SysUserExample> implements UserService {

	@Override
	public Page<SysUser> getUsersByPage(int pageNo, int pageSize) {

		Page<SysUser> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectByExample(null);

		return page;
	}

	@Override
	public SysUser selectByPrimaryKey(String id) {

		SysUser user = this.getMapper().selectByPrimaryKey(id);

		return user;
	}

	@Override
	public int activateUser(String id, String password, String comfirmPassword){

		SysUser user = this.getMapper().selectByPrimaryKey(id);
		
		if (user == null) {
			throw new ResourceNotFound(MessageSourceUtils.getMessage("error.user.not-found"));
		}
		if(user.getStatus() != null && 1 == user.getStatus()){
			throw new UserActivationException(MessageSourceUtils.getMessage("error.user.actied"));//"用户已激活"
		}
		if (password == null || !password.equals(comfirmPassword)) {
			throw new IllegalArgumentException(MessageSourceUtils.getMessage("error.user.password.not-same"));//"密码不一致"
		}
		String salt = "$@|t."+UUID.randomUUID().toString();
		
		user.setPassword(PasswordUtil.md5PasswordEncoder(password, salt));
		user.setSalt(salt);
		user.setStatus(1);
		user.setExpired(0);
		user.setLocked(0);
		user.setCredentialsExpired(0);

		return this.getMapper().updateByPrimaryKey(user);
	}

}

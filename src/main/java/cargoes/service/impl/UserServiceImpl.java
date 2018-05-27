package cargoes.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;
import cargoes.service.UserService;
import cargoes.web.exception.ResourceNotFound;
import cargoes.web.exception.UserActivationException;

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
			throw new ResourceNotFound("用户资源不存在");
		}
		if(user.getStatus() != null && 1 == user.getStatus()){
			throw new UserActivationException("用户已激活");
		}
		if (password == null || !password.equals(comfirmPassword)) {
			throw new IllegalArgumentException("密码不一致");
		}
		
		user.setPassword(password);
		user.setExpired(0);
		user.setStatus(1);
		user.setDisabled(0);

		return this.getMapper().updateByPrimaryKey(user);
	}

}

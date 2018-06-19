package cargoes.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cargoes.dao.SysUserMapper;
import cargoes.model.po.SysUser;
import cargoes.service.UserService;
import cargoes.web.exception.ResourceNotFound;
import cargoes.web.exception.UserActivationException;

@Service
public class UserServiceImpl extends AbstractServiceImpl<SysUser> implements UserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUserMapper getMapper() {
		return sysUserMapper;
	}

	@Override
	public PageInfo<SysUser> getUsersByPage(int pageNo, int pageSize) {

		Page<SysUser> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectList();
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(page);
		return pageInfo;
	}

	@Override
	public SysUser selectByPrimaryKey(String id) {

		SysUser user = this.getMapper().selectByPrimaryKey(id);

		return user;
	}

	@Override
	public SysUser loadUserByUsername(String username) {

		return this.getMapper().loadUserByUsername(username);
	}

	@Override
	public int activateUser(String id, String password, String comfirmPassword) {

		SysUser user = this.getMapper().selectByPrimaryKey(id);
		SysUser tempUser = new SysUser();

		if (user == null) {
			throw new ResourceNotFound("用户不存在");
		}
		if (user.getStatus() != null && 1 == user.getStatus()) {
			throw new UserActivationException("用户已激活");//
		}
		if (password == null || !password.equals(comfirmPassword)) {
			throw new IllegalArgumentException("密码不一致");//
		}
		String salt = "$@lt." + UUID.randomUUID().toString();
		
		tempUser.setId(user.getId());
		tempUser.setPassword(password);
		tempUser.setSalt(salt);
		tempUser.setStatus(1);
		tempUser.setExpired(0);
		tempUser.setLocked(0);
		tempUser.setCredentialsExpired(0);

		return this.getMapper().updateByPrimaryKeySelective(tempUser);
	}

	@Override
	public int changePassword(String id, String oldPassword, String password, String comfirmPassword) {
		
		SysUser user = this.getMapper().selectByPrimaryKey(id);
		SysUser tempUser = new SysUser();

		if (user == null) {
			throw new ResourceNotFound("用户不存在");
		}
		if(!user.getPassword().equals(oldPassword)){
			throw new IllegalArgumentException("旧密码不正确");//
		}
		if (password == null || !password.equals(comfirmPassword)) {
			throw new IllegalArgumentException("密码不一致");//
		}
		
		tempUser.setId(user.getId());
		tempUser.setPassword(password);
		
		return this.getMapper().updateByPrimaryKeySelective(tempUser);
	}

	

}

package cargoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.dao.SysUserMapper;
import cargoes.model.po.SysUser;
import cargoes.service.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<SysUser> implements UserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUserMapper getMapper() {
		return sysUserMapper;
	}
	
	@Override
	public Page<SysUser> getUsersByPage(int pageNo, int pageSize) {

		Page<SysUser> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectList();

		return page;
	}

	@Override
	public SysUser selectByPrimaryKey(String id) {

		SysUser user = this.getMapper().selectByPrimaryKey(id);

		return user;
	}

	@Override
	public int activateUser(String id, String password, String comfirmPassword){

		return 0;
	}


}

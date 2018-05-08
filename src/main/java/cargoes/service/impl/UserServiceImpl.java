package cargoes.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;
import cargoes.service.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<SysUser,SysUserExample> implements UserService {

	@Override
	public Page<SysUser> getUsersByPage(int pageNo, int pageSize) {
		
		Page<SysUser> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectByExample(null);
		
		return page;
	}

}

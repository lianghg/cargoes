package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;


public interface UserService extends AbstractService<SysUser,SysUserExample>{

	public Page<SysUser> getUsersByPage(int pageNo, int pageSize);
	
	
}

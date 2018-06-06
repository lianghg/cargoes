package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.SysUser;


public interface UserService extends AbstractService<SysUser>{

	public Page<SysUser> getUsersByPage(int pageNo, int pageSize);

	public int activateUser(String id, String password, String comfirmPassword);
	
}

package cargoes.service;

import com.github.pagehelper.PageInfo;

import cargoes.model.po.SysUser;


public interface UserService extends AbstractService<SysUser>{

	public PageInfo<SysUser> getUsersByPage(int pageNo, int pageSize);

	SysUser loadUserByUsername(String username);
	
	public int activateUser(String id, String password, String comfirmPassword);
	
	public int changePassword(String id, String oldPassword, String password, String comfirmPassword);
	
	
	
	
}

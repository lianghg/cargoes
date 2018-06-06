package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.Role;

public interface RoleService extends AbstractService<Role>{
   
	public Page<Role> getRolesByPage(int pageNo, int pageSize);
}
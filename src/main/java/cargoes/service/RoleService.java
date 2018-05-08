package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.Role;
import cargoes.model.po.RoleExample;

public interface RoleService extends AbstractService<Role,RoleExample>{
   
	public Page<Role> getRolesByPage(int pageNo, int pageSize);
}
package cargoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.dao.RoleMapper;
import cargoes.model.po.Role;
import cargoes.service.RoleService;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role> implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public RoleMapper getMapper() {
		return roleMapper;
	}
	
	@Override
	public Page<Role> getRolesByPage(int pageNo, int pageSize) {
		Page<Role> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectList();
		
		return page;
	}
   
}
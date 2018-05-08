package cargoes.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.model.po.Role;
import cargoes.model.po.RoleExample;
import cargoes.service.RoleService;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role,RoleExample> implements RoleService{

	@Override
	public Page<Role> getRolesByPage(int pageNo, int pageSize) {
		Page<Role> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectByExample(null);
		
		return page;
	}
   
}
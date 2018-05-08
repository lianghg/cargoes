package cargoes.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.model.po.Department;
import cargoes.model.po.DepartmentExample;
import cargoes.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends AbstractServiceImpl<Department,DepartmentExample> implements DepartmentService{

	@Override
	public Page<Department> getDepartmentsByPage(int pageNo, int pageSize) {
		Page<Department> page = PageHelper.startPage(pageNo, pageSize);
		this.getMapper().selectByExample(null);
		
		return page;
	}
    
}
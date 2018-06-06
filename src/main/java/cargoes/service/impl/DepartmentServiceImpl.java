package cargoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cargoes.dao.DepartmentMapper;
import cargoes.model.po.Department;
import cargoes.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends AbstractServiceImpl<Department> implements DepartmentService{

	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public DepartmentMapper getMapper() {
		return departmentMapper;
	}
	
	@Override
	public Page<Department> getDepartmentsByPage(int pageNo, int pageSize) {
		Page<Department> page = PageHelper.startPage(pageNo, pageSize);
//		this.getMapper().selectByExample(null);
		
		return page;
	}
    
}
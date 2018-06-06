package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.Department;

public interface DepartmentService extends AbstractService<Department>{
    
	public Page<Department> getDepartmentsByPage(int pageNo, int pageSize);
}
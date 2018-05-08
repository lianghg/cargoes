package cargoes.service;

import com.github.pagehelper.Page;

import cargoes.model.po.Department;
import cargoes.model.po.DepartmentExample;

public interface DepartmentService extends AbstractService<Department,DepartmentExample>{
    
	public Page<Department> getDepartmentsByPage(int pageNo, int pageSize);
}
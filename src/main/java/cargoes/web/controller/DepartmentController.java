package cargoes.web.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cargoes.model.po.Department;
import cargoes.plugin.paging.PagePlugin;
import cargoes.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable(name="id") String id){
		
		Department department =  null;//departmentService.selectByPrimaryKey(id);
		
		return new ResponseEntity<Department>(department,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable(name="id") String id){
		
		departmentService.deleteByPrimaryKey(id);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> updateDepartment(@PathVariable(name="id") String id, @RequestBody Department tempDepartment){
		
		Department department =  null;//departmentService.selectByPrimaryKey(id);
		BeanUtils.copyProperties(tempDepartment, department, "id");
		departmentService.updateByPrimaryKeySelective(department);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/")
	public ResponseEntity<String> addDepartment(@RequestBody Department record){
		
		record.setCreateTime(new Date());
		departmentService.insertSelective(record);
		
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/")
	public ResponseEntity<PagePlugin<Page<Department>>> listDepartment(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize){
		
		Page<Department> page = departmentService.getDepartmentsByPage(pageNo, pageSize);
		PagePlugin<Page<Department>> pagePlugin = new PagePlugin<Page<Department>>(pageNo, pageSize, page.getTotal(), page);
		
		return new ResponseEntity<PagePlugin<Page<Department>>>(pagePlugin, HttpStatus.OK);
		
	}
}

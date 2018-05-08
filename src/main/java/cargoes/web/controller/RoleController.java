package cargoes.web.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cargoes.model.po.Role;
import cargoes.plugin.paging.PagePlugin;
import cargoes.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Role> getRole(@PathVariable(name="id") String id){
		
		Role role = roleService.selectByPrimaryKey(id);
		
		return new ResponseEntity<Role>(role,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteRole(@PathVariable(name="id") String id){
		
		roleService.deleteByPrimaryKey(id);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> updateRole(@PathVariable(name="id") String id, @RequestBody Role tempRole){
		
		Role role = roleService.selectByPrimaryKey(id);
		BeanUtils.copyProperties(tempRole, role, "id");
		roleService.updateByPrimaryKeySelective(role);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	@GetMapping(value="/")
	public ResponseEntity<String> addRole(@RequestBody Role record){
		
		record.setCreateTime(new Date());
		roleService.insertSelective(record);
		
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/{pageNo}/{pageSize}")
	public ResponseEntity<PagePlugin<Page<Role>>> listRole(@PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize){
		
		Page<Role> page = roleService.getRolesByPage(pageNo, pageSize);
		PagePlugin<Page<Role>> pagePlugin = new PagePlugin<Page<Role>>(pageNo, pageSize, page.getTotal(), page);
		
		return new ResponseEntity<PagePlugin<Page<Role>>>(pagePlugin, HttpStatus.OK);
		
	}
		
}

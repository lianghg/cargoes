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
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cargoes.model.po.SysUser;
import cargoes.plugin.paging.PagePlugin;
import cargoes.service.UserService;
	
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<SysUser> getUser(@PathVariable(name="id") String id){
		
		SysUser user = userService.selectByPrimaryKey(id);
		
		return new ResponseEntity<SysUser>(user,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name="id") String id){
		
		userService.deleteByPrimaryKey(id);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(name="id") String id, @RequestBody SysUser tempUser){
		
		SysUser user = userService.selectByPrimaryKey(id);
		BeanUtils.copyProperties(tempUser, user, "id");
		userService.updateByPrimaryKeySelective(user);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/")
	public ResponseEntity<String> addUser(@RequestBody SysUser record){
		
		record.setCreateTime(new Date());
		userService.insertSelective(record);
		
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/{pageNo}/{pageSize}")
	public ResponseEntity<PagePlugin<Page<SysUser>>> listUser(@PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize){
		
		Page<SysUser> page = userService.getUsersByPage(pageNo, pageSize);
		PagePlugin<Page<SysUser>> pagePlugin = new PagePlugin<Page<SysUser>>(pageNo, pageSize, page.getTotal(), page);
		
		return new ResponseEntity<PagePlugin<Page<SysUser>>>(pagePlugin, HttpStatus.OK);
		
	}

}

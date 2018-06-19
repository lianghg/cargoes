package cargoes.web.controller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cargoes.model.dto.DataEntity;
import cargoes.model.po.Authority;
import cargoes.model.po.Role;
import cargoes.model.po.SysUser;
import cargoes.service.AuthorityService;
import cargoes.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;
	
	
	/**
	 * 根据ID查询角色
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<DataEntity<Role>> getRole(@PathVariable(name="id") String id){
		
		Role role = roleService.selectByPrimaryKey(id);
		
		DataEntity<Role> dataEntity = new DataEntity<Role>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("查询成功");
		dataEntity.setResult(role);
		
		return new ResponseEntity<DataEntity<Role>>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 根据ID删除角色
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<DataEntity> deleteRole(@PathVariable(name="id") String id){
		
		roleService.deleteByPrimaryKey(id);
		
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 根据一组ID删除多个角色
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value="", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DataEntity> deleteRoles(@RequestParam("ids[]") List<String> ids){
		
		roleService.deleteByPrimaryKeys(ids);
		
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
	}
	
	/**
	 * 根据ID更新角色
	 * @param id
	 * @param tempUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping(value="/{id}")
	public ResponseEntity<DataEntity> updateRole(@PathVariable(name="id") String id, Role roleDto, List<String> authorityIds){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(authorityIds);
		
		Role role = roleService.selectByPrimaryKey(id);
		
		role.setModifyTime(new Date());
		role.setCode(roleDto.getCode());
		role.setName(roleDto.getName());
		role.setOrder(roleDto.getOrder());
		role.setStatus(roleDto.getStatus());
		role.setAuthorities(authorities);
		
		roleService.updateByPrimaryKey(role);
		//
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("更新成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 根据ID按需要更新角色
	 * @param id
	 * @param tempUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PatchMapping(value="/{id}")
	public ResponseEntity<DataEntity> updateRoleSelective(@PathVariable(name="id") String id, Role roleDto, List<String> authorityIds){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(authorityIds);
		
		Role role = roleService.selectByPrimaryKey(id);
		
		role.setModifyTime(new Date());
		role.setCode(roleDto.getCode());
		role.setName(roleDto.getName());
		role.setOrder(roleDto.getOrder());
		role.setStatus(roleDto.getStatus());
		role.setAuthorities(authorities);
		
		roleService.updateByPrimaryKeySelective(role);
		//
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("更新成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/")
	public ResponseEntity<DataEntity> addRoleSelective(Role role, List<String> authorityIds){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(authorityIds);
		
		role.setCreateTime(new Date());
		role.setAuthorities(authorities);
		
		roleService.insertSelective(role);
		//
		DataEntity dataEntity = new DataEntity<SysUser>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.CREATED.value());
		dataEntity.setMessage("添加成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.CREATED);
		
	}
	
	/**
	 * 分页查询角色列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "",headers="api-version=1.1")
	public ResponseEntity<DataEntity<PageInfo<Role>>> listRole(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize) {

		Page<Role> sourcePage = roleService.getRolesByPage(pageNo, pageSize);
		
		PageInfo<Role> pageInfo = new PageInfo<Role>(sourcePage);
		//
		DataEntity<PageInfo<Role>> dataEntity = new DataEntity<PageInfo<Role>>();
		dataEntity.setFlag(true);
		dataEntity.setMessage("查询成功");
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(pageInfo);

		return new ResponseEntity<DataEntity<PageInfo<Role>>>(dataEntity, HttpStatus.OK);

	}
		
}

package cargoes.web.controller;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cargoes.model.dto.DataEntity;
import cargoes.model.dto.RoleInDto;
import cargoes.model.dto.RoleOutDto;
import cargoes.model.po.Authority;
import cargoes.model.po.Role;
import cargoes.model.po.SysUser;
import cargoes.service.AuthorityService;
import cargoes.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private ModelMapper modelMapper;

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
	public ResponseEntity<DataEntity<RoleOutDto>> getRole(@PathVariable(name="id") String id){
		
		Role role = roleService.selectByPrimaryKey(id);
		
		RoleOutDto roleOutDto = modelMapper.map(role, RoleOutDto.class);
		
		DataEntity<RoleOutDto> dataEntity = new DataEntity<RoleOutDto>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("查询成功");
		dataEntity.setResult(roleOutDto);
		
		return new ResponseEntity<DataEntity<RoleOutDto>>(dataEntity,HttpStatus.OK);
		
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
	public ResponseEntity<DataEntity> deleteRoles(@RequestBody List<String> ids){
		
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
	public ResponseEntity<DataEntity> updateRole(@PathVariable(name="id") String id, RoleInDto roleDto){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(roleDto.getAuthorityIds());
		
		Role role = roleService.selectByPrimaryKey(id);
		
		Role r = modelMapper.map(roleDto, Role.class);
		role.setModifyTime(new Date());
		role.setCode(r.getCode());
		role.setName(r.getName());
		role.setOrder(r.getOrder());
		role.setStatus(r.getStatus());
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
	public ResponseEntity<DataEntity> updateRoleSelective(@PathVariable(name="id") String id, @RequestBody RoleInDto roleDto){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(roleDto.getAuthorityIds());
		
		Role role = roleService.selectByPrimaryKey(id);
		
		Role r = modelMapper.map(roleDto, Role.class);
		role.setModifyTime(new Date());
		role.setCode(r.getCode());
		role.setName(r.getName());
		role.setOrder(r.getOrder());
		role.setStatus(r.getStatus());
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
	 * @param tempUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/")
	public ResponseEntity<DataEntity> addRoleSelective(@RequestBody RoleInDto roleDto){
		
		List<Authority> authorities = authorityService.selectByPrimaryKeys(roleDto.getAuthorityIds());
		
		Role role = modelMapper.map(roleDto, Role.class);
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
	public ResponseEntity<DataEntity<PageInfo<RoleOutDto>>> listRole(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize) {

		Page<Role> sourcePage = roleService.getRolesByPage(pageNo, pageSize);
		
		Type type = new TypeToken<PageInfo<RoleOutDto>>() {}.getType();
		PageInfo<RoleOutDto> pageInfo = modelMapper.map(sourcePage, type);
		
		//
		DataEntity<PageInfo<RoleOutDto>> dataEntity = new DataEntity<PageInfo<RoleOutDto>>();
		dataEntity.setFlag(true);
		dataEntity.setMessage("查询成功");
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(pageInfo);

		return new ResponseEntity<DataEntity<PageInfo<RoleOutDto>>>(dataEntity, HttpStatus.OK);

	}
		
}

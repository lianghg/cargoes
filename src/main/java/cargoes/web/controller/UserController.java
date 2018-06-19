package cargoes.web.controller;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.github.pagehelper.PageInfo;

import cargoes.model.dto.DataEntity;
import cargoes.model.dto.SysUserInDto;
import cargoes.model.dto.SysUserOutDto;
import cargoes.model.po.Department;
import cargoes.model.po.Role;
import cargoes.model.po.SysUser;
import cargoes.service.DepartmentService;
import cargoes.service.RoleService;
import cargoes.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	 @Autowired
	 private RoleService roleService;

	 @Autowired
	 private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * 根据ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<DataEntity<SysUserOutDto>> getUser(@PathVariable(name = "id") String id) {

		SysUser user = userService.selectByPrimaryKey(id);

		SysUserOutDto sysUserDto = modelMapper.map(user, SysUserOutDto.class);

		DataEntity<SysUserOutDto> dataEntity = new DataEntity<SysUserOutDto>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("查询成功");
		dataEntity.setResult(sysUserDto);

		return new ResponseEntity<DataEntity<SysUserOutDto>>(dataEntity, HttpStatus.OK);

	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<DataEntity> deleteUser(@PathVariable(name = "id") String id) {

		userService.deleteByPrimaryKey(id);

		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);

	}

	/**
	 * 根据一组ID删除多个用户
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "")
	public ResponseEntity<DataEntity> deleteUsers(@RequestParam("ids[]") List<String> ids) {

		userService.deleteByPrimaryKeys(ids);

		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);
	}

	/**
	 * 根据ID更新用户
	 * 
	 * @param id
	 * @param userDto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/{id}")
	public ResponseEntity<DataEntity> updateUser(@PathVariable(name = "id") String id,  SysUserInDto userDto) {
		
		List<Role> role = roleService.selectByPrimaryKeys(userDto.getRoleIds());
		Department department = departmentService.selectByPrimaryKey(userDto.getDepartmentId());

		SysUser user = userService.selectByPrimaryKey(id);
		SysUser u = modelMapper.map(userDto, SysUser.class);
		user.setDepartment(department);
		user.setRoles(role);
		user.setBirthday(u.getBirthday());
		user.setCredentialsExpired(u.getCredentialsExpired());
		user.setEmail(u.getEmail());
		user.setExpired(u.getExpired());
		user.setGender(u.getGender());
		user.setStatus(u.getStatus());
		user.setName(u.getName());
		user.setModifyTime(new Date());

		userService.updateByPrimaryKey(user);

		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("更新成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);

	}

	/**
	 * 新增用户
	 * 
	 * @param userInDto
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/")
	public ResponseEntity<DataEntity> addUser(SysUserInDto userDto) {

		List<Role> role = roleService.selectByPrimaryKeys(userDto.getRoleIds());
		Department department = departmentService.selectByPrimaryKey(userDto.getDepartmentId());
		
		SysUser user = modelMapper.map(userDto, SysUser.class);
		user.setCreateTime(new Date());
		user.setExpired(0);
		user.setLocked(0);
		user.setStatus(0);
		user.setCredentialsExpired(0);
		user.setDepartment(department);
		user.setRoles(role);

		userService.insertSelective(user);

		DataEntity dataEntity = new DataEntity<SysUser>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.CREATED.value());
		dataEntity.setMessage("添加成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.CREATED);

	}

	/**
	 * 分页查询用户列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "", headers = "api-version=1.1")
	public ResponseEntity<DataEntity<PageInfo<SysUserOutDto>>> listUser(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize) {

		PageInfo<SysUser> sourcePage = userService.getUsersByPage(pageNo, pageSize);
		Type type = new TypeToken<PageInfo<SysUserOutDto>>() {}.getType();
		PageInfo<SysUserOutDto> pageInfo = modelMapper.map(sourcePage, type);
		//
		DataEntity<PageInfo<SysUserOutDto>> dataEntity = new DataEntity<PageInfo<SysUserOutDto>>();
		dataEntity.setFlag(true);
		dataEntity.setMessage("查询成功");
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(pageInfo);

		return new ResponseEntity<DataEntity<PageInfo<SysUserOutDto>>>(dataEntity, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/activation")
	public ResponseEntity<DataEntity> activateUser(String id, String password, String comfirmPassword) {

		userService.activateUser(id, password, comfirmPassword);

		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("账号激活成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);

	}
}

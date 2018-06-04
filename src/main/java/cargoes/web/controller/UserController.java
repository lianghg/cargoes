package cargoes.web.controller;

import java.util.Date;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import cargoes.annotation.Operation;
import cargoes.exception.ResourceNotFound;
import cargoes.model.dto.SysUserAddDto;
import cargoes.model.dto.SysUserEditedDto;
import cargoes.model.dto.SysUserInfoDto;
import cargoes.model.po.SysUser;
import cargoes.model.vo.DefaultDataEntity;
import cargoes.plugin.paging.PagePlugin;
import cargoes.service.UserService;
import cargoes.util.MessageSourceUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Operation("查询用户")
	@ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "string", name = "id", value = "用户ID", required = true, paramType = "path") })
	@GetMapping(value = "/{id}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreAuthorize("hasAuthority('AUTH_SLT_USER_BY_ID')")
	public ResponseEntity<Map<String, Object>> getUser(@PathVariable(name = "id") String id) {
		

		SysUser user = userService.selectByPrimaryKey(id);
		if (user == null) {
			throw new ResourceNotFound(MessageSourceUtils.getMessage("error.user.not-found"));
		}

		SysUserInfoDto userInfo = new SysUserInfoDto();
		BeanUtils.copyProperties(user, userInfo);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.common.query-success"));
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(userInfo);

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.OK);

	}

	@Operation("删除用户")
	@ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "string", name = "id", value = "用户ID", required = true, paramType = "path") })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable(name = "id") @NotBlank(message="ID不能为空") String id) {

		userService.deleteByPrimaryKey(id);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.common.delete-success"));
		dataEntity.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.OK);

	}

	@Operation("更新用户")
	@ApiOperation(value = "更新用户", notes = "根据用户ID更新用户，不提交的属性更新为空（NULL）")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "string", name = "id", value = "用户ID", required = true, paramType = "path"),
			@ApiImplicitParam(dataType = "SysUserEditedDto", name = "tempUser", value = "json格式的数据", required = true, paramType = "body") })
	@ApiResponses({ @ApiResponse(code = 200, message = "更新成功") })
	@PutMapping(value = "/{id}",consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> updateUser(@PathVariable(name="id") String id, @RequestBody SysUserEditedDto tempUser) {

		SysUser user = userService.selectByPrimaryKey(id);
		if (user == null) {
			throw new ResourceNotFound(MessageSourceUtils.getMessage("error.user.not-found"));
		}

		BeanUtils.copyProperties(tempUser, user,"id","username");
		user.setModifyTime(new Date());
		userService.updateByPrimaryKey(user);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.common.update-success"));//更新成功
		dataEntity.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.OK);

	}
	
	@Operation("添加用户")
	@ApiOperation(value = "添加用户", notes = "添加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "SysUserAddDto", name = "tempUser", value = "json格式的数据", required = true, paramType = "body") })
	@ApiResponses({ @ApiResponse(code = 201, message = "添加成功") })
	@PostMapping(value = "/",consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody SysUserAddDto tempUser) {
		SysUser user = new SysUser();
		BeanUtils.copyProperties(tempUser, user);
		user.setCreateTime(new Date());
		user.setStatus(0);
		userService.insertSelective(user);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.common.add-success"));
		dataEntity.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.CREATED);

	}

	@Operation("分页查询用户")
	@ApiOperation(value = "分页查询用户", notes = "分页查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(defaultValue = "1", dataType = "int", name = "page_no", value = "页码，默认：1", paramType = "query"),
			@ApiImplicitParam(defaultValue = "10", dataType = "int", name = "page_size", value = "单页记录数量，默认：10", paramType = "query") })
	@GetMapping(value = "", headers = "api-version=1.1")
	public ResponseEntity<Map<String, Object>> listUser(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize) {

		Page<SysUser> sourcePage = userService.getUsersByPage(pageNo, pageSize);

		Page<SysUserInfoDto> page = new Page<SysUserInfoDto>();
		BeanUtils.copyProperties(sourcePage, page);
		if (sourcePage != null && sourcePage.size() > 0) {
			for (SysUser user : sourcePage) {
				SysUserInfoDto userInfo = new SysUserInfoDto();
				BeanUtils.copyProperties(user, userInfo);
				page.add(userInfo);
			}
		}

		PagePlugin<Page<SysUserInfoDto>> pagePlugin = new PagePlugin<Page<SysUserInfoDto>>(pageNo, pageSize,
				sourcePage.getTotal(), page);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.common.query-success"));
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(pagePlugin);

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.OK);

	}

	@Operation("激活或账号")
	@ApiOperation(value = "激活或账号", notes = "设置密码，激活账号")
	@ApiImplicitParams({ @ApiImplicitParam(dataType = "string", name = "id", value = "访问令牌", required = true, paramType = "query"),
			@ApiImplicitParam(dataType = "string", name = "password", value = "密码", required = true, paramType = "form"),
			@ApiImplicitParam(dataType = "string", name = "comfirmPassword", value = "确认密码", required = true, paramType = "form") })
	@PutMapping(value = "/activation")
	public ResponseEntity<Map<String, Object>> activateUser(
			@RequestParam(value = "id")
			String id,
			String password, 
			String comfirmPassword){

		userService.activateUser(id, password, comfirmPassword);
		
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(true);
		dataEntity.setMessage(MessageSourceUtils.getMessage("msg.user.actived-success"));//账号激活成功
		dataEntity.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(dataEntity, HttpStatus.OK);

	}

}

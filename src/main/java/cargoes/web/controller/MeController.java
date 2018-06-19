package cargoes.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cargoes.model.dto.DataEntity;
import cargoes.model.dto.MeInDto;
import cargoes.model.dto.MeOutDto;
import cargoes.model.po.SysUser;
import cargoes.service.UserService;

@RestController
public class MeController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/me")
	public ResponseEntity<DataEntity<MeOutDto>> getUser(@PathVariable(name = "id") String id) {

		SysUser user = userService.selectByPrimaryKey(id);

		MeOutDto meOutDto = new MeOutDto();
		BeanUtils.copyProperties(user, meOutDto);
		
		DataEntity<MeOutDto> dataEntity = new DataEntity<MeOutDto>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("查询成功");
		dataEntity.setResult(meOutDto);

		return new ResponseEntity<DataEntity<MeOutDto>>(dataEntity, HttpStatus.OK);

	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/me")
	public ResponseEntity<DataEntity> changeInfo(@RequestBody MeInDto meInDto) {

		SysUser user = userService.selectByPrimaryKey(meInDto.getId());

		MeOutDto userInfo = new MeOutDto();
		BeanUtils.copyProperties(userInfo, user);
		userService.updateByPrimaryKey(user);
		
		DataEntity<MeOutDto> dataEntity = new DataEntity<MeOutDto>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("更新成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);

	}
	
	@SuppressWarnings("rawtypes")
	@PatchMapping(value = "/me/password")
	public ResponseEntity<DataEntity> changePassword(String id, String oldPassword, String password, String comfirmPassword) {

		userService.changePassword(id, oldPassword, password, comfirmPassword);
		
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("密码修改成功");

		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.OK);

	}
	
}

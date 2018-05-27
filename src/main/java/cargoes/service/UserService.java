package cargoes.service;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.github.pagehelper.Page;

import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;


public interface UserService extends AbstractService<SysUser,SysUserExample>{

	public Page<SysUser> getUsersByPage(@Min(value=1, message="页码应大于或等于1") int pageNo, @Min(value=1, message="单页记录数量应大于或等于1") int pageSize);

	public int activateUser(@NotBlank(message = "id不能为空") String id, @Length(message = "密码最小长度为6", min = 6) String password, String comfirmPassword);
	
}

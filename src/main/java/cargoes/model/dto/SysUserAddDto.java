package cargoes.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysUserAddDto {

	@ApiModelProperty(value = "用户名*", required = true, dataType = "string")
	private String username;

	@ApiModelProperty(value = "名称*", required = true, dataType = "string")
	private String name;

	@ApiModelProperty(value = "性别（0：女，1：男，2：未公开）", required = true, dataType = "int")
	private Integer gender;

	@ApiModelProperty(value = "手机号码", required = true, dataType = "string")
	private String phone;

	@ApiModelProperty(value = "邮箱", required = true, dataType = "string", example = "example@cargoes.top")
	private String email;

	@ApiModelProperty(value = "出生日期", required = true, dataType = "date", example = "1970-01-01")
	private Date birthday;

	@ApiModelProperty(value = "角色ID", required = true, dataType = "string")
	private String roleId;

	@ApiModelProperty(value = "部门ID", required = true, dataType = "string")
	private String departmentId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

}

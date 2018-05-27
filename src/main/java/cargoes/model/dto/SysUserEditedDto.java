package cargoes.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysUserEditedDto {
	
	@ApiModelProperty(value = "用户ID*", hidden=true, dataType = "string")
	private String id;

	@ApiModelProperty(value = "用户名*", dataType = "string")
	private String username;

	@ApiModelProperty(value = "名称*", dataType = "string")
	private String name;

	@ApiModelProperty(value = "性别（0：女，1：男，2：未公开）", dataType = "int")
	private Integer gender;

	@ApiModelProperty(value = "手机号码", dataType = "string")
	private String phone;

	@ApiModelProperty(value = "邮箱", dataType = "string", example = "example@cargoes.top")
	private String email;

	@ApiModelProperty(value = "出生日期", dataType = "date", example = "1970-01-01")
	private Date birthday;

	@ApiModelProperty(value = "角色ID", dataType = "string")
	private String roleId;

	@ApiModelProperty(value = "部门ID", dataType = "string")
	private String departmentId;

	@ApiModelProperty(value = "账号状态，0：未激活，1：已激活，默认值:0）", dataType = "int")
	private Integer status;

	@ApiModelProperty(value = "账号是否过期，0：未过期，1：过期，默认值:1", dataType = "int")
	private Integer expired;

	@ApiModelProperty(value = "账号是否可用,0：不可用，1：可用，默认值:0", dataType = "int")
	private Integer disabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getExpired() {
		return expired;
	}

	public void setExpired(Integer expired) {
		this.expired = expired;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	
}

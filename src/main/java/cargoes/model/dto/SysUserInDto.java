package cargoes.model.dto;

import java.util.Date;
import java.util.List;

public class SysUserInDto {

	private String name;

	private String username;

	private Integer gender;

	private String phone;

	private String email;

	private Date birthday;

	private Integer status;

	private Integer expired;

	private Integer locked;

	private String departmentId;

	private List<String> roleIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	
}
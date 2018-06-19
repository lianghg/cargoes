package cargoes.model.dto;

import java.util.Date;
import java.util.List;

public class SysUserOutDto {

	private String id;

	private String name;

	private String username;

	private Integer gender;

	private String phone;

	private String email;

	private Date birthday;

	private Date createTime;

	private Integer status;

	private Integer expired;

	private Integer locked;

	private Integer credentialsExpired;

	private DepartmentOutDto department;

	private List<RoleOutDto> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Integer getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(Integer credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public DepartmentOutDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentOutDto department) {
		this.department = department;
	}

	public List<RoleOutDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleOutDto> roles) {
		this.roles = roles;
	}
	

}
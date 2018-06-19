package cargoes.model.dto;

import java.util.Date;
import java.util.List;

public class MeOutDto {
	
	private String id;

	private String name;

	private String username;

	private Integer gender;

	private String phone;

	private String email;

	private Date birthday;

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

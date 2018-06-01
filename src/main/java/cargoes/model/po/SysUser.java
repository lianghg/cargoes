package cargoes.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class SysUser implements UserDetails {

	private List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>(0);

	private List<Role> roles = new ArrayList<Role>(0);

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private String id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.name
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.username
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@NotBlank(message = "error.user.username.rule.not-blank")
	private String username;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private String password;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.gender
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@Range(min = 0, max = 1, message = "error.user.gender.rule.range")
	private Integer gender;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.phone
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "error.user.phone.rule.pattern")//请输入正确的手机号码
	private String phone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.email
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@NotBlank(message="error.user.email.rule.not-blank")//请输入邮箱
	@Email(message = "error.user.email.rule.email")//请输入正确的邮箱
	private String email;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.birthday
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@Past(message = "error.user.birthday.rule.past")//请输入正确的出生日期
	private Date birthday;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.department_id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private String departmentId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.create_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@NotNull(message = "error.user.create-time.rule.not-null")//创建日期缺失
	private Date createTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.modify_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@Past(message = "error.user.modify-time.rule.past")//修改日期有误
	private Date modifyTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.salt
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private String salt;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.last_change_password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	@Past(message = "error.user.last-change-password.rule.past")//修改密码日期有误
	private Date lastChangePassword;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.status
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private Integer status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private Integer expired;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.locked
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private Integer locked;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column sys_user.credentials_expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	private Integer credentialsExpired;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.id
	 *
	 * @return the value of sys_user.id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.id
	 *
	 * @param id
	 *            the value for sys_user.id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.name
	 *
	 * @return the value of sys_user.name
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.name
	 *
	 * @param name
	 *            the value for sys_user.name
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.username
	 *
	 * @return the value of sys_user.username
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.username
	 *
	 * @param username
	 *            the value for sys_user.username
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.password
	 *
	 * @return the value of sys_user.password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.password
	 *
	 * @param password
	 *            the value for sys_user.password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.gender
	 *
	 * @return the value of sys_user.gender
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.gender
	 *
	 * @param gender
	 *            the value for sys_user.gender
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.phone
	 *
	 * @return the value of sys_user.phone
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.phone
	 *
	 * @param phone
	 *            the value for sys_user.phone
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.email
	 *
	 * @return the value of sys_user.email
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.email
	 *
	 * @param email
	 *            the value for sys_user.email
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.birthday
	 *
	 * @return the value of sys_user.birthday
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.birthday
	 *
	 * @param birthday
	 *            the value for sys_user.birthday
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.department_id
	 *
	 * @return the value of sys_user.department_id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.department_id
	 *
	 * @param departmentId
	 *            the value for sys_user.department_id
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.create_time
	 *
	 * @return the value of sys_user.create_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.create_time
	 *
	 * @param createTime
	 *            the value for sys_user.create_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.modify_time
	 *
	 * @return the value of sys_user.modify_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.modify_time
	 *
	 * @param modifyTime
	 *            the value for sys_user.modify_time
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.salt
	 *
	 * @return the value of sys_user.salt
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.salt
	 *
	 * @param salt
	 *            the value for sys_user.salt
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.last_change_password
	 *
	 * @return the value of sys_user.last_change_password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Date getLastChangePassword() {
		return lastChangePassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.last_change_password
	 *
	 * @param lastChangePassword
	 *            the value for sys_user.last_change_password
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setLastChangePassword(Date lastChangePassword) {
		this.lastChangePassword = lastChangePassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.status
	 *
	 * @return the value of sys_user.status
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.status
	 *
	 * @param status
	 *            the value for sys_user.status
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.expired
	 *
	 * @return the value of sys_user.expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Integer getExpired() {
		return expired;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.expired
	 *
	 * @param expired
	 *            the value for sys_user.expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setExpired(Integer expired) {
		this.expired = expired;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.locked
	 *
	 * @return the value of sys_user.locked
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Integer getLocked() {
		return locked;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.locked
	 *
	 * @param locked
	 *            the value for sys_user.locked
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column sys_user.credentials_expired
	 *
	 * @return the value of sys_user.credentials_expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public Integer getCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column sys_user.credentials_expired
	 *
	 * @param credentialsExpired
	 *            the value for sys_user.credentials_expired
	 *
	 * @mbggenerated Wed May 30 10:17:25 CST 2018
	 */
	public void setCredentialsExpired(Integer credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	@Override
	public List<? extends GrantedAuthority> getAuthorities() {

		if (authorities.size() < 1) {

			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getCode()));
				List<Authority> authorityList = role.getAuthorities();
				for (Authority auth : authorityList) {
					authorities.add(new SimpleGrantedAuthority(auth.getCode()));
				}
			}
		}

		return authorities;
	}

	public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return this.expired == 0? true:false;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return this.locked == 0? true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return this.credentialsExpired == 0? true:false;
	}

	@Override
	public boolean isEnabled() {
		
		
		return this.status == 1? true:false;
	}
	
	
}
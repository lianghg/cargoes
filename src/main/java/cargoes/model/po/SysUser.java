package cargoes.model.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class SysUser {
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
	@NotBlank(message = "ID不能为空")
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.name
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
	@NotBlank(message = "请输入用户名")
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.gender
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Range(min = 0, max = 1, message = "性别（0：女，1：男，2：未公开）")
    private Integer gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.phone
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "请输入正确的手机号码")
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.email
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @NotBlank(message="请输入邮箱")
	@Email(message = "请输入正确的邮箱")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.birthday
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Past(message = "请输入正确的出生日期")
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.status
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Range(min = 0, max = 1, message = "账号状态，0：未激活，1：已激活，默认值:0）")
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.create_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @NotNull(message = "请输入创建日期")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.modify_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Past(message = "请输入正确的修改日期")
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.role_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.department_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    private String departmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.last_change_password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Past(message = "请输入正确的修改密码日期")
    private Date lastChangePassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.expired
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Range(min = 0, max = 1, message = "账号是否过期，0：未过期，1：过期，默认值:1")
    private Integer expired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.disabled
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    @Range(min = 0, max = 1, message = "账号是否可用,0：不可用，1：可用，默认值:0")
    private Integer disabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.salt
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    private String salt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.name
     *
     * @return the value of sys_user.name
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.name
     *
     * @param name the value for sys_user.name
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.gender
     *
     * @return the value of sys_user.gender
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.gender
     *
     * @param gender the value for sys_user.gender
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.phone
     *
     * @return the value of sys_user.phone
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.phone
     *
     * @param phone the value for sys_user.phone
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.email
     *
     * @return the value of sys_user.email
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.email
     *
     * @param email the value for sys_user.email
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.birthday
     *
     * @return the value of sys_user.birthday
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.birthday
     *
     * @param birthday the value for sys_user.birthday
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.status
     *
     * @return the value of sys_user.status
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.status
     *
     * @param status the value for sys_user.status
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.create_time
     *
     * @return the value of sys_user.create_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.create_time
     *
     * @param createTime the value for sys_user.create_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.modify_time
     *
     * @return the value of sys_user.modify_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.modify_time
     *
     * @param modifyTime the value for sys_user.modify_time
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.role_id
     *
     * @return the value of sys_user.role_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.role_id
     *
     * @param roleId the value for sys_user.role_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.department_id
     *
     * @return the value of sys_user.department_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.department_id
     *
     * @param departmentId the value for sys_user.department_id
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.last_change_password
     *
     * @return the value of sys_user.last_change_password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Date getLastChangePassword() {
        return lastChangePassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.last_change_password
     *
     * @param lastChangePassword the value for sys_user.last_change_password
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setLastChangePassword(Date lastChangePassword) {
        this.lastChangePassword = lastChangePassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.expired
     *
     * @return the value of sys_user.expired
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Integer getExpired() {
        return expired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.expired
     *
     * @param expired the value for sys_user.expired
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.disabled
     *
     * @return the value of sys_user.disabled
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public Integer getDisabled() {
        return disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.disabled
     *
     * @param disabled the value for sys_user.disabled
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.salt
     *
     * @return the value of sys_user.salt
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.salt
     *
     * @param salt the value for sys_user.salt
     *
     * @mbggenerated Mon May 07 23:15:13 CST 2018
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
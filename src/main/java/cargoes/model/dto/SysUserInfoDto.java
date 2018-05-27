package cargoes.model.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysUserInfoDto {

	@ApiModelProperty(value = "用户ID*", required = true, dataType = "string")
	@NotBlank(message = "ID不能为空")
	private String id;

	@NotBlank(message = "请输入名称")
	@ApiModelProperty(value = "用户名*", required = true, dataType = "string")
	private String username;

	@NotBlank(message = "请输入名称")
	@ApiModelProperty(value = "名称*", required = true, dataType = "string")
	private String name;

	@ApiModelProperty(value = "性别（0：女，1：男，2：未公开）", required = true, dataType = "int")
	@Range(min = 0, max = 1, message = "性别（0：女，1：男，2：未公开）")
	private Integer gender;

	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "请输入正确的手机号码")
	@ApiModelProperty(value = "手机号码", required = true, dataType = "string")
	private String phone;

	@NotBlank(message = "请输入邮箱")
	@Email(message = "请输入正确的邮箱")
	@ApiModelProperty(value = "邮箱", required = true, dataType = "string", example = "example@cargoes.top")
	private String email;

	@Past(message = "请输入正确的出生日期")
	@ApiModelProperty(value = "出生日期", required = true, dataType = "date", example = "1970-01-01")
	private Date birthday;

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
	

}

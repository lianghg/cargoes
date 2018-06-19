package cargoes.model.dto;

import java.util.List;

public class RoleOutDto {

	private List<AuthorityDto> authorities;

	private String id;

	private String code;

	private String name;

	private String description;

	private Integer status;

	private Integer order;

	public List<AuthorityDto> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityDto> authorities) {
		this.authorities = authorities;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	
}

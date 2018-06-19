package cargoes.model.dto;

import java.util.List;

public class RoleInDto {

	private List<String> authorityIds;

	private String code;

	private String name;

	private String description;

	private Integer status;

	private Integer order;


	public List<String> getAuthorityIds() {
		return authorityIds;
	}

	public void setAuthorityIds(List<String> authorityIds) {
		this.authorityIds = authorityIds;
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

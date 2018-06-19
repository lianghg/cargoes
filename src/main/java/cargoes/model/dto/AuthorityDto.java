package cargoes.model.dto;

import java.util.List;

public class AuthorityDto {
	
    private String id;

    private String code;

    private String name;

    private String description;

    private Integer order;

    private AuthorityDto parent;
    
    private List<AuthorityDto> children;

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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public AuthorityDto getParent() {
		return parent;
	}

	public void setParent(AuthorityDto parent) {
		this.parent = parent;
	}

	public List<AuthorityDto> getChildren() {
		return children;
	}

	public void setChildren(List<AuthorityDto> children) {
		this.children = children;
	}

}
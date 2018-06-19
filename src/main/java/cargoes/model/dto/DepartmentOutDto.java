package cargoes.model.dto;

import java.util.List;

public class DepartmentOutDto {
	
	private String id;

    private String code;

    private String name;

    private String description;

    private Integer order;
    
    private DepartmentOutDto parent;
    
	private List<DepartmentOutDto> children;

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

	public DepartmentOutDto getParent() {
		return parent;
	}

	public void setParent(DepartmentOutDto parent) {
		this.parent = parent;
	}

	public List<DepartmentOutDto> getChildren() {
		return children;
	}

	public void setChildren(List<DepartmentOutDto> children) {
		this.children = children;
	}
	
}

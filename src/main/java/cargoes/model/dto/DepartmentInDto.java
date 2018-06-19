package cargoes.model.dto;

import java.util.List;

public class DepartmentInDto {
	
	private String id;

    private String code;

    private String name;

    private String description;

    private Integer order;
    
    private String parentId;
    
	private List<String> childrenIds;

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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<String> getChildrenIds() {
		return childrenIds;
	}

	public void setChildrenIds(List<String> childrenIds) {
		this.childrenIds = childrenIds;
	}

}

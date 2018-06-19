package cargoes.model.po;

import java.util.Date;
import java.util.List;

public class Department {
	
    private String id;

    private String code;

    private String name;

    private String description;

    private Integer order;
    
    private Date createTime;
    
    private Date modifyTime;

    private Department parent;
    
	private List<Department> children;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}
	
}
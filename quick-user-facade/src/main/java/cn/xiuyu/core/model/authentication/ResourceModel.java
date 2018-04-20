package cn.xiuyu.core.model.authentication;

import cn.xiuyu.core.model.base.BaseModel;

public class ResourceModel extends BaseModel {

	private static final long serialVersionUID = -644158204480893845L;

	private Integer id;

	private String resourceName;

	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceModel() {
		super();
	}

}

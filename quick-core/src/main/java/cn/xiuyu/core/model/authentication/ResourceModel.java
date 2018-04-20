package cn.xiuyu.core.model.authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.xiuyu.core.model.base.BaseModel;
import cn.xiuyu.core.model.base.TableConstant;

@Entity
@Table(name = TableConstant.AUTHENTICATION + "resource")
public class ResourceModel extends BaseModel {

	private static final long serialVersionUID = -644158204480893845L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "resource_name")
	private String resourceName;

	@Column(name = "description")
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

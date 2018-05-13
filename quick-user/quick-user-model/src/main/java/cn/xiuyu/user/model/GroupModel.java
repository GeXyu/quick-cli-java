package cn.xiuyu.user.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.xiuyu.core.model.base.BaseModel;
import cn.xiuyu.core.model.base.TableConstant;

@Entity
@Table(name = TableConstant.AUTHENTICATION + "group")
public class GroupModel extends BaseModel {

	private static final long serialVersionUID = 7094174620555598861L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "description")
	private String description;

	// 用户
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = TableConstant.AUTHENTICATION + "user_group_relation", joinColumns = {
			@JoinColumn(name = "group_name") }, inverseJoinColumns = { @JoinColumn(name = "user_name") })
	private Set<UserModel> userSet;

	// 资源
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = TableConstant.AUTHENTICATION + "group_resource_relation", joinColumns = {
			@JoinColumn(name = "group_name") }, inverseJoinColumns = { @JoinColumn(name = "resource_name") })
	private Set<ResourceModel> resourceSet;

	@Transient
	private List<ResourceModel> resourceList;

	@Transient
	private List<UserModel> userList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserModel> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserModel> userSet) {
		this.userSet = userSet;
	}

	public Set<ResourceModel> getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(Set<ResourceModel> resourceSet) {
		this.resourceSet = resourceSet;
	}

	public List<ResourceModel> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceModel> resourceList) {
		this.resourceList = resourceList;
	}

	public List<UserModel> getUserList() {
		return userList;
	}

	public void setUserList(List<UserModel> userList) {
		this.userList = userList;
	}

	public GroupModel() {
		super();
	}
}

package cn.xiuyu.core.model.authentication;

import java.util.List;
import java.util.Set;

import cn.xiuyu.core.model.base.BaseModel;

public class GroupModel extends BaseModel {

	private static final long serialVersionUID = 7094174620555598861L;

	private Integer id;

	private String groupName;

	private String description;

	// 用户
	private Set<UserModel> userSet;

	// 资源
	private Set<ResourceModel> resourceSet;

	private List<ResourceModel> resourceList;

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

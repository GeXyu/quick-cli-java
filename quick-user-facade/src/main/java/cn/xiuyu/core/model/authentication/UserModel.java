package cn.xiuyu.core.model.authentication;

import java.util.List;
import java.util.Set;

import cn.xiuyu.core.model.base.BaseModel;

public class UserModel extends BaseModel {

	private static final long serialVersionUID = -6525812361564117630L;

	private Integer id;

	// 用户名
	private String username;

	// 密码
	private String password;

	// 是否使用
	private Byte enable;

	// 是否使用
	private String description;

	private Set<GroupModel> groupSet;

	private List<GroupModel> groupList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getEnable() {
		return enable;
	}

	public void setEnable(Byte enable) {
		this.enable = enable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<GroupModel> getGroupSet() {
		return groupSet;
	}

	public void setGroupSet(Set<GroupModel> groupSet) {
		this.groupSet = groupSet;
	}

	public List<GroupModel> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupModel> groupList) {
		this.groupList = groupList;
	}

	public UserModel() {
		super();
	}

}

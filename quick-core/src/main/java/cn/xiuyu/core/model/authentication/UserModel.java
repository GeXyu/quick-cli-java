package cn.xiuyu.core.model.authentication;

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
@Table(name = TableConstant.AUTHENTICATION + "user")
public class UserModel extends BaseModel {

	private static final long serialVersionUID = -6525812361564117630L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	// 用户名
	@Column(name = "username")
	private String username;

	// 密码
	@Column(name = "password")
	private String password;

	// 是否使用
	@Column(name = "enable")
	private Byte enable;

	// 是否使用
	@Column(name = "description")
	private String description;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = TableConstant.AUTHENTICATION + "user_group_relation", joinColumns = {
			@JoinColumn(name = "user_name") }, inverseJoinColumns = { @JoinColumn(name = "group_name") })
	private Set<GroupModel> groupSet;

	@Transient
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

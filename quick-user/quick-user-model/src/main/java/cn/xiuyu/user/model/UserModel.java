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

    // 微信
    @Column(name = "we_chat")
    private String weChat;

    // qq
    @Column(name = "qq")
    private String qq;

    // 手机号
    @Column(name = "phone")
    private String phone;

    // 头像
    @Column(name = "head_picture")
    private String headPicture;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = TableConstant.AUTHENTICATION + "user_group_relation", joinColumns = {
            @JoinColumn(name = "user_name") }, inverseJoinColumns = { @JoinColumn(name = "group_name") })
    private Set<GroupModel> groupSet;

    @Transient
    private List<GroupModel> groupList;

    @Transient
    private List<ResourceModel> resourceList;

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

    /**
     * @return the weChat
     */
    public String getWeChat() {
        return weChat;
    }

    /**
     * @param weChat
     *            the weChat to set
     */
    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     *            the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the headPicture
     */
    public String getHeadPicture() {
        return headPicture;
    }

    /**
     * @return the resourceList
     */
    public List<ResourceModel> getResourceList() {
        return resourceList;
    }

    /**
     * @param resourceList
     *            the resourceList to set
     */
    public void setResourceList(List<ResourceModel> resourceList) {
        this.resourceList = resourceList;
    }

    /**
     * @param headPicture
     *            the headPicture to set
     */
    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public UserModel() {
        super();
    }

}

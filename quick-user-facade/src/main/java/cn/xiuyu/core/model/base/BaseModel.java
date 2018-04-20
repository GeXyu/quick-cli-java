package cn.xiuyu.core.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 9007117085349104906L;

	// 创建时间
	private Date createTime;

	// 修改时间
	private Date modifyTime;

	// 创建人
	private String createManager;

	// 修改人
	private String modifyManager;

	// 备注
	private String remake;

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

	public String getCreateManager() {
		return createManager;
	}

	public void setCreateManager(String createManager) {
		this.createManager = createManager;
	}

	public String getModifyManager() {
		return modifyManager;
	}

	public void setModifyManager(String modifyManager) {
		this.modifyManager = modifyManager;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	public BaseModel() {
		super();
	}

}

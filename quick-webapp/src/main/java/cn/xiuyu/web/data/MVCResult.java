package cn.xiuyu.web.data;

import java.util.Date;

public class MVCResult {

	private Date currentTime = new Date();

	private Integer status;

	private String result;

	private String message;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public MVCResult message(String message) {
		this.message = message;
		return this;
	}

	public MVCResult status(Integer status) {
		this.status = status;
		return this;
	}

	public MVCResult result(String result) {
		this.result = result;
		return this;
	}

	public static MVCResult getTrueResult() {

		MVCResult result = new MVCResult();

		result.setStatus(200);
		result.result("true");

		return result;
	}

	public static MVCResult getFalseResult(String message) {

		MVCResult result = new MVCResult();

		result.setStatus(200);
		result.result("false");
		result.setMessage(message);

		return result;
	}

}

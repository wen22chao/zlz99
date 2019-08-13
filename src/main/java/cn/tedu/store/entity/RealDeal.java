package cn.tedu.store.entity;

import java.io.Serializable;

public class RealDeal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7925180204606778835L;
	private Long time;
	private String userName;
	private String nickName;
	private Double tz_money;
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Double getTz_money() {
		return tz_money;
	}
	public void setTz_money(Double tz_money) {
		this.tz_money = tz_money;
	}
	public RealDeal() {
		super();
	}
	public RealDeal(Long time, String userName, String nickName, Double tz_money) {
		super();
		this.time = time;
		this.userName = userName;
		this.nickName = nickName;
		this.tz_money = tz_money;
	}
	@Override
	public String toString() {
		return "RealDeal [time=" + time + ", userName=" + userName + ", nickName=" + nickName + ", tz_money=" + tz_money
				+ "]";
	}
	
	
}

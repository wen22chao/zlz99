package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	private static final long serialVersionUID = -4087009661970931968L;

	private Integer id;
	private Integer uid;
	private String recvAddress;
	private String recvName;
	private String recvPhone;
	private Long totalPrice;
	private Date startTime;
	private Date endTime;
	private Integer status;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;

	public Order() {
		super();
	}

	public Order(Integer id, Integer uid, String recvAddress, String recvName, String recvPhone, Long totalPrice,
			Date startTime, Date endTime, Integer status, String createdUser, Date createdTime, String modifiedUser,
			Date modifiedTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.recvAddress = recvAddress;
		this.recvName = recvName;
		this.recvPhone = recvPhone;
		this.totalPrice = totalPrice;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRecvAddress() {
		return recvAddress;
	}

	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}

	public String getRecvName() {
		return recvName;
	}

	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}

	public String getRecvPhone() {
		return recvPhone;
	}

	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", recvAddress=" + recvAddress + ", recvName=" + recvName
				+ ", recvPhone=" + recvPhone + ", totalPrice=" + totalPrice + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", createdUser=" + createdUser + ", createdTime=" + createdTime
				+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}

}

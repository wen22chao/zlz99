package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = -6604434425159823934L;

	private Integer id;
	private Integer orderId;
	private Long goodsId;
	private String goodsTitle;
	private String goodsImage;
	private Long goodsPrice;
	private Integer num;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer orderId, Long goodsId, String goodsTitle, String goodsImage, Long goodsPrice,
			Integer num, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsTitle = goodsTitle;
		this.goodsImage = goodsImage;
		this.goodsPrice = goodsPrice;
		this.num = num;
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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public Long getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", goodsId=" + goodsId + ", goodsTitle=" + goodsTitle
				+ ", goodsImage=" + goodsImage + ", goodsPrice=" + goodsPrice + ", num=" + num + ", createdUser="
				+ createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime="
				+ modifiedTime + "]";
	}

}

package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {

	private static final long serialVersionUID = 2339018028265330963L;

	private Integer id;
	private Integer uid;
	private Long goodsId;
	private Integer num;
	private Long goodsPrice;
	private String goodsImage;
	private String goodsTitle;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

	public Cart() {
		super();
	}

	public Cart(Integer id, Integer uid, Long goodsId, Integer num, Long goodsPrice, String goodsImage,
			String goodsTitle, Date createdTime, Date modifiedTime, String createdUser, String modifiedUser) {
		super();
		this.id = id;
		this.uid = uid;
		this.goodsId = goodsId;
		this.num = num;
		this.goodsPrice = goodsPrice;
		this.goodsImage = goodsImage;
		this.goodsTitle = goodsTitle;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", num=" + num + ", goodsPrice="
				+ goodsPrice + ", goodsImage=" + goodsImage + ", goodsTitle=" + goodsTitle + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser="
				+ modifiedUser + "]";
	}

}

package cn.tedu.store.entity;

import java.io.Serializable;

public class Banner implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer type;
	private String content;
	private String img_url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNamr(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public Banner() {
		super();
	}
	public Banner(Integer id, String name, Integer type, String content, String img_url) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.content = content;
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", name=" + name + ", type=" + type + ", content=" + content + ", img_url="
				+ img_url + "]";
	}
	
	
}

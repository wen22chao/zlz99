package cn.tedu.store.entity;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7067869997899195490L;
	private Integer id;
	private String order_no;
	private String name;
	private String img_url;
	private Double rate;
	private Double expect_rate;
	private Integer money_pond;
	private Integer least_money;
	private String service_content;
	private Integer type;
	private Integer is_stick;
	private Integer month;
	private Integer ctime;
	private Integer status;
	private Integer full_time;
	private Integer is_delete;
	private String location;
	private String addr;
	private Integer is_lock;
	private Integer c_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getExpect_rate() {
		return expect_rate;
	}
	public void setExpect_rate(Double expect_rate) {
		this.expect_rate = expect_rate;
	}
	public Integer getMoney_pond() {
		return money_pond;
	}
	public void setMoney_pond(Integer money_pond) {
		this.money_pond = money_pond;
	}
	public Integer getLeast_money() {
		return least_money;
	}
	public void setLeast_money(Integer least_money) {
		this.least_money = least_money;
	}
	public String getService_content() {
		return service_content;
	}
	public void setService_content(String service_content) {
		this.service_content = service_content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIs_stick() {
		return is_stick;
	}
	public void setIs_stick(Integer is_stick) {
		this.is_stick = is_stick;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getCtime() {
		return ctime;
	}
	public void setCtime(Integer ctime) {
		this.ctime = ctime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getFull_time() {
		return full_time;
	}
	public void setFull_time(Integer full_time) {
		this.full_time = full_time;
	}
	public Integer getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(Integer is_lock) {
		this.is_lock = is_lock;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Product(Integer id, String order_no, String name, String img_url, Double rate, Double expect_rate,
			Integer money_pond, Integer least_money, String service_content, Integer type, Integer is_stick,
			Integer month, Integer ctime, Integer status, Integer full_time, Integer is_delete, String location,
			String addr, Integer is_lock, Integer c_id) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.name = name;
		this.img_url = img_url;
		this.rate = rate;
		this.expect_rate = expect_rate;
		this.money_pond = money_pond;
		this.least_money = least_money;
		this.service_content = service_content;
		this.type = type;
		this.is_stick = is_stick;
		this.month = month;
		this.ctime = ctime;
		this.status = status;
		this.full_time = full_time;
		this.is_delete = is_delete;
		this.location = location;
		this.addr = addr;
		this.is_lock = is_lock;
		this.c_id = c_id;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", order_no=" + order_no + ", name=" + name + ", img_url=" + img_url + ", rate="
				+ rate + ", expect_rate=" + expect_rate + ", money_pond=" + money_pond + ", least_money=" + least_money
				+ ", service_content=" + service_content + ", type=" + type + ", is_stick=" + is_stick + ", month="
				+ month + ", ctime=" + ctime + ", status=" + status + ", full_time=" + full_time + ", is_delete="
				+ is_delete + ", location=" + location + ", addr=" + addr + ", is_lock=" + is_lock + ", c_id=" + c_id
				+ "]";
	}
	
	
}

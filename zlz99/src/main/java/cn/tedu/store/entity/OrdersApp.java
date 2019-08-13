package cn.tedu.store.entity;

import java.io.Serializable;

public class OrdersApp implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer user_id;
	private String order_no;
	private Integer goods_id;
	private Integer c_id;
	private Long c_money;
	private Integer c_type;
	private Integer tz_money;
	private Long quit_time;
	private Long tz_time;
	private Integer type;
	private Integer status;

	public OrdersApp() {
		super();
	}

	public OrdersApp(Integer id, Integer user_id, String order_no, Integer goods_id, Integer c_id, Long c_money,
			Integer c_type, Integer tz_money, Long quit_time, Long tz_time, Integer type, Integer status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_no = order_no;
		this.goods_id = goods_id;
		this.c_id = c_id;
		this.c_money = c_money;
		this.c_type = c_type;
		this.tz_money = tz_money;
		this.quit_time = quit_time;
		this.tz_time = tz_time;
		this.type = type;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Long getC_money() {
		return c_money;
	}

	public void setC_money(Long c_money) {
		this.c_money = c_money;
	}

	public Integer getC_type() {
		return c_type;
	}

	public void setC_type(Integer c_type) {
		this.c_type = c_type;
	}

	public Integer getTz_money() {
		return tz_money;
	}

	public void setTz_money(Integer tz_money) {
		this.tz_money = tz_money;
	}

	public Long getQuit_time() {
		return quit_time;
	}

	public void setQuit_time(Long quit_time) {
		this.quit_time = quit_time;
	}

	public Long getTz_time() {
		return tz_time;
	}

	public void setTz_time(Long tz_time) {
		this.tz_time = tz_time;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrdersApp [id=" + id + ", user_id=" + user_id + ", order_no=" + order_no + ", goods_id=" + goods_id
				+ ", c_id=" + c_id + ", c_money=" + c_money + ", c_type=" + c_type + ", tz_money=" + tz_money
				+ ", quit_time=" + quit_time + ", tz_time=" + tz_time + ", type=" + type + ", status=" + status + "]";
	}

}

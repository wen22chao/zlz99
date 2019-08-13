package cn.tedu.store.entity;

import java.io.Serializable;

public class IndexTz implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sum_user;
	private Integer sum_money;
	private Double all_earn;
	public Integer getSum_user() {
		return sum_user;
	}
	public void setSum_user(Integer sum_user) {
		this.sum_user = sum_user;
	}
	public Integer getSum_money() {
		return sum_money;
	}
	public void setSum_money(Integer sum_money) {
		this.sum_money = sum_money;
	}
	public Double getAll_earn() {
		return all_earn;
	}
	public void setAll_earn(Double all_earn) {
		this.all_earn = all_earn;
	}
	public IndexTz(Integer sum_user, Integer sum_money, Double all_earn) {
		super();
		this.sum_user = sum_user;
		this.sum_money = sum_money;
		this.all_earn = all_earn;
	}
	public IndexTz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public IndexTz(Double all_earn) {
		super();
		this.all_earn = all_earn;
	}
	public IndexTz(Integer sum_user, Integer sum_money) {
		super();
		this.sum_user = sum_user;
		this.sum_money = sum_money;
	}
	@Override
	public String toString() {
		return "indexTz [sum_user=" + sum_user + ", sum_money=" + sum_money + ", all_earn=" + all_earn + "]";
	}

}

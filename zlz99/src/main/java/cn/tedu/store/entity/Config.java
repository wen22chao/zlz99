package cn.tedu.store.entity;

import java.io.Serializable;

public class Config implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer tx_num;
	private Double tx_money;
	private Double tx_service;
	private Integer s_jf;
	private Integer half_jf;
	private Integer m_jf;
	private Integer share_jf;
	private Integer scan_jf;
	private Integer tz_return;
	private Integer tz_jf;
	private Integer deduct_jf;
	private Integer throw_month;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTx_num() {
		return tx_num;
	}
	public void setTx_num(Integer tx_num) {
		this.tx_num = tx_num;
	}
	public Double getTx_money() {
		return tx_money;
	}
	public void setTx_money(Double tx_money) {
		this.tx_money = tx_money;
	}
	public Double getTx_service() {
		return tx_service;
	}
	public void setTx_service(Double tx_service) {
		this.tx_service = tx_service;
	}
	public Integer getS_jf() {
		return s_jf;
	}
	public void setS_jf(Integer s_jf) {
		this.s_jf = s_jf;
	}
	public Integer getHalf_jf() {
		return half_jf;
	}
	public void setHalf_jf(Integer half_jf) {
		this.half_jf = half_jf;
	}
	public Integer getM_jf() {
		return m_jf;
	}
	public void setM_jf(Integer m_jf) {
		this.m_jf = m_jf;
	}
	public Integer getShare_jf() {
		return share_jf;
	}
	public void setShare_jf(Integer share_jf) {
		this.share_jf = share_jf;
	}
	public Integer getScan_jf() {
		return scan_jf;
	}
	public void setScan_jf(Integer scan_jf) {
		this.scan_jf = scan_jf;
	}
	public Integer getTz_return() {
		return tz_return;
	}
	public void setTz_return(Integer tz_return) {
		this.tz_return = tz_return;
	}
	public Integer getTz_jf() {
		return tz_jf;
	}
	public void setTz_jf(Integer tz_jf) {
		this.tz_jf = tz_jf;
	}
	public Integer getDeduct_jf() {
		return deduct_jf;
	}
	public void setDeduct_jf(Integer deduct_jf) {
		this.deduct_jf = deduct_jf;
	}
	public Integer getThrow_month() {
		return throw_month;
	}
	public void setThrow_month(Integer throw_month) {
		this.throw_month = throw_month;
	}
	@Override
	public String toString() {
		return "Config [id=" + id + ", tx_num=" + tx_num + ", tx_money=" + tx_money + ", tx_service=" + tx_service
				+ ", s_jf=" + s_jf + ", half_jf=" + half_jf + ", m_jf=" + m_jf + ", share_jf=" + share_jf + ", scan_jf="
				+ scan_jf + ", tz_return=" + tz_return + ", tz_jf=" + tz_jf + ", deduct_jf=" + deduct_jf
				+ ", throw_month=" + throw_month + "]";
	}
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Config(Integer id, Integer tx_num, Double tx_money, Double tx_service, Integer s_jf, Integer half_jf,
			Integer m_jf, Integer share_jf, Integer scan_jf, Integer tz_return, Integer tz_jf, Integer deduct_jf,
			Integer throw_month) {
		super();
		this.id = id;
		this.tx_num = tx_num;
		this.tx_money = tx_money;
		this.tx_service = tx_service;
		this.s_jf = s_jf;
		this.half_jf = half_jf;
		this.m_jf = m_jf;
		this.share_jf = share_jf;
		this.scan_jf = scan_jf;
		this.tz_return = tz_return;
		this.tz_jf = tz_jf;
		this.deduct_jf = deduct_jf;
		this.throw_month = throw_month;
	}
	
	
	

	

}

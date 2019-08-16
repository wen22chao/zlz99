package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

public class Members implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717247672955756755L;
	private Integer id;
	private String nickname;
	private String accout;
	private String token;
	private String openid;
	private String password;
	private String header;
	private String realname;
	private Integer age;
	private String sex;
	private String education;
	private String mobile;
	private String address;
	private String email;
	private Double money;
	private Double withdrew_limit;
	private Double lock_money;
	private Integer integray;
	private Integer level;
	private String id_card_number;
	private String id_card_img;
	private String id_card_img2;
	private Integer reviewing_status;
	private Integer is_locking;
	private Integer is_black;
	private Date datetime;
	private Date utime;
	private Integer is_online;
	private Integer is_authentication;
	private String pay_pwd;
	private String qr_url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getWithdrew_limit() {
		return withdrew_limit;
	}
	public void setWithdrew_limit(Double withdrew_limit) {
		this.withdrew_limit = withdrew_limit;
	}
	public Double getLock_money() {
		return lock_money;
	}
	public void setLock_money(Double lock_money) {
		this.lock_money = lock_money;
	}
	public Integer getIntegray() {
		return integray;
	}
	public void setIntegray(Integer integray) {
		this.integray = integray;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getId_card_number() {
		return id_card_number;
	}
	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}
	public String getId_card_img() {
		return id_card_img;
	}
	public void setId_card_img(String id_card_img) {
		this.id_card_img = id_card_img;
	}
	public String getId_card_img2() {
		return id_card_img2;
	}
	public void setId_card_img2(String id_card_img2) {
		this.id_card_img2 = id_card_img2;
	}
	public Integer getReviewing_status() {
		return reviewing_status;
	}
	public void setReviewing_status(Integer reviewing_status) {
		this.reviewing_status = reviewing_status;
	}
	public Integer getIs_locking() {
		return is_locking;
	}
	public void setIs_locking(Integer is_locking) {
		this.is_locking = is_locking;
	}
	public Integer getIs_black() {
		return is_black;
	}
	public void setIs_black(Integer is_black) {
		this.is_black = is_black;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Date getUtime() {
		return utime;
	}
	public void setUtime(Date utime) {
		this.utime = utime;
	}
	public Integer getIs_online() {
		return is_online;
	}
	public void setIs_online(Integer is_online) {
		this.is_online = is_online;
	}
	public Integer getIs_authentication() {
		return is_authentication;
	}
	public void setIs_authentication(Integer is_authentication) {
		this.is_authentication = is_authentication;
	}
	public String getPay_pwd() {
		return pay_pwd;
	}
	public void setPay_pwd(String pay_pwd) {
		this.pay_pwd = pay_pwd;
	}
	public String getQr_url() {
		return qr_url;
	}
	public void setQr_url(String qr_url) {
		this.qr_url = qr_url;
	}
	public Members() {
		super();
	}
	public Members(Integer id, String nickname, String accout, String token, String openid, String password,
			String header, String realname, Integer age, String sex, String education, String mobile, String address,
			String email, Double money, Double withdrew_limit, Double lock_money, Integer integray, Integer level,
			String id_card_number, String id_card_img, String id_card_img2, Integer reviewing_status,
			Integer is_locking, Integer is_black, Date datetime, Date utime, Integer is_online,
			Integer is_authentication, String pay_pwd, String qr_url) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.accout = accout;
		this.token = token;
		this.openid = openid;
		this.password = password;
		this.header = header;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.education = education;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.money = money;
		this.withdrew_limit = withdrew_limit;
		this.lock_money = lock_money;
		this.integray = integray;
		this.level = level;
		this.id_card_number = id_card_number;
		this.id_card_img = id_card_img;
		this.id_card_img2 = id_card_img2;
		this.reviewing_status = reviewing_status;
		this.is_locking = is_locking;
		this.is_black = is_black;
		this.datetime = datetime;
		this.utime = utime;
		this.is_online = is_online;
		this.is_authentication = is_authentication;
		this.pay_pwd = pay_pwd;
		this.qr_url = qr_url;
	}
	@Override
	public String toString() {
		return "Members [id=" + id + ", nickname=" + nickname + ", accout=" + accout + ", token=" + token + ", openid="
				+ openid + ", password=" + password + ", header=" + header + ", realname=" + realname + ", age=" + age
				+ ", sex=" + sex + ", education=" + education + ", mobile=" + mobile + ", address=" + address
				+ ", email=" + email + ", money=" + money + ", withdrew_limit=" + withdrew_limit + ", lock_money="
				+ lock_money + ", integray=" + integray + ", level=" + level + ", id_card_number=" + id_card_number
				+ ", id_card_img=" + id_card_img + ", id_card_img2=" + id_card_img2 + ", reviewing_status="
				+ reviewing_status + ", is_locking=" + is_locking + ", is_black=" + is_black + ", datetime=" + datetime
				+ ", utime=" + utime + ", is_online=" + is_online + ", is_authentication=" + is_authentication
				+ ", pay_pwd=" + pay_pwd + ", qr_url=" + qr_url + "]";
	}
	
	
}

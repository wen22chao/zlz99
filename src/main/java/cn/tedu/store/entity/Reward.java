package cn.tedu.store.entity;

public class Reward {
	private String order_date;
	private String Agent_name;
	private Integer Agent_id;
	private String username;
	private Integer user_idcard;
	private Integer user_id;
	private Integer c_money;
	private Integer c_mons;
	private Integer reward;

	public Reward() {
		super();
	}

	public Reward(String order_date, String agent_name, Integer agent_id, String username, Integer user_idcard,
			Integer user_id, Integer c_money, Integer c_mons, Integer reward) {
		super();
		this.order_date = order_date;
		Agent_name = agent_name;
		Agent_id = agent_id;
		this.username = username;
		this.user_idcard = user_idcard;
		this.user_id = user_id;
		this.c_money = c_money;
		this.c_mons = c_mons;
		this.reward = reward;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getAgent_name() {
		return Agent_name;
	}

	public void setAgent_name(String agent_name) {
		Agent_name = agent_name;
	}

	public Integer getAgent_id() {
		return Agent_id;
	}

	public void setAgent_id(Integer agent_id) {
		Agent_id = agent_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUser_idcard() {
		return user_idcard;
	}

	public void setUser_idcard(Integer user_idcard) {
		this.user_idcard = user_idcard;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getC_money() {
		return c_money;
	}

	public void setC_money(Integer c_money) {
		this.c_money = c_money;
	}

	public Integer getC_mons() {
		return c_mons;
	}

	public void setC_mons(Integer c_mons) {
		this.c_mons = c_mons;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "Reward [order_date=" + order_date + ", Agent_name=" + Agent_name + ", Agent_id=" + Agent_id
				+ ", username=" + username + ", user_idcard=" + user_idcard + ", user_id=" + user_id + ", c_money="
				+ c_money + ", c_mons=" + c_mons + ", reward=" + reward + "]";
	}

}

package cn.tedu.store.service;

public interface IUtilService {
	/**
	 * 用用户token获取用户id
	 * @param token
	 * @return 用户id
	 */
	Integer getUidFromToken(String token);
	
	/**
	 * 获取格式化String类型日期
	 * @param time
	 * @return
	 */
	String getStringDate(long time);
}

package cn.tedu.store.service;

public interface IUtilService {
	/**
	 * 用用户token获取用户id
	 * @param token
	 * @return 用户id
	 */
	Integer getUidFromToken(String token);
}

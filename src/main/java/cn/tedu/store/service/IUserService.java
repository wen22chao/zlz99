package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotExistsException;
import cn.tedu.store.service.ex.UsernameConflictException;

public interface IUserService {
	
	/**
	 * 用户注册
	 * @param user 注册的用户信息
	 * @return 用户信息，包括用户id
	 * @throws UsernameConflictException
	 */
	User reg(User user);
	
	/**
	 * 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户信息，如果没有匹配的用户信息，则返回null
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return 用户信息，如果没有匹配的用户信息，则返回null
	 * 查询用户的信息，如果没有匹配度用户信息，则返回null
	 * 查询用户的信息，如果没有匹配的用户信息，则返回null
	 */
	User findUserByUsername(String username);
	
	/**
	 * 获取加密后的密码
	 * @param password 明文密码
	 * @param salt 盐
	 * @return 密文密码
	 */
	String getEncrpytedPassword(
			String password, String salt);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 成功登录的用户信息
	 * 成功登录的用户信息
	 * @throws UserNotExistsException
	 * @throws PasswordNotMatchException
	 */
	User login(String username, String password);
	
	/**
	 * 修改密码
	 * @param id 用户id
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return 受影响的行数
	 * @throws UserNotExistsException
	 * @throws PasswordNotMatchException
	 */
	Integer changePassword(Integer id, 
	    String oldPassword, String newPassword);
	
	/**
	 * 修改用户个人信息
	 * @param id 用户id
	 * @param username 新的用户名
	 * @param gender 新的性别
	 * @param phone 新的手机号
	 * @param email 新的电子邮件
	 * @return 受影响的行数
	 * Integer
	 * @throws UserNotExistsException
	 */
	Integer changeInfo(
			Integer id, 
			String username, 
			Integer gender, 
			String phone, 
			String email);
	
	List<HashMap> getIndexUnreal_msg(Integer type);
	
}








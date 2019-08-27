package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBoonServicer {
	/**
	 * 获取可以积分兑换的劵
	 * @return 所有可以兑换的券
	 */
	List<HashMap<Object,Object>> convert();
	/**
	 * 通过用户id获取用户积分
	 * @param id 用户id
	 * @return 用户的积分
	 */
	Integer getIntegralById(Integer id);
	/**
	 * 获取单个券的详情
	 * @param id 券id
	 * @return 券的所有信息
	 */
	List<HashMap<Object,Object>> coupons_detail(Integer id);
	/**
	 * 查询用户是否有未使用的某个券
	 * @param uid 用户id
	 * @param c_id 券id
	 * @return 用户拥有的券的信息
	 */
	Boolean is_conversion(Integer uid, Integer c_id);
	
	/**
	 * 为用户增加一张券
	 * @param map 
	 */
	Integer putMemberCoupon(Map<String, Object> map);
	
	/**
	 * 为用户更新积分
	 * @param integral
	 */
	Integer uptadeIntegral(Integer integral, Integer uid);
	
	/**
	 * 为用户增加兑换券日志信息
	 * @param map2
	 */
	Integer add_integral_data(HashMap<String, Object> map2);
	
	/**
	 * 获取用户兑换券的记录
	 * @param uid 用户id
	 * @param page 第几页
	 * @return 
	 */
	List<Map<Object,Object>> get_user_coupons_log(Integer uid, Integer per);
	
	/**
	 * 获取任务详情
	 * @return
	 */
	List<Map<Object,Object>> get_task();
	
	
	
}

package cn.tedu.store.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoonMapper {
	/**
	 * 查询所有的券（有效的）
	 * @return 
	 */
	List<HashMap<Object,Object>> convert();
	/**
	 * 查询用户积分
	 * @param id 用户id
	 * @return 用户积分
	 */
	Integer getIntegralById(Integer id);
	/**
	 * 查询券详情
	 * @param id 券id
	 * @return 券详情
	 */
	List<HashMap<Object,Object>> coupons_detail(Integer id);
	/**
	 *查询用户是否已经有某种券
	 * @param uid 用户id
	 * @param c_id 券id
	 * @return 返回券信息
	 */
	List<HashMap<Object,Object>> is_conversion(@Param("uid")Integer uid, @Param("c_id")Integer c_id);
	
	/**
	 * 为用户增加券
	 * @param map
	 */
	Integer putMemberCoupon(Map<String, Object> map);
	
	/***
	 * 
	 * @param integral
	 * @param uid
	 * @return
	 */
	Integer uptadeIntegral(@Param("integral")Integer integral, @Param("id")Integer id);
	
	/**
	 * 为用户增加兑换券日志
	 * @param maps
	 * @return
	 */
	Integer add_integral_data(Map<String, Object> maps);
	
	/**
	 * 获取用户兑换券的记录
	 * @param uid
	 * @param page
	 * @return
	 */
	List<Map<Object,Object>> get_user_coupons_log(@Param("uid")Integer uid, @Param("per")Integer per);
	
	/**
	 *获取任务详情
	 * @return
	 */
	List<Map<Object,Object>> get_task();
	
	/**
	 * 插入用户兑换记录到数据库
	 * @param map
	 * @return
	 */
	Integer insert_member_exch_goods(Map<String, Object> map);
	
	/**
	 * 为用户增加券
	 * @param map1
	 */
	Integer insert_member_coupons(HashMap<String, Object> map1);
	
}

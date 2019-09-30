package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
	
	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return 受影响的行数
	 */
	Integer insert(User user);
	
	/**
	 * 查询用户信息
	 * @param where WHERE子句，不要包含WHERE关键字
	 * @param orderBy OrderBy子句，不要包含Order By关键字
	 * @param offset 偏移量，用于Limit子句的第1个值
	 * @param countPerPage 每页显示的数据量，用于Limit子句的第2个值，仅当参数offset有效时，该参数才有效，如果没有提供offset值，则该参数没有意义
	 * @return 匹配的用户信息的集合
	 */
	List<User> select(
		@Param("where") String where,
		@Param("orderBy") String orderBy,
		@Param("offset") Integer offset,
		@Param("countPerPage") Integer countPerPage);
	
	/**
	 * 修改用户资料
	 * @param user 至少封装了用户的id，和新的数据的对象
	 * @return 受影响的行数
	 */
	Integer update(User user);
	
	List<HashMap<Object,Object>> getIndexUnread_msg(Integer type);

}









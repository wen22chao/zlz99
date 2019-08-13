package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

	/**
	 * 新增收货地址
	 * @param address 收货地址的对象
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
	/**
	 * 查询收货地址信息
	 * @param where WHERE子句
	 * @param orderBy ORDER BY子句
	 * @param offset LIMIT子句中的第1个参数，表示跳过多少条数据
	 * @param countPerPage LIMIT子句中的第2个参数，表示将获取多少条数据
	 * @return 查询到的若干条收货地址的集合
	 */
	List<Address> select(
			@Param("where")		String where, 
			@Param("orderBy")	String orderBy, 
			@Param("offset")	Integer offset, 
			@Param("countPerPage") Integer countPerPage);
	
	/**
	 * 删除收货地址数据
	 * @param where WHERE子句
	 * @return 受影响的行数
	 */
	Integer delete(@Param("where") String where);
	
	/**
	 * 修改收货地址数据
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer update(Address address);
	
}

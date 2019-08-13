package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;

public interface OrderMapper {

	/**
	 * 增加订单数据
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	Integer insert(Order order);
}

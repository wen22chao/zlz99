package cn.tedu.store.mapper;

import cn.tedu.store.entity.OrderItem;

public interface OrderItemMapper {
	
	/**
	 * 增加订单中的商品数据
	 * @param order 订单中的商品数据
	 * @return 受影响的行数
	 */
	Integer insert(OrderItem orderItem);

}

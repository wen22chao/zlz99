package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.service.ex.InsertFailException;

import java.util.List;

public interface IOrderService {

	/**
	 * 增加订单数据
	 * @param order 订单数据
	 * @return 成功增加的订单数据，包括订单id
	 * @throws InsertFailException
	 */
	Order insert(Order order);
	
	/**
	 * 增加订单中的商品数据
	 * @param order 订单中的商品数据
	 * @return 受影响的行数
	 */
	Integer insert(OrderItem orderItem);
	
	/**
	 * 插入订单数据
	 * @param order 订单表数据
	 * @param orderItems 多条订单中的商品数据
	 * @return 成功创建后的订单表数据，该数据中包括订单ID
	 */
	Order insert(
			Order order, 
			List<OrderItem> orderItems);
	
	/**
	 * 创建订单
	 * @param uid 用户id
	 * @param addressId 收货地址数据的id
	 * @param cartIds 订单中各商品在购物车中的数据id
	 * @return 成功创建的订单数据
	 */
	Order createOrder(
			Integer uid, Integer addressId, Integer[] cartIds);
}








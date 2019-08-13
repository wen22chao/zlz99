package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderItemMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.ex.InsertFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private IAddressService addressService;
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private OrderItemMapper orderItemMapper;

	public Order insert(Order order) {
		Integer rows = orderMapper
				.insert(order);
		if (rows == 1) {
			return order;
		} else {
			throw new InsertFailException(
				"增加数据失败！请联系系统员！");
		}
	}

	public Integer insert(OrderItem orderItem) {
		Integer rows = orderItemMapper
				.insert(orderItem);
		if (rows == 1) {
			return 1;
		} else {
			throw new InsertFailException(
				"增加数据失败！请联系系统员！");
		}
	}

	@Transactional
	public Order insert(
			Order order, 
			List<OrderItem> orderItems) {
		// 增加订单表数据，并产生订单id
		insert(order);
		// 获取订单id
		Integer orderId = order.getId();
			
		// 遍历多个订单中的商品信息
		for (OrderItem orderItem : orderItems) {
			// 为订单中的商品数据添加订单id
			orderItem.setOrderId(orderId);
			// 增加订单中的商品数据
			insert(orderItem);
		}
		// 返回订单表数据
		return order;
	}

	@Transactional
	public Order createOrder(
			Integer uid, 
			Integer addressId, 
			Integer[] cartIds) {
		// 声明1个Order对象和若干个OrderItem对象
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		OrderItem orderItem = null;
		
		// 获取当前时间
		Date now = new Date();

		// 订单状态(status)固定为1
		Integer status = 1;
		
		// 根据addressId获取地址信息
		// 结果：recvName, recvPhone, recvDistrict, recvAddress
		Address address = 
				addressService.getAddressById(
						addressId);

		// 根据cartIds获取购物车信息
		// 结果：goods_id, goods_image, goods_title, goods_price, num
		List<Cart> carts = 
				cartService.getListByIds(cartIds);
		
		// 封装若干个OrderItem对象
		// 同时，计算总价(total_price)
		Long totalPrice = 0L;
		for (Cart cart : carts) {
			// 计算总价(total_price)
			totalPrice += cart.getGoodsPrice()
					* cart.getNum();
			// 封装OrderItem对象
			orderItem = new OrderItem();
			orderItem.setGoodsId(cart.getGoodsId());
			orderItem.setGoodsTitle(cart.getGoodsTitle());
			orderItem.setGoodsPrice(cart.getGoodsPrice());
			orderItem.setGoodsImage(cart.getGoodsImage());
			orderItem.setNum(cart.getNum());
			// 封装OrderItem中的日志信息
			orderItem.setCreatedUser("[System]");
			orderItem.setCreatedTime(now);
			orderItem.setModifiedUser("[System]");
			orderItem.setModifiedTime(now);
			// 将封装完的OrderItem对象添加到集合中
			orderItems.add(orderItem);
		}

		// 封装1个Order对象
		order.setUid(uid);
		order.setRecvName(address.getRecvName());
		order.setRecvPhone(address.getRecvPhone());
		order.setRecvAddress(address.getRecvDistrict() + " " + address.getRecvAddress());
		order.setTotalPrice(totalPrice);
		order.setStartTime(now);
		order.setStatus(status);
		// 封装Order中的日志信息
		order.setCreatedUser("[System]");
		order.setCreatedTime(now);
		order.setModifiedUser("[System]");
		order.setModifiedTime(now);

		// 调用原来的createOrder()，现在改名为insert()，执行插入数据
		Order result = insert(order, orderItems);
		// 删除购物车中对应的数据：已经创建订单后，购物车中不再保存对应的数据
		cartService.delete(uid, cartIds);
		
		// 返回
		return result;
	}

}

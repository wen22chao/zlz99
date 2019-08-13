package cn.tedu.store.service;

import cn.tedu.store.entity.OrdersApp;
import cn.tedu.store.mapper.OrdersAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ordersAppService")
public class OrdersAppServiceImpl implements IOrdersAppService {
	
	@Autowired
	private OrdersAppMapper ordersAppMapper;

	public List<OrdersApp> select() {
		
		List<OrdersApp> orders = ordersAppMapper.select();
		
		for (OrdersApp ordersApp : orders) {
			System.out.println(ordersApp.toString());
		}
		
		return null;
	}

}

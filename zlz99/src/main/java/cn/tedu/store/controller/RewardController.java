package cn.tedu.store.controller;

import cn.tedu.store.service.IOrdersAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RewardController {
	
	@Autowired
	private IOrdersAppService ordersAppService;
	
	@RequestMapping("/reward.do")
	public String outReward() {
		System.out.println("正在调用");
		
		ordersAppService.select();
		
		System.out.println("输出成功");
		
		return null;
	}
	
	
}

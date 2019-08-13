package cn.tedu.store.controller;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.entity.Province;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private IProvinceService provinceService;
	
	@Autowired public IGoodsService goodsService;
	
	@Autowired public IGoodsCategoryService goodsCategoryService;
	
	@RequestMapping("/form3.do")
	public String showTest3() {
		return "test3";
	}
	
	@RequestMapping("/handle_form3.do")
	public String handleTest3(Long[] goods, Integer[] num) {
		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i]);
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		return null;
	}
	
	@RequestMapping("/get_user_list.do")
	public String handleTest2(
		@RequestParam("username") String[] usernames, 
		@RequestParam("password") String[] passwords
		// User[] users
		) {
		System.out.println("用户列表");
//		for (int i = 0; i < users.length; i++) {
//			System.out.println(users[i]);
//		}
		
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < usernames.length; i++) {
			User user = new User();
			user.setUsername(usernames[i]);
			user.setPassword(passwords[i]);
			users.add(user);
		}
		
		for (User user : users) {
			System.out.println(user);
		}
		return null;
	}

	@RequestMapping("/address.do")
	public String showTest(ModelMap modelMap) {
		List<Province> provinces = 
			provinceService.getProvinceList();
		modelMap.addAttribute("provinces", provinces);
		return "test";
	}
	
	@RequestMapping("/goods.do")
	public String showGoodsList(ModelMap modelMap) {
		// 查询数据
		@SuppressWarnings("deprecation")
		List<Goods> goodsList = goodsService.getGoodsList();

		// 封装数据，准备转发
		modelMap.addAttribute("goodsList", goodsList);

		// 执行转发
		return "test_goods";
	}

	@RequestMapping("/goods_category.do")
	public String showGoodsList(
		Integer parentId, ModelMap modelMap) {
		// 设置默认parentId
		if (parentId == null) {
			parentId = 0;
		}
		
		// 查询数据
		@SuppressWarnings("deprecation")
		List<GoodsCategory> goodsCategoryList = 
			goodsCategoryService.getGoodsCategoryList(parentId);

		// 封装数据，准备转发
		modelMap.addAttribute(
			"goodsCategoryList", goodsCategoryList);

		// 执行转发
		return "test_goods_category";
	}
	
	
}








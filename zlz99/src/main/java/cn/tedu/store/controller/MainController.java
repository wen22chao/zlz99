package cn.tedu.store.controller;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController 
	extends BaseController {
	
	@Autowired
	private IGoodsCategoryService 
				goodsCategoryService;
	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping("/index.do")
	public String showIndex(ModelMap modelMap) {
		// 读取需要显示的商品分类数据
		Long categoryParentId = 161L; // Ctrl + 2, R
		Integer categoryCount = 3;
		Long computerCategoryId = 163L;
		Integer computerCount = 3;
		// 读取“电脑”的二级分类“”  ""
		// 读取"电脑"的二级分类 “”  ""
		// 读取“电脑”的二级分类  " "
		List<GoodsCategory> categories161
			= goodsCategoryService.getList(
				categoryParentId, categoryCount);
		// 读取各三级分类
		List<GoodsCategory> categories1611
			= goodsCategoryService.getList(
				categories161.get(0).getId());
		List<GoodsCategory> categories1612
			= goodsCategoryService.getList(
				categories161.get(1).getId());
		List<GoodsCategory> categories1613
			= goodsCategoryService.getList(
				categories161.get(2).getId());
		// 读取前3个电脑数据
		List<Goods> computers = 
				goodsService.getGoodsListByCategory(
					computerCategoryId, computerCount);
		
		// 封装必要的数据，以准备转发
		// 封装必要的数据，以准备转发
		// 1. 商品分类的数据
		modelMap.addAttribute("categories161", categories161);
		modelMap.addAttribute("categories1611", categories1611);
		modelMap.addAttribute("categories1612", categories1612);
		modelMap.addAttribute("categories1613", categories1613);
		// 2. 3台电脑的数据
		modelMap.addAttribute("computers", computers);
		
		// 转发到index.jsp
		return "index";
	}

}








package cn.tedu.store.controller;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IGoodsCategoryService goodsCategoryService;
	
	@RequestMapping("/list.do")
	public String showList(
	        @RequestParam("category_id") Long categoryId,
	        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
	        ModelMap modelMap) {
		// 该品类下的商品的总数
	    Integer goodsCount = 
	    		goodsService
	    			.getGoodsCountByCategory(
	    					categoryId);
	    // 计算页数
	    Integer pages = (int) Math.ceil(
	    		1.0 * goodsCount / IGoodsService.DEFAULT_COUNT_PER_PAGE);
	    // Integer pages = goodsCount / IGoodsService.DEFAULT_COUNT_PER_PAGE;
	    // pages += goodsCount % IGoodsService.DEFAULT_COUNT_PER_PAGE == 0 ? 0 : 1;
	    // if (goodsCount % IGoodsService.DEFAULT_COUNT_PER_PAGE != 0) {
	    //	pages++;
	    // }
		
	    // 判断page是否有效
	    if(page == null || page < 0) {
	        page = 1;
	    }
	    // 判断page的值是否在最大值范围之内
	    if (page > pages) {
	    	page = pages;
	    }
	    
	    // 通过业务层获取数据
	    // 1. 商品列表
	    Integer offset =
	         (page - 1) * IGoodsService.DEFAULT_COUNT_PER_PAGE;
	    List<Goods> goodsList = 
	            goodsService.getGoodsListByCategory(
	                categoryId, offset,
	                IGoodsService.DEFAULT_COUNT_PER_PAGE);
	    // 2. 商品分类数据
	    GoodsCategory goodsCategory
	    	= goodsCategoryService.getGoodsCategoryById(categoryId);
	    
	    // 将数据封装，准备转发
	    modelMap.addAttribute("goodsList", goodsList);
	    modelMap.addAttribute("goodsCategory", goodsCategory);
	    // 封装页数
	    modelMap.addAttribute("pages", pages);
	    // 封装当前页的页码
	    modelMap.addAttribute("page", page);
	    
	    // 执行转发
	    return "goods_list";
	}
	
	@RequestMapping("/details.do")
	public String showDetails(
			@RequestParam("id") Long id,
			ModelMap modelMap) {
		// 获取id对应的商品数据
		Goods goods = goodsService.getGoodsById(id);
		// 判断数据，避免用户恶意修改URL中的参数
		if (goods == null) {
			// 转发到error.jsp错误页面
			return "error";
		}
		
		// 获取与当前商品同型号的商品列表
		String itemType = goods.getItemType();
		List<Goods> goodsList = 
				goodsService
					.getGoodsListByItemType(
							itemType);
		
		// 封装数据，准备转发
		// 1. 当前商品数据
		modelMap.addAttribute("goods", goods);
		// 2. 同型号的商品列表
		modelMap.addAttribute("goodsList", goodsList);
		
		// 执行转发
		return "goods_details";
	}
	
}










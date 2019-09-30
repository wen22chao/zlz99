package cn.tedu.store.controller;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	ResponseResult<Object> rr;
	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping("/hotel")
	public String hotel() {
		return "hotel";
	}

	@RequestMapping("/index")
	@ResponseBody
	public ResponseResult<Object> index(String token,Integer page,Integer type){
		Integer uid = getUidFromToken(token);
		if(page == null) {
			page = 1;
		}
		if(type == null) {
			type = 1;
		}
		int per = page * 10 - 10;
		List<Map<String, Object>> list = goodsService.get_goods_list(per,type,uid);
		if(list.size() < 1) {
			return new ResponseResult<>(0, "参数错误！", "");
		}
		return new ResponseResult<>(1, "获取参数成功", list);
	}


	
}










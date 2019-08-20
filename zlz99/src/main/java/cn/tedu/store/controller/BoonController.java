package cn.tedu.store.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IBoonServicer;

@Controller
@RequestMapping("boon")
@ResponseBody
public class BoonController extends BaseController {
	
	public ResponseResult<Object> rr;
	@Autowired
	private IBoonServicer boonService;
	
	@RequestMapping("/convert.do")
	public ResponseResult<Object> convert(){
		
		List<HashMap<Object, Object>> list = boonService.convert();
		if(list == null || list.size() < 1) {
			return new ResponseResult<>(0,"未获取到优惠券信息");
		}
		
		return new ResponseResult<Object>(1,"获取优惠券信息成功！", list);
	}
	
	@RequestMapping("/convert_list.do")
	public ResponseResult<Object> convert_list(String token){
		if(token == null) {
			return new ResponseResult<>(0,"请传递用户token");
		}
		Integer id = getUidFromToken(token);
		Integer integral = boonService.getIntegralById(id);
		List<HashMap<Object, Object>> list = boonService.convert();
		if(list == null || list.size() < 1) {
			return new ResponseResult<>(0,"未获取到优惠券信息");
		}
		for(int i = 0; i < list.size(); i++) {
			list.get(i).put("day", "有效期" + list.get(i).get("day") + "天");
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("integral", integral);
		map.put("list", list);
		System.out.println(map.get("integral"));
		return new ResponseResult<Object>(1,"获取优惠券信息成功！", map);
	}
}	

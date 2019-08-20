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
}	

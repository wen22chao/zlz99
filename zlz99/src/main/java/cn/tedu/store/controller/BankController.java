package cn.tedu.store.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IBankService;
import cn.tedu.store.service.IIndexService;

@Controller
@RequestMapping("/bank")
@ResponseBody
public class BankController extends BaseController {
	
	private IBankService bankService;
	private IIndexService indexService;
	
	@RequestMapping("/get_user_bank.do")
	public ResponseResult<Object> get_user_bank(String token){
		System.out.println(token);
		ResponseResult<Object> rr = new ResponseResult<>();
		Integer uid = indexService.getUidFromToken(token);
		if(uid == 0) {
			rr.setState(ResponseResult.STATE_ERR);
			return rr;
		}
		HashMap<Object, Object> maps = bankService.get_user_bank(uid);
		if(maps.isEmpty()) {
			rr.setState(ResponseResult.STATE_ERR);
		}else {
			rr.setData(maps);
			rr.setMessage("获取参数成功！");
			rr.setState(ResponseResult.STATE_OK);
		}
		return rr;
	}
}

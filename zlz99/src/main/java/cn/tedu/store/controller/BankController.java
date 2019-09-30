package cn.tedu.store.controller;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IBankService;
import cn.tedu.store.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/bank")
@ResponseBody
public class BankController extends BaseController {
	
	@Autowired
	private IBankService bankService;
	@Autowired
	private IIndexService indexService;
	
	ResponseResult<Object> rr;
	
	@RequestMapping("/get_user_bank.do")
	public ResponseResult<Object> get_user_bank(String token){
		System.out.println(token);
		rr = new ResponseResult<>();
		Integer uid = indexService.getUidFromToken(token);
		System.out.println(uid);
		if(uid == 0) {
			rr.setState(ResponseResult.STATE_ERR);
			return rr;
		}
		List<HashMap<Object, Object>> maps = bankService.get_user_bank(uid);
		if(maps == null || maps.isEmpty()) {
			rr.setState(ResponseResult.STATE_ERR);
		}else {
			rr.setData(maps);
			rr.setMessage("获取参数成功！");
			rr.setState(ResponseResult.STATE_OK);
		}
		return rr; 
	}
	
	@RequestMapping("/get_user_open_bank.do")
	public ResponseResult<Object> get_user_open_bank(String token,String city,String card_name){
		rr = new ResponseResult<>();
		Integer uid = indexService.getUidFromToken(token);
		System.out.println(uid);
		if(uid == 0) {
			rr.setState(ResponseResult.STATE_ERR);
			rr.setMessage("token参数错误");
			return rr;
		}
		List<HashMap<Object, Object>> maps = bankService.get_user_open_bank(city,card_name);
		if(maps == null || maps.isEmpty()) {
			rr.setState(ResponseResult.STATE_ERR);
			rr.setMessage("未获取到银行信息");
		}else {
			rr.setData(maps);
			rr.setMessage("获取参数成功！");
			rr.setState(ResponseResult.STATE_OK);
		}
		return rr; 
	}
}

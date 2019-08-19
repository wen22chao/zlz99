package cn.tedu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IBankService;

@Controller
@RequestMapping("/user")
@ResponseBody
public class BankController extends BaseController {
	
	private IBankService bankService;
	
	@RequestMapping("/get_user_bank.do")
	public ResponseResult<Object> get_user_bank(String token){
		
		return null;
	}
}

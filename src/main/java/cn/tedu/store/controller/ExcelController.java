package cn.tedu.store.controller;

import cn.tedu.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ExcelController extends BaseController {
	
	@SuppressWarnings("unused")
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/excel.do")
	public String showExcel() {
		return "excel";
	}

}










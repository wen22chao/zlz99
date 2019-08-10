package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UsernameConflictException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/reg.do")
	public String showReg() {
		return "register";
	}
	
	@RequestMapping("/config.do")
	@ResponseBody
	public ResponseResult<String> showString() {
		ResponseResult<String> rr = new ResponseResult<String>();
		rr.setData("123");
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		
		return rr;
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<ArrayList> showList() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(2);
		list.add(3);
		ResponseResult<ArrayList> rr = new ResponseResult<ArrayList>();
		rr.setData(list);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		
		return rr;
	}
	 
	@RequestMapping("/test_view.do")
	public String showTest_view() {
		return "test_view";
	}
	
	@RequestMapping("/login.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/change_password.do")
	public String showChangePassword() {
		return "user_password";
	}
	
	@RequestMapping("/change_info.do")
	public String showChangeInfo(
			ModelMap modelMap,
			HttpSession session) {
		// 从session中获取当前用户的id“”""
		Integer id = getUidFromSession(session);
		// 根据id获取当前用户的信息
		User user = userService.findUserById(id);
		// 判断是否获取到用户数据，因为可能在登录后，数据被管理员删除
		if (user != null) {
			// 将数据封装到ModelMap对象，以转发到前端页面
			modelMap.addAttribute("user", user);
			// 执行转发
			return "user_info";
		} else {
			// 找不到数据，极可能是被管理员删除了
			// 执行重定向
			return "redirect:../main/error.do";
		}
	}
	
	@RequestMapping(value="/handle_reg.do",
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleReg(
			String username,
			String password,
			String phone,
			String email,
			HttpSession session) {
		ResponseResult<Void> rr;
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		
		try {
			User u = userService.reg(user);
			session.setAttribute("uid", u.getId());
			session.setAttribute("username", u.getUsername());
			rr = new ResponseResult<Void>(
					ResponseResult.STATE_OK);
		} catch (UsernameConflictException e) {
			rr = new ResponseResult<Void>(e);
		}
		
		return rr;
	}
	
	@RequestMapping(value="/handle_login.do",
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleLogin(
		String username, 
		String password,
		HttpSession session) {
		ResponseResult<Void> rr;
		try {
			User user = userService.login(username, password);
			session.setAttribute("uid", user.getId());
			session.setAttribute("username", user.getUsername());
			rr = new ResponseResult<Void>(
					ResponseResult.STATE_OK);
		} catch (ServiceException e) {
			rr = new ResponseResult<Void>(e);
		}
		return rr;
	}

	@RequestMapping(value="/handle_change_password.do",
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleChangePassword(
		String oldPassword,
		String newPassword,
		String confirmPassword,
		HttpSession session) {
		// 声明返回值
		ResponseResult<Void> rr;
		// 检查数据的有效性
		if (newPassword != null && 
			newPassword.equals(confirmPassword) &&
			newPassword.length() >= 6 && newPassword.length() <= 16) {
			try {
				// 从session中获取当前登录的用户的id
				Integer id = getUidFromSession(session);
				// 执行修改密码
				userService.changePassword(
					id, oldPassword, newPassword);
				rr = new ResponseResult<Void>(
						ResponseResult.STATE_OK);
			} catch (ServiceException e) {
				rr = new ResponseResult<Void>(e);
			}
		} else {
			// 两次输入的新密码不一致
			rr = new ResponseResult<Void>(
					ResponseResult.STATE_ERR,
					"两次输入的新密码不一致！");
		}
		// 返回
		return rr;
	}
	
	@RequestMapping(value="/handle_change_info.do",
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleChangeInfo(
				String username, 
				Integer gender,
				String phone, 
				String email,
				HttpSession session) {
		// 检查数据的有效性
		if ("".equals(username)) {
			username = null;
		}
		// 获取session中的uid
		Integer id = getUidFromSession(session);

		// 声明返回值
		ResponseResult<Void> rr;

		try {
			// 执行修改
			// 执行修改
			userService.changeInfo(id, username, gender, phone, email);
			rr = new ResponseResult<Void>(
						ResponseResult.STATE_OK);
		} catch (ServiceException e) {
			rr = new ResponseResult<Void>(e);
		}

		// 返回
		return rr;
	}
	
	@RequestMapping("/logout.do")
	
	public String handleLogout(HttpSession session) {
		// 清除session中的信息
		session.invalidate();
		// 重定向到首页
		return "redirect:../main/index.do";
	}
	
	@RequestMapping("/unreal_msg.do")
	@ResponseBody
	public ResponseResult<Object> getIndexProduct(String token,Integer type) {
		ResponseResult<Object> rr = new ResponseResult<Object>();
		
		List<HashMap> list = userService.getIndexUnreal_msg(type);
		if(list == null) {
			rr.setMessage("发生错误");
			return rr;
		}else {
			rr.setData(list);
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("获取参数成功！");
			
		}
		return rr;
	}
}










package cn.tedu.store.controller;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Area;
import cn.tedu.store.entity.City;
import cn.tedu.store.entity.Province;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IAreaService;
import cn.tedu.store.service.ICityService;
import cn.tedu.store.service.IProvinceService;
import cn.tedu.store.service.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	
	@Autowired 
	private IProvinceService provinceService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IAreaService areaService;
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping("/list.do")
	public String showList(
			String action,
			Integer id,
			ModelMap modelMap, HttpSession session) {
		// 判断此次显示列表页时，表单的操作类型
		String actionUrl;
		String actionTitle;
		if (!"edit".equals(action)) {
			action = "addnew";
			actionUrl = "addnew.do";
			actionTitle = "增加";
		} else {
			action = "edit";
			actionUrl = "edit.do";
			actionTitle = "修改";
			// 如果此次是修改操作，需要读取对应的数据
			Address address = 
					addressService.getAddressById(id);
			// 获取修改的地址对应的市列表和区列表
			// 并转发到JSP页面
			List<City> cities = cityService
					.getCityListByProvinceCode(
							address.getRecvProvince());
			List<Area> areas = areaService
					.getAreaListByCityCode(
							address.getRecvCity());
			// 封装所修改的收货地址数据
			modelMap.addAttribute("address", address);
			// 封装市列表
			modelMap.addAttribute("cities", cities);
			// 封装区列表
			modelMap.addAttribute("areas", areas);
		}
		// 获取省的列表
		List<Province> provinces
			= provinceService.getProvinceList();
		// 获取当前登录的用户的uid
		Integer uid = getUidFromSession(session);
		// 获取收货地址列表
		List<Address> addresses = 
			addressService.getAddressListByUid(uid);
		// 封装页面操作类型的名称 
		modelMap.addAttribute("actionTitle", actionTitle);
		// 封装当前页面表单的操作类型和提交位置
		modelMap.addAttribute("action", action);
		modelMap.addAttribute("actionUrl", actionUrl);
		// 封装省的列表，以准备转发
		modelMap.addAttribute("provinces", provinces);
		// 封装收货地址列表，以准备转发
		modelMap.addAttribute("addresses", addresses);
		// 执行转发
		return "address";
	}
	
	@RequestMapping("/addnew.do")
	public String handleAddnew(Address address,
			HttpSession session) {
		// 此次省略N多数据有效性的判断
		
		// 封装uid
		Integer uid = getUidFromSession(session);
		address.setUid(uid);
		// 执行增加
		addressService.addnew(address);
		// 完成，重定向
		return "redirect:list.do";
	}
	
	@RequestMapping("/delete.do")
	public String handleDelete(
			Integer id, HttpSession session) {
		// 获取uid
		Integer uid = getUidFromSession(session);
		// 执行删除
		addressService.deleteAddressById(id, uid);
		// 重定向到列表页
		return "redirect:list.do";
	}
	
	@RequestMapping("/set_default.do")
	public String handleSetDefault(
		@RequestParam("id") Integer id, 
		HttpSession session, 
		ModelMap modelMap) {
		// 获取uid
		Integer uid = getUidFromSession(session);
		// 执行
		try {
			addressService.setDefault(id, uid);
			return "redirect:list.do";
		} catch (ServiceException e) {
			// 封装e.getMessage()
			modelMap.addAttribute("err-msg", e.getMessage());
			// 转发到专门的错误页面
			return "error";
		}
	}
	
	@RequestMapping(value="/edit.do", 
			method=RequestMethod.POST)
	public String handleEdit(
		Address address,
		HttpSession session) {
		// 获取username
		String username = 
			session.getAttribute("username").toString();
		// 获取uid
		Integer uid = getUidFromSession(session);
		
		// 向Address对象中封装数据
		address.setUid(uid);

		try {
			// 执行修改
			addressService.update(username, address);

			// 返回：重定向
			return "redirect:list.do";
		} catch (ServiceException e) {
			// 转发到专门提示错误的页面
			return "error"; 
		}
	}
	
}

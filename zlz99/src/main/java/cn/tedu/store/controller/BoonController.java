package cn.tedu.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IBoonServicer;
import cn.tedu.store.service.IUtilService;

@Controller
@RequestMapping("boon")
@ResponseBody
public class BoonController extends BaseController {
	
	public ResponseResult<Object> rr;
	@Autowired
	private IBoonServicer boonService;
	@Autowired
	private IUtilService utilService;
	
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
	
	@RequestMapping("coupons_detail.do")
	public ResponseResult<Object> coupons_detail(Integer id, @RequestParam(value = "token") String token){
		Integer uid = getUidFromToken(token);
		if( uid == null || uid == 0 || id == null || id == 0) {
			return new ResponseResult<>(0,"请传入券id");
		}
		Integer integral = boonService.getIntegralById(uid);
		List<HashMap<Object, Object>> list = boonService.coupons_detail(id);
		if(list == null || list.size() < 1) {
			return new ResponseResult<>(0, "未查询到优惠券信息");
		}
		HashMap<Object, Object> map = new HashMap<>();
		map.put("integral", integral);
		list.add(map);
		return new ResponseResult<>(1, "获取优惠券信息成功！", list);
	}
	
	@RequestMapping("/user_convert.do")
	@Transactional
	public ResponseResult<Object> user_convert(String token,Integer id) throws Exception{
		Integer uid = getUidFromToken(token);
		if(token == null || id == null || uid == 0) {
			return new ResponseResult<>(0, "参数错误");
		}
		Integer integral = boonService.getIntegralById(uid);
		List<HashMap<Object, Object>> detail = boonService.coupons_detail(id);
		if(detail == null) {
			return new ResponseResult<>(0, "券id错误");
		}
		if(integral < (Integer)detail.get(0).get("integral")) {
			return new ResponseResult<>(0, "积分不足");
		}
		Boolean flag = boonService.is_conversion(uid, id);
		if(flag) {
			return new ResponseResult<>(0, "用户已经有相同的未使用的券");
		}
		Map<Object, Object> maps = detail.get(0);
		
		Integer nums = boonService.uptadeIntegral((Integer)maps.get("integral"),uid);
		System.out.println("num: = " + nums);
		
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("money", maps.get("money"));
		map.put("type", maps.get("type"));
		map.put("integral", maps.get("integral"));
		map.put("name", maps.get("name"));
		map.put("astrict_sum", maps.get("astrict_sum"));
		map.put("c_id", maps.get("id"));
		map.put("ctime", System.currentTimeMillis() / 1000);
		map.put("past_time", System.currentTimeMillis() / 1000 + 86400 * 15);
		map.put("day", maps.get("day"));
		
		
		Integer result1 = boonService.putMemberCoupon(map);
//		System.out.println(num + ".....");
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("user_id", uid);
		map2.put("num",  "-" + maps.get("integral") + "积分");
		System.out.println(maps.get("integral") + "+++++++");
		map2.put("name", "兑换" + maps.get("name"));
		map2.put("ctime", System.currentTimeMillis() / 1000);
		System.out.println(map2);
		
		Integer result2 = boonService.add_integral_data(map2);
		System.out.println(result1 + "---------" + result2);
		if(result1 == null || result2 == null) {
			throw new Exception();
		}
		return new ResponseResult<>(1, "兑换成功！", map2);
	}
	
	@RequestMapping("/user_coupons_log")
	public ResponseResult<Object> user_coupons_log(String token, Integer page){
		Integer uid = getUidFromToken(token);
		if(uid == 0) {
			return new ResponseResult<>(0,"token错误");
		}
		if(page == null) {
			page = 1;
		}
		Integer per = page * 10 - 10;
		List<Map<Object, Object>> list = boonService.get_user_coupons_log(uid,per);
		if(list.size() < 1) {
			return new ResponseResult<>(0, "已显示所有信息");
		}
		for(int i = 0; i < list.size(); i++) {
			long time = (long)(int)list.get(i).get("ctime");
			list.get(i).put("ctime", utilService.getStringDate(time));
			long past_time = (long)(int)list.get(i).get("past_time");
			list.get(i).put("past_time", utilService.getStringDate(past_time));
		}
		return new ResponseResult<>(1, "获取信息成功！", list);
	}
	
	@RequestMapping("/get_task")
	public ResponseResult<Object> get_task(){
		List<Map<Object, Object>> list = boonService.get_task();
		if(list.size() < 1) {
			return new ResponseResult<>(0, "未获取到任务");
		}
		return new ResponseResult<>(1, "获取任务成功！", list);
	}
	
	@RequestMapping("/user_exchange")
	public ResponseResult<Object> user_exchange(String token, Integer id){
		Integer uid = getUidFromToken(token);
		if(uid == 0 || id == null) {
			return new ResponseResult<>(0, "参数错误！");
		}
		Map<String, Object> map = boonService.user_exchange(uid, id);
		return new ResponseResult<>((int)map.get("state"), map.get("msg"));
	}
	
	@RequestMapping("/order_submit")
	@Transactional
	public ResponseResult<Object> order_submit(@Param(value = "token")String token,
			Integer id,
			String postman,
			String tele,
			String addr,
			Integer number){
		if(token == null || postman == null || tele == null || addr == null || id == null) {
			return new ResponseResult<>(0, "参数错误");
		}
		Integer uid = getUidFromToken(token);
		if(uid == 0) {
			return new ResponseResult<>(0, "token错误！");
		}
		if(number == null) {
			number = 1;
		}
		Integer integral = boonService.getIntegralById(uid);
		List<HashMap<Object,Object>> list = boonService.coupons_detail(id);
		int integral_all = number * (int)list.get(0).get("integral"); 
		if(integral <= 0 || integral < integral_all) {
			return new ResponseResult<>(0, "用户积分不足");
		}
		Integer uptadeIntegral = boonService.uptadeIntegral(integral_all, uid);
		if(uptadeIntegral == null) {
			return new ResponseResult<>(0, "发生错误", "");
		}
		Map<String,Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("o_money", list.get(0).get("money"));
		map.put("type", list.get(0).get("type"));
		map.put("o_name", list.get(0).get("name"));
		map.put("number", number);
		map.put("postman", postman);
		map.put("tele", tele);
		map.put("addr", addr);
		map.put("c_id", list.get(0).get("id"));
		map.put("c_time", (int)(System.currentTimeMillis() / 1000));
		
		Integer insertId = boonService.insert_member_exch_goods(map);
		System.out.println(insertId);
		
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("uid", uid);
		map1.put("money", list.get(0).get("money"));
		map1.put("type", list.get(0).get("type"));
		map1.put("integral", list.get(0).get("integral"));
		map1.put("name", list.get(0).get("name"));
		map1.put("ctime", System.currentTimeMillis() / 1000);
		map1.put("day", number);
		map1.put("o_id", insertId);
		
		Integer inseretId2 = boonService.insert_member_coupons(map1);
		System.out.println(inseretId2);
		
		HashMap<String, Object> map2 = new HashMap<>();
		System.out.println("\t" + uid + "\t");
		map2.put("user_id", uid);
		map2.put("num", "-" + integral_all + "积分");
		map2.put("name", "兑换" + list.get(0).get("name"));
		map2.put("ctime", System.currentTimeMillis() / 1000);
		Integer insertId3 = boonService.add_integral_data(map2);
		return new ResponseResult<>(1, "兑换成功", insertId3);
	}
	
	
	
	
	
	
	
	
	
	
}	

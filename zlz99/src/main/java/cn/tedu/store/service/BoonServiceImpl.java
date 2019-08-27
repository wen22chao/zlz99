package cn.tedu.store.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.BoonMapper;

@Service("boonService")
public class BoonServiceImpl implements IBoonServicer {

	@Autowired
	private BoonMapper boonMapper;
	
	public String getStringDate(long ctime) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = sdf.format(date);
		return string;
	}
	
	@Override
	public List<HashMap<Object, Object>> convert() {
		List<HashMap<Object, Object>> list = boonMapper.convert();
		return list;
	}
	@Override
	public Integer getIntegralById(Integer id) {
		
		return boonMapper.getIntegralById(id);
	}
	@Override
	public List<HashMap<Object, Object>> coupons_detail(Integer id) {
		List<HashMap<Object, Object>> list = boonMapper.coupons_detail(id);
		return list;
	}
	@Override
	public Boolean is_conversion(Integer uid, Integer c_id) {
		List<HashMap<Object, Object>> list = boonMapper.is_conversion(uid,c_id);
		System.out.println(list);
		if(list == null || list.size() < 1) {
			return true;
		}
		Integer past_time = (Integer)list.get(0).get("past_time");
		if(past_time > System.currentTimeMillis()) {
			return true;
		}
		return false;
	}
	@Override
	public Integer putMemberCoupon(Map<String, Object> map) {
		boonMapper.putMemberCoupon(map);
//		System.out.println("Service....." + map.get("id"));
		return (Integer) map.get("id");
	}
	@Override
	public Integer uptadeIntegral(Integer integral, Integer uid) {
		
		return boonMapper.uptadeIntegral( integral,  uid);
	}
	@Override
	public Integer add_integral_data(HashMap<String, Object> maps) {
		boonMapper.add_integral_data(maps);
		return (Integer) maps.get("id");
	}
	
	@Override
	public List<Map<Object, Object>> get_user_coupons_log(Integer uid, Integer per) {
		List<Map<Object, Object>> list = boonMapper.get_user_coupons_log(uid, per);
		if(list == null || list.size() < 1){
			return null;
		}
		return list;
	}
	@Override
	public List<Map<Object, Object>> get_task() {
		List<Map<Object, Object>> list = boonMapper.get_task();
		if(list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				long ctime = (long) list.get(i).get("ctime");
				list.get(i).put("ctime", getStringDate(ctime));
				
			}
			return list;
		}
		return null;
	}
	
	
}

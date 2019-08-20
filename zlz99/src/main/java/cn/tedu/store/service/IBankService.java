package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;


public interface IBankService {
	List<HashMap<Object, Object>>  get_user_bank(Integer uid);
	
	List<HashMap<Object, Object>> get_user_open_bank(String city,String bank_name);
}

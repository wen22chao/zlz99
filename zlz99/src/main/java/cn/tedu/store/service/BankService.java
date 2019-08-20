package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.BankMapper;

@Service("bankService")
public class BankService implements IBankService {

	@Autowired
	private BankMapper bankMapping;
	
	@Override
	public List<HashMap<Object, Object>> get_user_bank(Integer uid) {
		
		return bankMapping.get_user_bank(uid);
	}

	@Override
	public List<HashMap<Object, Object>> get_user_open_bank(String city,String bank_name) {
		if( city == null || bank_name == null) {
			return null;
		}
		List<HashMap<Object, Object>> list = bankMapping.get_user_open_bank(city,bank_name);
		return list.size() < 1 ? null : list;
	}

}

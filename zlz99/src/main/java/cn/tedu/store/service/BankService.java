package cn.tedu.store.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.BankMapper;

@Service("bankService")
public class BankService implements IBankService {

	@Autowired
	private BankMapper bankMapping;
	
	@Override
	public HashMap<Object, Object> get_user_bank(Integer uid) {
		
		return bankMapping.get_user_bank(uid);
	}

}

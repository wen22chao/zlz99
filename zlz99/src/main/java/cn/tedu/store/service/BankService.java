package cn.tedu.store.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tedu.store.mapper.BankMapping;

public class BankService implements IBankService {

	@Autowired
	private BankMapping bankMapping;
	
	@Override
	public HashMap<Object, Object> get_user_bank(Integer uid) {
		
		return bankMapping.get_user_bank();
	}

}

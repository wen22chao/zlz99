package cn.tedu.store.service;

import java.util.HashMap;

public interface IBankService {
	HashMap<Object, Object>  get_user_bank(String token);
}

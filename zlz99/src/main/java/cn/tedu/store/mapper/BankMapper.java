package cn.tedu.store.mapper;

import java.util.HashMap;

public interface BankMapper {

	HashMap<Object, Object> get_user_bank(Integer uid);
}

package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface BankMapper {

	List<HashMap<Object, Object>> get_user_bank(Integer uid);

	List<HashMap<Object,Object>> get_user_open_bank(@Param("city")String city, @Param("bank_name")String bank_name);
}

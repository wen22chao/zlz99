package cn.tedu.store.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BankMapper {

	List<HashMap<Object, Object>> get_user_bank(Integer uid);

	List<HashMap<Object,Object>> get_user_open_bank(@Param("city")String city, @Param("bank_name")String bank_name);
}

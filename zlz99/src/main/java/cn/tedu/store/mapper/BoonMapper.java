package cn.tedu.store.mapper;

import java.util.HashMap;
import java.util.List;

public interface BoonMapper {
	List<HashMap<Object,Object>> convert();
	Integer getIntegralById(Integer id);
}

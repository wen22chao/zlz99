package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;

public interface IBoonServicer {
	List<HashMap<Object,Object>> convert();
	Integer getIntegralById(Integer id);
}

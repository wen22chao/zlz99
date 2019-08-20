package cn.tedu.store.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.BoonMapper;

@Service("boonService")
public class BoonServiceImpl implements IBoonServicer {

	@Autowired
	private BoonMapper boonMapper;
	@Override
	public List<HashMap<Object, Object>> convert() {
		List<HashMap<Object, Object>> list = boonMapper.convert();
		return list;
	}
	@Override
	public Integer getIntegralById(Integer id) {
		
		return boonMapper.getIntegralById(id);
	}
	
	
}

package cn.tedu.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Members;
import cn.tedu.store.mapper.IndexMapper;

@Service("utilService")
public class UtilService implements IUtilService {

	@Autowired
	private IndexMapper indexMapper;
	
	@Override
	public Integer getUidFromToken(String token) {
		
		if(token == null) {
			return 0;
		}
		Members lists = indexMapper.getUidFromToken(token);
		if(lists == null || lists.getId() == null) {
			return 0; 
		}
		Integer id = lists.getId();
		return id;
	}

}

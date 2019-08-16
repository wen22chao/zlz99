package cn.tedu.store.service;

import java.util.List;

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
		List<Members> lists = indexMapper.getUidFromToken(token);
		if(lists == null || lists.size() == 0) {
			return 0; 
		}
		Integer id = lists.get(0).getId();
		return id;
	}

}

package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Members;
import cn.tedu.store.mapper.IndexMapper;

@Service("utilService")
public class Util {
	
	@Autowired
	private static IndexMapper indexMapper;
	
	public static Integer getUidByToken(String token) {
		
		List<Members> lists = indexMapper.getUidFromToken(token);
		
		System.out.println(lists);
		return 0;
	}
}	

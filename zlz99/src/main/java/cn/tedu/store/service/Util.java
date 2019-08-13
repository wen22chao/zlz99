package cn.tedu.store.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.IndexMapper;

@Service("utilService")
public class Util {
	
	@Autowired
	private static IndexMapper indexMapper;
	
	public static Integer getUidByToken(String token) {
		HashMap<String, Integer> map = indexMapper.getUidFromToken(token);
		System.out.println(map);
		if(map.isEmpty()) {
			return 0;
		}
		return map.get("id");
	}
}	

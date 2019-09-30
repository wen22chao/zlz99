package cn.tedu.store.service;

import cn.tedu.store.entity.Members;
import cn.tedu.store.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	@Override
	public String getStringDate(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date(time * 1000L));
		return format;
	}

}

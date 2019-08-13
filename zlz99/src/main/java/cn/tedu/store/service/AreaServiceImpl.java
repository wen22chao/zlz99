package cn.tedu.store.service;

import cn.tedu.store.entity.Area;
import cn.tedu.store.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	public List<Area> getAreaListByCityCode(String cityCode) {
		return areaMapper.getAreaListByCityCode(cityCode);
	}

	public Area getAreaByCode(String areaCode) {
		return areaMapper.getAreaByCode(areaCode);
	}

}

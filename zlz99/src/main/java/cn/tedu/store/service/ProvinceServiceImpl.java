package cn.tedu.store.service;

import cn.tedu.store.entity.Province;
import cn.tedu.store.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private ProvinceMapper provinceMapper;
	
	public List<Province> getProvinceList() {
		return provinceMapper.getProvinceList();
	}

	public Province getProvinceByCode(String provinceCode) {
		return provinceMapper.getProvinceByCode(provinceCode);
	}

}

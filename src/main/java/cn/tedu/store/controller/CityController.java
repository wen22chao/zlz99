package cn.tedu.store.controller;

import cn.tedu.store.entity.City;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private ICityService cityService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<City>> 
		getList(String provinceCode) {
		ResponseResult<List<City>> rr;
		List<City> cities = 
				cityService
					.getCityListByProvinceCode(
						provinceCode);
		rr = new ResponseResult<List<City>>(
				ResponseResult.STATE_OK, cities);
		return rr;
	}
	
	@RequestMapping("/info.do")
	@ResponseBody
	public ResponseResult<City>
		getInfo(String code) {
		ResponseResult<City> rr;
		City city = 
				cityService.getCityByCode(code);
		rr = new ResponseResult<City>(
				ResponseResult.STATE_OK, city);
		return rr;
	}
	
}

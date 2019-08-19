package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.Banner;
import cn.tedu.store.entity.Config;
import cn.tedu.store.entity.IndexTz;
import cn.tedu.store.entity.Product;
import cn.tedu.store.entity.RealDeal;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IIndexService;
import cn.tedu.store.service.IUtilService;

@Controller
@ResponseBody
@RequestMapping("/index")
public class IndexController extends BaseController {
	
	@Autowired
	private IIndexService indexService;
	@Autowired
	private IUtilService utilService;
	
/***
 * 
 * @param session
 * @return
 */
	@RequestMapping("/user_tz_all.do")
	@ResponseBody
	public ResponseResult<Object> getIndexUserAllTz(HttpSession session) {
		ResponseResult<Object> rr = new ResponseResult<>();
		IndexTz indexTz = indexService.getUserAllTz();
		
		if(indexTz == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(indexTz);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}

	@RequestMapping("/test.do")
	@ResponseBody
	public ResponseResult<Object> getUidFromToken11(String token) {
		System.out.println(token);
		Integer lists = indexService.getUidFromToken(token);
		ResponseResult<Object> rr = new ResponseResult<>();
		
		if(lists == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(lists);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping(value="/test2.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> getUidFromToken12(String token) {
//		System.out.println(token);
		Integer id = utilService.getUidFromToken(token);
		ResponseResult<Object> rr = new ResponseResult<>();
		
		if(id == 0 || id == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(id);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping(value="/test", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> getUidFromToken13(String token) {
//		System.out.println(token);
		Integer id = utilService.getUidFromToken(token);
		ResponseResult<Object> rr = new ResponseResult<>();
		
		if(id == 0 || id == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(id);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping("/banner.do")
	@ResponseBody
	public ResponseResult<Object> getIndexBanner(Integer type) {
		ResponseResult<Object> rr = new ResponseResult<>();
		List<Banner> indexBanners = indexService.getIndexBanner(type);
		
		if(indexBanners == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(indexBanners);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping("/real_deal.do")
	@ResponseBody
	public ResponseResult<Object> getIndexBanner() {
		ResponseResult<Object> rr = new ResponseResult<>();
		List<RealDeal> realDeals = indexService.getIndexRealDeal();
		
		if(realDeals == null) {
			return new ResponseResult<>(ResponseResult.STATE_ERR);
		}
		rr.setData(realDeals);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping("/config.do")
	public ResponseResult<Object> getIndexConfig(HttpSession session) {
		ResponseResult<Object> rr = new ResponseResult<>();
		
		List<Config> list = indexService.findIndexConfig();
		if(list == null) {
			rr.setMessage("发生错误");
			return rr;
		}else {
			List<String> list1 = new ArrayList<String>();
			rr.setData(list1);
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("获取参数成功！");
			
		}
		return rr;
	}
	
	@RequestMapping("/product.do")
	public ResponseResult<Object> getIndexProduct(HttpSession session) {
		ResponseResult<Object> rr = new ResponseResult<>();
		
		List<Product> list = indexService.getIndexProduct();
		if(list == null) {
			rr.setMessage("发生错误");
			return rr;
		}else {
			rr.setData(list);
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("获取参数成功！");
			
		}
		return rr;
	}
}










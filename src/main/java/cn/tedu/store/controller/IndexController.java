package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.Banner;
import cn.tedu.store.entity.Config;
import cn.tedu.store.entity.IndexTz;
import cn.tedu.store.entity.Product;
import cn.tedu.store.entity.RealDeal;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IIndexService;

@Controller
@ResponseBody
@RequestMapping("/index")
public class IndexController extends BaseController {
	
	@Autowired
	private IIndexService indexService;
	

	@RequestMapping("/user_tz_all.do")
	@ResponseBody
	//
	public ResponseResult<Object> getIndexUserAllTz(HttpSession session) {
		ResponseResult<Object> rr = new ResponseResult<Object>();
		IndexTz indexTz = indexService.getUserAllTz();
		
		if(indexTz == null) {
			return new ResponseResult<Object>(ResponseResult.STATE_ERR);
		}
		rr.setData(indexTz);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}

	@RequestMapping("/banner.do")
	@ResponseBody
	public ResponseResult<Object> getIndexBanner(Integer type) {
		ResponseResult<Object> rr = new ResponseResult<Object>();
		List<Banner> indexBanners = indexService.getIndexBanner(type);
		
		if(indexBanners == null) {
			return new ResponseResult<Object>(ResponseResult.STATE_ERR);
		}
		rr.setData(indexBanners);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping("/real_deal.do")
	@ResponseBody
	public ResponseResult<Object> getIndexBanner() {
		ResponseResult<Object> rr = new ResponseResult<Object>();
		List<RealDeal> realDeals = indexService.getIndexRealDeal();
		
		if(realDeals == null) {
			return new ResponseResult<Object>(ResponseResult.STATE_ERR);
		}
		rr.setData(realDeals);
		rr.setMessage("成功！");
		rr.setState(ResponseResult.STATE_OK);
		return rr;
	}
	
	@RequestMapping("/config.do")
	public ResponseResult<Object> getIndexConfig(HttpSession session) {
		ResponseResult<Object> rr = new ResponseResult<Object>();
		
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
		ResponseResult<Object> rr = new ResponseResult<Object>();
		
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










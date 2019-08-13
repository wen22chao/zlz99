package cn.tedu.store.service;

import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	@SuppressWarnings("deprecation")
	public List<GoodsCategory> getGoodsCategoryList(
			Integer parentId) {
		return goodsCategoryMapper
				.getGoodsCategoryList(parentId);
	}

	public List<GoodsCategory> getList(
			Long parentId, Integer count) {
		// 判断parentId，如果没有值，视为查询一级分类的列表
		if (parentId == null) {
			parentId = 0L;
		}
		// 通过持久层执行查询并获取数据
		return goodsCategoryMapper.getList(
				parentId, count);
	}

	public List<GoodsCategory> getList(
			Long parentId) {
		// 直接调用自身的重载方法
		return getList(parentId, null);
	}

	public GoodsCategory getGoodsCategoryById(Long id) {
		return goodsCategoryMapper
				.getGoodsCategoryById(id);
	}
	
}








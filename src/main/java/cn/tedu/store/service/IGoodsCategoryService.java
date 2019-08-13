package cn.tedu.store.service;

import cn.tedu.store.entity.GoodsCategory;

import java.util.List;

public interface IGoodsCategoryService {

	/**
	 * 获取某个分类下的分类列表
	 * @param parentId 父级分类的id 
	 * @return 分类列表
	 */
	@Deprecated
	List<GoodsCategory> getGoodsCategoryList(
			Integer parentId);
	
	/**
	 * 获取商品分类列表
	 * @param parentId 商品分类的父级分类id，如果是一级分类，则父级分类id值为0
	 * @param count 需要获取的商品分类的数量
	 * @return 商品分类的List集合
	 */
	List<GoodsCategory> getList(
			Long parentId, 
			Integer count);
	
	/**
	 * 获取商品分类列表
	 * @param parentId 商品分类的父级分类id，如果是一级分类，则父级分类id值为0
	 * @return 商品分类的List集合
	 */
	List<GoodsCategory> getList(Long parentId);
	
	/**
	 * 根据商品分类的id，获取商品分类信息
	 * @param id 商品分类的id
	 * @return 商品分类信息
	 */
	GoodsCategory getGoodsCategoryById(Long id);
}

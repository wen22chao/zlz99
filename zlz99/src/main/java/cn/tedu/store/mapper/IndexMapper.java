package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Banner;
import cn.tedu.store.entity.Config;
import cn.tedu.store.entity.IndexTz;
import cn.tedu.store.entity.Members;
import cn.tedu.store.entity.Product;
import cn.tedu.store.entity.RealDeal;

public interface IndexMapper {
	
	List<Members> getUidFromToken(String token);
	
	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return 受影响的行数
	 */
	List<IndexTz> getUserAllTz();
	
	List<IndexTz> getUserAllTzEarn();
	
	/**
	 * 首页查询基本配置信息
	 * @return
	 */
	List<Config> select();
	
	List<Banner> getIndexBanner(Integer type);

	List<RealDeal> getIndexRealDeal();
	
	List<Product> getIndexProduct();
	



}









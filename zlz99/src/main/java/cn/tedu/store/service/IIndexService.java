package cn.tedu.store.service;

import cn.tedu.store.entity.*;

import java.util.List;

public interface IIndexService {
	
	

	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return 用户信息，如果没有匹配的用户信息，则返回null
	 * 查询用户的信息，如果没有匹配度用户信息，则返回null
	 * 查询用户的信息，如果没有匹配的用户信息，则返回null
	 */
	List<Config> findIndexConfig();
	/**
	 * 
	 */
	IndexTz getUserAllTz();
	
	List<Banner> getIndexBanner(Integer type);
	
	List<RealDeal> getIndexRealDeal();
	
	List<Product> getIndexProduct();
	
	Integer getUidFromToken(String token);
	

}

	

	









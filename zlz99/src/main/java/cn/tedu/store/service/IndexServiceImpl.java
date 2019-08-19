package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Banner;
import cn.tedu.store.entity.Config;
import cn.tedu.store.entity.IndexTz;
import cn.tedu.store.entity.Members;
import cn.tedu.store.entity.Product;
import cn.tedu.store.entity.RealDeal;
import cn.tedu.store.mapper.IndexMapper;

@Service("indexService")
public class IndexServiceImpl implements IIndexService {

	@Autowired
	private IndexMapper indexMapper;

	@Override
	public List<Config> findIndexConfig() {
		List<Config> config = indexMapper.select();
		if (config == null) {
			return null;
		} else {
			return config;
		}
	}

	@Override
	public IndexTz getUserAllTz() {
		IndexTz indexTz = new IndexTz();
		List<IndexTz> list = indexMapper.getUserAllTz();
		List<IndexTz> list2 = indexMapper.getUserAllTzEarn();
		System.out.println(list);
//		indexTz.setAll_earn(indexMapper.getUserAllTzEarn().getAll_earn());
		if (list != null && list2 != null) {
			indexTz = list.get(0);
			indexTz.setAll_earn(list2.get(0).getAll_earn());
			System.out.println(indexTz);
		}
		return indexTz;
	}

	@Override
	public List<Banner> getIndexBanner(Integer type) {
		List<Banner> list = indexMapper.getIndexBanner(type);
		return list;
	}

	@Override
	public List<RealDeal> getIndexRealDeal() {
		List<RealDeal> lists = indexMapper.getIndexRealDeal();

		return lists;
	}

	@Override
	public List<Product> getIndexProduct() {
		List<Product> list = indexMapper.getIndexProduct();
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public Integer getUidFromToken(String token) {
		System.out.println(0000);
		Members lists = indexMapper.getUidFromToken(token);
		System.out.println(1111);
		
		return lists.getId();
	}

}

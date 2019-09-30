package cn.tedu.store.service;

import cn.tedu.store.entity.*;
import cn.tedu.store.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
		if(lists == null){
			return 0;
		}
		return lists.getId();
	}

}

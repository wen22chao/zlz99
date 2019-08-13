package cn.tedu.store.service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl 
	implements IGoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@SuppressWarnings("deprecation")
	public List<Goods> getGoodsList() {
		return goodsMapper.getGoodsList();
	}

	public List<Goods> getGoodsListByCategory(
			Long categoryId, 
			Integer offset, 
			Integer countPerPage) {
		return goodsMapper
				.getGoodsListByCategory(
					categoryId, offset, countPerPage);
	}

	public List<Goods> getGoodsListByCategory(
			Long categoryId, Integer count) {
		return getGoodsListByCategory(
				categoryId, 0, count);
	}

	public Integer getGoodsCountByCategory(
			Long categoryId) {
		return goodsMapper
				.getGoodsCountByCategory(
					categoryId);
	}

	public Goods getGoodsById(Long id) {
		return goodsMapper.getGoodsById(id);
	}

	public List<Goods> getGoodsListByItemType(
			String itemType) {
		return goodsMapper
				.getGoodsListByItemType(
						itemType);
	}

}





package cn.tedu.store.service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl 
	implements IGoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;



	@Override
	public List<Map<String, Object>> get_goods_list(int per, Integer type, Integer uid) {
		List<Map<String, Object>> list = goodsMapper.get_goods_list(per, type);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).remove("service_content");
			Number a = (Number)list.get(i).get("id");
			Number number = goodsMapper.get_user_tz(a.intValue());
			if(number == null) {
				number = 0;
			}
			Integer get_user_tz =  number.intValue();
			System.out.println(get_user_tz);
			System.out.println(list.get(i).get("money_pond"));
			System.out.println("****");
			list.get(i).put("surplus_tz", (int)list.get(i).get("money_pond") - get_user_tz);
			List<Map<String,Object>> list2 = goodsMapper.check_user_tz(uid, a.intValue());
			if(list2.size() > 0) {
				list.get(i).put("is_user_tz", 1);
			}else {
				list.get(i).put("is_user_tz", 0);
			}
		}
		return list;
	}



	@Override
	public List<Goods> getGoodsList() {
		return null;
	}



	@Override
	public List<Goods> getGoodsListByCategory(Long categoryId, Integer offset, Integer countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Goods> getGoodsListByCategory(Long categoryId, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Integer getGoodsCountByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Goods getGoodsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Goods> getGoodsListByItemType(String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

}





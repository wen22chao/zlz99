package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface GoodsMapper {



	/**
	 * 获取首页来租排行
	 * @param per
	 * @param type
	 * @return
	 */
	List<Map<String, Object>> get_goods_list(@Param(value="per")int per, @Param(value="type")Integer type);

	/**
	 * 获取某个产品的总投资金额
	 * @param id
	 * @return 
	 */
	Number get_user_tz(int id);

	List<Map<String, Object>> check_user_tz(@Param(value="user_id")Integer user_id, @Param(value="goods_id")Integer goods_id);
}










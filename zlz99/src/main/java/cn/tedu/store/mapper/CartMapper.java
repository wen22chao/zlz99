package cn.tedu.store.mapper;

import cn.tedu.store.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

	/**
	 * 增加购物车数据
	 * @param cart 购物车数据
	 * @return 受影响的行数
	 */
	Integer insert(Cart cart);
	
	/**
	 * 查询某用户的购物车信息
	 * @param uid 用户id
	 * @param offset 跳过多少条记录
	 * @param countPerPage 每页显示多少
	 * @return 用户的购物车信息
	 */
	List<Cart> getListByUid(
			@Param("uid") Integer uid, 
			@Param("offset") Integer offset, 
			@Param("countPerPage") Integer countPerPage);
	
	/**
	 * 根据用户id和商品id查询购物车信息
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 购物车信息，如果没有匹配信息，则返回null
	 */
	Cart getCartByUserAndGoods(
			@Param("uid") Integer uid, 
			@Param("goodsId") Long goodsId);
	
	/**
	 * 修改购物车某商品的数量
	 * @param num 商品的新的数量
	 * @param id 购物车信息的id
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer changeNumber(
			@Param("num") Integer num,
			@Param("id") Integer id,
			@Param("uid") Integer uid);

	/**
	 * 根据id查询购物车数据
	 * @param cartId 购物车数据的id
	 * @return 购物车数据
	 */
	Cart getCartById(Integer cartId);
	
	/**
	 * 删除购物车数据
	 * @param uid 数据的持有用户的id
	 * @param ids 需要删除的数据的id形成的数组
	 * @return 受影响的行数
	 */
	Integer delete(
			@Param("uid") Integer uid, 
			@Param("ids") Integer[] ids);
	
}








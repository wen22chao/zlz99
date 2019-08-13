package cn.tedu.store.service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ex.DataNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private CartMapper cartMapper;

	public Cart insert(Cart cart) {
		// 保存日志信息
		Date now = new Date();
		cart.setCreatedUser("System");
		cart.setCreatedTime(now);
		cart.setModifiedUser("System");
		cart.setModifiedTime(now);
		
		cartMapper.insert(cart);
		return cart;
	}

	public List<Cart> getListByUid(Integer uid, Integer page) {
		// 判断page
		if (page == null || page < 1) {
			page = 1;
		}
		// 确定每页显示多少条数据
		Integer countPerPage = DEFAULT_COUNT_PER_PAGE;
		// 跳过多少条数据
		Integer offset = (page - 1) * countPerPage;
		// 执行查询，并返回结果
		return cartMapper.getListByUid(
				uid, offset, countPerPage);
	}

	public Cart getCartByUserAndGoods(Integer uid, Long goodsId) {
		return cartMapper.getCartByUserAndGoods(uid, goodsId);
	}

	public Integer changeNumber(Integer num, Integer id, Integer uid) {
		Integer rows = cartMapper.changeNumber(num, id, uid);
		if (rows == 1) {
			return 1;
		} else {
			throw new DataNotExistsException("修改失败！尝试访问的数据不存在，可能已经被删除！请联系系统管理员！");
		}
	}

	public Integer addToCart(Cart cart) {
		// 查询用户id与商品id同时匹配的记录是否存在
		Integer uid = cart.getUid();
		Long goodsId = cart.getGoodsId();
		Cart data = 
			getCartByUserAndGoods(uid, goodsId);
		if (data != null) {
			// 存在：修改数量
			Integer id = data.getId();
			// 最终提交到数据表的num = 
			//		原本数据表中的num + 
			//		用户此次通过前端页面提交的num
			Integer num = 
					data.getNum() + cart.getNum(); // 1 + 3
			return changeNumber(num, id, uid);
		} else {
			// 不存在：添加数据
			insert(cart);
			return 1;
		}
	}

	public List<Cart> getListByIds(Integer[] cartIds) {
		// 准备List集合
		List<Cart> carts = new ArrayList<Cart>();
		// 根据若干个id查询对应的购物车数据
		for (Integer cartId : cartIds) {
			Cart cart 
				= cartMapper.getCartById(cartId);
			carts.add(cart);
		}
		// 返回
		return carts;
	}

	public Integer delete(Integer uid, Integer[] ids) {
		Integer rows 
				= cartMapper.delete(uid, ids);
		if (rows == ids.length) {
			return rows;
		} else {
			throw new DataNotExistsException(
					"尝试删除的数据不存在！");
		}
	}

}









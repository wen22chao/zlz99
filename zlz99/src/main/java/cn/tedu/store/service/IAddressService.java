package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.DataNotExistsException;

import java.util.List;

public interface IAddressService {

	/**
	 * 新增收货地址
	 * @param address 收货地址
	 * @return 收货地址完整信息，将包括数据的id
	 */
	Address addnew(Address address);
	
	/**
	 * 根据用户的id获取该用户的所有收货地址
	 * @param uid 用户的id
	 * @return 该用户的收货地址列表
	 */
	List<Address> getAddressListByUid(Integer uid);
	
	/**
	 * 根据数据id获取收货地址信息
	 * @param id 数据id
	 * @return 收货地址信息
	 */
	Address getAddressById(Integer id);
	
	/**
	 * 根据数据id删除收货地址信息
	 * @param id 数据id
	 * @param uid 数据持有者的id
	 * @return 如果删除成功则返回1，否则，返回0
	 */
	Integer deleteAddressById(Integer id, Integer uid);
	
	/**
	 * 将指定的收货地址设置为默认收货地址
	 * @param id 需要设置为默认收货地址的数据id
	 * @param uid 该收货地址的持有者
	 * @return 受影响的行数
	 * @throws DataNotExistsException
	 */
	Integer setDefault(Integer id, Integer uid);
	
	/**
	 * 修改收货地址信息
	 * @param username 用户名，该收货地址的持有者，用于记录日志
	 * @param address 新的收货地址信息，必须包含id、uid及新数据，且不包含isDefault
	 * @return 受影响的行数
	 * @throws DataNotExistsException
	 */
	Integer update(String username, Address address);
	
}







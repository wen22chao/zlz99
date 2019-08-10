package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.ex.DataNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IAreaService areaService;
	
	@Autowired
	private AddressMapper addressMapper;
	
	public Address addnew(Address address) {
		// 获取省市区对应的中文名称
		String district = getDistrict(
				address.getRecvProvince(), 
				address.getRecvCity(), 
				address.getRecvArea());
		address.setRecvDistrict(district);
		
		// 封装日志信息
		Date now = new Date();
		address.setCreatedUser("System");
		address.setCreatedTime(now);
		address.setModifiedUser("System");
		address.setModifiedTime(now);
		
		// 确定是否默认
		// 先获取当前用户的所有收货地址
		List<Address> list = getAddressListByUid(
				address.getUid());
		// 判断当前用户的收货地址的数量
		if (list.size() == 0) {
			// 当前用户还没有创建任何收货地址
			// 即此次创建的是第1条收货地址
			// 则该收货地址是该用户的默认地址
			address.setIsDefault(1);
		} else {
			// 当前用户已经创建过收货地址
			// 则该收货地址不作为默认地址
			address.setIsDefault(0);
		}

		// 执行增加
		addressMapper.insert(address);
		// 返回
		return address;
	}

	public List<Address> getAddressListByUid(Integer uid) {
		String where = "uid=" + uid;
		String orderBy = "is_default desc, id desc";
		return addressMapper.select(
				where, orderBy, null, null);
	}

	public Address getAddressById(Integer id) {
		String where = "id=" + id;
		List<Address> list = 
			addressMapper.select(
					where, null, null, null);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public Integer deleteAddressById(Integer id, Integer uid) {
		// 查询即将删除的数据的信息
		Address data = getAddressById(id);
		
		// 确定删除时的条件
		String where = "id=" + id + " AND uid=" + uid;
		// 执行删除
		Integer rows = 
				addressMapper.delete(where);
		// 判断删除是否成功
		if (rows == 0) {
			throw new DataNotExistsException("删除失败！尝试删除的数据不存在！请联系系统管理员！");
		}
		
		// 判断刚刚删除的数据是否为默认收货地址
		if (data.getIsDefault() == 1) {
			// 刚刚删除的数据是默认收货地址
			// 需要把剩余的地址中，id最大的设置为默认
			// 则应该根据id倒序排列找出id最大的数据
			where = "uid=" + uid;
			String orderBy = "id desc";
			Integer offset = 0;
			Integer countPerPage = 1;
			List<Address> list = 
				addressMapper.select(
					where, orderBy, offset, countPerPage);
			// 判断是否找到了数据
			if (list.size() > 0) {
				// 找到了数据，则取出第1条，
				// 这条数据就是删除后，
				// 即将设置为默认收货地址的数据
				data = list.get(0);
				// 取出这条数据的id，用于设置为默认收货地址
				Integer dataId = data.getId();
				// 将这条数据设置为默认收货地址
				Address address = new Address();
				address.setId(dataId);
				address.setUid(uid);
				address.setIsDefault(1);
				rows = addressMapper.update(address);
				// 判断设置默认收货地址是否成功
				if (rows == 0) {
					throw new DataNotExistsException("尝试失败！无法进行后续更新操作！请联系系统管理员！");
				} else {
					// 返回
					return 1;
				}
			}
		}
		
		// 返回删除时受影响的行数
		return rows;
	}

	@Transactional
	public Integer setDefault(Integer id, Integer uid) {
		// 创建Address对象，因为持久层方法要求参数是Address类型
		Address address = new Address();
		// 封装第1次执行时的参数
		address.setIsDefault(0);
		address.setUid(uid);
		// 执行：将所有收货地址设置为非默认
		Integer rows = addressMapper.update(address);
		// 判断第1次操作是否成功
		if (rows > 0) {
			// 封装第2次执行时的参数
			address.setIsDefault(1);
			address.setId(id);
			// address.setUid(uid);
			// 执行：将指定收货地址设置为默认
			rows = addressMapper.update(address);
			if (rows > 0) {
				return rows;
			} else {
				throw new DataNotExistsException("修改失败！尝试修改的数据[2]不存在，请联系系统管理员！");
			}
		} else {
			throw new DataNotExistsException("修改失败！尝试修改的数据[1]不存在，请联系系统管理员！");
		}
	}

	public Integer update(String username, Address address) {
		// 获取省市区的名称
		String district = getDistrict(
				address.getRecvProvince(), 
				address.getRecvCity(), 
				address.getRecvArea());
		
		// 确定参数address中的必要数据
		address.setIsDefault(null);
		address.setRecvDistrict(district);
		address.setModifiedUser(username);
		address.setModifiedTime(new Date());
		
		// 执行修改 
		Integer rows = addressMapper.update(address);

		// 确定如何返回
		if (rows == 1) {
			return 1; // 基于id执行修改，受影响的行数只可能是1或者0
		} else {
			throw new DataNotExistsException("修改失败！尝试修改的数据不存在，请联系系统管理员！");
		}
	}
	
	/**
	 * 获取省市区的名称
	 * @param provinceCode 省的代号
	 * @param cityCode 市的代号
	 * @param areaCode 区的代号
	 * @return 省市区的名称
	 */
	private String getDistrict(
			String provinceCode,
			String cityCode,
			String areaCode) {
		// 组成recvDistrict
		// 11000  110100  110101
		// recvDistrict = "北京市   市辖区     海淀区"
		StringBuffer district = new StringBuffer();
		String provinceName = 
				provinceService.getProvinceByCode(
					provinceCode).getName();
		String cityName = 
				cityService.getCityByCode(
					cityCode).getName();
		String areaName =
				areaService.getAreaByCode(
					areaCode).getName();
		
		district.append(provinceName);
		district.append(cityName);
		district.append(areaName);
		
		return district.toString();
	}

}

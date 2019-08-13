import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.ServiceException;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AddressServiceTest {

	@Test
	public void testGetAddressList() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
					"spring-dao.xml", "spring-service.xml");
		
		IAddressService service
			= ac.getBean(
				"addressService", IAddressService.class);
		
		Integer uid = 8;
		List<Address> addresses
			= service.getAddressListByUid(uid);
		
		System.out.println("【数据列表】");
		for (Address address : addresses) {
			System.out.println(address);
		}
		System.out.println("【结束】");
		
		ac.close();
	}
	
	@Test
	public void testGetAddress() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IAddressService service
			= ac.getBean(
				"addressService", IAddressService.class);
		
		Integer id = 5;
		Address address = service.getAddressById(id );
		System.out.println("【Result】");
		System.out.println(address);
		System.out.println("【Done】");
		
		ac.close();
	}
	
	@Test
	public void testSetDefault() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IAddressService service
			= ac.getBean(
				"addressService", IAddressService.class);
		
		Integer uid = 8;
		Integer id = 3;
		try {
			service.setDefault(id, uid);
			System.out.println("修改成功！");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		
		ac.close();
	}
	
}

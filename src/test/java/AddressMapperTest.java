import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressMapperTest {

	@Test
	public void testInsert() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml");
		
		AddressMapper addressMapper
			= ac.getBean("addressMapper", AddressMapper.class);
		
		Address address = new Address();
		address.setUid(8);
		address.setRecvName("刘老师");
		address.setRecvProvince("110000");
		address.setRecvCity("110100");
		address.setRecvArea("110101");
		address.setRecvDistrict("北京市市辖区海淀区");
		address.setRecvAddress("3栋1单元666室");
		address.setRecvPhone("13900139000");
		Integer rows = addressMapper.insert(address);
		System.out.println("rows=" + rows);
		
		ac.close();
	}
	
}

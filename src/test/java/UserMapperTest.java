import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {

	@Test
	public void testInsert() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext("spring-dao.xml");
		
		UserMapper mapper = 
				ac.getBean("userMapper", UserMapper.class);
		
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setGender(1);
		user.setPhone("13800138000");
		user.setEmail("admin@tedu.cn");
		mapper.insert(user);
		
		ac.close();
	}
	
	@Test
	public void testSelect() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext("spring-dao.xml");
		
		UserMapper mapper = 
				ac.getBean("userMapper", UserMapper.class);
		
		String where = "id=3";
		String orderBy = null;
		Integer offset = null;
		Integer countPerPage =null;
		List<User> users 
			= mapper.select(where, orderBy, offset, countPerPage);
		
		System.out.println(users.size());
		for(User u : users) {
			System.out.println(u);
		}
		
		ac.close();
	}
	
	@Test
	public void testUpdate() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext("spring-dao.xml");
		
		UserMapper mapper = 
				ac.getBean("userMapper", UserMapper.class);
		
		User user = new User();
		user.setId(3);
		// user.setUsername("Html");
		user.setPassword("000000");
		user.setGender(0);
		user.setPhone("13800138001");
		user.setEmail("html@tedu.cn");
		Integer rows = mapper.update(user);
		System.out.println(rows);
		
		ac.close();
	}
	
}

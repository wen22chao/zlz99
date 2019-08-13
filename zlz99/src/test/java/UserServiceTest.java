import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
	
	@Test
	public void testReg() {
		AbstractApplicationContext ac
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IUserService service
		= ac.getBean("userService", IUserService.class);
		
		User user = new User();
		user.setUsername("SpringMVC");
		user.setPassword("123456");
		
		User data = service.reg(user);
		System.out.println(data);
		
		ac.close();
	}	
	
	@Test
	public void testFindUserByUsername() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IUserService service
			= ac.getBean("userService", IUserService.class);
		
		User user = 
			service.findUserByUsername("SpringMVC");
		System.out.println(user);
		
		ac.close();
	}	
	
	@Test
	public void testLogin() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IUserService service
			= ac.getBean("userService", IUserService.class);
		
		String username = "SpringMVC";
		String password = "888888";
		User user = 
				service.login(username, password);
		System.out.println(user);
		
		ac.close();
	}	
	
	@Test
	public void testChangePassword() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IUserService service
			= ac.getBean("userService", IUserService.class);
		
		Integer id = 8;
		String oldPassword = "123456";
		String newPassword = "888888";
		Integer rows = 
				service.changePassword(
					id, oldPassword, newPassword);
		System.out.println("rows=" + rows);
		
		ac.close();
	}	
	
	@Test
	public void testChangeInfo() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
		
		IUserService service
			= ac.getBean("userService", IUserService.class);
		
		Integer id = 8;
		String username = "SpringBoot";
		Integer gender = 1;
		String phone = "13900139001";
		String email = "SpringMVC@tedu.cn";
		Integer rows = service.changeInfo(id, username, gender, phone, email);
		System.out.println("rows=" + rows);
		
		ac.close();
	}	
}

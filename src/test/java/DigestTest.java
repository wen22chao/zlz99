import org.springframework.util.DigestUtils;

public class DigestTest {

	public static void main(String[] args) {
		System.out.println("DigestTest");
		
		String[] passwords = {
				"123456",
				"123450", 
				"123456" };
		String salt = "java"; // 密码加盐
		for (int i = 0; i < passwords.length; i++) {
			String md5Str =
					DigestUtils.md5DigestAsHex(
						passwords[i].getBytes());
			md5Str = DigestUtils.md5DigestAsHex((salt + md5Str).getBytes());
			System.out.println(md5Str.toUpperCase());
		}
	}

}

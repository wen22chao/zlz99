import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {

	public static void main(String[] args) 
			throws NoSuchAlgorithmException {
		System.out.println("MessageDigestTest");
		
		String[] passwords = {
			"123456", "123450", "123456" };
		MessageDigest md
			= MessageDigest.getInstance("MD5");
		
		for (int i = 0; i < passwords.length; i++) {
			byte[] mdBytes
				= md.digest(passwords[i].getBytes());
			
			for (int j = 0; j < mdBytes.length; j++) {
				int v = mdBytes[j] & 0xff;
				if (v < 16) {
					System.out.print(0);
				}
				String s = Integer.toHexString(v);
				System.out.print(s.toUpperCase());
			}
			System.out.println();
		}
	}

}






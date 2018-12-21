import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class TestContactInfo {
	public ArrayList<ContactInfo> list;
	
	String name = "sarah";
	String phone = "010-1234-5678";
	String email = "sarah@email.com";
	ContactInfo info = new ContactInfo(name, phone, email);
	
	@Test
	@DisplayName("Get Name from Contact Info")
	public void getName() {
		info.setName(name);
		String result = info.getName();
		assertEquals("sarah", result);
	}
	
	@Test
	@DisplayName("Get Email from Contact Info")
	public void getEmail() {
		info.setEmail(email);
		String result = info.getEmail();
		assertEquals("sarah@email.com", result);
	}
	
	@Test
	@DisplayName("Get Phone number from Contact Info")
	public void getPhone() {
		info.setEmail(phone);
		String result = info.getPhone();
		assertEquals("010-1234-5678", result);
	}
	
	@Test
	@DisplayName("Get All data from Contact Info")
	public void getContactInfo() {
		String result = info.toString();
		assertEquals("NAME: sarah  | PHONE: 010-1234-5678  | EMAIL: sarah@email.com", result);
	}
}

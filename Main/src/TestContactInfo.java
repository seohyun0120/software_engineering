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
	@DisplayName("연락처 정보중에서 이름 가져오기")
	public void getName() {
		info.setName(name);
		String result = info.getName();
		assertEquals("sarah", result);
	}
	
	@Test
	@DisplayName("연락처 정보중에서 이메일 가져오기")
	public void getEmail() {
		info.setEmail(email);
		String result = info.getEmail();
		assertEquals("sarah@email.com", result);
	}
	
	@Test
	@DisplayName("연락처 정보중에서 핸드폰 번호 가져오기")
	public void getPhone() {
		info.setEmail(phone);
		String result = info.getPhone();
		assertEquals("010-1234-5678", result);
	}
	
	@Test
	@DisplayName("연락처 정보(이름, 연락처, 이메일 전부 가져오기")
	public void getContactInfo() {
		String result = info.toString();
		assertEquals("이름: sarah  | 연락처: 010-1234-5678  | 이메일: sarah@email.com", result);
	}
}

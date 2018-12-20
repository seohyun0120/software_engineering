import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TestContactInfo {
	public static ContactMenu menu;
	public static final String DATA_DIR = "data";
	public static final String DATA_FILE = "contact.data";
	public ArrayList<ContactInfo> list;
	
	String name = "sarah";
	String phone = "010-1234-5678";
	String email = "sarah@email.com";
	
	int test1_index = 1;
	int test2_index = 2;
	ContactInfo info = new ContactInfo(name, phone, email);
	ContactInfoManager manager = new ContactInfoManager();
	
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
	@DisplayName("연락처 정보 전부 가져오기")
	public void getContactInfo() {
		String result = info.toString();
		assertEquals("이름: sarah  | 연락처: 010-1234-5678  | 이메일: sarah@email.com", result);
	}
	
	@Test
	@DisplayName("폴더에서 contact.data파일 있는지 확인")
	public void initDataFile() {
		int result = manager.initDataFile(DATA_DIR, DATA_FILE);
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("연락처 파일에서 테스트 계정 정보 가져오기")
	public void selectInfoFromList() {
		info = manager.select(test1_index);
		String result = info.toString();
		assertEquals("이름: test  | 연락처: 010-1111-1111  | 이메일: test@test.com", result);
	}
	
	@Test
	@Disabled()
	@DisplayName("연락처 파일에 테스트2 계정 정보 넣기")
	public void insertInfoFromList() {
		ContactInfo contact = new ContactInfo("JUnit5", "JUnitEmail", "JUnit5@test.com");
		int result = manager.insert(contact);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("연락처 파일에 테스트2 계정 정보 수정")
	public void updateInfoFromList() {
		ContactInfo contact = new ContactInfo("JUnit5", "JUnit5Email", "JUnit5_test@test.com");
		int result = manager.update(test2_index, contact);
		assertEquals(1, result);
	}
}

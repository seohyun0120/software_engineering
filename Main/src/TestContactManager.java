import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class TestContactManager {
	public ArrayList<ContactInfo> list;
	
	public static final String DATA_DIR = "data";
	public static final String DATA_FILE = "contact.data";
	
	String name = "sarah";
	String phone = "010-1234-5678";
	String email = "sarah@email.com";
	
	ContactInfo info = new ContactInfo(name, phone, email);
	ContactManager manager = new ContactManager();
	
	int test_0_index = 0;
	int test_1_index = 1;

	@Test
	@DisplayName("contact 폴더 있는지 확인")
	public void test5_initDataDir() {
		int result = manager.initDataDir(DATA_DIR);
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("폴더에 contact.data파일 있는지 확인")
	public void test4_initDataFile() {
		int result = manager.initDataFile(DATA_DIR, DATA_FILE);
		assertEquals(0, result);
	}
	
	
	@Test
	@DisplayName("연락처 파일에 테스트 계정 정보 넣기")
	public void test3_insertInfoFromList() {
		ContactInfo contact = new ContactInfo("test2", "test2Email", "test2@test.com");
		int result = manager.insert(contact);
		assertEquals(1, result);
	}
	
	
	@Test
	@DisplayName("연락처 파일에 테스트 계정 정보 수정")
	public void test2_updateInfoFromList() {
		ContactInfo contact = new ContactInfo("test2", "test2Email", "test2_update@test.com");
		int result = manager.update(test_1_index, contact);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("연락처 파일에 테스트 계정 정보 삭제")
	public void	test1_deleteInfoFromList() {
		int result = manager.delete(test_1_index);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("연락처 파일에서 test 계정 정보 가져오기")
	public void test6_selectInfoFromList() {
		info = manager.select(test_0_index);
		String result = info.toString();
		assertEquals("이름: test  | 연락처: 010-1111-1111  | 이메일: test@test.com", result);
	}
}

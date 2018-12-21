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
	@DisplayName("Check if data folder exists")
	public void test5_initDataDir() {
		int result = manager.initDataDir(DATA_DIR);
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("Check if contact file exists")
	public void test4_initDataFile() {
		int result = manager.initDataFile(DATA_DIR, DATA_FILE);
		assertEquals(0, result);
	}
	
	
	@Test
	@DisplayName("Put Data into Contact file")
	public void test3_insertInfoFromList() {
		ContactInfo contact = new ContactInfo("test2", "test2Email", "test2@test.com");
		int result = manager.insert(contact);
		assertEquals(1, result);
	}
	
	
	@Test
	@DisplayName("Update Data into Contact file")
	public void test2_updateInfoFromList() {
		ContactInfo contact = new ContactInfo("test2", "test2Email", "test2_update@test.com");
		int result = manager.update(test_1_index, contact);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("Detele Data into Contact file")
	public void	test1_deleteInfoFromList() {
		int result = manager.delete(test_1_index);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("Get Data from Contact file")
	public void test6_selectInfoFromList() {
		info = manager.select(test_0_index);
		String result = info.toString();
		assertEquals("NAME: test  | PHONE: 010-1111-1111  | EMAIL: test@test.com", result);
	}
}

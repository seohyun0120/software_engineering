import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class TestTodoManager {
public ArrayList<TodoInfo> list;
	
	public static final String DATA_DIR = "data";
	public static final String DATA_FILE = "todo.data";
	
	String date = "2018/12/21";
	String due = "2018/12/21";
	String description = "소웨공 3차과제 마감";
	
	TodoInfo info = new TodoInfo(date, due, description);
	TodoManager manager = new TodoManager();
	
	int test_0_index = 0;
	int test_1_index = 1;

	@Test
	@DisplayName("contact")
	public void test5_initDataDir() {
		int result = manager.initDataDir(DATA_DIR);
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("contact.data")
	public void test4_initDataFile() {
		int result = manager.initDataFile(DATA_DIR, DATA_FILE);
		assertEquals(0, result);
	}
	
	
	@Test
	public void test3_insertInfoFromList() {
		TodoInfo contact = new TodoInfo("test2", "test2-2", "test2-3");
		int result = manager.insert(contact);
		assertEquals(1, result);
	}
	
	
	@Test
	public void test2_updateInfoFromList() {
		TodoInfo contact = new TodoInfo("test2", "test2-2", "test2-3 Update");
		int result = manager.update(test_1_index, contact);
		assertEquals(1, result);
	}
	
	@Test
	public void	test1_deleteInfoFromList() {
		int result = manager.delete(test_1_index);
		assertEquals(1, result);
	}
	
	@Test
	public void test6_selectInfoFromList() {
		info = manager.select(test_0_index);
		String result = info.toString();
		assertEquals("Date: test  | Due: 2018/12/21  | Description: test", result);
	}
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class TestTodoInfo {
public ArrayList<TodoInfo> list;
	
	String date = "2018/12/21";
	String due = "2018/12/21";
	String description = "소웨공 3차과제 마감";
	TodoInfo info = new TodoInfo(date, due, description);
	
	@Test
	public void getDate() {
		info.setDate(date);
		String result = info.getDate();
		assertEquals("2018/12/21", result);
	}
	
	@Test
	public void getDue() {
		info.setDue(due);
		String result = info.getDue();
		assertEquals("2018/12/21", result);
	}
	
	@Test
	public void getDescription() {
		info.setDescription(description);
		String result = info.getDescription();
		assertEquals("소웨공 3차과제 마감", result);
	}
	
	@Test
	public void getContactInfo() {
		String result = info.toString();
		assertEquals("Date: 2018/12/21  | Due: 2018/12/21  | Description: 소웨공 3차과제 마감", result);
	}
}

import java.io.Serializable;

public class AppointInfo implements Serializable {
	private static final long serialVersionUID = 1L; // Serializable error 諛⑹�
	private String name;
	private String date;
	private String time;
	
	public AppointInfo() {}
	public AppointInfo(String name, String date, String time) {
		this.name = name;
		this.date = date;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}
	
	public void setEmail(String time) {
		this.time = time;
	}
	
	public String toString() {
		String str = "이름: " + name + "  |" + " 날자: " + date + "  |" + " 시간: " + time; 
		return str;
	}
}

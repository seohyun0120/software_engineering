import java.io.Serializable;

public class AppointInfo implements Serializable {
	private static final long serialVersionUID = 1L; // Serializable error 諛⑹�

	private String name;
	private String date;
	private String time;
	private String location;

	
	
	public AppointInfo() {}
	public AppointInfo(String name, String date, String time, String location) {
	
		this.name = name;
		this.date = date;
		this.time = time;
		this.location = location;
		
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
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toString() {
		String str = "이름: " + name + "  |" + " 날짜: " + date + "  |" + " 시간: " + time+"  |"+" 위치: "+location+"\n"; 
		return str;
	}
}

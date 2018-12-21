import java.io.Serializable;

public class TodoInfo implements Serializable {
<<<<<<< HEAD
	private static final long serialVersionUID = 1L; // Serializable error 諛⑹�
=======
	private static final long serialVersionUID = 1L;
>>>>>>> dev-Huikyung
	private String date;
	private String due;
	private String description;
	
	public TodoInfo() {}
	public TodoInfo(String date, String due, String description) {
		this.date = date;
		this.due = due;
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDue() {
		return due;
	}
	
	public void setDue(String due) {
		this.due = due;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		String str = "Date: " + date + "  |" + " Due: " + due + "  |" + " Description: " + description; 
		return str;
	}
}
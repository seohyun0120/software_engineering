import java.io.Serializable;

public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 1L; // Serializable error 방지
	private String name;
	private String phone;
	private String email;
	
	public ContactInfo() {}
	public ContactInfo(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String str = "이름: " + name + "  |" + " 연락처: " + phone + "  |" + " 이메일: " + email; 
		return str;
	}
}

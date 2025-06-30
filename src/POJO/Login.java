package POJO;

public class Login {
	private String emailId;
	private String pass;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Login(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.pass = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

	@Override
	public String toString() {
		return "Login:\nemailId=" + emailId + ", \npassword=" + pass;
	}
	
	
}

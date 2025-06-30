package POJO;

public class Customer {
	private int custId;
	private String custName;
	private String emailId;
	private String custPass;
	private String custAdd;
	private String custContact;
	private String custLoc;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String custName, String emailId, String custPass, String custAdd, String custContact,
			String custLoc) {
		super();
		this.custName = custName;
		this.emailId = emailId;
		this.custPass = custPass;
		this.custAdd = custAdd;
		this.custContact = custContact;
		this.custLoc = custLoc;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustPass() {
		return custPass;
	}

	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	public String getCustLoc() {
		return custLoc;
	}

	public void setCustLoc(String custLoc) {
		this.custLoc = custLoc;
	}

	@Override
	public String toString() {
		return "Customer:\ncustId=" + custId + ", \ncustName=" + custName + ", \nemailId=" + emailId + ", \ncustPass="
				+ custPass + ", \ncustAdd=" + custAdd + ", \ncustContact=" + custContact + ", \ncustLoc=" + custLoc ;
	}

	
	
	
}

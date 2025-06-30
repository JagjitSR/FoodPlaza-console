package DAO;

public interface LoginDAO {
	public boolean userLogin(String emailId, String pass);
	public boolean adminLogin(String emailId, String pass);
}

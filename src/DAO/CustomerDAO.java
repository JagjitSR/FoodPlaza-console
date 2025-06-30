package DAO;

import java.util.List;

import POJO.Customer;

public interface CustomerDAO {
	
	public boolean AddCustomer(Customer C);
	public boolean UpdateCustomer(String emailId,Customer C);
	public boolean DeleteCustomer(String emailId);
	public Customer SearchByEmailId(String emailId);
	public List <Customer> getAllCustomer();
	
}
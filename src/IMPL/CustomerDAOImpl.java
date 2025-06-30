package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CustomerDAO;
import POJO.Customer;
import Util.DBUtility;

public class CustomerDAOImpl implements CustomerDAO{

	public boolean AddCustomer(Customer C) {

		Connection con=DBUtility.getConnect();
		String sql="insert into Customer(custName,emailId,custPass,custAdd,custContact,custLoc) values (?,?,?,?,?,?)";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, C.getCustName());
		ps.setString(2, C.getEmailId());
		ps.setString(3, C.getCustPass());
		ps.setString(4, C.getCustAdd());
		ps.setString(5, C.getCustContact());
		ps.setString(6, C.getCustLoc());
		int i=ps.executeUpdate();
		if (i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean UpdateCustomer(String emailId,Customer C) {
		Connection con=DBUtility.getConnect();
		String sql="update Customer set custName=?, custPass=?, custAdd=?, custContact=?, custLoc=? where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, C.getCustName());
			ps.setString(2, C.getCustPass());
			ps.setString(3, C.getCustAdd());
			ps.setString(4, C.getCustContact());
			ps.setString(5, C.getCustLoc());
			ps.setString(6, C.getEmailId());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean DeleteCustomer(String emailId) {
		Connection con=DBUtility.getConnect();
		String sql="delete from Customer where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public Customer SearchByEmailId(String emailId) {
		Connection con=DBUtility.getConnect();
		Customer Cs=null;
		String sql="select * from Customer where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Cs=new Customer();
				Cs.setCustId(rs.getInt(1));
				Cs.setCustName(rs.getString(2));
				Cs.setEmailId(rs.getString(3));
				Cs.setCustPass(rs.getString(4));
				Cs.setCustAdd(rs.getString(5));
				Cs.setCustContact(rs.getString(6));
				Cs.setCustLoc(rs.getString(7));
				return Cs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List <Customer> getAllCustomer(){
		Connection con=DBUtility.getConnect();
		Customer Cg=new Customer();
		String sql="select * from Customer";
		List<Customer> l=new ArrayList<Customer>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Cg=new Customer();
				Cg.setCustId(rs.getInt(1));
				Cg.setCustName(rs.getString(2));
				Cg.setEmailId(rs.getString(3));
				Cg.setCustPass(rs.getString(4));
				Cg.setCustAdd(rs.getString(5));
				Cg.setCustContact(rs.getString(6));
				Cg.setCustLoc(rs.getString(7));
				l.add(Cg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
		
	}
	
}
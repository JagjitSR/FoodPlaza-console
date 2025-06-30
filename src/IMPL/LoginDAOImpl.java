package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.LoginDAO;
import Util.DBUtility;

public class LoginDAOImpl implements LoginDAO{

	public boolean userLogin(String emailId, String pass) {
		Connection con=DBUtility.getConnect();
		String sql="select * from Customer where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String custPass=rs.getString("custPass");
				if(custPass.equals(pass)) {
					return true;
				}
				else{
					return false;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean adminLogin(String emailId, String pass) {
		Connection con=DBUtility.getConnect();
		String sql="";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

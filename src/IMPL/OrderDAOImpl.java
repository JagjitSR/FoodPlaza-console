package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DAO.OrderDAO;
import POJO.OrderFood;
import Util.DBUtility;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public boolean placeOrder(OrderFood o) {
		LocalDateTime dt=LocalDateTime.now();
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatedDateTime=dt.format(f);
		double totalBill=calculatedBill(o.getEmailId());
		Connection con=DBUtility.getConnect();
		String sql="insert into OrderFood(orderDate,totalBill,cEmail,orderStatus)values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setTimestamp(1,Timestamp.valueOf(formatedDateTime));
			ps.setDouble(2,totalBill);
			ps.setString(3,o.getEmailId());
			ps.setString(4, o.getOrderStatus());
			
			int i=ps.executeUpdate();
			if(i>0) {
				new CartDAOImpl().deleteCartByEmail(o.getEmailId());
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private double calculatedBill(String emailId) {
		double totalBill=0;
		Connection con=DBUtility.getConnect();
		String sql="select totalPrice from Cart where CEmail=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				totalBill=rs.getDouble("totalPrice");
			}
			return totalBill;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public OrderFood showOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderFood> showAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeOrderStatus(String orderStatus, int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderFood> showMyOrderHistory(String emailId) {
		Connection con=DBUtility.getConnect();
		OrderFood O=new OrderFood();
		String sql="select * from OrderFood";
		List<OrderFood> l=new ArrayList<OrderFood>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				O=new OrderFood();
				O.setOrderId(rs.getInt(1));
				O.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				O.setTotalBill(rs.getDouble(3));
				O.setEmailId(rs.getString(4));
				O.setOrderStatus(rs.getString(5));
				l.add(O);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}

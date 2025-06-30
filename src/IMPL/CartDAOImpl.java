package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CartDAO;
import POJO.Cart;
import POJO.Food;
import Util.DBUtility;

public class CartDAOImpl implements CartDAO {
			
	@Override
	public boolean addToCart(Cart cart) {
		Connection con=DBUtility.getConnect();
		String sql="insert into Cart(foodId,fprice,fquantity,totalPrice,cEmail,fname)values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,cart.getFoodId());
			Food f=new FoodDaoImpl().SearchFoodById(cart.getFoodId());
			pst.setDouble(2,f.getFoodPrice());
			pst.setInt(3, cart.getFquantity());
			double totalPrice=f.getFoodPrice()*cart.getFquantity();
			pst.setDouble(4, totalPrice);
			pst.setString(5, cart.getcEmail());
			pst.setString(6, f.getFoodName());
			
			int row=pst.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> showCartList() {
		Connection con=DBUtility.getConnect();
		Cart C=null;
		List<Cart> l=new ArrayList<Cart>();
		String sql="select * from Cart";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				C=new Cart();
				C.setCartId(rs.getInt(1));
				C.setFoodId(rs.getInt(2));
				C.setcEmail(rs.getString(3));
				C.setFquantity(rs.getInt(4));
				C.setFname(rs.getString(5));
				C.setFprice(rs.getDouble(6));
				C.setTotalPrice(rs.getDouble(7));
				l.add(C);
			}
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Cart> searchCartById(int cartId) {
		Connection con=DBUtility.getConnect();
		Cart C=null;
		String sql="select * from Cart where cartId=?";
		List<Cart> l=new ArrayList<Cart>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				C=new Cart();
				C.setCartId(rs.getInt(1));
				C.setFoodId(rs.getInt(2));
				C.setcEmail(rs.getString(3));
				C.setFquantity(rs.getInt(4));
				C.setFname(rs.getString(5));
				C.setFprice(rs.getDouble(6));
				C.setTotalPrice(rs.getDouble(7));
				l.add(C);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Cart> searchByEmailId(String cEmail) {
		Connection con=DBUtility.getConnect();
		Cart C=null;
		String sql="select * from Cart where cEmail=?";
		List<Cart> l=new ArrayList<Cart>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cEmail);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				C=new Cart();
				C.setCartId(rs.getInt(1));
				C.setFoodId(rs.getInt(2));
				C.setcEmail(rs.getString(3));
				C.setFquantity(rs.getInt(4));
				C.setFname(rs.getString(5));
				C.setFprice(rs.getDouble(6));
				C.setTotalPrice(rs.getDouble(7));
				l.add(C);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean deleteCartById(int cartId) {
		Connection con=DBUtility.getConnect();
		String sql="delete from Cart where cartId=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,cartId);
			int i=pst.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException E) {
			E.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCartByEmail(String cEmail) {
		Connection con=DBUtility.getConnect();
		String sql="delete from Cart where cEmail=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,cEmail);
			int i=pst.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException E) {
			E.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCart(int cartId, int fquantity) {
		double totalPrice=calculateTotalPrice(cartId,fquantity);
		Connection con=DBUtility.getConnect();
		String sql="Update Cart set fquantity=?,totalPrice=? where cartId=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, fquantity);
			pst.setDouble(2, totalPrice);
			pst.setInt(3, cartId);
			int i=pst.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException E){
			E.printStackTrace();
		}
		return false;
	}
	
private double calculateTotalPrice(int cartId,int fquantity) {
	double totalPrice=0.0;
    Connection con = DBUtility.getConnect();
    String sql = "SELECT fquantity, fprice FROM Cart WHERE cartId = ?";
    try {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cartId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            double price = rs.getDouble("fprice");
            totalPrice = fquantity * price;
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
		return totalPrice;
	}
	
}

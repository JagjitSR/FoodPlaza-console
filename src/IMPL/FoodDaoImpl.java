package IMPL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.FoodDao;
import POJO.Food;
import Util.DBUtility;

public class FoodDaoImpl implements FoodDao {

	@Override
	public boolean AddFood(Food f) {
		Connection con=DBUtility.getConnect();
		String sql="insert into Food(foodName,foodType,foodCategory,foodDesc,foodPrice,img) values (?,?,?,?,?,?)";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, f.getFoodName());
		ps.setString(2, f.getFoodType());
		ps.setString(3, f.getFoodCategory());
		ps.setString(4, f.getFoodDesc());
		ps.setDouble(5, f.getFoodPrice());
		ps.setString(6, f.getImg());
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

	@Override
	public boolean UpdateFood(Food f) {
		Connection con=DBUtility.getConnect();
		String sql="update Food set foodName=?,foodType=?,foodCategory=?,foodDesc=?,foodPrice=?,img=? where foodId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setString(4, f.getFoodDesc());
			ps.setDouble(5, f.getFoodPrice());
			ps.setString(6, f.getImg());
			ps.setInt(7, f.getFoodId());
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

	@Override
	public boolean DeleteFood(int foodId) {
		Connection con=DBUtility.getConnect();
		String sql="delete from Food where foodId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
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

	@Override
	public Food SearchFoodById(int foodId) {
		Connection con=DBUtility.getConnect();
		Food f1=null;
		String sql="select * from Food where foodId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getInt(6));
				f1.setImg(rs.getString(7));
				return f1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		Connection con=DBUtility.getConnect();
		Food f2=new Food();
		String sql="select * from Food";
		List<Food> l=new ArrayList<Food>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f2=new Food();
				f2.setFoodId(rs.getInt(1));
				f2.setFoodName(rs.getString(2));
				f2.setFoodType(rs.getString(3));
				f2.setFoodCategory(rs.getString(4));
				f2.setFoodDesc(rs.getString(5));
				f2.setFoodPrice(rs.getInt(6));
				f2.setImg(rs.getString(7));
				l.add(f2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Food> SearchFoodByName(String foodName) {
		Connection con=DBUtility.getConnect();
		Food f1=null;
		String sql="select * from Food where foodName=?";
		List<Food> l=new ArrayList<Food>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getInt(6));
				f1.setImg(rs.getString(7));
				l.add(f1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Food> SearchFoodByCategory(String foodCategory) {
		Connection con=DBUtility.getConnect();
		Food f1=null;
		String sql="select * from Food where foodCategory=?";
		List<Food> l=new ArrayList<Food>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodCategory);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getInt(6));
				f1.setImg(rs.getString(7));
				l.add(f1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	
}

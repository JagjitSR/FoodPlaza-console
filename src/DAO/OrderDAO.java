package DAO;

import java.util.List;

import POJO.OrderFood;

public interface OrderDAO {
	boolean placeOrder(OrderFood o);
	OrderFood showOrderById(int orderId);
	List<OrderFood> showAllOrder();
	public boolean changeOrderStatus(String orderStatus,int orderId);
	public List<OrderFood> showMyOrderHistory(String emailId);
}

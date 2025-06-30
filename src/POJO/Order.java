package POJO;

import java.time.LocalDateTime;

public class Order {

	private int OrderId;
	private LocalDateTime orderDate;
	private double totalBill;
	private String emailId;
	private String orderStatus;

	public Order() {
		super();
	}

	public Order(int orderId, LocalDateTime orderDate, double totalBill, String emailId, String orderStatus) {
		super();
		OrderId = orderId;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
		this.emailId = emailId;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", orderDate=" + orderDate + ", totalBill=" + totalBill + ", emailId="
				+ emailId + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
}

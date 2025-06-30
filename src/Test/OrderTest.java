package Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import IMPL.CartDAOImpl;
import IMPL.LoginDAOImpl;
import IMPL.OrderDAOImpl;
import POJO.Cart;
import POJO.OrderFood;

public class OrderTest {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		OrderDAOImpl oimpl=new OrderDAOImpl();
		System.out.println("Enter EmailId");
		String email=sc.nextLine();
		System.out.println("Enter Password");
		String password=sc.nextLine();
		boolean login=new LoginDAOImpl().userLogin(email,password);
		boolean oMenuLoop=true;
		if(login) {
			do {
				System.out.println("1. Place Order");
				System.out.println("2. Show my Order History");
				int option=sc.nextInt();
				sc.nextLine();
				switch(option) {
				case 1:{
					List<Cart> clist=new CartDAOImpl().searchByEmailId(email);
					if(clist!=null && clist.isEmpty()!=true) {
						for(Cart c:clist) {
							System.out.println(c);
							System.out.println("------------------------------");
						}
						System.out.println("Procced to Buy? Enter YES/NO");
						String answer=sc.nextLine().toUpperCase();
						if(answer.equals("YES")) {
							String orderStatus="Processing";
							OrderFood O=new OrderFood();
							O.setOrderStatus(orderStatus);
							O.setEmailId(email);
							boolean flag=oimpl.placeOrder(O);
							if(flag) {
								System.out.println("Your Order Has Been Placed");
								LocalTime time=LocalTime.now().plusHours(1);
								System.out.println("Delivery will be done before: "+time);
							}
							else {
								System.out.println("Error whileplacing order");
							}
						}
						else if(answer.equals("NO")){
							System.out.println("Thank you for being with us");
						}
						else {
							System.out.println("Please Give answer in YES/NO");
						}
						break;
					}
					else {
						System.out.println("You do not have items in your cart. Hence you cannot place order");
					}
				}
				
				case 2:{
					 List<OrderFood> olist = oimpl.showMyOrderHistory(email);
					if(olist!=null && olist.isEmpty()!=true) {
						for(OrderFood ol:olist) {
							System.out.println("Order No:"+ol.getOrderId());
							System.out.println("Order Date:"+ol.getOrderDate().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
							System.out.println("Bill:"+ol.getTotalBill());
							System.out.println("Status:"+ol.getOrderStatus());
							System.out.println("------------------------------");
						}
					}
					else {
						System.out.println("You havent ordered any thing from us till now!!");
					}
					break;
				}
				default:
				}
			}while(oMenuLoop==true);
		}
		else {
			System.out.println("Failed to Login");
		}
		sc.close();

	}
}

package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import IMPL.CartDAOImpl;
import IMPL.FoodDaoImpl;
import IMPL.LoginDAOImpl;
import POJO.Cart;
import POJO.Food;

public class CartTest {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		FoodDaoImpl fimpl=new FoodDaoImpl();
		CartDAOImpl cimpl=new CartDAOImpl();
		Cart cart=null;
		List<Food> flist=null;
		
		System.out.println("Enter EmailId:");
		String EmailId=sc.nextLine();
		System.out.println("Enter Password:");
		String Password=sc.nextLine();
		//ldi.userLogin(EmailId, Password);
		boolean login=new LoginDAOImpl().userLogin(EmailId, Password);
		boolean cMenuLoop=true;
		if(login==true)
		{
			do{
				System.out.println("------------------------------");
				System.out.println("1. Add to Cart");
				System.out.println("2. Show my Cart");//getall or by emailid
				System.out.println("3. Update Quantity of items by cartId");
				System.out.println("4. Delete Items from Cart by cartId");//deletebyID
				System.out.println("5. Clear my Cart");//deletebyEMAIL
				System.out.println("6. Exit");
				int option=sc.nextInt();
				sc.nextLine();
				switch(option)
				{
				case 1:
				{
					flist=fimpl.getAllFood();
					for (Food f:flist)
					{
						System.out.println(f);
						System.out.println("------------------------------");
					}
					System.out.println("Enter Id of Food you want to add to cart");
					int foodid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter quantity of Food you want to add to cart");
					int fquantity=sc.nextInt();
					sc.nextLine();
					cart=new Cart();
					cart.setFoodId(foodid);
					cart.setFquantity(fquantity);
					cart.setcEmail(EmailId);
					
					boolean flag=cimpl.addToCart(cart);
					if (flag)
					{
						System.out.println("Food Item Added to Cart Successfully");
					}
					else 
					{
						System.out.println("Error while adding this item to cart. Please try again");
					}
					break;
				}
				case 2:
				{
					boolean sMenuLoop=true;
					do
					{
					System.out.println("------------------------------");
					System.out.println("1. Show Complete Cart");
					System.out.println("2. Show Cart by Id");
					System.out.println("3. Show Cart by Email");
					System.out.println("4. Exit");
					int choice=sc.nextInt();
					sc.nextLine();
					System.out.println("------------------------------");
					switch(choice) {
					case 1:{
						List<Cart> l=cimpl.showCartList();
						if(l!=null)
						{
							Iterator<Cart> it=l.iterator();
							while (it.hasNext())
							{
								System.out.println(it.next());
								System.out.println();
							}
							break;
						}
						break;
					}
					case 2:{
						System.out.println("Enter CartId");
						int cartId=sc.nextInt();
						sc.nextLine();
						System.out.println("------------------------------");
						List<Cart> l=cimpl.searchCartById(cartId);
						if(l!=null)
						{
							Iterator<Cart> it=l.iterator();
							while (it.hasNext())
							{
								System.out.println(it.next());
								System.out.println();
							}
						}
						break;
					}
					case 3:{
						System.out.println("Enter EmailId");
						String CemailId=sc.nextLine();
						System.out.println("------------------------------");
						List<Cart> l=cimpl.searchByEmailId(CemailId);
						if(l!=null)
						{
							Iterator<Cart> it=l.iterator();
							while (it.hasNext())
							{
								System.out.println(it.next());
								System.out.println();
							}
						}
						break;
					}
					case 4:{
						sMenuLoop=false;
						break;
					}
					default:
					}
					
					}while(sMenuLoop==true);
					break;
				}
				case 3:
				{
					System.out.println("Enter cartId");
					int cartId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Quantity");
					int fQuantity=sc.nextInt();
					sc.nextLine();
					System.out.println("------------------------------");
					boolean flag=cimpl.updateCart(cartId, fQuantity);
					if(flag)
					{
						System.out.println("Updated Succesfully");
					}
					else
					{
						System.out.println("Failed to Update");
					}
					break;
				}
				case 4:
				{
					System.out.println("Enter cartId to be deleted from Cart");
					int cartId=sc.nextInt();
					sc.nextLine();
					System.out.println("------------------------------");
					boolean flag=cimpl.deleteCartById(cartId);
					if(flag)
					{
						System.out.println("Successfully Deleted");
					}
					else
					{
						System.out.println("Not Deleted");
					}
					break;
				}
				case 5:
				{
					System.out.println("Enter emailId to Clear Cart");
					String CemailId=sc.nextLine();
					System.out.println("------------------------------");
					boolean flag=cimpl.deleteCartByEmail(CemailId);
					if(flag)
					{
						System.out.println("Successfully Deleted");
					}
					else
					{
						System.out.println("Not Deleted");
					}
					break;
				}
				case 6:
				{
					cMenuLoop=false;
					System.out.println("------------------------------");
					System.out.println("Terminated");
					System.out.println("------------------------------");
					break;
				}
				default:
				}
			}
			while(cMenuLoop==true);
		}
		else
		{
			System.out.println("Try Again");
		}
		sc.close();
		
	}

}

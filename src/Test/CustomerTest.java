package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import IMPL.CustomerDAOImpl;
import POJO.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		boolean CMenuLoop=true;
		do {
			Customer C=new Customer();
			CustomerDAOImpl cdi=new CustomerDAOImpl();
			System.out.println("1. Add");
			System.out.println("2. Update By EmailId");
			System.out.println("3. Delete By EmailId");
			System.out.println("4. SearchByEmailId");
			System.out.println("5. Get All Customers");
			System.out.println("6. Menu");
			int menu=sc.nextInt();
			sc.nextLine();
			System.out.println("------------------------------");
			switch(menu) {
			case 1:{
				System.out.println("Enter Customer Name:");
				String custName=sc.nextLine();
				System.out.println("Enter Customer EmailId:");
				String emailId=sc.nextLine();
				System.out.println("Enter Customer Password:");
				String custPass=sc.nextLine();
				System.out.println("Enter Customer Address:");
				String custAdd=sc.nextLine();
				System.out.println("Enter Customer Contact:");
				String custContact=sc.nextLine();
				System.out.println("Enter Customer Location:");
				String custLoc=sc.nextLine();
				System.out.println("------------------------------");
				C=new Customer(custName,emailId,custPass,custAdd,custContact,custLoc);
				boolean flag=cdi.AddCustomer(C);
				if(flag)
				{
					System.out.println("Successfully Inserted.");
					System.out.println("------------------------------");
				}
				else
				{
					System.out.println("Not Inserted.");
					System.out.println("------------------------------");
				}
				break;
			}
			case 2:{
				System.out.println("Enter Email Id you want to update:");
				String emailId=sc.nextLine();
				System.out.println("Enter Customer Name:");
				String custName=sc.nextLine();
				System.out.println("Enter Customer Password:");
				String custPass=sc.nextLine();
				System.out.println("Enter Customer Address:");
				String custAdd=sc.nextLine();
				System.out.println("Enter Customer Contact:");
				String custContact=sc.nextLine();
				System.out.println("Enter Customer Location:");
				String custLoc=sc.nextLine();
				C.setEmailId(emailId);
				C.setCustName(custName);
				C.setCustPass(custPass);
				C.setCustAdd(custAdd);
				C.setCustContact(custContact);
				C.setCustLoc(custLoc);
				System.out.println("------------------------------");
				boolean flag=cdi.UpdateCustomer(emailId,C);
				if(flag)
				{
					System.out.println("Successfully Updated.");
					System.out.println("------------------------------");
				}
				else
				{
					System.out.println("Not Updated.");
					System.out.println("------------------------------");
				}
				break;
			}
			case 3:{
				System.out.println("Enter Email Id you want to delete:");
				String emailId=sc.nextLine();
				System.out.println("------------------------------");
				boolean flag=cdi.DeleteCustomer(emailId);
				if(flag)
				{
					System.out.println("Successfully Deleted.");
					System.out.println("------------------------------");
				}
				else
				{
					System.out.println("Not Deleted.");
					System.out.println("------------------------------");
				}
				break;
			}
			case 4:{
				System.out.println("Enter Email Id you want to View:");
				String emailId=sc.nextLine();
				System.out.println("------------------------------");
				Customer Cs=cdi.SearchByEmailId(emailId);
				if(C!=null)
				{
					System.out.println(Cs);
					System.out.println("------------------------------");
				}
				break;
			}
			case 5:{
				List<Customer> l=cdi.getAllCustomer();
				if(l!=null)
				{
					Iterator<Customer> it=l.iterator();
					while (it.hasNext())
					{
						System.out.println(it.next());
						System.out.println();
					}
					System.out.println("------------------------------");
					break;
				}
				break;
			}
			case 6:{
				CMenuLoop=false;
				break;
			}
			default:
			}
			
		}
		while (CMenuLoop==true);
		sc.close();

	}

}
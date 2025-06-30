package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import POJO.Food;
import IMPL.FoodDaoImpl;

public class FoodTest {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		boolean SMenuLoop=true;
		do {
		Food f=new Food();
		FoodDaoImpl fdi=new FoodDaoImpl();
		System.out.println("Enter your choice");
		System.out.println("1. Add Food:");
		System.out.println("2. Update Food:");
		System.out.println("3. Delete Food:");
		System.out.println("4. Search Food By Id:");
		System.out.println("5. Get All Food:");
		System.out.println("6. Search Food By Name:");
		System.out.println("7. Search Food By Category:");
		System.out.println("8. End Program:");
		int choice=sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------------");
		switch (choice)
		{
			case 1:
			{
				System.out.println("Enter Food Name:");
				String foodName=sc.nextLine();
				System.out.println("Enter Food Type:");
				String foodType=sc.nextLine();
				System.out.println("Enter Food Category:");
				String foodCategory=sc.nextLine();
				System.out.println("Enter Food Description:");
				String foodDesc=sc.nextLine();
				System.out.println("Enter Food Price:");
				double foodPrice=sc.nextDouble();
				System.out.println("Enter Food Image:");
				String img=sc.nextLine();
				sc.nextLine();
				System.out.println("------------------------------");
				f=new Food(foodName,foodType,foodCategory,foodDesc,foodPrice,img);
				boolean flag=fdi.AddFood(f);
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
			case 2:
			{
				System.out.println("Enter Exisiting ID for Update:");
				int foodId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Food Name:");
				String foodName=sc.nextLine();
				System.out.println("Enter Food Type:");
				String foodType=sc.nextLine();
				System.out.println("Enter Food Category:");
				String foodCategory=sc.nextLine();
				System.out.println("Enter Food Description:");
				String foodDesc=sc.nextLine();
				System.out.println("Enter Food Price:");
				double foodPrice=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Food Image:");
				String img=sc.nextLine();
				System.out.println("------------------------------");
				f.setFoodId(foodId);
				f.setFoodName(foodName);
				f.setFoodType(foodType);
				f.setFoodCategory(foodCategory);
				f.setFoodDesc(foodDesc);
				f.setFoodPrice(foodPrice);
				f.setImg(img);
				boolean flag=fdi.UpdateFood(f);
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
			case 3:
			{
				System.out.println("Enter Food Id you want to delete:");
				int foodId=sc.nextInt();
				System.out.println("------------------------------");
				boolean flag=fdi.DeleteFood(foodId);
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
			case 4:
			{
				System.out.println("Enter Food Id you want to View:");
				int foodId=sc.nextInt();
				System.out.println("------------------------------");
				Food f1=fdi.SearchFoodById(foodId);
				if(f1!=null)
				{
					System.out.println(f1);
					System.out.println("------------------------------");
				}
				else
				{
					System.out.println("Food is not available.");
				}
				break;
			}
			case 5:
			{
				List<Food> l=fdi.getAllFood();
				if(l!=null)
				{
					Iterator<Food> it=l.iterator();
					while (it.hasNext())
					{
						System.out.println(it.next());
						System.out.println();
					}
					System.out.println("------------------------------");
					break;
				}
			}
			case 6:
			{
				System.out.println("Search By Name:");
				String foodName=sc.nextLine();
				System.out.println("------------------------------");
				List<Food> l=fdi.SearchFoodByName(foodName);
				if(l!=null)
				{
					Iterator<Food> it=l.iterator();
					while (it.hasNext())
					{
						System.out.println(it.next());
						System.out.println();
					}
					System.out.println("------------------------------");
					break;
				}
			}
			case 7:
			{
				System.out.println("Search By Category:");
				String foodCategory=sc.nextLine();
				System.out.println("------------------------------");
				List<Food> l=fdi.SearchFoodByCategory(foodCategory);
				if(l!=null)
				{
					Iterator<Food> it=l.iterator();
					while (it.hasNext())
					{
						System.out.println(it.next());
						System.out.println();
					}
					System.out.println("------------------------------");
					break;
				}
			}
			case 8:
			{
				SMenuLoop=false;
				break;
			}
			default:
			}
		}
		while(SMenuLoop==true);
		
		sc.close();
		
		
	}

}

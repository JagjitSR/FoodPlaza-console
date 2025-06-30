package DAO;
import java.util.List;
import POJO.Food;

public interface FoodDao {

	public boolean AddFood(Food f);
	public boolean UpdateFood(Food f);
	public boolean DeleteFood(int foodId);
	public Food SearchFoodById(int foodId);
	public List <Food> getAllFood();
	public List <Food> SearchFoodByName(String foodName);
	public List <Food> SearchFoodByCategory(String foodCategory);
	
	
}

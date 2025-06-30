package DAO;

import java.util.List;

import POJO.Cart;

public interface CartDAO {

	boolean addToCart(Cart cart);
	public List<Cart> showCartList();
	public List<Cart> searchByEmailId(String cEmail);
	public List<Cart> searchCartById(int cartId);
	boolean deleteCartById(int cartId);
	boolean deleteCartByEmail(String email);
	boolean updateCart(int cartId,int fquantity);
}
	
	

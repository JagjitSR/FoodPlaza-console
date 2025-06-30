package POJO;

public class Cart {

	private int cartId;
	private int foodId;
	private String cEmail;
	private int fquantity;
	private String fname;
	private double fprice;
	private double totalPrice;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, int foodId, String emailId, int fquantity, String fname, double fprice) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.cEmail = emailId;
		this.fquantity = fquantity;
		this.fname = fname;
		this.fprice = fprice;
	}

	public Cart(int foodId, String emailId, int fquantity) {
		super();
		this.foodId = foodId;
		this.cEmail = emailId;
		this.fquantity = fquantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public int getFquantity() {
		return fquantity;
	}

	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public double getFprice() {
		return fprice;
	}

	public void setFprice(double fprice) {
		this.fprice = fprice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart:\ncartId=" + cartId + ", \nfoodId=" + foodId + ", \ncEmail=" + cEmail + ", \nfquantity=" + fquantity
				+ ", \nfname=" + fname + ", \nfprice=" + fprice + ", \ntotalPrice=" + totalPrice;
	}
	
	
	
}

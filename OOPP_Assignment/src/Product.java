
public abstract class Product {
	private String productName;
	private double productPrice;
	private int productQuantity;
	private int productItemNumber;
	private boolean productStatus = true;
	
	//Default Constructor
	public Product() {
		
	}
	//Constructor
	public Product(String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus){
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productItemNumber = productItemNumber;
		this.productStatus = productStatus;
	}

	//Getters
	public String getProductName(){
		return productName;
	}
	public double getProductPrice(){
		return productPrice;
	}
	public int getProductQuantity(){
		return productQuantity;
	}
	public int getProductItemNumber(){
		return productItemNumber;
	}
	public boolean getProductStatus(){
		return productStatus;
	}

	//Setters 
	public void setProductName(String productName){
		this.productName = productName;
	}
	public void setProductPrice(double productPrice){
		this.productPrice = productPrice;

	}
	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	public void setProductItemNumber(int productItemNumber ){
		this.productItemNumber = productItemNumber;

	}
	public void setProductStatus(boolean productStatus){
		this.productStatus = productStatus;

	}

	//new methods 

	public double getTotalInventoryValue (){
		
		return productPrice*productQuantity;
	}
	
	public void addProductQuantity(int num) {
		productQuantity += num;
	}
	public void deductProductQuantity(int num) {
		productQuantity -= num;
	}
	public String getDetails() {
		return "";
	}
	//override toString
	@Override 
	public String toString(){
		String desc = 
				  "Item number	         : " + productItemNumber 
				+ "\nProduct name	     : " + productName 
				+ "\nQuantity available  : " + productQuantity 
				+ "\nPrice (RM)	        : " + productPrice 
				+ "\nInventory value (RM): " + getTotalInventoryValue()
				+ "\nProduct status      : " +productStatus;

		return desc;
	}
}



public class Product {
	private String productName;
	private double productPrice;
	private int productQuantity;
	private int productItemNumber;
	private boolean productStatus = true;
	
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
	

}


import java.util.ArrayList;
import java.util.Scanner;

public class SharedList {
	private static ArrayList<Product> sharedProduct = new ArrayList<>();
	private ArrayList<Product> products;
	
	public SharedList() {
        products = new ArrayList<>(sharedProduct);
    }
	
	public ArrayList<Product> getProductList(){
		return products;
	}
	
	public void addProducts(Product product) {
		//products.add(product);
		sharedProduct.add(product);
	}
    public Product getProduct(int locNumber) {    	
    	
    	Product product=sharedProduct.get(locNumber);
    	return product;
    }
	public void updateProduct(int itemNumber, Product product) {
		sharedProduct.set(itemNumber,product);
	}
	
	public int checkItemNumber(int itemNumber) {
		int value = -1;
		for (int i=0;i<sharedProduct.size();i++) {
			Product tempProduct = sharedProduct.get(i); 
			if(tempProduct.getProductItemNumber() == itemNumber){	
				value = i;
				break;
			}
		}
		return value;
	}
}

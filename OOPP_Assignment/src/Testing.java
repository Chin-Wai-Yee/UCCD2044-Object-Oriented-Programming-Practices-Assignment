import java.util.ArrayList;

public class Testing {
	public static void main(String[] args) {

        
		SharedList pl = new SharedList();
		ArrayList<Product> products = pl.getProductList();

		for (Product product : products) {
		    System.out.println(product.getProductItemNumber() + ": " + product.getProductName() + " - $" + product.getProductPrice());
		}
	}
}

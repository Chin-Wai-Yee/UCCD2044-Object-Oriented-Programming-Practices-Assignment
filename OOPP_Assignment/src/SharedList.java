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
    
	public boolean updateProduct(int itemNumber) {
		int returnNum=checkItemNumber(itemNumber,products);
		if(returnNum == -1)
			return false;
		return false;
	}
	
	public static void updateOven(int indexNumber,ArrayList<Product> products,Scanner scanner){
		int choice;
		String tempGlassDoorDesign;
		boolean tempHasConvection,tempHasTimer;
		Product tempProduct = products.get(indexNumber);
		tempProduct.toString();
		do{
			System.out.println("1. Product Name");
			System.out.println("2. Product Price");
			System.out.println("3. Product Glass Door Design");
			System.out.println("4. Product convection heating");
			System.out.println("5. Product built-in timer");
			System.out.println("6. Exit");
            System.out.println("Please enter a menu option to update.");
			while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Please enter a valid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	System.out.print("Please enter a new door design: ");
    			tempGlassDoorDesign=scanner.nextLine();
    			Oven oven = (Oven) tempProduct;
                oven.setGlassDoorDesign(tempGlassDoorDesign);
                tempProduct = oven;
            }
            else if(choice==4) {
            	System.out.print("Please enter a new door design: ");
    			tempHasConvection=scanner.nextBoolean();
    			Oven oven = (Oven) tempProduct;
                oven.setHasConventional(tempHasConvection);
                tempProduct = oven;
            }
            else if(choice==5) {
            	System.out.print("Please enter a new door design: ");
    			tempHasTimer=scanner.nextBoolean();
    			Oven oven = (Oven) tempProduct;
                oven.setHasTimer(tempHasTimer);
                tempProduct = oven;
            }
		}while(choice!=7);
		products.set(indexNumber,tempProduct);
	}
	public static void updateTV(int indexNumber,ArrayList<Product> products,Scanner scanner){
		int choice;
		String tempScreenType;
		int tempResolution, tempDisplaySize;
		Product tempProduct = products.get(indexNumber);
		tempProduct.toString();
		do{
			System.out.println("1. Product Name");
			System.out.println("2. Product Price");
			System.out.println("3. Product Screen Type");
			System.out.println("4. Product Resolution");
			System.out.println("5. Product Display Size");
			System.out.println("6. Exit");
            System.out.println("Please enter a menu option to update.");
			while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 6) {
                System.out.println("Please enter a valid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	System.out.print("Please enter a new door design: ");
    			tempScreenType=scanner.nextLine();
    			TV  tv = (TV) tempProduct;
                tv.setScreenType(tempScreenType);
                tempProduct = tv;
            }
            else if(choice==4) {
            	System.out.print("Please enter a new door design: ");
    			tempResolution=scanner.nextInt();
    			TV tv = (TV) tempProduct;
                tv.setResolution(tempResolution);
                tempProduct = tv;
            }
            else if(choice==5) {
            	System.out.print("Please enter a new door design: ");
    			tempDisplaySize=scanner.nextInt();
    			TV tv = (TV) tempProduct;
                tv.setDisplaySize(tempDisplaySize);
                tempProduct = tv;
            }
		}while(choice!=6);
		products.set(indexNumber,tempProduct);
	}
	public static void updateWashingMachine(int indexNumber,ArrayList<Product> products,Scanner scanner){
		int choice,tempCapacityKg;
		boolean tempHasDryer;
		String tempNoiceLevel;
		Product tempProduct = products.get(indexNumber);
		tempProduct.toString();
		do{
			System.out.println("1. Product Name");
			System.out.println("2. Product Price");
			System.out.println("3. Product Capacity(kg)");
			System.out.println("4. Product Built-in Dryer");
			System.out.println("5. Product Noice Level");
			System.out.println("6. Exit");
            System.out.println("Please enter a menu option to update.");
			while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 6) {
                System.out.println("Please enter a valid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	System.out.print("Please enter a new door design: ");
    			tempCapacityKg=scanner.nextInt();
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setCapacityKg(tempCapacityKg);
                tempProduct = wm;
            }
            else if(choice==4) {
            	System.out.print("Please enter a new door design: ");
    			tempHasDryer=scanner.nextBoolean();
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setHasDryer(tempHasDryer);
                tempProduct = wm;
            }
            else if(choice==5) {
            	System.out.print("Please enter a new door design: ");
    			tempNoiceLevel=scanner.nextLine();
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setNoiceLevel(tempNoiceLevel);
                tempProduct = wm;
            }
		}while(choice!=6);
		products.set(indexNumber,tempProduct);
	}
	public static Product updateSuperValue(int choice,Product product,Scanner scanner) {
		String tempName;
		Double tempPrice;
		if(choice==1) {
            System.out.print("Please enter a new name: ");
			tempName=scanner.nextLine();
			product.setProductName(tempName);
		}
		else if(choice==2) {
			System.out.print("Please enter a new price: ");
			tempPrice=scanner.nextDouble();
			product.setProductPrice(tempPrice);
		}
		return product;
	}
	
	public int checkItemNumber(int itemNumber, ArrayList<Product> products) {
		int value = -1;
		for (int i=0;i<products.size();i++) {
			Product tempProduct = products.get(i);
			if(tempProduct.getProductItemNumber() == itemNumber){	
				value = i;
				break;
			}
		}
		return value;
	}
}

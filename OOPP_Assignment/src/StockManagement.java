import java.util.Scanner;
import java.util.ArrayList;
public class StockManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static int productTotalNumber = 0; //increase by 1 when add 1 products
    private static int productMaxNumber;
    public static int getMaxProducts(Scanner scanner) {
        int maxProducts;
        do {
            System.out.print("Enter the maximum number of products: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid positive integer.");
                scanner.next();
            }
            maxProducts = scanner.nextInt();
            if (maxProducts <= 0) {
                System.out.println("Please enter a positive value.");
            }
        } while (maxProducts <= 0);
        return maxProducts;
    }

    public static int displayProducts(ArrayList<Product> products, Scanner scanner) {

        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i).getProductName());
        }
        int choice;
        do {
            System.out.print("Select a product to update: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid product index.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice >= products.size()+1) {
                System.out.println("Please enter a valid product index.");
            }
        } while (choice < 1 || choice >= products.size()+1);
        return choice;
    }
  

    public static int displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. View products");
            System.out.println("2. Add stock");
            System.out.println("3. Deduct stock");
            System.out.println("4. Discontinue product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 4) {
                System.out.println("Please enter a valid menu option.");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    public static void addStock(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        System.out.print("Enter the quantity to add: ");
        int quantityToAdd;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid quantity.");
                scanner.next();
            }
            quantityToAdd = scanner.nextInt();
            if (quantityToAdd <= 0) {
                System.out.println("Please enter a positive value.");
            }
        } while (quantityToAdd <= 0);
        products.get(choice).setProductQuantity(products.get(choice).getProductQuantity() + quantityToAdd);
        System.out.println("Stock added successfully.");
    }

    public static void deductStock(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        System.out.print("Enter the quantity to deduct: ");
        int quantityToDeduct;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid quantity.");
                scanner.next();
            }
            quantityToDeduct = scanner.nextInt();
            if (quantityToDeduct <= 0 || quantityToDeduct > products.get(choice).getProductQuantity()) {
                System.out.println("Please enter a valid quantity.");
            }
        } while (quantityToDeduct <= 0 || quantityToDeduct > products.get(choice).getProductQuantity());
        products.get(choice).setProductQuantity(products.get(choice).getProductQuantity() - quantityToDeduct);
        System.out.println("Stock deducted successfully.");
    }

    public static void discontinueProduct(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        products.get(choice-1).setProductStatus(false);

        System.out.println("Product discontinued successfully.");
    }

    public static void executeMethod(int choice,ArrayList<Product> products, Scanner scanner) {
        switch (choice) {
            case 1:
                displayProductMenu(products,scanner);
                break;
            case 2:
                addStock(products, scanner);
                break;
            case 3:
                deductStock(products, scanner);
                break;
            case 4:
                discontinueProduct(products, scanner);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
        }
    }

    public static void addProduct(ArrayList<Product> products, Scanner scanner) {
        System.out.println("Add product:");
        System.out.println("1. Refrigerator");
        System.out.println("2. TV");
        System.out.println("3. Oven");
        System.out.println("4. Washing Machine");
        int choice;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Only numbers 1 to 4 allowed!");
            }
        } while (choice < 1 || choice > 2);
        if(productTotalNumber >= productMaxNumber) {
            System.out.println("products reach maximum numbers");
        }
        else if (choice == 1) {
            addRefrigerator(products, scanner);
        } else if(choice==2){
            addTV(products, scanner);
        }else if(choice==3) {
        	addOven(products,scanner);
        }else if(choice==4) {
        	addWashingMachine(products,scanner);
        }
        
    }

    public static void addRefrigerator(ArrayList<Product>products, Scanner scanner) {
		int value=-1,itemNumber;
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter door design: ");
        String doorDesign = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
//        System.out.print("Enter quantity available in stock: ");
//        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        do {
        	System.out.print("Enter item number: ");
        	itemNumber = scanner.nextInt();
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.println("dear user...item number found in the system..");
            }
        }while(value!=-1);
        // Create Refrigerator object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String doorDesign, String color, double capacity
        products.add(new Refrigerator(name,price, 0, itemNumber,true, doorDesign, color, capacity));
        productTotalNumber++;
        System.out.println("Refrigerator added successfully.");
    }

    public static void addTV(ArrayList<Product> products, Scanner scanner) {
    	int value,itemNumber;
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter screen type: ");
        String screenType = scanner.nextLine();
        System.out.print("Enter resolution: ");
        int resolution = scanner.nextInt();
        System.out.print("Enter display size: ");
        int displaySize = scanner.nextInt();
//      System.out.print("Enter quantity available in stock: ");
//      int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        do {
        	System.out.print("Enter item number: ");
        	itemNumber = scanner.nextInt();
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("dear user...item number found in the system..");
            }
        }while(value!=-1);
        // Create TV object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String screenType, int resolution, int displaySize
        products.add(new TV(name, price, 0, itemNumber, true, screenType, resolution, displaySize));
        productTotalNumber++;
        System.out.println("TV added successfully.");
    }
    
    public static void addOven(ArrayList<Product> products, Scanner scanner) {
    	int itemNumber,value;
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter glass door design: ");
        String glassDoor = scanner.nextLine();
        System.out.print("Enter built-in convection: ");
        boolean hasConvection = scanner.nextBoolean();
        System.out.print("Enter built-in timer: ");
        boolean hasTimer = scanner.nextBoolean();
//      System.out.print("Enter quantity available in stock: ");
//      int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        do {
        	System.out.print("Enter item number: ");
        	itemNumber = scanner.nextInt();
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("dear user...item number found in the system..");
            }
        }while(value!=-1);
        // Create TV object and store it in the array
        //	String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,String glassDoorDesign,boolean hasConvection,boolean hasTimer)
        products.add(new Oven(name, price, 0, itemNumber, true, glassDoor, hasConvection, hasTimer));
        productTotalNumber++;
        System.out.println("TV added successfully.");
    }
    
    public static void addWashingMachine(ArrayList<Product> products, Scanner scanner) {
    	int itemNumber,value;
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter capacity(KG): ");
        int capacityKg = scanner.nextInt();
        System.out.print("Enter built-in dryer ");
        boolean hasDryer=scanner.nextBoolean();
        System.out.print("Enter noice level: ");
        String noiceLevel = scanner.nextLine();
        //System.out.print("Enter quantity available in stock: ");
        //int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        do {
        	System.out.print("Enter item number: ");
        	itemNumber = scanner.nextInt();
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("dear user...item number found in the system..");
            }
        }while(value!=-1);
        // Create WashingMachine object and store it in the array
        // String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,int capacityKg,boolean hasDryer,String noiceLevel

        products.add(new WashingMachine(name, price, 0, itemNumber, true, capacityKg,hasDryer,noiceLevel));
        productTotalNumber++;
        System.out.println("TV added successfully.");
    }
    //product main
    public static void displayProductMenu(ArrayList<Product> products,Scanner scanner) {
    	int choice;
    	//testing purpose only
//    	productTotalNumber++;
//    	productTotalNumber++;
//    	products.add(new Refrigerator("Samsung refri" ,9999, 0, 1,true, "dual glass", "black", 12));
//        products.add(new WashingMachine("Samsung wash" ,999, 0, 2,true, 10, true, "low"));

        do {
            displayProducts(products);
            choice = productMenu(products);
            executeProductMethod(choice, products, scanner);
        } while (choice != 0);    	
    }
    
    //display all the product row-by-row
    public static void displayProducts(ArrayList<Product> products) {
		System.out.printf("%-15s  %-20s %-14s %-10s %-7s %-40s%n", "Product Number","Product Name","Product Price","Quantity","Status","Details");
		if(products.size() > 0 )
			for (Product product:products) {
				System.out.printf("%-15d  %-20s %-14.2f %-10d %-7s %-40s%n",product.getProductItemNumber(),product.getProductName(),product.getProductPrice(),product.getProductQuantity(),product.getProductStatus(),product.getDetails());
		}
    }
	//product selection menu	
	public static int productMenu(ArrayList<Product> products) {   
        System.out.println(productTotalNumber);

		int choice;
        do {
            System.out.println("Product Menu:");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Please enter a valid menu option.");
            }
        } while (choice < 0 || choice > 3);
        return choice;
	}
	//execution of product method
	public static void executeProductMethod(int choice, ArrayList<Product> products, Scanner scanner){
		 switch (choice) {
         case 1:
             addProduct(products,scanner);
             break;
         case 2:
             updateProduct(products,scanner);
             break;
         case 3:
            deleteProduct(products,scanner);
             break;
         case 0:
             System.out.println("Exiting...");
             System.out.println("Back to main menu...");
             break;
     }
	}
	
	//update the products
	public static void updateProduct(ArrayList<Product> products, Scanner scanner) {
		int itemNumber;
		boolean valid=false;
		if(products.size() <= 0) {
			System.out.println("No product to update");
		}
		else {
			displayProducts(products);
            System.out.print("Please enter item number to update: ");
            while(!scanner.hasNextInt()) {
                System.out.print("Please enter valid item number to update: ");
                System.out.print("Please reenter item number to update: ");
                scanner.next();
            }
            itemNumber=scanner.nextInt();
            int value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
				Product tempProduct = products.get(value);
            	if(tempProduct instanceof Refrigerator) {
					updateRefrigerator(value,products,scanner);
				}
				else if(tempProduct instanceof TV) {
					updateTV(value,products,scanner);
				}
				else if(tempProduct instanceof WashingMachine) {
					updateWashingMachine(value,products,scanner);
				}
				else if(tempProduct instanceof Oven) {
					updateOven(value,products,scanner);
				}
            }
            else {
                System.out.print("dear user...item number not found in the system..");
            }
		}
	}
	public static void updateRefrigerator(int indexNumber,ArrayList<Product> products,Scanner scanner){
		int choice;
		String tempDoorDesign,tempColor;
		double tempCapacity;
		Product tempProduct = products.get(indexNumber);
		tempProduct.toString();
		do{
			System.out.println("1. Product Name");
			System.out.println("2. Product Price");
			System.out.println("3. Product Door Design");
			System.out.println("4. Product color");
			System.out.println("5. Product capacity(kg)");
			System.out.println("6. Exit");
            System.out.println("Please enter a menu option to update:");
			while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option:");
                System.out.print("Please enter a menu option: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	System.out.print("Please enter a new door design: ");
    			tempDoorDesign=scanner.nextLine();
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setDoorDesign(tempDoorDesign);
                tempProduct = refrigerator;
            }
            else if(choice==4) {
            	System.out.print("Please enter a new color: ");
    			tempColor=scanner.nextLine();
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setDoorDesign(tempColor);
                tempProduct = refrigerator;
            }
            else if(choice==5) {
            	System.out.print("Please enter a capacity: ");
    			tempCapacity=scanner.nextDouble();
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setCapacity(tempCapacity);
                tempProduct = refrigerator;
            }
		}while(choice!=7);
		products.set(indexNumber,tempProduct);
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
	
	public static int checkItemNumber(int itemNumber, ArrayList<Product> products) {
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
	
	
	public static void deleteProduct(ArrayList<Product>products,Scanner scanner) {
		int itemNumber;
		if(products.size() <=0) {
			System.out.println("No product to delete");
		}
		else {
			displayProducts(products);
            System.out.print("Please enter item number to delete: ");
            while(!scanner.hasNextInt()) {
                System.out.print("Please enter valid item number to delete: ");
                System.out.print("Please reenter item number to delete: ");
                scanner.next();
            }
            itemNumber=scanner.nextInt();
            int value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
            	products.remove(value);
                System.out.println("Successfully delete the product");
                productTotalNumber--;
            }
            else {
                System.out.print("dear user...item number not found in the system..");
            }
		}
	};	
	
    public static void main(String[] args) {
        //Product[] products = new Product[maxProducts];
        ArrayList<Product> products = new ArrayList<Product>();
        int choice;
        productMaxNumber= getMaxProducts(scanner);
        do {
            choice = displayMenu(scanner);
            if(choice!=0) {
            	executeMethod(choice, products, scanner);
            }
        } while (choice != 0);
        System.out.println("Dear user.....thank you for using our prorgam");
        System.out.println("Have a nice day ^-^");
        scanner.close(); // Close the scanner
    }
}
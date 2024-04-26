import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class StockManagement {
	public static final String ALPHA_NUM_REGEX = "^[a-zA-Z0-9\\s]*$";
    private static final String INTEGER_REGEX = "^\\d+$";
    private static final String DOUBLE_REGEX = "^\\d*\\.?\\d+$";
    private static final String BOOLEAN_REGEX = "^(?i)(true|false)$";
    private static Scanner scanner = new Scanner(System.in);
    private static int productTotalNumber = 0; //increase by 1 when add 1 products
    private static int productMaxNumber;

    private static UserInfo user= new UserInfo("","");
    private static String name;
    public static int getMaxProducts(Scanner scanner) {
    	System.out.println("======================================================");
    	System.out.println("||                                                  ||");
    	System.out.println("||      Welcome to snow stock management system     ||");
    	System.out.println("||                                                  ||");
    	System.out.println("======================================================");
    	LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentDate.format(formatter);
		System.out.println("Current Date and Time: " + formattedDate);
        int maxProducts;
        name = getStringInput("Enter your name :",ALPHA_NUM_REGEX,scanner);
        user.setName(name);
        user.setUserID();
        do {
        	maxProducts=getIntInput("Enter the maximum number of products: ",INTEGER_REGEX,scanner);
            if (maxProducts <= 0) {
                System.out.println("Please enter a positive value.");
            }
        } while (maxProducts <= 0);
        System.out.println("Nice to meet you..." + user.getUserID());        return maxProducts;
    }
    
    public static int displayProducts(ArrayList<Product> products, Scanner scanner) {
        if(products.isEmpty()) {
        	return -1;
        }
        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i).getProductName());
        }
        int choice;
        do {
        	choice=getIntInput("Select a product to update: ",INTEGER_REGEX,scanner);
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
            System.out.println("5. Show statistic");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");

                System.out.print("Please enter a menu option: ");

                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice > 5) {
                System.out.println("Please enter a valid menu option.");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

    public static void addStock(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        if (choice ==  -1) {
        	System.out.println("No product added in this system");
        	return;
        }
        int quantityToAdd;
        do {
            quantityToAdd = getIntInput("Enter the quantity to add: ", INTEGER_REGEX, scanner);
            if (quantityToAdd <= 0) {
                System.out.println("Please enter a positive value.");
            }
        } while (quantityToAdd <= 0);
        choice -= 1;
        products.get(choice)
                .setProductQuantity(products.get(choice).getProductQuantity() + quantityToAdd);
        System.out.println("Stock added successfully.");
    }

    public static void deductStock(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        if (choice ==  -1) {
        	System.out.println("No product added in this system");
        	return;
        }
        System.out.print("Enter the quantity to deduct: ");
        int quantityToDeduct;
        do {
            quantityToDeduct = getIntInput("Enter the quantity to deduct: ", INTEGER_REGEX, scanner);
            if (quantityToDeduct <= 0 || quantityToDeduct > products.get(choice).getProductQuantity()) {
                System.out.println("Please enter a valid quantity.");
            }
        } while (quantityToDeduct <= 0 || quantityToDeduct > products.get(choice).getProductQuantity());
        choice -= 1;
        products.get(choice)
                .setProductQuantity(products.get(choice).getProductQuantity() - quantityToDeduct);
        System.out.println("Stock deducted successfully.");
    }

    public static void discontinueProduct(ArrayList<Product> products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        if (choice ==  -1) {
        	System.out.println("No product added in this system");
        	return;
        }
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
            case 5:
            	showStatistic(products,scanner);
            case 0:
                System.out.println("Exiting...");
                break;
        }
    }
    public static void showStatistic(ArrayList<Product> products,Scanner scanner) {
    	int ovenNum = 0;
    	int washNum = 0;
    	int fridgeNum = 0; 
    	int TVNum  = 0;
    	double ovenIntValue = 0;
    	double washIntValue = 0;
    	double fridgeIntValue = 0; 
    	double TVIntValue  = 0;
    	double totalValue=0;
		for(Product product:products) {
			if (product instanceof Oven) {
				ovenNum+=product.getProductQuantity();
				ovenIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof WashingMachine) {
				washNum+=product.getProductQuantity();
				washIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof Refrigerator) {
				fridgeNum+=product.getProductQuantity();
				fridgeIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof TV) {
				TVNum+=product.getProductQuantity();
				TVIntValue += product.getTotalInventoryValue();
			}
			totalValue += product.getTotalInventoryValue();
			
		}
        System.out.println("Product\t\tQuantity\tValue\t\tPercentage of Inventory Value");
        System.out.printf("%-15s  %-15d %-20.2f %-10.2f %n","Oven",ovenNum,ovenIntValue,ovenIntValue/totalValue);
        System.out.printf("%-15s  %-15d %-20.2f %-10.2f %n","Washing Machine",washNum,washIntValue,washIntValue/totalValue);
        System.out.printf("%-15s  %-15d %-20.2f %-10.2f %n","Refridgerator",fridgeNum,fridgeIntValue,fridgeIntValue/totalValue);
        System.out.printf("%-15s  %-15d %-20.2f %-10.2f %n","TV",TVNum,TVIntValue,TVIntValue/totalValue);

        System.out.println("----------------------------------------------------------");

        System.out.println("Press any key to go back");

        scanner.nextLine(); // Consume the newline character from previous input
        scanner.nextLine();
    }

    public static void addProduct(ArrayList<Product> products, Scanner scanner) {
        System.out.println("Add product:");
        System.out.println("1. Refrigerator");
        System.out.println("2. TV");
        System.out.println("3. Oven");
        System.out.println("4. Washing Machine");

        int choice;
        do {
        	choice=getIntInput("Enter your choice: ",INTEGER_REGEX,scanner);
            if (choice < 1 || choice > 4) {
                System.out.println("Only numbers 1 to 4 allowed!");
            }
        } while (choice < 1 || choice > 4);
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
        String name = getStringInput("Enter name: ",ALPHA_NUM_REGEX,scanner);
        String doorDesign = getStringInput("Enter door design: ",ALPHA_NUM_REGEX,scanner);
        String color = getStringInput("Enter color: ",ALPHA_NUM_REGEX,scanner);
        double capacity = getDoubleInput("Enter capacity: ",DOUBLE_REGEX,scanner);
        int quantity=getIntInput("Enter quantity available in stock: ",INTEGER_REGEX,scanner);
        double price = getDoubleInput("Enter price: ",DOUBLE_REGEX,scanner);
        do {
        	itemNumber = getIntInput("Enter item number: ",INTEGER_REGEX,scanner);
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.println("Dear user "+user.getUserID()+", item number found in the system..");
            }
        }while(value!=-1);
        // Create Refrigerator object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String doorDesign, String color, double capacity
        products.add(new Refrigerator(name,price, quantity, itemNumber,true, doorDesign, color, capacity));
        productTotalNumber++;
        System.out.println("Refrigerator added successfully.");
    }

    public static void addTV(ArrayList<Product> products, Scanner scanner) {
    	int value,itemNumber;
        String name = getStringInput("Enter name: ",ALPHA_NUM_REGEX,scanner);
        String screenType = getStringInput("Enter screen type: ",ALPHA_NUM_REGEX,scanner);
        int resolution = getIntInput("Enter resolution: ",INTEGER_REGEX,scanner);
        int displaySize = getIntInput("Enter display size: ",INTEGER_REGEX,scanner);
        int quantity=getIntInput("Enter quantity available in stock: ",INTEGER_REGEX,scanner);
        double price = getDoubleInput("Enter price: ",DOUBLE_REGEX,scanner);
        do {
        	itemNumber = getIntInput("Enter item number: ",INTEGER_REGEX,scanner);
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("Dear user "+user.getUserID()+"item number found in the system..");
            }
        }while(value!=-1);
        // Create TV object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String screenType, int resolution, int displaySize
        products.add(new TV(name, price, quantity, itemNumber, true, screenType, resolution, displaySize));
        productTotalNumber++;
        System.out.println("TV added successfully.");
    }
    
    public static void addOven(ArrayList<Product> products, Scanner scanner) {
    	int itemNumber,value;
        String name = getStringInput("Enter name: ",ALPHA_NUM_REGEX,scanner);
        String glassDoor = getStringInput("Enter glass door design: ",ALPHA_NUM_REGEX,scanner);
        boolean hasConvection = getBooleanInput("Enter built-in convection: ",BOOLEAN_REGEX,scanner);
        boolean hasTimer = getBooleanInput("Enter built-in timer: ",BOOLEAN_REGEX,scanner);
        int quantity=getIntInput("Enter quantity available in stock: ",INTEGER_REGEX,scanner);
        double price = getDoubleInput("Enter price: ",DOUBLE_REGEX,scanner);
        do {
        	itemNumber = getIntInput("Enter item number: ",INTEGER_REGEX,scanner);
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("Dear user "+user.getUserID()+", item number found in the system..");
            }
        }while(value!=-1);
        // Create TV object and store it in the array
        //	String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,String glassDoorDesign,boolean hasConvection,boolean hasTimer)
        products.add(new Oven(name, price, quantity, itemNumber, true, glassDoor, hasConvection, hasTimer));
        productTotalNumber++;
        System.out.println("TV added successfully.");
    }
    
    public static void addWashingMachine(ArrayList<Product> products, Scanner scanner) {
    	int itemNumber,value;
        String name = getStringInput("Enter name: ",ALPHA_NUM_REGEX,scanner);
        int capacityKg = getIntInput("Enter capacity(KG): ",INTEGER_REGEX,scanner);
        boolean hasDryer=getBooleanInput("Enter built-in dryer ",BOOLEAN_REGEX,scanner);
        String noiceLevel = getStringInput("Enter noice level: ",ALPHA_NUM_REGEX,scanner);
        int quantity=getIntInput("Enter quantity available in stock: ",INTEGER_REGEX,scanner);
        double price = getDoubleInput("Enter price: ",DOUBLE_REGEX,scanner);
        do {
        	itemNumber = getIntInput("Enter item number: ",INTEGER_REGEX,scanner);
            value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
                System.out.print("Dear user "+user.getUserID()+", item number found in the system..");
            }
        }while(value!=-1);
        // Create WashingMachine object and store it in the array
        // String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,int capacityKg,boolean hasDryer,String noiceLevel
        products.add(new WashingMachine(name, price, quantity, itemNumber, true, capacityKg,hasDryer,noiceLevel));
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
		System.out.println();
    }
	//product selection menu	
	public static int productMenu(ArrayList<Product> products) {   
		int choice;
        do {
            System.out.println("Product Menu:");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("0. Exit");
            choice=getIntInput("Please enter a menu option: ",INTEGER_REGEX,scanner);
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
			itemNumber=getIntInput("Please enter item number to update: ",INTEGER_REGEX,scanner);
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
                System.out.print("Dear user...item number not found in the system..");
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
			System.out.println("0. Exit");
            choice = getIntInput("Please enter a menu option to update:",INTEGER_REGEX,scanner);
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	tempDoorDesign = getStringInput("Enter door design: ",ALPHA_NUM_REGEX,scanner);
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setDoorDesign(tempDoorDesign);
                tempProduct = refrigerator;
            }
            else if(choice==4) {
    			tempColor=getStringInput("Enter color: ",ALPHA_NUM_REGEX,scanner);
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setDoorDesign(tempColor);
                tempProduct = refrigerator;
            }
            else if(choice==5) {
    			tempCapacity=getDoubleInput("Enter capacity: ",DOUBLE_REGEX,scanner);
    			Refrigerator refrigerator = (Refrigerator) tempProduct;
                refrigerator.setCapacity(tempCapacity);
                tempProduct = refrigerator;
            }
            else if(choice==0) {
            	System.out.println("Back to product menu....");
            }
		}while(choice!=0);
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
			System.out.println("0. Exit");
            choice=getIntInput("Please enter a menu option to update: ",INTEGER_REGEX,scanner);
            if (choice < 0 || choice > 3) {
                System.out.println("Please enter a valid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
    			tempGlassDoorDesign=getStringInput("Enter glass door design: ",ALPHA_NUM_REGEX,scanner);
    			Oven oven = (Oven) tempProduct;
                oven.setGlassDoorDesign(tempGlassDoorDesign);
                tempProduct = oven;
            }
            else if(choice==4) {
            	tempHasConvection=getBooleanInput("Enter built-in convection: ",BOOLEAN_REGEX,scanner);
    			Oven oven = (Oven) tempProduct;
                oven.setHasConventional(tempHasConvection);
                tempProduct = oven;
            }
            else if(choice==5) {
    			tempHasTimer=getBooleanInput("Enter built-in timer: ",BOOLEAN_REGEX,scanner);
    			Oven oven = (Oven) tempProduct;
                oven.setHasTimer(tempHasTimer);
                tempProduct = oven;
            }else if(choice==0) {
            	System.out.println("Back to product menu....");
            }
		}while(choice!=0);
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
			System.out.println("0. Exit");
            choice=getIntInput("Please enter a menu option: ",INTEGER_REGEX,scanner);			
            if (choice < 0 || choice > 6) {
                System.out.println("Please enter a valid menu option.");
            }
            else if(choice >=1 && choice<=2) {
            	tempProduct=updateSuperValue(choice,tempProduct,scanner);
            }
            else if(choice==3) {
            	tempScreenType=getStringInput("Enter screen type: ",ALPHA_NUM_REGEX,scanner);
    			TV  tv = (TV) tempProduct;
                tv.setScreenType(tempScreenType);
                tempProduct = tv;
            }
            else if(choice==4) {
            	tempResolution=getIntInput("Enter resolution: ",INTEGER_REGEX,scanner);
    			TV tv = (TV) tempProduct;
                tv.setResolution(tempResolution);
                tempProduct = tv;
            }
            else if(choice==5) {
            	tempDisplaySize=getIntInput("Enter resolution: ",INTEGER_REGEX,scanner);
            	TV tv = (TV) tempProduct;
                tv.setDisplaySize(tempDisplaySize);
                tempProduct = tv;
            }else if(choice==0) {
            	System.out.println("Back to product menu....");
            }
		}while(choice!=0);
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
			System.out.println("0. Exit");
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
    			tempCapacityKg=getIntInput("Enter capacity(KG): ",INTEGER_REGEX,scanner);
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setCapacityKg(tempCapacityKg);
                tempProduct = wm;
            }
            else if(choice==4) {
    			tempHasDryer=getBooleanInput("Enter built-in dryer ",BOOLEAN_REGEX,scanner);
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setHasDryer(tempHasDryer);
                tempProduct = wm;
            }
            else if(choice==5) {
    			tempNoiceLevel=getStringInput("Enter noice level: ",ALPHA_NUM_REGEX,scanner);
    			WashingMachine wm = (WashingMachine) tempProduct;
                wm.setNoiceLevel(tempNoiceLevel);
                tempProduct = wm;
            }else if(choice==0) {
            	System.out.println("Back to product menu....");
            }
		}while(choice!=0);
		products.set(indexNumber,tempProduct);
	}
	public static Product updateSuperValue(int choice,Product product,Scanner scanner) {
		String tempName;
		Double tempPrice;
		if(choice==1) {
			tempName=getStringInput("Enter name: ",ALPHA_NUM_REGEX,scanner);
			product.setProductName(tempName);
		}
		else if(choice==2) {
			tempPrice=getDoubleInput("Enter price: ",DOUBLE_REGEX,scanner);
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
            itemNumber=getIntInput("Please enter item number to delete: ",INTEGER_REGEX,scanner);
            int value=checkItemNumber(itemNumber,products);
            if(value!=-1) {
            	products.remove(value);
                System.out.println("Successfully delete the product");
                productTotalNumber--;
            }
            else {
                System.out.print("Dear user"+user.getUserID()+", item number not found in the system..");
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
        System.out.println("Dear user "+ user.getUserID()+ ",thank you for using our prorgam");
        System.out.println("Have a nice day ^-^");
        scanner.close(); // Close the scanner
    }
    
    public static String getStringInput(String prompt, String regex, Scanner scanner) {
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.matches(regex)) {
                System.out.println("Input must contain only alphanumeric characters.");
            }
        } while (!input.matches(regex));

        return input;
    }
    public static int getIntInput(String prompt, String regex,Scanner scanner) {
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.matches(regex)) {
                System.out.println("Input must be an integer.");
            }
        } while (!input.matches(regex));

        return Integer.parseInt(input);
    }

    public static double getDoubleInput(String prompt, String regex,Scanner scanner) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.matches(regex)) {
                System.out.println("Input must be a double.");
            }
        } while (!input.matches(regex));

        return Double.parseDouble(input);
    }

    public static boolean getBooleanInput(String prompt, String regex,Scanner scanner) {
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.matches(regex)) {
                System.out.println("Input must be 'true' or 'false'.");
            }
        } while (!input.matches(regex));

        return Boolean.parseBoolean(input);
    }
    
    
}
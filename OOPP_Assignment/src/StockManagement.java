import java.util.Scanner;
import java.util.ArrayList;
public class StockManagement {
    private static Scanner scanner = new Scanner(System.in);

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
                displayProducts(products);
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
        int choice;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Only numbers 1 or 2 allowed!");
            }
        } while (choice < 1 || choice > 2);

        if (choice == 1) {
            addRefrigerator(products, scanner);
        } else {
            addTV(products, scanner);
        }
    }

    public static void addRefrigerator(ArrayList<Product>products, Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter door design: ");
        String doorDesign = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter quantity available in stock: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        // Create Refrigerator object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String doorDesign, String color, double capacity
        products.add(new Refrigerator(name,price, quantity, itemNumber,true, doorDesign, color, capacity));
        System.out.println("Refrigerator added successfully.");
    }

    public static void addTV(ArrayList<Product> products, Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter screen type: ");
        String screenType = scanner.nextLine();
        System.out.print("Enter resolution: ");
        int resolution = scanner.nextInt();
        System.out.print("Enter display size: ");
        int displaySize = scanner.nextInt();
        System.out.print("Enter quantity available in stock: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        // Create TV object and store it in the array
        //String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String screenType, int resolution, int displaySize
        products.add(new TV(name, price, quantity, itemNumber, true, screenType, resolution, displaySize));
        System.out.println("TV added successfully.");
    }

    public static void displayProducts(ArrayList<Product> products) {
    	if (products.size() < 1) {
    		System.out.println("Add product...");
    	}else {
        System.out.println("Products:");
        for (Product product:products) {
            System.out.println(product.toString());
        }
        }
    }

    public static void main(String[] args) {
        int maxProducts = getMaxProducts(scanner);
        //Product[] products = new Product[maxProducts];
        ArrayList<Product> products = new ArrayList<Product>();
        for(int i = 0 ; i < maxProducts;i++) {

        addProduct(products,scanner);
        }
        int choice;
        do {
            choice = displayMenu(scanner);
            executeMethod(choice, products, scanner);
        } while (choice != 0);
    }
}
import java.util.Scanner;
import java.util.ArrayList;
public class StockManagement{
	public static void main(String[] args) {
		/*Product pro1 = new Product("Something",1.2,2,123,true);
		System.out.println(pro1 + "\n");
		Refrigerator re1 = new Refrigerator("weff", 12.23, 3, 3, true, "round", "blue", 12.3);
		System.out.println(re1+"\n");
		TV tv = new TV("few", 2.2, 2, 2,false, "OLED", 1000, 23);
		System.out.println(tv+"\n");*/
		//UserInfo userInfo = new UserInfo();
		//System.out.println(userInfo.getUserID());
		//menu();
	}
	public static boolean checkInt(String line) { 
        try{
        	Integer.parseInt(line);
        	return true;
        }
        catch (NumberFormatException ex){
            System.out.println("Do not use string input. ");
        }
        return false; 
	}
	//need  to test
	public static int getMaximum(Scanner input) { 
		String addValue = input.nextLine();
		int addVal = -1;
		if (checkInt(addValue)) { 
			addVal = Integer.parseInt(addValue);
		}else {
			System.out.println("Invalid input");
		}
		if (addVal > 0 ) { 
			return addVal;
		}else { 
			System.out.println("Only input positive value");
		}
		return addVal;
	}
	//Not done yet
	public static void menu(ArrayList<Product> productArr, Scanner something , int menuChoice) {
		boolean flag = true; 
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1. View products\r\n" + 
					"2. Add stock\r\n" + 
					"3. Deduct stock\r\n" + 
					"4. Discontinue product\r\n" + 
					"0. Exit\r\n" + 
					"Please enter a menu option:");
			String parser = input.nextLine();
			int menuInput = 999;
	        try{
	            menuInput = Integer.parseInt(parser);
	        }
	        catch (NumberFormatException ex){
	            System.out.println("Do not use string input. ");
	        }
			switch(menuInput) {
			case 0: 
				flag = false;
				break;
			case 1: 
				viewProduct();
				break;
			case 2: 
				addStock();
				break;
			case 3:
				deductStock();
				break;
			case 4: 
				discontinueProd();
				break;
			default:
				System.out.println("Invalid input please try again. ");
				break;
							
			}
			//*****

		}while(flag);
		//close Scanner
		input.close();
	}
	public static void viewProduct() {
	} 
	public static void addStock() {
		 
	}
	public static void deductStock() {
		 
	}
	public static void discontinueProd() { 
		
	}
	}

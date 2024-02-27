import java.util.Scanner;
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
		menu();
	}
	public static void menu() {
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
	            System.out.println("Invalid input please try again. ");
	        }
			switch(menuInput) {
			case 0: 
				flag = false;
				break;
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
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
	}

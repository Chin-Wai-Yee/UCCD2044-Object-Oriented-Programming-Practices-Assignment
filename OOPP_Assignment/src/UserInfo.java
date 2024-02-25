import java.util.Scanner;
public class UserInfo {
	private String name;
	private String userID;
	//Default constructor
	public UserInfo() {
		setName();
		setUserID();
	}
	//Constructor
	public UserInfo(String name , String userID) {
		this.name = name;
		this.userID =  userID;
	}
	//Getters
	public String getName() {
		return name;
	}
	public String getUserID() {
		return userID;
	}
	//Setters
	public void setName (String name) {
		this.name = name;
	}
	public void setUserID (String userID) {
		this.userID = userID;
	}
	//New methods
	public void setName() {
		Scanner userInput =  new Scanner(System.in);
		System.out.println("Enter a username: ");
		name = userInput.nextLine();
	}
	public void setUserID() {

		if(checkSpace(name)) {
			String[] arrOfStr = name.split(" ",0);
			String firstName =   arrOfStr[0].substring(0,1);
			String lastName = arrOfStr[arrOfStr.length-1];
			this.userID = firstName + lastName;
		}else {
			this.userID="guest";
		}

	}
	public boolean checkSpace(String line) {
		return line.contains(" ");
		
	}
	//override
	
}

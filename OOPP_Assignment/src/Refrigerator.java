
public class Refrigerator extends Product {
	private String doorDesign;
	private String color;
	private double capacity;
	//Default constructor
	public Refrigerator() {
		
	}

    // Constructor
    public Refrigerator(String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String doorDesign, String color, double capacity) {
        super(productName, productPrice, productQuantity, productItemNumber, productStatus);
        this.doorDesign = doorDesign;
        this.color = color;
        this.capacity = capacity;
    }

    // Getters
    public String getDoorDesign() {
        return doorDesign;
    }

    public String getColor() {
        return color;
    }

    public double getCapacity() {
        return capacity;
    }

    // Setters
    public void setDoorDesign(String doorDesign) {
        this.doorDesign = doorDesign;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    //A method to calculate the value of stock of a refrigerator??

    // Override toString method
    @Override
    public String toString() {
        String desc = super.toString() +
                "\nDoor Design         : " + doorDesign +
                "\nColor               : " + color +
                "\nCapacity (Liters)   : " + capacity;
        return desc;
    }
}

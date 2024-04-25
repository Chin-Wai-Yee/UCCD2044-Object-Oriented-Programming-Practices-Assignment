
public class WashingMachine extends Product{
	private int capacityKg;//10 , 8 ,5
	private boolean hasDryer;//true or false
	private String noiceLevel;//high medium low
	
	public WashingMachine(){
		
	}
	//constructor
	public WashingMachine(String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,int capacityKg,boolean hasDryer,String noiceLevel) {
		super(productName, productPrice, productQuantity, productItemNumber, productStatus);
		this.capacityKg = capacityKg;
		this.hasDryer = hasDryer;
		this.noiceLevel = noiceLevel;
	}
	//getter
	public int getCapacityKg () {
		return capacityKg;
	}
	
	public boolean getHasDryer() {
		return hasDryer;
	}
	public String getNoiceLevel() {
		return noiceLevel;
	}
	//setter
	
	public void setCapacityKg(int capacityKg) {
		this.capacityKg = capacityKg;
	}
	public void setHasDryer(boolean hasDryer) {
		this.hasDryer = hasDryer;
	}
	public void setNoiceLevel(String  noiceLevel) {
		this.noiceLevel = noiceLevel;
	}
	@Override
	public String getDetails() {
    	String desc = "Washing Machine >>"+"Capacity (kg): " + capacityKg + " Built-in dryer: " + hasDryer + " Noice Level: " + noiceLevel;
    	return (desc);
    }
	
	@Override
    public String toString() {
        String desc = super.toString() +
                "\nCapacity (kg)            : " + capacityKg +
                "\nBuilt-in Dryer           : " + hasDryer +
                "\nNoice Level              : " + noiceLevel;
        return desc;
    }
	
	
	
}

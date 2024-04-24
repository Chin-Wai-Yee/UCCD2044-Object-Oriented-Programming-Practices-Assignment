
public class Oven extends Product{
	private String glassDoorDesign;
	private boolean hasConvection;
	private boolean hasTimer; //set cooking time/delay start
	
	public Oven(){
		
	}
	//constructor
	public Oven(String productName, double productPrice, int productQuantity, int productItemNumber,boolean productStatus,String glassDoorDesign,boolean hasConvection,boolean hasTimer) {
		super(productName, productPrice, productQuantity, productItemNumber, productStatus);
		this.glassDoorDesign = glassDoorDesign;
		this.hasConvection = hasConvection;
		this.hasTimer = hasTimer;
	}
	//getter
	public String getGlassDoorDesign() {
		return glassDoorDesign;
	}
	
	public boolean getHasConvection() {
		return hasConvection;
	}
	public boolean getHasTimer() {
		return hasTimer;
	}
	//setter
	
	public void setGlassDoorDesign(String glassDoorDesign) {
		this.glassDoorDesign = glassDoorDesign;
	}
	public void setHasConventional(boolean hasConvection) {
		this.hasConvection = hasConvection;
	}
	public void setHasTimer(boolean hasTimer) {
		this.hasTimer = hasTimer;
	}
	
	@Override
	public String getDetails() {
    	String desc = "Oven >>" + "Glass Door Design: " + glassDoorDesign + " Convection heating: " + hasConvection + " Built-in Timer: " + hasTimer;
    	return (desc);
    }
	
	@Override
    public String toString() {
        String desc = super.toString() +
                "\nGlass Door Design         : " + glassDoorDesign +
                "\nConvection heating        : " + hasConvection +
                "\nCooking Timer             : " + hasTimer;
        return desc;
    }
}

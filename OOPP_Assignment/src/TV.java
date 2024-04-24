public class TV extends Product {
    private String screenType;
    private int resolution;//idk this should be int or double
    private int displaySize;//idk this should be int or double

    // Default constructor
    public TV() {
        
    }

    // Constructor
    public TV(String productName, double productPrice, int productQuantity, int productItemNumber, boolean productStatus, String screenType, int resolution, int displaySize) {
        super(productName, productPrice, productQuantity, productItemNumber, productStatus);
        this.screenType = screenType;
        this.resolution = resolution;
        this.displaySize = displaySize; 
    }

    // Getters
    public String getScreenType() {
        return screenType;
    }

    public int getResolution() {
        return resolution;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    // Setters
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    // get the details
    @Override
    public String getDetails() {
    	String desc = "TV >> " + "Screen Type: " + screenType + " Resolution (pixels): " + resolution + " Display size: " + displaySize;
    	return (desc);
    }
    
    // Override toString method
    @Override
    public String toString() {
        String desc = super.toString() +
                "\nScreen Type         : " + screenType +
                "\nResolution (pixels) : " + resolution +
                "\nDisplay Size (inch) : " + displaySize;
        return desc;
    }
}
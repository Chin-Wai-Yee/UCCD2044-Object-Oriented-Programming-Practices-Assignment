
public class StockManagement{
	public static void main(String[] args) {
		Product pro1 = new Product("Something",1.2,2,123,true);
		System.out.println(pro1 + "\n");
		Refrigerator re1 = new Refrigerator("weff", 12.23, 3, 3, true, "round", "blue", 12.3);
		System.out.println(re1+"\n");
		TV tv = new TV("few", 2.2, 2, 2,false, "OLED", 1000, 23);
		System.out.println(tv+"\n");
	}
	}

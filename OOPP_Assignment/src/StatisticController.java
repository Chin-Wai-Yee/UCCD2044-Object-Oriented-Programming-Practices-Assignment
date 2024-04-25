import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class StatisticController{
	private ArrayList<Product> products = new  ArrayList<Product>();

	private int ovenNum = 0;
	private int washNum = 0;
	private int fridgeNum = 0; 
	private int TVNum  = 0;
	private double ovenIntValue = 0;
	private double washIntValue = 0;
	private double fridgeIntValue = 0; 
	private double TVIntValue  = 0;
	@FXML
	private Pane chartPane;
	@FXML
	private ComboBox<String> comboBox;
	private Stage stage;
	private Scene scene;
	private Parent root;
	private SharedList  productList = new SharedList();

	

	public void initialize() {
		comboBox.setItems(FXCollections.observableArrayList("Quantity","Inventory Value"));

		products = productList.getProductList();

	}
	public void setArray(ArrayList<Product>products) {
	    if (this.products == null) {
	        this.products = new ArrayList<>();
	    } else {
	        this.products.clear();
	    }
	    for (Product product : products) {
	        this.products.add(product);
	    }
	}
	
	public void setValues(ArrayList<Product> products) {
		ovenNum = 0;
		washNum = 0;
		fridgeNum = 0; 
		TVNum  = 0;
		ovenIntValue = 0;
		washIntValue = 0;
		fridgeIntValue = 0; 
		TVIntValue  = 0;
		for(Product product:products) {
			if (product instanceof Oven && product.getProductStatus()) {
				ovenNum+=product.getProductQuantity();
				ovenIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof WashingMachine&& product.getProductStatus()) {
				washNum+=product.getProductQuantity();
				washIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof Refrigerator&& product.getProductStatus()) {
				fridgeNum+=product.getProductQuantity();
				fridgeIntValue += product.getTotalInventoryValue();
			}
			if (product instanceof TV && product.getProductStatus()) {
				TVNum+=product.getProductQuantity();
				TVIntValue += product.getTotalInventoryValue();
			}
			
			
		}
	}
	public void setChart() {
		chartPane.getChildren().clear();

		if(products.isEmpty()) {
			
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Empty data");
	        alert.setHeaderText(null);
	        alert.setContentText("Please insert some products in the view product interface");
	        alert.showAndWait();
		}

		else if (comboBox.getValue() == "Quantity") {
			setValues(products);
			int total = ovenNum+washNum+fridgeNum+TVNum;
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		list.add(new PieChart.Data("Oven", ovenNum));
		list.add(new PieChart.Data("Washing Machine", washNum));
		list.add(new PieChart.Data("TV", TVNum));
		list.add(new PieChart.Data("Refrigerator", fridgeNum));
        list.forEach(data->
		data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), " ", data.pieValueProperty(), " units", " ",String.format("%.2f", data.pieValueProperty().getValue()/total*100),"%"
                )
        )
        );
		PieChart quantityChart= new PieChart(list);
        quantityChart.setTitle("PieChart of Product Quantity");
		chartPane.getChildren().add(quantityChart);

		}
		else if(comboBox.getValue()== "Inventory Value") {
			setValues(products);
			double total = ovenIntValue+washIntValue+TVIntValue+fridgeIntValue;
			ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
			list.add(new PieChart.Data("Oven", ovenIntValue ));
			list.add(new PieChart.Data("Washing Machine",  washIntValue));
			list.add(new PieChart.Data("TV",  TVIntValue));
			list.add(new PieChart.Data("Refrigerator",  fridgeIntValue));
			list.forEach(data ->
	        data.nameProperty().bind(
	                Bindings.concat(
	                        data.getName(), " RM ", data.pieValueProperty(), " ",String.format("%.2f", data.pieValueProperty().getValue()/total*100),"%"
	                )
	        )
  
	);
			PieChart valueChart= new PieChart(list);
	        valueChart.setTitle("PieChart of Inventory Value");
			chartPane.getChildren().add(valueChart);

		
		}
		
	}
	public void handleBackBtn(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
		root  = loader.load();
		stage =	(Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}

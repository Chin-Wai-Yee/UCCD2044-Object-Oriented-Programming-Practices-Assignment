import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewController{
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Pane viewPane;

    @FXML
    private TableView<Product> productTableView;


    @FXML
    private TableColumn<Product, Integer> productNumber;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Double> productPrice;

    @FXML
    private TableColumn<Product, String> quantity;

    @FXML
    private TableColumn<Product, Boolean> status;

    @FXML
    private TableColumn<Product, String> details;
	public void switchScene(ActionEvent e, String fxmlFile) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
		root  = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void handleAddProductButton(ActionEvent e) throws IOException{
		switchScene(e,"AddProductUI.fxml");
	}
	@FXML
	public void handleUpdateProductButton(ActionEvent e) throws IOException {
		switchScene(e,"UpdateProductUI.fxml");
	}
	@FXML
	public void handleDeleteProductButton(ActionEvent e) throws IOException {
		switchScene(e,"DeleteProductUI.fxml");
	}
	@FXML
	public void handleBackMenuButton(ActionEvent e) throws IOException {
		switchScene(e,"MenuUI.fxml");
	}
	
	public void initialize() {


//		SharedList pal = new SharedList();
//        Product n1 = new Refrigerator("Samsung refri", 9999, 0, 1, true, "dual glass", "black", 12);
//        Product n2 = new WashingMachine("Samsung wash", 999, 0, 2, true, 10, true, "low");
//        pal.addProducts(n1);
//        pal.addProducts(n2);
        
        SharedList pl = new SharedList();
		ArrayList<Product> products = pl.getProductList();
		//ObservableList<Product> product = FXCollections.observableArrayList(products);
//        productTableView.setItems(product);
		
	    // Set cell value factories to populate table columns
        productNumber.setCellValueFactory(new PropertyValueFactory<>("productItemNumber"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        status.setCellValueFactory(new PropertyValueFactory<>("productStatus"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
	    
        
        
        productTableView.getItems().addAll(products);

    }
	
}

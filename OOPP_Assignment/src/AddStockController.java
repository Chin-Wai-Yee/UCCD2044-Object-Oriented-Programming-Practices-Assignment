import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddStockController {

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

    @FXML
    private TextField selectedProductName;

    @FXML
    private TextField addQuantity;

    @FXML
    private Button backToMenuBtn;
    
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        switchScene(event, "MenuUI.fxml");
		stage.setTitle("Stock Management System");
    }

    @FXML
    void displaySelected(MouseEvent event) {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            return;
        }
        selectedProductName.setText(selectedProduct.getProductName());
    }

    @FXML
    void addStock(ActionEvent event) {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No product selected");
            alert.setContentText("Please select a product to add stock to");
            alert.showAndWait();
            return;
        }

        try {
            Integer.parseInt(addQuantity.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a valid number");
            alert.showAndWait();
            return;
        }

        int quantity = Integer.parseInt(addQuantity.getText());
        if (quantity <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a positive number");
            alert.showAndWait();
            return;
        }

        // update
        selectedProduct.setProductQuantity(quantity + selectedProduct.getProductQuantity());

        productTableView.refresh();
        selectedProductName.clear();
        productTableView.getSelectionModel().clearSelection();
        
        addQuantity.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Stock added successfully");
        alert.setContentText("Stock added to " + selectedProduct.getProductName());
        alert.showAndWait();

    }

    public void initialize() {

        SharedList pl = new SharedList();
        ArrayList<Product> products = pl.getProductList();

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

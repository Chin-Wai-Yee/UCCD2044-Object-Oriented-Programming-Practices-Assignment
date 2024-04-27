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

public class DiscontinueController {

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
    private Button backToMenuBtn;

    @FXML
    private Button discontinueBtn;

    @FXML
    private Button continueBtn;

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
    void discontinueProduct(ActionEvent event) {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            return;
        }
        selectedProduct.setProductStatus(false);
        productTableView.refresh();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Product discontinued");
        alert.setHeaderText("Product discontinued successfully");
        alert.showAndWait();
    }

    @FXML
    void continueProduct(ActionEvent event) {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            return;
        }
        selectedProduct.setProductStatus(true);
        productTableView.refresh();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Product continued");
        alert.setHeaderText("Product continued successfully");
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

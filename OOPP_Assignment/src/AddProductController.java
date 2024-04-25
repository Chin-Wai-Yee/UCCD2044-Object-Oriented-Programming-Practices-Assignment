import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddProductController {
	private int targetProduct=1;//1-refri,2-tv,3-oven,4-washingMachine
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Pane viewPane;

	@FXML
    private Button refrigeratorButton;
	@FXML
	private Button tvButton;

	@FXML
	private Button ovenButton;

	@FXML
	private Button washingMachineButton;
	@FXML
    private Label label1;

    @FXML
    private TextField textField1;

    @FXML
    private Label label2;

    @FXML
    private TextField textField2;

    @FXML
    private Label label3;

    @FXML
    private TextField textField3;

    @FXML
    private Label label4;

    @FXML
    private TextField textField4;

    @FXML
    private Label label5;

    @FXML
    private TextField textField5;

    @FXML
    private Label label6;

    @FXML
    private TextField textField6;
	@FXML
	public void switchScene(ActionEvent e, String fxmlFile) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
		root  = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		targetProduct=1;
	}
	

	@FXML
	void handleBackMenuButton(ActionEvent e) throws IOException {
		switchScene(e,"ViewUI.fxml");
	}

	@FXML
	void handleMouseEnter(MouseEvent event) {
	    	
	}

	@FXML
	void handleMouseExit(MouseEvent event) {

	}

    @FXML
    void handleRefriEvent(ActionEvent event) {
    	label1.setText("Product Number :");
    	label2.setText("Product Name : ");
    	label3.setText("Product Price : ");
    	label4.setText("Door Design : ");
    	label5.setText("Color : ");
    	label6.setText("Capacity(Litres) : ");
    	targetProduct=1;
    }
    @FXML
    void handleTVEvent(ActionEvent event) {
    	label1.setText("Product Number :");
    	label2.setText("Product Name : ");
    	label3.setText("Product Price : ");
    	label4.setText("Screen Type : ");
    	label5.setText("Resolution : ");
    	label6.setText("Display Size : ");
    	targetProduct=2;
    }
    @FXML
    void handleOvenEvent(ActionEvent event) {
    	label1.setText("Product Number :");
    	label2.setText("Product Name : ");
    	label3.setText("Product Price : ");
    	label4.setText("Glass Door Design : ");
    	label5.setText("Convection Heating : ");
    	label6.setText("Built-in Timer : ");
    	targetProduct=3;
    }


    @FXML
    void handleWashingMachineEvent(ActionEvent event) {
    	label1.setText("Product Number :");
    	label2.setText("Product Name : ");
    	label3.setText("Product Price : ");
    	label4.setText("Capacity(Kg) : ");
    	label5.setText("Built-in Dryer : ");
    	label6.setText("Noice Level : ");
    	targetProduct=4;
    }

    @FXML
    void handleConfirmEvent(ActionEvent event) throws IOException {
    	SharedList pal = new SharedList();
    	pal.getProductList();
		int tf1 = Integer.parseInt(textField1.getText()); //product item number
		String tf2 = textField2.getText();//product name
		Double tf3 = Double.parseDouble(textField3.getText()); //price
    	if(targetProduct==1) {
    		String tf4 = textField4.getText();
    		String tf5 = textField5.getText();
    		Double tf6 = Double.parseDouble(textField6.getText());
    	    Product n1 = new Refrigerator(tf2,tf3,0,tf1,true,tf4,tf5,tf6);
    	    pal.addProducts(n1);
    	}
    	else if(targetProduct==2) {
    		String tf4 = textField4.getText();
    		int tf5 = Integer.parseInt(textField5.getText());
    		int tf6 = Integer.parseInt(textField6.getText());
    	    Product n1 = new TV(tf2,tf3,0,tf1,true,tf4,tf5,tf6);
    	    pal.addProducts(n1);
    	}
    	else if(targetProduct==3) {
    		String tf4 = textField4.getText();
    		Boolean tf5 = Boolean.parseBoolean(textField5.getText());
    		Boolean tf6 = Boolean.parseBoolean(textField6.getText());
    	    Product n1 = new Oven(tf2,tf3,0,tf1,true,tf4,tf5,tf6);
    	    pal.addProducts(n1);
    	}
    	else if(targetProduct==4) {
    		int tf4 = Integer.parseInt(textField4.getText());
    		Boolean tf5 = Boolean.parseBoolean(textField5.getText());
    		String tf6 = textField6.getText();
    	    Product n1 = new WashingMachine(tf2,tf3,0,tf1,true,tf4,tf5,tf6);
    	    pal.addProducts(n1);
    	}
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Product Adding");
		alert.setHeaderText("Successfully add the product with number " + tf1);
		if(alert.showAndWait().get()==ButtonType.OK) {
			switchScene(event,"ViewUI.fxml");
		}		    	
    }
    
    @FXML
    void handleResetEvent(ActionEvent event) {
    	textField1.clear();
    	textField2.clear();
    	textField3.clear();
    	textField4.clear();
    	textField5.clear();
    	textField6.clear();

    }
}
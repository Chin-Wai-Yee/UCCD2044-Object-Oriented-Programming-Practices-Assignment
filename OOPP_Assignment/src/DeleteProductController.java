import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DeleteProductController {
	private int productLoc = -1;

	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	
    @FXML
    private Pane viewPane;

    @FXML
    private Button confirmButton;

    @FXML
    private Button resetButton;

    @FXML
    private TextField textField1;

    @FXML
    private Label label1;

    @FXML
    private Label text1;

    @FXML
    private Label label2;

    @FXML
    private Label text2;

    @FXML
    private Label label3;

    @FXML
    private Label text3;

    @FXML
    private Label label4;

    @FXML
    private Label text4;

    @FXML
    private Label label5;

    @FXML
    private Label text5;

    @FXML
    private Label informLabel;

	@FXML
	public void switchScene(ActionEvent e, String fxmlFile) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
		root  = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
    @FXML
    void handleBackMenuButton(ActionEvent event) throws IOException {
    	switchScene(event,"ViewUI.fxml");
    }
    @FXML
    void handleConfirmEvent(ActionEvent event) throws IOException {

		if(productLoc==-1) {
			Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("id not found");
			fail.setContentText("please ensure your id is correct to confirm");
			fail.showAndWait();
		}
		else {
			int loc=productLoc;
			SharedList pal = new SharedList();			
			pal.deleteProduct(loc);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Product Deleting");
			alert.setHeaderText("Dear user...Successfully Delete the product");
			if(alert.showAndWait().get()==ButtonType.OK) {
				switchScene(event,"ViewUI.fxml");
			}	
		}
    }
    @FXML
    void handleKeyEnter(KeyEvent event) {
        	if(event.getCode()==KeyCode.ENTER)
        		handleSearchButton(new ActionEvent());
    }
    @FXML
    void handleResetEvent(ActionEvent event) {
        	label1.setText("");
        	label2.setText("");
        	label3.setText("");
        	label4.setText("");
        	label5.setText("");
        	informLabel.setText("");
        	text1.setText("");
        	text2.setText("");
        	text3.setText("");
        	text4.setText("");
        	text5.setText("");
        	textField1.clear();
        	productLoc=-1; //reset location of product
    }
    
    @FXML
    void handleSearchButton(ActionEvent event) {
    	SharedList pal=new SharedList();
    	int itemNumber = Integer.parseInt(textField1.getText());
    	int loc=pal.checkItemNumber(itemNumber);
    	productLoc=loc; //update the product location
    	if(loc==-1) {
    		//alert the user
    	}
    	else {
    		Product temp=pal.getProduct(loc);
    		
			text1.setText(temp.getProductName());
			text2.setText(Double.toString(temp.getProductPrice()));

			label1.setText("Product Name : ");
			label2.setText("Product Price : ");

    		if(temp instanceof Refrigerator) {

    			
    			text3.setText(((Refrigerator) temp).getDoorDesign());
    			text4.setText(((Refrigerator) temp).getColor());
    			text5.setText(Double.toString(((Refrigerator) temp).getCapacity()));
    			
    	    	label3.setText("Door Design : ");
    	    	label4.setText("Color : ");
    	    	label5.setText("Capacity(Litres) : ");
    	        			
            }
    		else if(temp instanceof TV) {
    			text3.setText(((TV) temp).getScreenType());
    			text4.setText(Integer.toString(((TV) temp).getResolution()));
    			text5.setText(Integer.toString(((TV) temp).getDisplaySize()));
    			
    			label3.setText("Screen Type : ");
    			label4.setText("Resolution : ");
    			label5.setText("Display Size : ");
    		
    			
    		}
    		else if(temp instanceof WashingMachine) {
    			text3.setText(Integer.toString(((WashingMachine) temp).getCapacityKg()));
    			text4.setText(Boolean.toString(((WashingMachine) temp).getHasDryer()));
    			text5.setText(((WashingMachine) temp).getNoiceLevel());
    	
    	    	label3.setText("Capacity(Kg) : ");
    	    	label4.setText("Built-in Dryer : ");
    	    	label5.setText("Noice Level : ");	
    		}	
    		else if(temp instanceof Oven) {
    			text3.setText(((Oven) temp).getGlassDoorDesign());
    			text4.setText(Boolean.toString(((Oven) temp).getHasConvection()));
    			text5.setText(Boolean.toString(((Oven) temp).getHasTimer()));
    	    	
    			label3.setText("Glass Door Design : ");
    	    	label4.setText("Convection Heating : ");
    	    	label5.setText("Built-in Timer : ");
    		}
    		informLabel.setText("Please click confirm to delete the product with item Number " + temp.getProductItemNumber());
    		informLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    		informLabel.setAlignment(Pos.CENTER);
    	}
    }
}

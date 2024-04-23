import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UpdateProductController {
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
    private Label label6;

    @FXML
    private TextField textField2;

    @FXML
    private Label label7;

    @FXML
    private TextField textField3;

    @FXML
    private Label label8;

    @FXML
    private TextField textField4;

    @FXML
    private Label label9;

    @FXML
    private TextField textField5;

    @FXML
    private Label label10;

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
	}
	@FXML
	void handleBackMenuButton(ActionEvent e) throws IOException {
		switchScene(e,"ViewUI.fxml");
	}

	@FXML
    public void handleConfirmEvent(ActionEvent e) throws IOException {

		if(textField1.getText().isEmpty()) {
			Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("Please input the id");
			fail.setContentText("id cannot be empty");
			fail.showAndWait();
		}
		else if(productLoc==-1) {
			Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("id not found");
			fail.setContentText("please ensure your id is correct to confirm");
			fail.showAndWait();
		}
		else {
			int loc=productLoc;
			SharedList pal = new SharedList();
			Product temp=pal.getProduct(loc);
			if(!textField2.getText().isEmpty()) {
				temp.setProductName(textField2.getText());
			}
			if(!textField3.getText().isEmpty()) {
				temp.setProductName(textField3.getText());
			}
			
			if(temp instanceof Refrigerator) {
				if(!textField4.getText().isEmpty()) {
					((Refrigerator) temp).setDoorDesign(textField4.getText());
				}
				if(!textField5.getText().isEmpty()) {
					((Refrigerator) temp).setColor(textField5.getText());
				}
				if(!textField6.getText().isEmpty()) {
					((Refrigerator) temp).setCapacity(Double.parseDouble(textField6.getText()));
				}			
	        }
			else if(temp instanceof TV) {
				if(!textField4.getText().isEmpty()) {
					((TV) temp).setScreenType(textField4.getText());
				}
				if(!textField5.getText().isEmpty()) {
					((TV) temp).setResolution(Integer.parseInt(textField5.getText()));
				}
				if(!textField6.getText().isEmpty()) {
					((TV) temp).setDisplaySize(Integer.parseInt(textField6.getText()));
				}		
			}
			else if(temp instanceof WashingMachine) {
				if(!textField4.getText().isEmpty()) {
					((WashingMachine) temp).setCapacityKg(Integer.parseInt(textField4.getText()));
				}
				if(!textField5.getText().isEmpty()) {
					((WashingMachine) temp).setHasDryer(Boolean.parseBoolean(textField5.getText()));
				}
				if(!textField6.getText().isEmpty()) {
					((WashingMachine) temp).setNoiceLevel(textField6.getText());
				}	
			}
					
			else if(temp instanceof Oven) {
				if(!textField4.getText().isEmpty()) {
					((Oven) temp).setGlassDoorDesign(textField4.getText());
				}
				if(!textField5.getText().isEmpty()) {
					((Oven) temp).setHasConventional(Boolean.parseBoolean(textField5.getText()));
				}
				if(!textField6.getText().isEmpty()) {
					((Oven) temp).setHasTimer(Boolean.parseBoolean(textField6.getText()));
				}	
			}
			pal.updateProduct(loc, temp);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Product Updating");
			alert.setHeaderText("dear user...Successfully update the product");
			if(alert.showAndWait().get()==ButtonType.OK) {
				switchScene(e,"ViewUI.fxml");
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
    	label6.setText("");
    	label7.setText("");
    	label8.setText("");
    	label9.setText("");
    	label10.setText("");
    	text1.setText("");
    	text2.setText("");
    	text3.setText("");
    	text4.setText("");
    	text5.setText("");
    	textField1.clear();
    	textField2.setVisible(false);
    	textField3.setVisible(false);
    	textField4.setVisible(false);
    	textField5.setVisible(false);
    	textField6.setVisible(false);

    }

    @FXML
    void handleSearchButton(ActionEvent event) {
    	SharedList pal=new SharedList();
    	int itemNumber = Integer.parseInt(textField1.getText());
    	int loc=pal.checkItemNumber(itemNumber);
    	productLoc=loc;
    	if(loc==-1) {
    		//alert the user
    	}
    	else {
    		Product temp=pal.getProduct(loc);
    		
			text1.setText(temp.getProductName());
			text2.setText(Double.toString(temp.getProductPrice()));

			label1.setText("Product Name : ");
			label2.setText("Product Price : ");
			
			label6.setText("Product Name : ");
			label7.setText("Product Price : ");

    		if(temp instanceof Refrigerator) {

    			
    			text3.setText(((Refrigerator) temp).getDoorDesign());
    			text4.setText(((Refrigerator) temp).getColor());
    			text5.setText(Double.toString(((Refrigerator) temp).getCapacity()));
    			
    	    	label3.setText("Door Design : ");
    	    	label4.setText("Color : ");
    	    	label5.setText("Capacity(Litres) : ");
    	    	
    	    	label8.setText("Door Design : ");
    	    	label9.setText("Color : ");
    	    	label10.setText("Capacity(Litres) : ");
    	        			
            }
    		else if(temp instanceof TV) {
    			text3.setText(((TV) temp).getScreenType());
    			text4.setText(Integer.toString(((TV) temp).getResolution()));
    			text5.setText(Integer.toString(((TV) temp).getDisplaySize()));
    			
    			label3.setText("Screen Type : ");
    			label4.setText("Resolution : ");
    			label5.setText("Display Size : ");
    		
    			label8.setText("Screen Type : ");
    			label9.setText("Resolution : ");
    			label10.setText("Display Size : ");
    			
    		}
    		else if(temp instanceof WashingMachine) {
    			
    			text3.setText(Integer.toString(((WashingMachine) temp).getCapacityKg()));
    			text4.setText(Boolean.toString(((WashingMachine) temp).getHasDryer()));
    			text5.setText(((WashingMachine) temp).getNoiceLevel());
    			
    	    	label3.setText("Capacity(Kg) : ");
    	    	label4.setText("Built-in Dryer : ");
    	    	label5.setText("Noice Level : ");
    	    	
    	    	label8.setText("Capacity(Kg) : ");
    	    	label9.setText("Built-in Dryer : ");
    	    	label10.setText("Noice Level : ");
    		}
    				
    		else if(temp instanceof Oven) {
    			text3.setText(((Oven) temp).getGlassDoorDesign());
    			text4.setText(Boolean.toString(((Oven) temp).getHasConvection()));
    			text5.setText(Boolean.toString(((Oven) temp).getHasTimer()));
    	    	
    			label3.setText("Glass Door Design : ");
    	    	label4.setText("Convection Heating : ");
    	    	label5.setText("Built-in Timer : ");
    			
    			label8.setText("Glass Door Design : ");
    	    	label9.setText("Convection Heating : ");
    	    	label10.setText("Built-in Timer : ");
    		}    	
    		textField2.setVisible(true);
    		textField3.setVisible(true);
    		textField4.setVisible(true);
    		textField5.setVisible(true);
    		textField6.setVisible(true);

    		
    	}
    }
}















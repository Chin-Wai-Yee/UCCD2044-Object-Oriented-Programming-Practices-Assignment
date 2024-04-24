import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField nameTextField;
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private Label DateTimeLabel;
    @FXML
    private TextField maximumQuantity;
    
public void switchToMenu(ActionEvent e) throws IOException{
	try {
	if (nameTextField.getText() == null || nameTextField.getText().trim().isEmpty()) {
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("Empty text field");
        fail.setContentText("Name cannot be empty");
        fail.showAndWait();
	}else if(Integer.parseInt(maximumQuantity.getText()) < 0 ) {
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("Error maximum quantity");
        fail.setContentText("The quantity should be a positive integer");
        fail.showAndWait();
	}
	else {
		UserInfo user = new UserInfo(nameTextField.getText(),"");
		SharedList pal=new SharedList();
		pal.setMAaximumProduct(Integer.parseInt(maximumQuantity.getText()));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
		root  = loader.load();
		MenuController menuController = loader.getController();
		menuController.setUserInfo(user);
	
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	}catch(NumberFormatException event) {
		// Handle the case when a number format exception occurs
		Alert alert = new Alert(AlertType.ERROR);
	 	alert.setTitle("Input Error");
	    alert.setHeaderText(null);
	    alert.setContentText("Please enter a valid number for numeric fields.");
	    alert.showAndWait();
        return;
    }catch (Exception event) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter valid values for all fields.");
        alert.showAndWait();
        return;
		
	}
}
	public void initialize(){
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentDate.format(formatter);
		DateTimeLabel.setText(formattedDate);
		DateTimeLabel.setFont(new Font(18));
		DateTimeLabel.setTextFill(Color.WHITE);
	}
}
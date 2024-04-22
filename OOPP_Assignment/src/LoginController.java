import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField nameTextField;
	private Stage stage;
	private Scene scene;
	private Parent root;
	

public void switchToMenu(ActionEvent e) throws IOException{
	if (nameTextField.getText() == null || nameTextField.getText().trim().isEmpty()) {
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("Empty text field");
        fail.setContentText("Name cannot be empty");
        fail.showAndWait();
	}else {
		UserInfo user = new UserInfo(nameTextField.getText(),"");
		
	FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
	root  = loader.load();
	MenuController menuController = loader.getController();
	menuController.setUserInfo(user);

	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}
}

}
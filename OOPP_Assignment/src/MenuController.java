import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController{
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	private UserInfo user = new UserInfo("","");
	public void setUserInfo(UserInfo user) {

	    this.user.setName(user.getName());
	    this.user.setUserID(user.getUserID());
	}
	public void switchScene(ActionEvent e, String fxmlFile) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
		root  = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void handleViewButton(ActionEvent e) throws IOException {
		switchScene(e,"ViewUI.fxml");
	}
	public void handleAddStockButton(ActionEvent e) throws IOException{
		switchScene(e,"AddStockUI.fxml");
	}
	public void handleDeductStockButton(ActionEvent e) throws IOException {
		switchScene(e,"DeductStockUI.fxml");
	}
	public void handleDiscontinueButton(ActionEvent e) throws IOException{
		switchScene(e,"DiscontinueUI.fxml");
	}
	public void handleStatisticButton(ActionEvent e) throws IOException{
		switchScene(e,"StatisticUI.fxml");
	}
	public void handleMenuExitButton(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText(user.getName()+" "+user.getUserID()+", you are about to exit!");
		alert.setContentText("Are you sure you want to exit");
		if(alert.showAndWait().get()==ButtonType.OK) {
		stage =	(Stage)((Node)e.getSource()).getScene().getWindow();
		stage.close();
		}
	
	}
	
}
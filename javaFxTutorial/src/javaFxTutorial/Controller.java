package javaFxTutorial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller{
	@FXML
	private	AnchorPane mainPane;
	public void handleMenuExitButton(ActionEvent e) {

		Stage stage = (Stage) mainPane.getScene().getWindow();
		stage.close();
		
	}
}
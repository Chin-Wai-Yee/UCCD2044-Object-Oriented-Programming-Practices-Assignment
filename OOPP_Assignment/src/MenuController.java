import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController{
	@FXML
	private	AnchorPane mainPane;
	public void handleMenuExitButton(ActionEvent e) {

		Stage stage = (Stage) mainPane.getScene().getWindow();
		stage.close();
		
	}
}
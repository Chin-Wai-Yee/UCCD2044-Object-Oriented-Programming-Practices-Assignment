package javaFxTutorial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
	@Override
	public void start(Stage  primaryStage) {
		try{
		Parent root  =  FXMLLoader.load(getClass().getResource("/Main.fxml")); 
		primaryStage.setTitle("Tutorial");
		primaryStage.setScene(new Scene(root));
	
		primaryStage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main (String[] args) {
		launch(args);
	}
}

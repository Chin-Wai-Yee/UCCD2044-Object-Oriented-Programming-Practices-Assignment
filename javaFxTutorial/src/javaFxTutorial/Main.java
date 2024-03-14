package javaFxTutorial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application {
	@Override
	public void start(Stage  primaryStage) throws Exception{
		Parent root = new BorderPane();
		primaryStage.setTitle("Tutorial");
		primaryStage.setScene(new Scene(root,300,275,Color.BLACK));
		primaryStage.show();
	}
	public static void main (String[] args) {
		launch(args);
	}
}


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.*;
public class StockManagementGUI extends Application {
    private TextField maxProductsField;
    private TextArea outputArea;
    private ComboBox<String> menuOptions;
    private Button executeButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stock Management System");

        // Create main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Create top layout with input fields
        VBox topLayout = new VBox(10);
        topLayout.setPadding(new Insets(10));
        Label maxProductsLabel = new Label("Enter maximum number of products:");
        maxProductsField = new TextField();
        topLayout.getChildren().addAll(maxProductsLabel, maxProductsField);

        // Create center layout with output area
        VBox centerLayout = new VBox(10);
        centerLayout.setPadding(new Insets(10));
        Label outputLabel = new Label("Output:");
        outputArea = new TextArea();
        outputArea.setEditable(false);
        centerLayout.getChildren().addAll(outputLabel, outputArea);

        // Create bottom layout with menu options and execute button
        HBox bottomLayout = new HBox(10);
        bottomLayout.setPadding(new Insets(10));
        menuOptions = new ComboBox<>();
        menuOptions.getItems().addAll("View products", "Add stock", "Deduct stock", "Discontinue product", "Exit");
        executeButton = new Button("Execute");
        bottomLayout.getChildren().addAll(menuOptions, executeButton);

        // Add layouts to main layout
        mainLayout.setTop(topLayout);
        mainLayout.setCenter(centerLayout);
        mainLayout.setBottom(bottomLayout);

        // Create scene and set it to the stage
        Scene scene = new Scene(mainLayout, 400, 300);
        primaryStage.setScene(scene);

        // Set event handler for execute button
        executeButton.setOnAction(event -> executeAction());

        // Show the stage
        primaryStage.show();
    }

    private void executeAction() {
        // Retrieve input from input fields
        String maxProductsInput = maxProductsField.getText();
        String menuOption = menuOptions.getValue();

        // Execute the appropriate action based on the selected menu option
        switch (menuOption) {
            case "View products":
                // Implement view products action
                outputArea.setText("View products action executed");
                break;
            case "Add stock":
                // Implement add stock action
                outputArea.setText("Add stock action executed");
                break;
            case "Deduct stock":
                // Implement deduct stock action
                outputArea.setText("Deduct stock action executed");
                break;
            case "Discontinue product":
                // Implement discontinue product action
                outputArea.setText("Discontinue product action executed");
                break;
            case "Exit":
                // Implement exit action
                outputArea.setText("Exit action executed");
                break;
            default:
                outputArea.setText("Invalid menu option");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
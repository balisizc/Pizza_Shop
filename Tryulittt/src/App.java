import controller.PaymentMethodController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Payment.fxml"));
        Parent root = loader.load();

        // Get the controller instance
        PaymentMethodController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        // Set up the primary stage
        primaryStage.setTitle("PIZZERIA");
        primaryStage.getIcons().add(new Image("/Images/pizzaLogo-removebg-preview 1.png")); // Set application icon
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}

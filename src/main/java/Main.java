
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load((getClass().getResource("fxmlFiles/HomeScreen.fxml")));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}
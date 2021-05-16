package controlers;


import database.DatabaseHandler;
import database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationControl {
    @FXML
    private TextField userNameRegister;
    @FXML
    private PasswordField passwordRegister;
    @FXML
    private TextField numberRegister;
    @FXML
    private Button registrationButton;

    public void registerClickButton() {

        registrationButton.setOnAction(event -> {
            System.out.println("REgister in Register PAge");
            signUpNewUser();
        });

    }

    private void signUpNewUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String username = userNameRegister.getText();
        String password = passwordRegister.getText();
        String number = numberRegister.getText();

        User user = new User(username,password,number);

        databaseHandler.signUpUser(user);
    }

    private void loginUser(String usernameRegisterText, String passwordRegisterText) {

    }


}
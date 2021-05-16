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

public class HomePageControl {

    @FXML
    private Button registerButtonHomeScreen;
    @FXML
    private Button loginButtonHomeScreen;;
    @FXML
    private TextField userNameHomePage;
    @FXML
    private PasswordField passwordHomeScreen;

    public void registerClickButton() throws IOException {

        registerButtonHomeScreen.setOnAction(actionEvent -> {
            registerButtonHomeScreen.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxmlFiles/LoginPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

            System.out.println("Te-ai inregistrat");

        });

        loginButtonHomeScreen.setOnAction(actionEvent ->{
          loginButtonHomeScreen.getScene().getWindow().hide();
          
          String loginText = loginButtonHomeScreen.getText().trim();
          String loginPassword = passwordHomeScreen.getText().trim();
          
          if(!loginText.equals("") && !loginPassword.equals("")){
              loginUser(loginText,loginPassword);
          }
          else
              System.out.println("Completati datele");

          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getClassLoader().getResource("fxmlFiles/ClientPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            });

        
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = databaseHandler.getUser(user);

        int couter =0;

        while(true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            couter++;
        }
        if(couter >= 1){
            System.out.println("Login Succes");
        }

    }
}
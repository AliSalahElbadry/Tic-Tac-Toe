package tic.tac.toe;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginFXMLBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView imageView0;
    protected final TextField EmailTextField;
    protected final PasswordField passwordTextField;
    protected final Button loginBtn;
    protected final ImageView imageView1;
    protected final Text dontHaveAnAccountText;
 protected final ImageView backButton;
    protected final ContextMenu emailValidator;
    protected final ContextMenu passValidator;
    public Socket mySocket;
    public static PlayerData playerData;
    public static PlayerConnection playerConnection;
    boolean isConnected = true;


    public LoginFXMLBase() {
       
            try {
                mySocket = new Socket(InetAddress.getLocalHost(), 5005);
                playerConnection = new PlayerConnection(mySocket);
            } catch (Exception ex) {
                isConnected = false;
            }
        backButton = new ImageView();
        imageView = new ImageView();
        rectangle = new Rectangle();
        imageView0 = new ImageView();
        EmailTextField = new TextField();
        passwordTextField = new PasswordField();
        loginBtn = new Button();
        imageView1 = new ImageView();
        dontHaveAnAccountText = new Text();

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tic/tac/toe/css/loginfxml.css");

        
         backButton.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        backButton.setFitHeight(70.0);
        backButton.setFitWidth(70.0);
        backButton.setLayoutX(2.0);
        backButton.setLayoutY(407.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backButton.setOnMouseClicked(event ->{
        
            TicTacToe.scene.setRoot(new MainPageScreenBase());
            
        });
        
        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        rectangle.setArcHeight(100.0);
        rectangle.setArcWidth(100.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setHeight(308.0);
        rectangle.setLayoutX(150.0);
        rectangle.setLayoutY(86.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(450.0);
        rectangle.setFocusTraversable(true);

        imageView0.setFitHeight(101.0);
        imageView0.setFitWidth(307.0);
        imageView0.setLayoutX(224.0);
        imageView0.setLayoutY(36.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        EmailTextField.setLayoutX(224.0);
        EmailTextField.setLayoutY(164.0);
        EmailTextField.setPrefHeight(45.0);
        EmailTextField.setPrefWidth(290.0);
        EmailTextField.setPromptText("Email");
        EmailTextField.getStyleClass().add("textField");
        EmailTextField.setFont(new Font(19.0));

        emailValidator = new ContextMenu();
        emailValidator.setAutoHide(false);

        passValidator = new ContextMenu();
        passValidator.setAutoHide(false);

        passwordTextField.setLayoutX(224.0);
        passwordTextField.setLayoutY(218.0);
        passwordTextField.setPrefHeight(45.0);
        passwordTextField.setPrefWidth(290.0);
        passwordTextField.setPromptText("Password");
        passwordTextField.getStyleClass().add("textField");
        passwordTextField.setFont(new Font(19.0));

        loginBtn.setLayoutX(293.0);
        loginBtn.setLayoutY(294.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(37.0);
        loginBtn.setPrefWidth(165.0);
        loginBtn.getStyleClass().add("loginBtn");
        loginBtn.setText("Log In");
        loginBtn.setFont(new Font("Serif Regular", 20.0));
        loginBtn.setOnAction(e -> {

            if (EmailTextField.getText().equals("")) {
                emailValidator.hide();
                passValidator.hide();
                emailValidator.getItems().clear();
                emailValidator.getItems().add(
                        new MenuItem("Please enter emil"));
                emailValidator.show(EmailTextField, Side.RIGHT, 10, 0);
                
            }
             else if(EmailTextField.getText().contains(","))
            {
                emailValidator.hide();
                passValidator.hide();
               emailValidator.getItems().clear();
                emailValidator.getItems().add(
                        new MenuItem("email shouldn't contain \",\""));
                emailValidator.show(EmailTextField, Side.RIGHT, 10, 0); 
            }
             else if(!emailPattern(EmailTextField.getText(), "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
             {
                 emailValidator.hide();
                passValidator.hide();
                 emailValidator.getItems().clear();
                emailValidator.getItems().add(
                        new MenuItem("Invalid email \nshould be like:yas@gmail.com"));
                emailValidator.show(EmailTextField, Side.RIGHT, 10, 0); 
             }
            else if (passwordTextField.getText().equals("")) {
                emailValidator.hide();
                passValidator.hide();
                passValidator.getItems().clear();
                passValidator.getItems().add(
                        new MenuItem("Please enter Password"));
                passValidator.show(passwordTextField, Side.RIGHT, 10, 0);
            }
            else if(passwordTextField.getText().contains(","))
            {
                emailValidator.hide();
                passValidator.hide();
                passValidator.getItems().clear();
                passValidator.getItems().add(
                        new MenuItem("Password shouldn't contain \",\""));
                passValidator.show(passwordTextField, Side.RIGHT, 10, 0);
            }
            else {
                emailValidator.hide();
                passValidator.hide();
                if (!isConnected) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Attention", ButtonType.OK);
                    alert.setTitle("Connection Failed");
                    alert.setContentText("Sorry! This service is not available now.\n Please,try again later");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        TicTacToe.scene.setRoot(new MainPageScreenBase());
                        return;
                    }
                }
                String email = EmailTextField.getText();
                String pass = passwordTextField.getText();
                String msg = "login" + "," + email + "," + pass;
                playerConnection.sendMessage(msg);
            }

            // TicTacToe.scene.setRoot(new AvailablePlayersBase());
        });
        
        imageView1.setFitHeight(37.0);
        imageView1.setFitWidth(165.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        loginBtn.setGraphic(imageView1);

        dontHaveAnAccountText.setFill(javafx.scene.paint.Color.WHITE);
        dontHaveAnAccountText.setLayoutX(253.0);
        dontHaveAnAccountText.setLayoutY(365.0);
        dontHaveAnAccountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        dontHaveAnAccountText.setStrokeWidth(0.0);
        dontHaveAnAccountText.setText("Don't have an account?");
        dontHaveAnAccountText.setFont(new Font("Serif Regular", 25.0));
        dontHaveAnAccountText.setOnMouseClicked(e -> {

            TicTacToe.scene.setRoot(new SignUpBase());

        });
        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(imageView0);
        getChildren().add(EmailTextField);
        getChildren().add(passwordTextField);
        getChildren().add(loginBtn);
        getChildren().add(dontHaveAnAccountText);
         getChildren().add(backButton);

    }
    
    public  boolean emailPattern(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
      .matcher(emailAddress)
      .matches();
}
    public static void showAlert()
    {Platform.runLater(new Runnable() {
        @Override
        public void run() {
           Alert alert = new Alert(Alert.AlertType.NONE, "Attention", ButtonType.OK);
                            alert.setTitle("Wrong Data");
                            alert.setContentText("Sorry! Invalid Email or Password .\n Please,check data and try again");
                            alert.show();  
        }
    });
       
    }
}

package tic.tac.toe;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tic.tac.toe.TicTacToe;
import java.util.regex.Pattern;

public class SignUpBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView imageView0;
    protected final TextField usernameTextField;
    protected final TextField EmailTextField;
    protected final PasswordField passwordTextField;
    protected final PasswordField repasswordTextField;
    protected final Button signUpBtn;
    protected final ImageView imageView1;
    protected final Text haveAnAccountText;
    String username;
    String email;
    String password;
    String repassword;
    boolean isConnected=true;

    public SignUpBase() {
        
        
        imageView = new ImageView();
        rectangle = new Rectangle();
        imageView0 = new ImageView();
        usernameTextField = new TextField();
        EmailTextField = new TextField();
        passwordTextField = new PasswordField();
        repasswordTextField = new PasswordField();
        signUpBtn = new Button();
        imageView1 = new ImageView();
        haveAnAccountText = new Text();

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tic/tac/toe/css/signup.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));
        
        rectangle.setArcHeight(100.0);
        rectangle.setArcWidth(100.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setHeight(325.0);
        rectangle.setLayoutX(150.0);
        rectangle.setLayoutY(86.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(450.0);
        rectangle.setFocusTraversable(true);
       
        imageView0.setFitHeight(101.0);
        imageView0.setFitWidth(307.0);
        imageView0.setLayoutX(224.0);
        imageView0.setLayoutY(26.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.getStyleClass().add("logo");
        imageView0.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));
        
        usernameTextField.setLayoutX(230.0);
        usernameTextField.setLayoutY(118.0);
        usernameTextField.setPrefHeight(35.0);
        usernameTextField.setPrefWidth(290.0);
        usernameTextField.setPromptText("Username");
        usernameTextField.getStyleClass().add("textField");
        usernameTextField.getStylesheets().add("/tic/tac/toe/css/signup.css");
        usernameTextField.setFont(new Font(19.0));

        EmailTextField.setLayoutX(230.0);
        EmailTextField.setLayoutY(164.0);
        EmailTextField.setPrefHeight(35.0);
        EmailTextField.setPrefWidth(290.0);
        EmailTextField.setPromptText("Email");
        EmailTextField.getStyleClass().add("textField");
        EmailTextField.setFont(new Font(19.0));

        passwordTextField.setLayoutX(231.0);
        passwordTextField.setLayoutY(210.0);
        passwordTextField.setPrefHeight(35.0);
        passwordTextField.setPrefWidth(290.0);
        passwordTextField.setPromptText("Password");
        passwordTextField.getStyleClass().add("textField");
        passwordTextField.setFont(new Font(19.0));

        repasswordTextField.setLayoutX(231.0);
        repasswordTextField.setLayoutY(256.0);
        repasswordTextField.setPrefHeight(35.0);
        repasswordTextField.setPrefWidth(290.0);
        repasswordTextField.setPromptText("Re-Password");
        repasswordTextField.getStyleClass().add("textField");
        repasswordTextField.setFont(new Font(19.0));

        signUpBtn.setLayoutX(294.0);
        signUpBtn.setLayoutY(314.0);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(37.0);
        signUpBtn.setPrefWidth(165.0);
        signUpBtn.getStyleClass().add("signUp");
        signUpBtn.getStylesheets().add("/tic/tac/toe/css/signup.css");
        signUpBtn.setText("Sign Up");
        signUpBtn.setFont(new Font("Serif Regular", 19.0));

        imageView1.setFitHeight(37.0);
        imageView1.setFitWidth(165.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        signUpBtn.setGraphic(imageView1);
        signUpBtn.setOnAction(event ->{
            username=usernameTextField.getText().toString();
            email=EmailTextField.getText().toString();
            password=passwordTextField.getText().toString();
            repassword=repasswordTextField.getText().toString();
            
            if(username.equals("")||email.equals("")||password.equals("")||repassword.equals("")){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("you must enter your all data");
                alert.showAndWait();
            }
            else if (username.contains(",")){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("your username can't have comma(,)");
                alert.showAndWait();
                usernameTextField.setText("");
            }else if(!isValidPassword(password)){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("Password must have at least one numeric character ,one lowercase character,one lowercase character,one special symbol among @#$% and Password length should be between 8 and 20.");
                alert.showAndWait();
                passwordTextField.setText("");
                repasswordTextField.setText("");
            }
            else if(!password.equals(repassword)){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("you entered two different passwords");
                alert.showAndWait();
                passwordTextField.setText("");
                repasswordTextField.setText("");
            }
            else if(password.equals(repassword)&&password.contains(",")){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("your password and repassword can't have comma(,)");
                alert.showAndWait();
                passwordTextField.setText("");
                repasswordTextField.setText("");
            }
            else if(!isValid(email)){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                alert.setTitle("Attention");
                alert.setContentText("invalid email");
                alert.showAndWait();
            }
            else{
               if(isConnected==false){
                    Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK);
                    alert.setTitle("Connection Failed");
                    alert.setContentText("Sorry! This service is not available now.\n Please,try again later");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        TicTacToe.scene.setRoot(new MainPageScreenBase());
                        return;
                    }
                }
                String messageToBeSend="signUp,"+username+","+email+","+password;
                LoginFXMLBase.playerConnection.sendMessage(messageToBeSend);
                //TicTacToe.scene.setRoot(new AvailablePlayersBase());
            }
        });

        haveAnAccountText.setFill(javafx.scene.paint.Color.WHITE);
        haveAnAccountText.setLayoutX(290.0);
        haveAnAccountText.setLayoutY(382.0);
        haveAnAccountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        haveAnAccountText.setStrokeWidth(0.0);
        haveAnAccountText.setText("Have an account?");
        haveAnAccountText.setFont(new Font("Serif Regular", 26.0));
        haveAnAccountText.setOnMouseClicked(event ->{
        
            TicTacToe.scene.setRoot(new LoginFXMLBase());
            
        });

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(imageView0);
        getChildren().add(usernameTextField);
        getChildren().add(EmailTextField);
        getChildren().add(passwordTextField);
        getChildren().add(repasswordTextField);
        getChildren().add(signUpBtn);
        getChildren().add(haveAnAccountText);

    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean isValidPassword(String password)
    {
        String regex= "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
  
}

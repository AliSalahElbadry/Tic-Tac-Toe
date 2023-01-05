package tic.tac.toe;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tic.tac.toe.TicTacToe;

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
        
            TicTacToe.scene.setRoot(new AvailablePlayersBase());
        
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
}

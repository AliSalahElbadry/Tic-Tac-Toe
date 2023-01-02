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

public class LoginFXMLBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView imageView0;
    protected final TextField EmailTextField;
    protected final PasswordField passwordTextField;
    protected final Button loginBtn;
    protected final ImageView imageView1;
    protected final Text dontHaveAnAccountText;

    public LoginFXMLBase() {

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
        loginBtn.setOnAction(e->{
        
            TicTacToe.scene.setRoot(new AvailablePlayersBase());
        
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
        dontHaveAnAccountText.setOnMouseClicked(e->{
            
           TicTacToe.scene.setRoot(new SignUpBase());
        
        });
        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(imageView0);
        getChildren().add(EmailTextField);
        getChildren().add(passwordTextField);
        getChildren().add(loginBtn);
        getChildren().add(dontHaveAnAccountText);

    }
}

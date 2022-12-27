package tic.tac.toe;

import java.net.URL;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PlayersNamesScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button startButton;
    protected final TextField Player1TextField;
    protected final TextField Player2TextField;
    protected final ImageView backButtonId;

    public PlayersNamesScreenBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        startButton = new Button();
        Player1TextField = new TextField();
        Player2TextField = new TextField();
        backButtonId = new ImageView();

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/tic/tac/toe/playersnamesscreen.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setHeight(248.0);
        rectangle.setLayoutX(150.0);
        rectangle.setLayoutY(116.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.getStyleClass().add("boardCorner");
        rectangle.setWidth(450.0);

        imageView0.setFitHeight(101.0);
        imageView0.setFitWidth(307.0);
        imageView0.setLayoutX(224.0);
        imageView0.setLayoutY(66.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        imageView1.setFitHeight(48.0);
        imageView1.setFitWidth(170.0);
        imageView1.setLayoutX(275.0);
        imageView1.setLayoutY(300.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));

        startButton.setLayoutX(275.0);
        startButton.setLayoutY(300.0);
        startButton.setMnemonicParsing(false);
        startButton.setPrefHeight(37.0);
        startButton.setPrefWidth(165.0);
        startButton.getStyleClass().add("backGroundButton");
        startButton.setText("Start");
        startButton.setTextFill(javafx.scene.paint.Color.valueOf("#2949ae"));
        startButton.setFont(new Font("Serif Regular", 24.0));

        Player1TextField.setLayoutX(227.0);
        Player1TextField.setLayoutY(173.0);
        Player1TextField.setPrefHeight(25.0);
        Player1TextField.setPrefWidth(255.0);
        Player1TextField.setPromptText("Player1");
        Player1TextField.setStyle("-fx-background-radius: 30;");
        Player1TextField.setFont(new Font("Serif Regular", 20.0));

        Player2TextField.setLayoutX(227.0);
        Player2TextField.setLayoutY(236.0);
        Player2TextField.setPrefHeight(25.0);
        Player2TextField.setPrefWidth(255.0);
        Player2TextField.setPromptText("Player2");
        Player2TextField.setStyle("-fx-background-radius: 30;");
        Player2TextField.setFont(new Font("Serif Regular", 20.0));

        backButtonId.setFitHeight(70.0);
        backButtonId.setFitWidth(70.0);
        backButtonId.setLayoutX(22.0);
        backButtonId.setLayoutY(387.0);
        backButtonId.setPickOnBounds(true);
        backButtonId.setPreserveRatio(true);
        backButtonId.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backButtonId.setOnMousePressed((event)->{
        
//            Parent root = new MainScreenBase();
//            Scene scene = new Scene(root, 750, 480);
//                       
//            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
        });

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(startButton);
        getChildren().add(Player1TextField);
        getChildren().add(Player2TextField);
        getChildren().add(backButtonId);

    }
}

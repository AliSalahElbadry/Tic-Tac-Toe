package tic.tac.toe;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tic.tac.toe.TicTacToe;

public  class GamesRecordItemSceenBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Button showGameItem1Btn;
    protected final ImageView imageView;
    protected final Text player2Item1Text;
    protected final Text timeItem1Text;
    protected final Text winnerItem1Text;
    protected final Rectangle rectangle0;
    protected final Button showGameItem2Btn;
    protected final ImageView imageView0;
    protected final Text player2Item2Text;
    protected final Text timeItem2Text;
    protected final Text winnerItem2Text;
    public static boolean flag = false ;

    public GamesRecordItemSceenBase() {

        rectangle = new Rectangle();
        showGameItem1Btn = new Button();
        imageView = new ImageView();
        player2Item1Text = new Text();
        timeItem1Text = new Text();
        winnerItem1Text = new Text();
        rectangle0 = new Rectangle();
        showGameItem2Btn = new Button();
        imageView0 = new ImageView();
        player2Item2Text = new Text();
        timeItem2Text = new Text();
        winnerItem2Text = new Text();

        setId("AnchorPane");
        setPrefHeight(128.0);
        setPrefWidth(415.0);
        getStyleClass().add("Container");
        getStylesheets().add("/tic/tac/toe/css/gamesrecorditemsceen.css");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        rectangle.setHeight(123.0);
        rectangle.setLayoutX(14.0);
        rectangle.setLayoutY(3.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(0.0);
        rectangle.setStyle("-fx-arc-width: 50; -fx-arc-height: 50;");
        rectangle.setWidth(170.0);

        showGameItem1Btn.setLayoutX(34.0);
        showGameItem1Btn.setLayoutY(81.0);
        showGameItem1Btn.setMnemonicParsing(false);
        showGameItem1Btn.setPrefHeight(31.0);
        showGameItem1Btn.setPrefWidth(90.0);
        showGameItem1Btn.getStyleClass().add("showbtn");
        showGameItem1Btn.getStylesheets().add("/tic/tac/toe/css/gamesrecorditemsceen.css");
        showGameItem1Btn.setText("Show Game");
        showGameItem1Btn.setTextFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        showGameItem1Btn.setFont(new Font("Serif Regular", 16.0));
        showGameItem1Btn.setOnAction(event ->{
        
            flag = true ;
            TicTacToe.scene.setRoot(new LocalMode().boardScreenBase);
            
        });

        imageView.setFitHeight(31.0);
        imageView.setFitWidth(120.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        showGameItem1Btn.setGraphic(imageView);

        player2Item1Text.setFill(javafx.scene.paint.Color.WHITE);
        player2Item1Text.setLayoutX(73.0);
        player2Item1Text.setLayoutY(29.0);
        player2Item1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Item1Text.setStrokeWidth(0.0);
        player2Item1Text.setText("with X");
        player2Item1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2Item1Text.setFont(new Font("Serif Regular", 22.0));

        timeItem1Text.setFill(javafx.scene.paint.Color.WHITE);
        timeItem1Text.setLayoutX(22.0);
        timeItem1Text.setLayoutY(49.0);
        timeItem1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        timeItem1Text.setStrokeWidth(0.0);
        timeItem1Text.setText("12/10/2022.10:33Am");
        timeItem1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        timeItem1Text.setFont(new Font("Serif Regular", 18.0));

        winnerItem1Text.setFill(javafx.scene.paint.Color.WHITE);
        winnerItem1Text.setLayoutX(77.0);
        winnerItem1Text.setLayoutY(76.0);
        winnerItem1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        winnerItem1Text.setStrokeWidth(0.0);
        winnerItem1Text.setText("X win");
        winnerItem1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        winnerItem1Text.setFont(new Font("Serif Regular", 22.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        rectangle0.setHeight(123.0);
        rectangle0.setLayoutX(231.0);
        rectangle0.setLayoutY(3.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setStrokeWidth(0.0);
        rectangle0.setStyle("-fx-arc-width: 50; -fx-arc-height: 50;");
        rectangle0.setWidth(170.0);

        showGameItem2Btn.setLayoutX(255.0);
        showGameItem2Btn.setLayoutY(80.0);
        showGameItem2Btn.setMnemonicParsing(false);
        showGameItem2Btn.setPrefHeight(43.0);
        showGameItem2Btn.setPrefWidth(131.0);
        showGameItem2Btn.getStyleClass().add("showbtn");
        showGameItem2Btn.getStylesheets().add("/tic/tac/toe/css/gamesrecorditemsceen.css");
        showGameItem2Btn.setText("Show Game");
        showGameItem2Btn.setTextFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        showGameItem2Btn.setFont(new Font("Serif Regular", 16.0));
        showGameItem2Btn.setOnAction(event ->{
        
            flag = true ;
            TicTacToe.scene.setRoot(new LocalMode().boardScreenBase);
            
            
            
        });

        imageView0.setFitHeight(31.0);
        imageView0.setFitWidth(120.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        showGameItem2Btn.setGraphic(imageView0);

        player2Item2Text.setFill(javafx.scene.paint.Color.WHITE);
        player2Item2Text.setLayoutX(290.0);
        player2Item2Text.setLayoutY(29.0);
        player2Item2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Item2Text.setStrokeWidth(0.0);
        player2Item2Text.setText("with X");
        player2Item2Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2Item2Text.setFont(new Font("Serif Regular", 22.0));

        timeItem2Text.setFill(javafx.scene.paint.Color.WHITE);
        timeItem2Text.setLayoutX(243.0);
        timeItem2Text.setLayoutY(50.0);
        timeItem2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        timeItem2Text.setStrokeWidth(0.0);
        timeItem2Text.setText("12/10/2022.10:33Am");
        timeItem2Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        timeItem2Text.setFont(new Font("Serif Regular", 18.0));

        winnerItem2Text.setFill(javafx.scene.paint.Color.WHITE);
        winnerItem2Text.setLayoutX(294.0);
        winnerItem2Text.setLayoutY(76.0);
        winnerItem2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        winnerItem2Text.setStrokeWidth(0.0);
        winnerItem2Text.setText("X win");
        winnerItem2Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        winnerItem2Text.setFont(new Font("Serif Regular", 22.0));

        getChildren().add(rectangle);
        getChildren().add(showGameItem1Btn);
        getChildren().add(player2Item1Text);
        getChildren().add(timeItem1Text);
        getChildren().add(winnerItem1Text);
        getChildren().add(rectangle0);
        getChildren().add(showGameItem2Btn);
        getChildren().add(player2Item2Text);
        getChildren().add(timeItem2Text);
        getChildren().add(winnerItem2Text);

    }
}

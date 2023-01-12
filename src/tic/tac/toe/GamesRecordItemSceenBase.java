package tic.tac.toe;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GamesRecordItemSceenBase extends AnchorPane {

    
    
    protected final Rectangle rectangle;
    protected final Button showGameItem1Btn;
    protected final ImageView imageView;
    protected final Text player2Item1Text;
    protected final Text timeItem1Text;
    protected final Text winnerItem1Text;
    public static boolean flag = false ;
    public int listId=0;

    public GamesRecordItemSceenBase() {
        PickYourSideScreenBase.level=6;
        rectangle = new Rectangle();
        showGameItem1Btn = new Button();
        imageView = new ImageView();
        player2Item1Text = new Text();
        timeItem1Text = new Text();
        winnerItem1Text = new Text();

        setId("AnchorPane");
        setPrefHeight(128.0);
        setPrefWidth(415.0);
        getStyleClass().add("Container");
        getStylesheets().add("/tic/tac/toe/css/gamesrecorditemsceen.css");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        rectangle.setHeight(123.0);
        rectangle.setLayoutX(4.0);
        rectangle.setLayoutY(3.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(0.0);
        rectangle.setStyle("-fx-arc-width: 50; -fx-arc-height: 50;");
        rectangle.setWidth(409.0);

        showGameItem1Btn.setLayoutX(285.0);
        showGameItem1Btn.setLayoutY(40.0);
        showGameItem1Btn.setMnemonicParsing(false);
        showGameItem1Btn.setPrefHeight(31.0);
        showGameItem1Btn.setPrefWidth(90.0);
        showGameItem1Btn.getStyleClass().add("showbtn");
        showGameItem1Btn.getStylesheets().add("/tic/tac/toe/css/gamesrecorditemsceen.css");
        showGameItem1Btn.setText("Show Game");
        showGameItem1Btn.setTextFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        showGameItem1Btn.setFont(new Font("Serif Regular", 16.0));
        showGameItem1Btn.setOnAction(e->{

        TicTacToe.player.stop();
        TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
        TicTacToe.player.play();
            flag = true ;

            ShowGame showGame = new ShowGame(GamesRecordScreenBase.listRecord.get(listId));
            TicTacToe.scene.setRoot(showGame.boardScreenBase);
            new Thread(showGame).start();

        });

        imageView.setFitHeight(31.0);
        imageView.setFitWidth(120.0);
        imageView.setPickOnBounds(true);
        
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        showGameItem1Btn.setGraphic(imageView);

        player2Item1Text.setFill(javafx.scene.paint.Color.WHITE);
        player2Item1Text.setLayoutX(68.0);
        player2Item1Text.setLayoutY(48.0);
        player2Item1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Item1Text.setStrokeWidth(0.0);
        player2Item1Text.setText("with X");
        player2Item1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2Item1Text.setFont(new Font("Serif Regular", 22.0));

        timeItem1Text.setFill(javafx.scene.paint.Color.WHITE);
        timeItem1Text.setLayoutX(14.0);
        timeItem1Text.setLayoutY(68.0);
        timeItem1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        timeItem1Text.setStrokeWidth(0.0);
        timeItem1Text.setText("12/10/2022.10:33Am");
        timeItem1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        timeItem1Text.setFont(new Font("Serif Regular", 18.0));

        winnerItem1Text.setFill(javafx.scene.paint.Color.WHITE);
        winnerItem1Text.setLayoutX(85.0);
        winnerItem1Text.setLayoutY(95.0);
        winnerItem1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        winnerItem1Text.setStrokeWidth(0.0);
        winnerItem1Text.setText("X win");
        winnerItem1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        winnerItem1Text.setFont(new Font("Serif Regular", 22.0));
        
        getChildren().add(rectangle);
        getChildren().add(showGameItem1Btn);
        getChildren().add(player2Item1Text);
        getChildren().add(timeItem1Text);
        getChildren().add(winnerItem1Text);

    }
}

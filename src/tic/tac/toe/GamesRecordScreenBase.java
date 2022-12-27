package tic.tac.toe;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class GamesRecordScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle container;
    protected final ListView hestoryGamesRecordListView;
    protected final Button backBtn;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    
    public GamesRecordScreenBase() {

        imageView = new ImageView();
        container = new Rectangle();
        hestoryGamesRecordListView = new ListView();
        backBtn = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();

        setMaxHeight(480.0);
        setMaxWidth(750.0);
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStyleClass().add("mainback");
        getStylesheets().add("/tic/tac/toe/gamesrecordsceen.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        container.setArcHeight(5.0);
        container.setArcWidth(5.0);
        container.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        container.setHeight(339.0);
        container.setLayoutX(148.0);
        container.setLayoutY(65.0);
        container.setStroke(javafx.scene.paint.Color.BLACK);
        container.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        container.setStrokeWidth(0.0);
        container.setStyle("-fx-arc-height: 60; -fx-arc-width: 60;");
        container.setWidth(474.0);

        hestoryGamesRecordListView.setLayoutX(179.0);
        hestoryGamesRecordListView.setLayoutY(98.0);
        hestoryGamesRecordListView.setPrefHeight(274.0);
        hestoryGamesRecordListView.setPrefWidth(414.0);
        hestoryGamesRecordListView.setStyle("-fx-padding:-20;-fx-control-inner-background: #2a47ad;");
        
        hestoryGamesRecordListView.getStylesheets().add("/tic/tac/toe/gamesrecordsceen.css");
        
        hestoryGamesRecordListView.getItems().add(new GamesRecordItemSceenBase());
        hestoryGamesRecordListView.getItems().add(new GamesRecordItemSceenBase());
        hestoryGamesRecordListView.getItems().add(new GamesRecordItemSceenBase());
        hestoryGamesRecordListView.getItems().add(new GamesRecordItemSceenBase());
        
        backBtn.setId("obtn");
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(384.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(70.0);
        backBtn.setPrefWidth(70.0);
        backBtn.getStyleClass().add("backbtn");
        backBtn.getStylesheets().add("/tic/tac/toe/ProfileScreen.css");

        imageView0.setFitHeight(70.0);
        imageView0.setFitWidth(70.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backBtn.setGraphic(imageView0);

        imageView1.setFitHeight(81.0);
        imageView1.setFitWidth(247.0);
        imageView1.setLayoutX(264.0);
        imageView1.setLayoutY(25.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(container);
        getChildren().add(hestoryGamesRecordListView);
        getChildren().add(backBtn);
        getChildren().add(imageView1);

    }
}

package tic.tac.toe;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class GamesRecordScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle container;
    protected final ListView hestoryGamesRecordListView;
    protected final Button backBtn;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    public static ArrayList<Record> listRecord;

    public GamesRecordScreenBase() {
        
        imageView = new ImageView();
        container = new Rectangle();
        hestoryGamesRecordListView = new ListView();
        backBtn = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        listRecord = new ArrayList<>();


            try {
                String paths[];
                File file = new File("Game\\"+LoginFXMLBase.playerData.getPlayerID()+"");
                paths = file.list();
                Gson gson = new Gson();
                for (int i = 0; i < paths.length; i++) {
                    Record record = gson.fromJson(new FileReader("Game\\"+LoginFXMLBase.playerData.getPlayerID()+"\\" + paths[i]), Record.class);
                    
                    listRecord.add(record);
                    GamesRecordItemSceenBase gamesRecordItemSceenBase = new GamesRecordItemSceenBase();
                    gamesRecordItemSceenBase.player2Item1Text.setText(record.player2Name);
                    gamesRecordItemSceenBase.winnerItem1Text.setText(record.Winner);
                    gamesRecordItemSceenBase.timeItem1Text.setText(record.date.toString());
                    gamesRecordItemSceenBase.listId = i;
                    hestoryGamesRecordListView.getItems().add(gamesRecordItemSceenBase);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GamesRecordScreenBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        setMaxHeight(480.0);
        setMaxWidth(750.0);
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStyleClass().add("mainback");
        getStylesheets().add("/tic/tac/toe/css/gamesrecordsceen.css");

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
        hestoryGamesRecordListView.setLayoutY(105.0);
        hestoryGamesRecordListView.setPrefHeight(274.0);
        hestoryGamesRecordListView.setPrefWidth(414.0);
        hestoryGamesRecordListView.getStylesheets().add("/tic/tac/toe/css/gamesrecordsceen.css");
        hestoryGamesRecordListView.getStyleClass().add("mylistview");

        backBtn.setId("obtn");
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(384.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(70.0);
        backBtn.setPrefWidth(70.0);
        backBtn.getStyleClass().add("backbtn");
        backBtn.getStylesheets().add("/tic/tac/toe/css/ProfileScreen.css");

        backBtn.setOnAction(event ->{
            TicTacToe.player.stop();
            TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
            TicTacToe.player.play();
            ProfileScreenBase base = new ProfileScreenBase();
            if(LoginFXMLBase.playerData!=null&&!LoginFXMLBase.playerConnection.socket.isClosed())

            {
              
               base.emailText.setText(LoginFXMLBase.playerData.email);
               base.userNameText.setText(LoginFXMLBase.playerData.userName);
               base.playedGamesText.setText(LoginFXMLBase.playerData.wins+"/"+LoginFXMLBase.playerData.countGames);
               TicTacToe.scene.setRoot(base);
              

            }
            TicTacToe.scene.setRoot( base);

        });

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

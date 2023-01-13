package tic.tac.toe;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tic.tac.toe.TicTacToe;

public class PickYourSideScreenBase extends AnchorPane {
    
    protected final ImageView imageView;
    protected final Rectangle container;
    protected final ImageView vsImage;
    protected final Button oBtn;
    protected final ImageView imageView0;
    protected final Button xBtn;
    protected final ImageView imageView1;
    protected final Button backBtn;
    protected final ImageView imageView2;
    protected final Text text;
    protected final ImageView imageView3;
    protected final RadioButton recordRadioButton;

    public static int level=0;

    public static String player1Side;

    

    public PickYourSideScreenBase() {
     
        imageView = new ImageView();
        container = new Rectangle();
        vsImage = new ImageView();
        oBtn = new Button();
        imageView0 = new ImageView();
        xBtn = new Button();
        imageView1 = new ImageView();
        backBtn = new Button();
        imageView2 = new ImageView();
        text = new Text();
        imageView3 = new ImageView();
        recordRadioButton = new RadioButton();
        
        

        setId("pickYourSide");
        setMaxHeight(480.0);
        setMaxWidth(750.0);
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStyleClass().add("pickYourSide");
        getStylesheets().add("/tic/tac/toe/css/pickYourSide.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        container.setArcHeight(5.0);
        container.setArcWidth(5.0);
        container.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        container.setHeight(250.0);
        container.setLayoutX(144.0);
        container.setLayoutY(140.0);
        container.setStroke(javafx.scene.paint.Color.BLACK);
        container.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        container.setStrokeWidth(0.0);
        container.setStyle("-fx-arc-height: 60; -fx-arc-width: 60;");
        container.setWidth(455.0);
        
        recordRadioButton.setLayoutX(290.0);
        recordRadioButton.setLayoutY(355.0);
        recordRadioButton.setMnemonicParsing(false);
        recordRadioButton.setText("Record The Game");
        recordRadioButton.setTextFill(javafx.scene.paint.Color.WHITE);
        recordRadioButton.setFont(new Font("System Bold", 18.0));
        if(recordRadioButton.isFocused()){
            BoardScreenBase.record = true;
        }
        
        if (GamesRecordItemSceenBase.flag == true){
            recordRadioButton.setVisible(false);
        }

        vsImage.setFitHeight(197.0);
        vsImage.setFitWidth(443.0);
        vsImage.setLayoutX(155.0);
        vsImage.setLayoutY(156.0);
        vsImage.setPickOnBounds(true);
        vsImage.setPreserveRatio(true);
        vsImage.setImage(new Image(getClass().getResource("Photos/picside.png").toExternalForm()));

        oBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        oBtn.setId("obtn");
        oBtn.setLayoutX(413.0);
        oBtn.setLayoutY(176.0);
        oBtn.setMnemonicParsing(false);
        oBtn.setPrefHeight(150.0);
        oBtn.setPrefWidth(150.0);
        oBtn.getStyleClass().add("obtn");
        oBtn.getStylesheets().add("/tic/tac/toe/css/pickYourSide.css");
        oBtn.setOnAction(event ->{

        
         GamesRecordItemSceenBase.flag = false ;
            switch(level){
                case 0 :
                   Easy.side=0;

                    Easy easy=new Easy();
                    TicTacToe.scene.setRoot(easy.boardScreen);
                    break;
                case 1:
                    Medium medium = new Medium();
                    Medium.side = "o";
                    TicTacToe.scene.setRoot(medium.boardScreenBase);
                    break;
                case 2:
                    
                    LevelHardClass hard=new LevelHardClass();
                    LevelHardClass.playerSide=1;
                    TicTacToe.scene.setRoot(hard.boardScreen);
                    break;
                case 3:
                    player1Side="O";
                    TicTacToe.scene.setRoot(new LocalMode().boardScreenBase);
                    break;
                case 4:
                    AvailablePlayersBase.boardGameOnline.playerSide='O';
                    TicTacToe.player.stop();
                    TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/gameStart.mp3").toExternalForm()));
                    TicTacToe.player.play();
                    TicTacToe.scene.setRoot(AvailablePlayersBase.boardGameOnline.boardScreenBase);
                    break;
                default :
                    System.out.print("");
                    break;
            
            }

            

            
        });

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(150.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
        oBtn.setGraphic(imageView0);

        xBtn.setId("obtn");
        xBtn.setLayoutX(164.0);
        xBtn.setLayoutY(176.0);
        xBtn.setMnemonicParsing(false);
        xBtn.setPrefHeight(150.0);
        xBtn.setPrefWidth(150.0);
        xBtn.getStyleClass().add("xbtn");
        xBtn.getStylesheets().add("/tic/tac/toe/css/pickYourSide.css");
        xBtn.setOnAction(event ->{
              
              GamesRecordItemSceenBase.flag = false ;
            switch(level){
                case 0 :
                    Easy.side=1;
                    Easy easy=new Easy();
                    TicTacToe.scene.setRoot(easy.boardScreen);
                    break;
                case 1:
                    Medium medium = new Medium();
                    Medium.side = "x";
                    TicTacToe.scene.setRoot(medium.boardScreenBase);
                    break;
                case 2:
                    LevelHardClass hard=new LevelHardClass();
                    LevelHardClass.playerSide=0;
                    TicTacToe.scene.setRoot(hard.boardScreen);
                    break;
                case 3:
                    player1Side="X";
                    TicTacToe.scene.setRoot(new LocalMode().boardScreenBase);
                    break;
                case 4:
                    AvailablePlayersBase.boardGameOnline.playerSide='X';
                    TicTacToe.player.stop();
                    TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/gameStart.mp3").toExternalForm()));
                    TicTacToe.player.play();
                    TicTacToe.scene.setRoot(AvailablePlayersBase.boardGameOnline.boardScreenBase);
                    break;
                default :
                    System.out.print("");
                    break;


            }
        });

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(150.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
        xBtn.setGraphic(imageView1);

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
            TicTacToe.scene.setRoot(new MainPageScreenBase());
            
        });

        imageView2.setFitHeight(70.0);
        imageView2.setFitWidth(70.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backBtn.setGraphic(imageView2);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(216.0);
        text.setLayoutY(91.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Pick Your Side");
        text.setFont(new Font("Serif Regular", 48.0));

        imageView3.setFitHeight(57.0);
        imageView3.setFitWidth(198.0);
        imageView3.setLayoutX(579.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(container);
        getChildren().add(vsImage);
        getChildren().add(oBtn);
        getChildren().add(xBtn);
        getChildren().add(backBtn);
        getChildren().add(text);
        getChildren().add(imageView3);
        getChildren().add(recordRadioButton);

    }
}

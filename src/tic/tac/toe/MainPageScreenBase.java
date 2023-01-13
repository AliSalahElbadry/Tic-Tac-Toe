package tic.tac.toe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class MainPageScreenBase extends AnchorPane {
    
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView prifileImage;
    protected final Text profileText;
    protected final Rectangle computerRectangle;
    protected final Rectangle localRectangle;
    protected final Rectangle onlineRectangle;
    protected final ImageView computerImageView;
    protected final ImageView lacalImageView;
    protected final ImageView onlineImageView;
    protected final Text computerText;
    protected final Text localText;
    protected final Text onlineText;

    public MainPageScreenBase() {
        TicTacToe.player.stop();
        TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/game.mp3").toExternalForm()));
        TicTacToe.player.play();
        imageView = new ImageView();
        imageView0 = new ImageView();
        prifileImage = new ImageView();
        profileText = new Text();
        computerRectangle = new Rectangle();
        localRectangle = new Rectangle();
        onlineRectangle = new Rectangle();
        computerImageView = new ImageView();
        lacalImageView = new ImageView();
        onlineImageView = new ImageView();
        computerText = new Text();
        localText = new Text();
        onlineText = new Text();
        LevelHardClass.playerRes=0;
        LevelHardClass.computerRes=0;
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/tic/tac/toe/css/MainPageScreen.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        imageView0.setFitHeight(55.0);
        imageView0.setFitWidth(170.0);
        imageView0.setLayoutX(580.0);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        prifileImage.setFitHeight(75.0);
        prifileImage.setFitWidth(85.0);
        prifileImage.setLayoutY(28.0);
        prifileImage.setPickOnBounds(true);
        prifileImage.setPreserveRatio(true);
        prifileImage.setImage(new Image(getClass().getResource("Photos/profile.png").toExternalForm()));
        prifileImage.setOnMouseClicked(event ->{

            if(LoginFXMLBase.playerData!=null&&!LoginFXMLBase.playerConnection.socket.isClosed())
            {
               ProfileScreenBase base = new ProfileScreenBase();
               base.emailText.setText(LoginFXMLBase.playerData.email);
               base.userNameText.setText(LoginFXMLBase.playerData.userName);
               base.playedGamesText.setText(LoginFXMLBase.playerData.wins+"/"+LoginFXMLBase.playerData.countGames);
               TicTacToe.scene.setRoot(base);
              
            }else 
            {
                 TicTacToe.scene.setRoot(new LoginFXMLBase());
            }
            TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
            
        });

        profileText.setFill(javafx.scene.paint.Color.WHITE);
        profileText.setLayoutX(4.0);
        profileText.setLayoutY(105.0);
        profileText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        profileText.setStrokeWidth(0.0);
        profileText.setText("Profile");
        profileText.setFont(new Font("Serif Regular", 30.0));

        computerRectangle.setArcHeight(5.0);
        computerRectangle.setArcWidth(5.0);
        computerRectangle.setFill(javafx.scene.paint.Color.WHITE);
        computerRectangle.setHeight(175.0);
        computerRectangle.setLayoutX(61.0);
        computerRectangle.setLayoutY(203.0);
        computerRectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        computerRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        computerRectangle.setStyle("-fx-arc-height: 46; -fx-arc-width: 46;");
        computerRectangle.getStyleClass().add("rect");
        computerRectangle.setWidth(185.0);
        computerRectangle.setOnMouseClicked(event ->{
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
             TicTacToe.scene.setRoot(new LevelScreenBase());
            
        });

        localRectangle.setArcHeight(5.0);
        localRectangle.setArcWidth(5.0);
        localRectangle.setFill(javafx.scene.paint.Color.WHITE);
        localRectangle.setHeight(175.0);
        localRectangle.setLayoutX(283.0);
        localRectangle.setLayoutY(203.0);
        localRectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        localRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        localRectangle.setStyle("-fx-arc-height: 46; -fx-arc-width: 46;");
        localRectangle.getStyleClass().add("rect");
        localRectangle.setWidth(185.0);
        localRectangle.setOnMouseClicked(event ->{
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
             PickYourSideScreenBase.level=3;
             TicTacToe.scene.setRoot(new PlayersNamesScreenBase());
            
        });

        onlineRectangle.setArcHeight(5.0);
        onlineRectangle.setArcWidth(5.0);
        onlineRectangle.setFill(javafx.scene.paint.Color.WHITE);
        onlineRectangle.setHeight(175.0);
        onlineRectangle.setLayoutX(502.0);
        onlineRectangle.setLayoutY(203.0);
        onlineRectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        onlineRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        onlineRectangle.setStyle("-fx-arc-height: 46; -fx-arc-width: 46;");
        onlineRectangle.getStyleClass().add("rect");
        onlineRectangle.setWidth(185.0);
        onlineRectangle.setOnMouseClicked(event ->{
            if(LoginFXMLBase.playerData!=null&&!LoginFXMLBase.playerConnection.socket.isClosed())
            {
                AvailablePlayersBase.availablePlayerslistView=null;
                AvailablePlayersBase.avaliable=null;
                AvailablePlayersBase base=new AvailablePlayersBase();
                
                TicTacToe.scene.setRoot(base);
              
            }else 
            {
                 TicTacToe.scene.setRoot(new LoginFXMLBase());
            }
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();

            PickYourSideScreenBase.level=4;
        
        });

        computerImageView.setFitHeight(100.0);
        computerImageView.setFitWidth(100.0);
        computerImageView.setLayoutX(102.0);
        computerImageView.setLayoutY(221.0);
        computerImageView.setPickOnBounds(true);
        computerImageView.setPreserveRatio(true);
        computerImageView.setImage(new Image(getClass().getResource("Photos/computer.png").toExternalForm()));
        computerImageView.setOnMouseClicked(event ->{
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
        
            TicTacToe.scene.setRoot(new LevelScreenBase());
            
        });
        computerText.setFill(javafx.scene.paint.Color.valueOf("#293b9f"));
        computerText.setLayoutX(90.0);
        computerText.setLayoutY(357.0);
        computerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        computerText.setStrokeWidth(0.0);
        computerText.setText("Computer");
        computerText.setFont(new Font("Serif Regular", 30.0));
        computerText.setOnMouseClicked(event ->{
           
            TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
        
            TicTacToe.scene.setRoot(new LevelScreenBase());
        });
        lacalImageView.setFitHeight(100.0);
        lacalImageView.setFitWidth(100.0);
        lacalImageView.setLayoutX(329.0);
        lacalImageView.setLayoutY(220.0);
        lacalImageView.setPickOnBounds(true);
        lacalImageView.setPreserveRatio(true);
        lacalImageView.setImage(new Image(getClass().getResource("Photos/local.png").toExternalForm()));
        lacalImageView.setOnMouseClicked(event ->{
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
        
            PickYourSideScreenBase.level=3;
            TicTacToe.scene.setRoot(new PlayersNamesScreenBase());
            
        });

        onlineImageView.setFitHeight(100.0);
        onlineImageView.setFitWidth(100.0);
        onlineImageView.setLayoutX(544.0);
        onlineImageView.setLayoutY(220.0);
        onlineImageView.setPickOnBounds(true);
        onlineImageView.setPreserveRatio(true);
        onlineImageView.setImage(new Image(getClass().getResource("Photos/onlinegame.png").toExternalForm()));
        onlineImageView.setOnMouseClicked(e->{
        
          if(LoginFXMLBase.playerData!=null&&!LoginFXMLBase.playerConnection.socket.isClosed())
            {
               AvailablePlayersBase.availablePlayerslistView=null;
                AvailablePlayersBase.avaliable=null;
                AvailablePlayersBase base=new AvailablePlayersBase();
                
                TicTacToe.scene.setRoot(base);
              
            }else 
            {
                 TicTacToe.scene.setRoot(new LoginFXMLBase());
            }
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();  
            
        
        });
        
            
        localText.setFill(javafx.scene.paint.Color.valueOf("#293b9f"));
        localText.setLayoutX(340.0);
        localText.setLayoutY(357.0);
        localText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        localText.setStrokeWidth(0.0);
        localText.setText("Local");
        localText.setFont(new Font("Serif Regular", 30.0));
        localText.setOnMouseClicked(event ->{
             TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
            PickYourSideScreenBase.level=3;
            TicTacToe.scene.setRoot(new PlayersNamesScreenBase());
            
        });

        onlineText.setFill(javafx.scene.paint.Color.valueOf("#293b9f"));
        onlineText.setLayoutX(554.0);
        onlineText.setLayoutY(357.0);
        onlineText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        onlineText.setStrokeWidth(0.0);
        onlineText.setText("Online");
        onlineText.setFont(new Font("Serif Regular", 30.0));
        onlineText.setOnMouseClicked(event ->{

            if(LoginFXMLBase.playerData!=null&&!LoginFXMLBase.playerConnection.socket.isClosed())
            {
               AvailablePlayersBase.availablePlayerslistView=null;
                AvailablePlayersBase.avaliable=null;
                AvailablePlayersBase base=new AvailablePlayersBase();
                
                TicTacToe.scene.setRoot(base);
              
            }else
            {
                 TicTacToe.scene.setRoot(new LoginFXMLBase());
            }
            TicTacToe.player.stop();
             TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/tic.mp3").toExternalForm()));
             TicTacToe.player.play();
        

        });
        

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(prifileImage);
        getChildren().add(profileText);
        getChildren().add(computerRectangle);
        getChildren().add(localRectangle);
        getChildren().add(onlineRectangle);
        getChildren().add(computerImageView);
        getChildren().add(lacalImageView);
        getChildren().add(onlineImageView);
        getChildren().add(computerText);
        getChildren().add(localText);
        getChildren().add(onlineText);

    }
}

package tic.tac.toe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ProfileScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle container;
    protected final Button backBtn;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Rectangle rectangle;
    protected final ImageView imageView2;
    protected final Text emailText;
    protected final Text text;
    protected final ImageView imageView3;
    protected final Text userNameText;
    protected final Text text0;
    protected final ImageView imageView4;
    protected final Text playedGamesText;
    protected final Text text1;
    protected final Button gamesRecordBtn;
    protected final ImageView imageView5;
    protected final ImageView imageView6;
    protected final Button logoutBtn;
    protected final ImageView imageView7;

    public ProfileScreenBase() {

        imageView = new ImageView();
        imageView7 = new ImageView();
        container = new Rectangle();
        backBtn = new Button();
        logoutBtn = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        rectangle = new Rectangle();
        imageView2 = new ImageView();
        emailText = new Text();
        text = new Text();
        imageView3 = new ImageView();
        userNameText = new Text();
        text0 = new Text();
        imageView4 = new ImageView();
        playedGamesText = new Text();
        text1 = new Text();
        gamesRecordBtn = new Button();
        imageView5 = new ImageView();
        imageView6 = new ImageView();

        setMaxHeight(480.0);
        setMaxWidth(750.0);
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/tic/tac/toe/ProfileScreen.css");

        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setLayoutX(1.0);
        imageView.setLayoutY(1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        container.setArcHeight(5.0);
        container.setArcWidth(5.0);
        container.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        container.setHeight(327.0);
        container.setLayoutX(148.0);
        container.setLayoutY(77.0);
        container.setStroke(javafx.scene.paint.Color.BLACK);
        container.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        container.setStyle("-fx-arc-height: 60; -fx-arc-width: 60;");
        container.setWidth(455.0);

        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(384.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(70.0);
        backBtn.setPrefWidth(70.0);
        backBtn.getStyleClass().add("backbtn");
        backBtn.getStylesheets().add("/tic/tac/toe/ProfileScreen.css");
        
        logoutBtn.setLayoutX(14.0);
        logoutBtn.setLayoutY(14.0);
        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setPrefHeight(70.0);
        logoutBtn.setPrefWidth(70.0);
        logoutBtn.getStyleClass().add("backbtn");
        logoutBtn.getStylesheets().add("/tic/tac/toe/ProfileScreen.css");
        imageView7.setFitHeight(70.0);
        imageView7.setFitWidth(70.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("Photos/back_logout.png").toExternalForm()));
        logoutBtn.setGraphic(imageView7);
        logoutBtn.setOnAction(e->{
        
            TicTacToe.scene.setRoot(new LoginFXMLBase());
        
        });
        imageView0.setFitHeight(70.0);
        imageView0.setFitWidth(70.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backBtn.setGraphic(imageView0);
        backBtn.setOnAction(event ->{
        
            TicTacToe.scene.setRoot(new MainPageScreenBase());
            
        });

        imageView1.setFitHeight(82.0);
        imageView1.setFitWidth(219.0);
        imageView1.setLayoutX(266.0);
        imageView1.setLayoutY(41.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#dae8f5"));
        rectangle.setHeight(127.0);
        rectangle.setLayoutX(471.0);
        rectangle.setLayoutY(142.0);
        rectangle.setOpacity(0.4);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-height: 50; -fx-arc-width: 50;");
        rectangle.setWidth(99.0);

        imageView2.setFitHeight(63.0);
        imageView2.setFitWidth(114.0);
        imageView2.setLayoutX(180.0);
        imageView2.setLayoutY(192.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Photos/Figame_Titile_Back.png").toExternalForm()));

        emailText.setFill(javafx.scene.paint.Color.WHITE);
        emailText.setLayoutX(313.0);
        emailText.setLayoutY(213.0);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("Email");
        emailText.setFont(new Font("Serif Regular", 22.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#2949ae"));
        text.setLayoutX(188.0);
        text.setLayoutY(212.0);
        text.setStroke(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Email");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(98.9999994635582);
        text.setFont(new Font("Serif Regular", 17.0));

        imageView3.setFitHeight(63.0);
        imageView3.setFitWidth(114.0);
        imageView3.setLayoutX(180.0);
        imageView3.setLayoutY(145.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Photos/Figame_Titile_Back.png").toExternalForm()));

        userNameText.setFill(javafx.scene.paint.Color.WHITE);
        userNameText.setLayoutX(313.0);
        userNameText.setLayoutY(166.0);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("Name");
        userNameText.setFont(new Font("Serif Regular", 22.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#2949ae"));
        text0.setLayoutX(195.0);
        text0.setLayoutY(165.0);
        text0.setStroke(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("User Name");
        text0.setWrappingWidth(98.9999994635582);
        text0.setFont(new Font("Serif Regular", 17.0));

        imageView4.setFitHeight(63.0);
        imageView4.setFitWidth(114.0);
        imageView4.setLayoutX(180.0);
        imageView4.setLayoutY(233.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("Photos/Figame_Titile_Back.png").toExternalForm()));

        playedGamesText.setFill(javafx.scene.paint.Color.WHITE);
        playedGamesText.setLayoutX(313.0);
        playedGamesText.setLayoutY(254.0);
        playedGamesText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playedGamesText.setStrokeWidth(0.0);
        playedGamesText.setText("PlayedGames");
        playedGamesText.setFont(new Font("Serif Regular", 22.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#2949ae"));
        text1.setLayoutX(185.0);
        text1.setLayoutY(251.0);
        text1.setStroke(javafx.scene.paint.Color.WHITE);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Wins");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(98.9999994635582);
        text1.setFont(new Font("Serif Regular", 15.0));

        AnchorPane.setBottomAnchor(gamesRecordBtn, 123.0);
        AnchorPane.setLeftAnchor(gamesRecordBtn, 307.0);
        AnchorPane.setRightAnchor(gamesRecordBtn, 325.0);
        AnchorPane.setTopAnchor(gamesRecordBtn, 323.0);
        gamesRecordBtn.setAccessibleRole(javafx.scene.AccessibleRole.IMAGE_VIEW);
        gamesRecordBtn.setLayoutX(307.0);
        gamesRecordBtn.setLayoutY(323.0);
        gamesRecordBtn.setMaxHeight(Double.MAX_VALUE);
        gamesRecordBtn.setMaxWidth(Double.MAX_VALUE);
        gamesRecordBtn.setMinHeight(USE_PREF_SIZE);
        gamesRecordBtn.setMinWidth(USE_PREF_SIZE);
        gamesRecordBtn.setMnemonicParsing(false);
        gamesRecordBtn.setPrefHeight(34.0);
        gamesRecordBtn.setPrefWidth(118.0);
        gamesRecordBtn.setSnapToPixel(false);
        gamesRecordBtn.getStyleClass().add("recordbtn");
        gamesRecordBtn.getStylesheets().add("/tic/tac/toe/ProfileScreen.css");
        gamesRecordBtn.setText("Games Record");
        gamesRecordBtn.setTextFill(javafx.scene.paint.Color.valueOf("#2949ae"));
        gamesRecordBtn.setFont(new Font("Serif Regular", 15.0));
        gamesRecordBtn.setOnAction(event ->{
        
            TicTacToe.scene.setRoot(new GamesRecordScreenBase());
            
        });

        imageView5.setFitHeight(31.0);
        imageView5.setFitWidth(119.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        gamesRecordBtn.setGraphic(imageView5);

        imageView6.setFitHeight(103.0);
        imageView6.setFitWidth(122.0);
        imageView6.setLayoutX(460.0);
        imageView6.setLayoutY(161.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("Photos/profile.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(container);
        getChildren().add(backBtn);
        getChildren().add(logoutBtn);
        getChildren().add(imageView1);
        getChildren().add(rectangle);
        getChildren().add(imageView2);
        getChildren().add(emailText);
        getChildren().add(text);
        getChildren().add(imageView3);
        getChildren().add(userNameText);
        getChildren().add(text0);
        getChildren().add(imageView4);
        getChildren().add(playedGamesText);
        getChildren().add(text1);
        getChildren().add(gamesRecordBtn);
        getChildren().add(imageView6);

    }
}

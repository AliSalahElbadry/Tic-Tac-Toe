package tic.tac.toe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import tic.tac.toe.TicTacToe;

public  class LevelScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView logoImageView;
    protected final Button easyButton;
    protected final ImageView imageView0;
    protected final ImageView backButton;
    protected final Button mediumButton;
    protected final ImageView imageView1;
    protected final Button hardButton;
    protected final ImageView imageView2;

    public LevelScreenBase() {

        
        imageView = new ImageView();
        rectangle = new Rectangle();
        logoImageView = new ImageView();
        easyButton = new Button();
        imageView0 = new ImageView();
        backButton = new ImageView();
        mediumButton = new Button();
        imageView1 = new ImageView();
        hardButton = new Button();
        imageView2 = new ImageView();

        setPrefHeight(480.0);
        setPrefWidth(750.0);

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setHeight(291.0);
        rectangle.setLayoutX(191.0);
        rectangle.setLayoutY(130.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(0.0);
        rectangle.setStyle("-fx-arc-height: 90; -fx-arc-width: 90;");
        rectangle.setWidth(354.0);

        logoImageView.setFitHeight(81.0);
        logoImageView.setFitWidth(262.0);
        logoImageView.setLayoutX(249.0);
        logoImageView.setLayoutY(90.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        easyButton.setId("button");
        easyButton.setLayoutX(235.0);
        easyButton.setLayoutY(200.0);
        easyButton.setMaxWidth(USE_PREF_SIZE);
        easyButton.setMinWidth(USE_PREF_SIZE);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(40.0);
        easyButton.setPrefWidth(260.0);
        easyButton.setStyle("-fx-content-display: center;");
        easyButton.getStylesheets().add("/tic/tac/toe/css/MainPageScreen.css");
        easyButton.setText("Easy");
        easyButton.setTextFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        easyButton.setFont(new Font("Serif Regular", 24.0));
        easyButton.setOnAction(event ->{
            
            TicTacToe.scene.setRoot(new PickYourSideScreenBase() );
            
        });

        imageView0.setFitHeight(45.0);
        imageView0.setFitWidth(260.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/buttonbackground1.png").toExternalForm()));
        easyButton.setGraphic(imageView0);

        backButton.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        backButton.setFitHeight(70.0);
        backButton.setFitWidth(70.0);
        backButton.setLayoutX(2.0);
        backButton.setLayoutY(407.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backButton.setOnMouseClicked(event ->{
        
            TicTacToe.scene.setRoot(new MainPageScreenBase());
            
        });

        mediumButton.setId("button");
        mediumButton.setLayoutX(235.0);
        mediumButton.setLayoutY(253.0);
        mediumButton.setMaxWidth(USE_PREF_SIZE);
        mediumButton.setMinWidth(USE_PREF_SIZE);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setPrefHeight(40.0);
        mediumButton.setPrefWidth(260.0);
        mediumButton.setStyle("-fx-content-display: center;");
        mediumButton.getStylesheets().add("/tic/tac/toe/css/MainPageScreen.css");
        mediumButton.setText("Medium");
        mediumButton.setTextFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        mediumButton.setFont(new Font("Serif Regular", 24.0));
        mediumButton.setOnAction(event ->{
            PickYourSideScreenBase.level = 1;
            TicTacToe.scene.setRoot(new PickYourSideScreenBase() );
            
        });

        imageView1.setFitHeight(45.0);
        imageView1.setFitWidth(260.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/buttonbackground1.png").toExternalForm()));
        mediumButton.setGraphic(imageView1);

        hardButton.setId("button");
        hardButton.setLayoutX(235.0);
        hardButton.setLayoutY(303.0);
        hardButton.setMaxWidth(USE_PREF_SIZE);
        hardButton.setMinWidth(USE_PREF_SIZE);
        hardButton.setMnemonicParsing(false);
        hardButton.setPrefHeight(40.0);
        hardButton.setPrefWidth(260.0);
        hardButton.setStyle("-fx-content-display: center;");
        hardButton.getStylesheets().add("/tic/tac/toe/css/MainPageScreen.css");
        hardButton.setText("Hard");
        hardButton.setTextFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        hardButton.setFont(new Font("Serif Regular", 24.0));

        imageView2.setFitHeight(45.0);
        imageView2.setFitWidth(260.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Photos/buttonbackground1.png").toExternalForm()));
        hardButton.setGraphic(imageView2);
        hardButton.setOnAction(event ->{
            LevelHardClass hard=new LevelHardClass();
            TicTacToe.scene.setRoot(hard.boardScreen);
            
        });


        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(logoImageView);
        getChildren().add(easyButton);
        getChildren().add(backButton);
        getChildren().add(mediumButton);
        getChildren().add(hardButton);

    }
}

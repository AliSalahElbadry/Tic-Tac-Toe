package tic.tac.toe;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tic.tac.toe.TicTacToe;

public  class BoardScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Rectangle bordRectangle;
    protected final ImageView backButton;
    protected final Rectangle rectangle;
    protected final ImageView box00;
    protected final Rectangle rectangle0;
    protected final ImageView box01;
    protected final Rectangle rectangle1;
    protected final ImageView box02;
    protected final Rectangle rectangle2;
    protected final ImageView box10;
    protected final Rectangle rectangle3;
    protected final ImageView box11;
    protected final Rectangle rectangle4;
    protected final ImageView box12;
    protected final Rectangle rectangle5;
    protected final ImageView box20;
    protected final Rectangle rectangle6;
    protected final ImageView box21;
    protected final Rectangle rectangle7;
    protected final ImageView box22;
    protected final Text scorePlayer1;
    protected final Text scorePlayer2;
    protected final ImageView imageView0;
    protected final Text levelText;
    protected final ImageView imageView1;
    protected final Text player1Text;
    protected final ImageView imageView2;
    protected final Text player2Text;
    protected final ImageView imageView3;

    

    public BoardScreenBase() {


        imageView = new ImageView();
        bordRectangle = new Rectangle();
        backButton = new ImageView();
        rectangle = new Rectangle();
        box00 = new ImageView();
        rectangle0 = new Rectangle();
        box01 = new ImageView();
        rectangle1 = new Rectangle();
        box02 = new ImageView();
        rectangle2 = new Rectangle();
        box10 = new ImageView();
        rectangle3 = new Rectangle();
        box11 = new ImageView();
        rectangle4 = new Rectangle();
        box12 = new ImageView();
        rectangle5 = new Rectangle();
        box20 = new ImageView();
        rectangle6 = new Rectangle();
        box21 = new ImageView();
        rectangle7 = new Rectangle();
        box22 = new ImageView();
        scorePlayer1 = new Text();
        scorePlayer2 = new Text();
        imageView0 = new ImageView();
        levelText = new Text();
        imageView1 = new ImageView();
        player1Text = new Text();
        imageView2 = new ImageView();
        player2Text = new Text();
        imageView3 = new ImageView();
        
        

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/tic/tac/toe/css/MainPageScreen.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        bordRectangle.setArcHeight(80.0);
        bordRectangle.setArcWidth(80.0);
        bordRectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        bordRectangle.setHeight(431.0);
        bordRectangle.setLayoutX(141.0);
        bordRectangle.setLayoutY(37.0);
        bordRectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        bordRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        bordRectangle.setStrokeWidth(0.0);
        bordRectangle.setWidth(456.0);

        backButton.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        backButton.setFitHeight(70.0);
        backButton.setFitWidth(70.0);
        backButton.setLayoutX(2.0);
        backButton.setLayoutY(408.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("Photos/back.png").toExternalForm()));
        backButton.setOnMouseClicked(event ->{

            
            Medium.player = 0;
            Medium.computer = 0;
           

           Easy.computerScore=0;
           Easy.playerScore=0;
            if (GamesRecordItemSceenBase.flag == false ){
                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK,ButtonType.CANCEL); 
                alert.setTitle("Attention");
                alert.setContentText("If you leave ,you will be the looser");
                alert.showAndWait().ifPresent(rs->{

                    if(rs==ButtonType.OK)
                        TicTacToe.scene.setRoot(new MainPageScreenBase());
                });
            }else {
            
                TicTacToe.scene.setRoot(new ProfileScreenBase());
            
            }
        });

        rectangle.setArcHeight(70.0);
        rectangle.setArcWidth(70.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(96.0);
        rectangle.setLayoutX(193.0);
        rectangle.setLayoutY(55.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(113.0);

        box00.setFitHeight(76.0);
        box00.setFitWidth(85.0);
        box00.setLayoutX(212.0);
        box00.setLayoutY(63.0);
        box00.setPickOnBounds(true);
        box00.setPreserveRatio(true);

      

        //box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));

        rectangle0.setArcHeight(70.0);
        rectangle0.setArcWidth(70.0);
        rectangle0.setFill(javafx.scene.paint.Color.WHITE);
        rectangle0.setHeight(96.0);
        rectangle0.setLayoutX(311.0);
        rectangle0.setLayoutY(55.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(113.0);

        box01.setFitHeight(76.0);
        box01.setFitWidth(85.0);
        box01.setLayoutX(334.0);
        box01.setLayoutY(61.0);
        box01.setPickOnBounds(true);
        box01.setPreserveRatio(true);
        //box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));

        rectangle1.setArcHeight(70.0);
        rectangle1.setArcWidth(70.0);
        rectangle1.setFill(javafx.scene.paint.Color.WHITE);
        rectangle1.setHeight(96.0);
        rectangle1.setLayoutX(430.0);
        rectangle1.setLayoutY(55.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(113.0);

        box02.setFitHeight(76.0);
        box02.setFitWidth(85.0);
        box02.setLayoutX(451.0);
        box02.setLayoutY(69.0);
        box02.setPickOnBounds(true);
        box02.setPreserveRatio(true);
       // box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
//        box02.setOnMouseClicked(e->{
//            Medium medium = new Medium();
//            medium.printSides(02);
//            
//        });

        rectangle2.setArcHeight(70.0);
        rectangle2.setArcWidth(70.0);
        rectangle2.setFill(javafx.scene.paint.Color.WHITE);
        rectangle2.setHeight(96.0);
        rectangle2.setLayoutX(195.0);
        rectangle2.setLayoutY(156.0);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(113.0);

        box10.setFitHeight(76.0);
        box10.setFitWidth(85.0);
        box10.setLayoutX(219.0);
        box10.setLayoutY(162.0);
        box10.setPickOnBounds(true);
        box10.setPreserveRatio(true);
        //box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));

        rectangle3.setArcHeight(70.0);
        rectangle3.setArcWidth(70.0);
        rectangle3.setFill(javafx.scene.paint.Color.WHITE);
        rectangle3.setHeight(96.0);
        rectangle3.setLayoutX(313.0);
        rectangle3.setLayoutY(156.0);
        rectangle3.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle3.setWidth(113.0);

        box11.setFitHeight(76.0);
        box11.setFitWidth(85.0);
        box11.setLayoutX(334.0);
        box11.setLayoutY(165.0);
        box11.setPickOnBounds(true);
        box11.setPreserveRatio(true);
       // box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));

        rectangle4.setArcHeight(70.0);
        rectangle4.setArcWidth(70.0);
        rectangle4.setFill(javafx.scene.paint.Color.WHITE);
        rectangle4.setHeight(96.0);
        rectangle4.setLayoutX(432.0);
        rectangle4.setLayoutY(156.0);
        rectangle4.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle4.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle4.setWidth(113.0);

        box12.setFitHeight(76.0);
        box12.setFitWidth(85.0);
        box12.setLayoutX(455.0);
        box12.setLayoutY(163.0);
        box12.setPickOnBounds(true);
        box12.setPreserveRatio(true);
      //  box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));

        rectangle5.setArcHeight(70.0);
        rectangle5.setArcWidth(70.0);
        rectangle5.setFill(javafx.scene.paint.Color.WHITE);
        rectangle5.setHeight(96.0);
        rectangle5.setLayoutX(195.0);
        rectangle5.setLayoutY(257.0);
        rectangle5.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle5.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle5.setWidth(113.0);

        box20.setFitHeight(76.0);
        box20.setFitWidth(85.0);
        box20.setLayoutX(216.0);
        box20.setLayoutY(266.0);
        box20.setPickOnBounds(true);
        box20.setPreserveRatio(true);
      //  box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));

        rectangle6.setArcHeight(70.0);
        rectangle6.setArcWidth(70.0);
        rectangle6.setFill(javafx.scene.paint.Color.WHITE);
        rectangle6.setHeight(96.0);
        rectangle6.setLayoutX(313.0);
        rectangle6.setLayoutY(257.0);
        rectangle6.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle6.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle6.setWidth(113.0);

        box21.setFitHeight(76.0);
        box21.setFitWidth(85.0);
        box21.setLayoutX(339.0);
        box21.setLayoutY(264.0);
        box21.setPickOnBounds(true);
        box21.setPreserveRatio(true);
      //  box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));

        rectangle7.setArcHeight(70.0);
        rectangle7.setArcWidth(70.0);
        rectangle7.setFill(javafx.scene.paint.Color.WHITE);
        rectangle7.setHeight(96.0);
        rectangle7.setLayoutX(432.0);
        rectangle7.setLayoutY(257.0);
        rectangle7.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle7.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle7.setWidth(113.0);

        box22.setFitHeight(76.0);
        box22.setFitWidth(85.0);
        box22.setLayoutX(453.0);
        box22.setLayoutY(264.0);
        box22.setPickOnBounds(true);
        box22.setPreserveRatio(true);
      //  box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));

        scorePlayer1.setFill(javafx.scene.paint.Color.WHITE);
        scorePlayer1.setLayoutX(230.0);
        scorePlayer1.setLayoutY(431.0);
        scorePlayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer1.setStrokeWidth(0.0);
        scorePlayer1.setText("3");
        scorePlayer1.setFont(new Font(22.0));

        scorePlayer2.setFill(javafx.scene.paint.Color.WHITE);
        scorePlayer2.setLayoutX(484.0);
        scorePlayer2.setLayoutY(429.0);
        scorePlayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer2.setStrokeWidth(0.0);
        scorePlayer2.setText("3");
        scorePlayer2.setFont(new Font(22.0));

        imageView0.setFitHeight(47.0);
        imageView0.setFitWidth(157.0);
        imageView0.setLayoutX(298.0);
        imageView0.setLayoutY(8.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setRotate(3.0);
        imageView0.setImage(new Image(getClass().getResource("Photos/Title2.png").toExternalForm()));

        levelText.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        levelText.setLayoutX(320.0);
        levelText.setLayoutY(39.0);
        levelText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        levelText.setStrokeWidth(0.0);
        levelText.setText("Easy");
        levelText.setWrappingWidth(61.13671875);
        levelText.setFont(new Font("Serif Regular", 23.0));

        imageView1.setFitHeight(47.0);
        imageView1.setFitWidth(157.0);
        imageView1.setLayoutX(173.0);
        imageView1.setLayoutY(357.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/Title2.png").toExternalForm()));

        player1Text.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        player1Text.setLayoutX(209.0);
        player1Text.setLayoutY(389.0);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);
        player1Text.setText("Player1");
        player1Text.setWrappingWidth(93.13671875);
        player1Text.setFont(new Font("Serif Regular", 23.0));

        imageView2.setFitHeight(47.0);
        imageView2.setFitWidth(157.0);
        imageView2.setLayoutX(415.0);
        imageView2.setLayoutY(350.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Photos/Title2.png").toExternalForm()));

        player2Text.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        player2Text.setLayoutX(455.0);
        player2Text.setLayoutY(383.0);
        player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Text.setStrokeWidth(0.0);
        player2Text.setText("Player2");
        player2Text.setWrappingWidth(81.13671875);
        player2Text.setFont(new Font("Serif Regular", 23.0));

        imageView3.setFitHeight(15.0);
        imageView3.setFitWidth(50.0);
        imageView3.setLayoutX(334.0);
        imageView3.setLayoutY(408.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setRotate(90.0);
        imageView3.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(bordRectangle);
        getChildren().add(backButton);
        getChildren().add(rectangle);
        getChildren().add(box00);
        getChildren().add(rectangle0);
        getChildren().add(box01);
        getChildren().add(rectangle1);
        getChildren().add(box02);
        getChildren().add(rectangle2);
        getChildren().add(box10);
        getChildren().add(rectangle3);
        getChildren().add(box11);
        getChildren().add(rectangle4);
        getChildren().add(box12);
        getChildren().add(rectangle5);
        getChildren().add(box20);
        getChildren().add(rectangle6);
        getChildren().add(box21);
        getChildren().add(rectangle7);
        getChildren().add(box22);
        getChildren().add(scorePlayer1);
        getChildren().add(scorePlayer2);
        getChildren().add(imageView0);
        getChildren().add(levelText);
        getChildren().add(imageView1);
        getChildren().add(player1Text);
        getChildren().add(imageView2);
        getChildren().add(player2Text);
        getChildren().add(imageView3);
        
    }
}

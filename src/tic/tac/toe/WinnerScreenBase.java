package tic.tac.toe;



import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class WinnerScreenBase extends AnchorPane {

    protected final MediaView congMediaView;
    protected final ImageView imageView;
    protected final Text winnerText;
    protected final Button playAgainButtton;
    protected final ImageView imageView0;
    protected final Button mainPageButton;
    protected final ImageView imageView1;

    public WinnerScreenBase() {

        congMediaView = new MediaView();
        imageView = new ImageView();
        winnerText = new Text();
        playAgainButtton = new Button();
        imageView0 = new ImageView();
        mainPageButton = new Button();
        imageView1 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/tic/tac/toe/Designfxml/../css/winnerscreen.css");

        AnchorPane.setBottomAnchor(congMediaView, 0.0);
        AnchorPane.setLeftAnchor(congMediaView, 0.0);
        AnchorPane.setRightAnchor(congMediaView, 0.0);
        AnchorPane.setTopAnchor(congMediaView, 0.0);
        congMediaView.setFitHeight(480.0);
        congMediaView.setFitWidth(750.0);
        congMediaView.setLayoutX(1.0);

        imageView.setFitHeight(183.0);
        imageView.setFitWidth(313.0);
        imageView.setLayoutX(238.0);
        imageView.setLayoutY(-2.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-rotate: 3;");
        imageView.setImage(new Image(getClass().getResource("../Photos/Title_image.png").toExternalForm()));

        winnerText.setFill(javafx.scene.paint.Color.WHITE);
        winnerText.setLayoutX(310.0);
        winnerText.setLayoutY(102.0);
        winnerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        winnerText.setStrokeWidth(0.0);
        winnerText.setText("X Wins");
        winnerText.setFont(new Font("Serif Regular", 39.0));

        playAgainButtton.setLayoutX(14.0);
        playAgainButtton.setLayoutY(390.0);
        playAgainButtton.setMnemonicParsing(false);
        playAgainButtton.setPrefHeight(50.0);
        playAgainButtton.setPrefWidth(129.0);
        playAgainButtton.getStyleClass().add("playagainbtn");
        playAgainButtton.getStylesheets().add("/tic/tac/toe/Designfxml/../css/winnerscreen.css");
        playAgainButtton.setText("Play Again");
        playAgainButtton.setFont(new Font("Serif Regular", 22.0));

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(200.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../Photos/buttonbackground.png").toExternalForm()));
        playAgainButtton.setGraphic(imageView0);

        mainPageButton.setLayoutX(495.0);
        mainPageButton.setLayoutY(389.0);
        mainPageButton.setMnemonicParsing(false);
        mainPageButton.setPrefHeight(76.0);
        mainPageButton.setPrefWidth(129.0);
        mainPageButton.getStyleClass().add("returnbtn");
        mainPageButton.getStylesheets().add("/tic/tac/toe/Designfxml/../css/winnerscreen.css");
        mainPageButton.setText("Main Page");
        mainPageButton.setFont(new Font("Serif Regular", 22.0));

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../Photos/buttonbackground.png").toExternalForm()));
        mainPageButton.setGraphic(imageView1);

        getChildren().add(congMediaView);
        getChildren().add(imageView);
        getChildren().add(winnerText);
        getChildren().add(playAgainButtton);
        getChildren().add(mainPageButton);

    }
}

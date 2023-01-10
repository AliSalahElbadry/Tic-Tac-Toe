package tic.tac.toe;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ItemBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Text playerNameText;
    protected final Button inviteBtn;
    protected final ImageView imageView;

    public ItemBase() {

        rectangle = new Rectangle();
        playerNameText = new Text();
        inviteBtn = new Button();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(48.0);
        setPrefWidth(410.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tic/tac/toe/css/Item.css");

        rectangle.setArcHeight(50.0);
        rectangle.setArcWidth(50.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        rectangle.setHeight(50.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(410.0);

        playerNameText.setFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        playerNameText.setLayoutX(20.0);
        playerNameText.setLayoutY(33.0);
        playerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerNameText.setStrokeWidth(0.0);
        playerNameText.setText("text");
        playerNameText.setWrappingWidth(95.6708984375);
        playerNameText.setFont(new Font("Serif Regular", 24.0));

        inviteBtn.setLayoutX(297.0);
        inviteBtn.setLayoutY(8.0);
        inviteBtn.setMnemonicParsing(false);
        inviteBtn.setPrefHeight(33.0);
        inviteBtn.setPrefWidth(77.0);
        inviteBtn.getStyleClass().add("inviteBtn");
        inviteBtn.getStylesheets().add("/tic/tac/toe/css/Item.css");
        inviteBtn.setText("Invite");
        inviteBtn.setFont(new Font("Serif Regular", 20.0));
        

        imageView.setFitHeight(33.0);
        imageView.setFitWidth(77.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));
        inviteBtn.setGraphic(imageView);

        getChildren().add(rectangle);
        getChildren().add(playerNameText);
        getChildren().add(inviteBtn);

    }
   
}

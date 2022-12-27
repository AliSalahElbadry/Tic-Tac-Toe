package tic.tac.toe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class TicTacToe extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new GamesRecordScreenBase(), 750, 480);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

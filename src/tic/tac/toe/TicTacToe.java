package tic.tac.toe;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class TicTacToe extends Application {
    
    public static Scene scene ;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        scene = new Scene(new SplashScreenBase(), 750, 480);
        
       primaryStage.setTitle("Tic Tac Toe");
       primaryStage.setScene(scene);
        primaryStage.show();       
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
                }
           
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        scene = new Scene(new AvailablePlayersBase(), 750, 480);

                        primaryStage.setScene(scene);
                        primaryStage.show();  
                        
                    }
                });
                 
            }
        }).start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

package tic.tac.toe;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class TicTacToe extends Application {
    
    public static Scene scene ;
    public static MediaPlayer player;

    @Override
    public void init() throws Exception {
       Media media = new Media(getClass().getResource("/sounds/start.mp3").toExternalForm());  
       player=new MediaPlayer(media);
       player.setAutoPlay(true);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setResizable(false);
        scene = new Scene(new SplashScreenBase(), 750, 480);
        
       primaryStage.setTitle("Tic Tac Toe");
       primaryStage.setScene(scene);
       primaryStage.show();  
        player.play();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
                }
           
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        scene = new Scene(new MainPageScreenBase(), 750, 480);
                        
                        primaryStage.setScene(scene);
                        primaryStage.show(); 
                        
                    }
                });
                 
            }
        }).start();
        primaryStage.setOnCloseRequest(e->{
 
                if(AvailablePlayersBase.boardGameOnline!=null){
                if(AvailablePlayersBase.boardGameOnline.isPalying)
                 LoginFXMLBase.playerConnection.sendMessage("endGame,"+AvailablePlayersBase.boardGameOnline.oponentID);
               }
               if(LoginFXMLBase.playerConnection!=null){
                    if(!LoginFXMLBase.playerConnection.socket.isClosed()){
                        LoginFXMLBase.playerConnection.sendMessage("Close,");
                        try {
                            LoginFXMLBase.playerConnection.socket.close();
                            LoginFXMLBase.playerConnection.stop();
                        } catch (IOException ex) {
                            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
               }

        });
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
  
}

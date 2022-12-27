/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Parent root = new SplashScreenBase();
        
        Scene scene = new Scene(root, 750, 480);
        
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

                        Parent root = new PlayersNamesScreenBase();
                        Scene scene = new Scene(root, 750, 480);

                        primaryStage.setScene(scene);
                        primaryStage.show();  
                        
                       
                        
                    }
                });
                 
            }
        }).start();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

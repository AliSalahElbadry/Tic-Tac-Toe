package tic.tac.toe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static tic.tac.toe.AvailablePlayersBase.boardGameOnline;

public class PlayerConnection extends Thread{
    public DataInputStream recive;
    public static DataOutputStream send;

    public volatile boolean isRunning=false;
    Socket socket;
    String message;

    public PlayerConnection(Socket s) {
        try {
            message = "";
            socket = s;isRunning=true;
            recive = new DataInputStream(socket.getInputStream());
            send = new DataOutputStream(socket.getOutputStream());
            start();

        } catch (Exception e) {

            System.out.println(e.getCause());
        }
    }

    @Override
    public void run() {
        
        while (isRunning) {
            try {

                if (recive != null) {
                    
                    message = recive.readUTF();//here message recived
                    
                    String dbResult[] = message.split(",");
                    
                    if (dbResult[0].equals("login")) {
                        
                        if (message.length() > 6) {
                    
                            LoginFXMLBase.playerData = new PlayerData(Integer.valueOf(dbResult[1]), dbResult[2], dbResult[3], dbResult[4], dbResult[5], Integer.valueOf(dbResult[6]), Integer.valueOf(dbResult[7]));
                            TicTacToe.scene.setRoot(new AvailablePlayersBase());
                            System.err.println("login alv sasa");
                        } 
                        else {
                             

                           LoginFXMLBase.showAlert();


                        }
                        
                    }
                    else if(dbResult[0].equals("signUp")){
                         
                        if(dbResult[1].equals("true")){
                           Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.NONE, "Attention", ButtonType.OK);
                            alert.setTitle("Attention");
                            alert.setContentText("you Signed successfully");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                               TicTacToe.scene.setRoot(new LoginFXMLBase());
                            }
                            });
                        }
                        else{
                             Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                                alert.setTitle("Attention");
                                alert.setContentText("You Aleady Have Account !!");
                                alert.show(); 
                            });
                        }
                        
                    }
                    else if("Move".equals(dbResult[0])){
                            message=dbResult[1];
                           AvailablePlayersBase.boardGameOnline.reciveMove(message);
                    }
                    else if(dbResult[0].equals("Avaliable")){

                        AvailablePlayersBase.avaliable.addAll(Arrays.asList(dbResult));

                        for(int i=2;i<dbResult.length;i+=2){
                            AvailablePlayersBase.preperList(dbResult[i]);
                        }
                    }else if(dbResult[0].equals("endGame"))
                    {
                        boardGameOnline.isPalying=false;
                        WinnerScreenBase winner=new WinnerScreenBase();
                        winner.PrepareWinnerScreen(LoginFXMLBase.playerData.userName,1);
                        message="wins,"+(LoginFXMLBase.playerData.wins+1);
                        sendMessage(message);
                        LoginFXMLBase.playerData.wins++;
                        message="PGames,"+""+(LoginFXMLBase.playerData.countGames+1);
                        LoginFXMLBase.playerData.countGames++;
                        sendMessage(message);
                        TicTacToe.scene.setRoot(winner);

                    }
                    else if(dbResult[0].equals("invite")){
                        
                         AvailablePlayersBase.showDialog(dbResult[2],dbResult[1]);
                    }
                    else if(dbResult[0].equals("startGame")){
                        boardGameOnline=new OnLineGameBoard();
                        boardGameOnline.PlayerName=LoginFXMLBase.playerData.userName;
                        boardGameOnline.oponentName="Player2";
                        PickYourSideScreenBase.level=4;
                        boardGameOnline.isPalying=true;
                        boardGameOnline.oponentID=Integer.valueOf(dbResult[1]);
                        
                        for(int i=1;i<AvailablePlayersBase.avaliable.size();i+=2)
                        {
                            if(AvailablePlayersBase.avaliable.get(i).equals(dbResult[1]))
                            {
                               boardGameOnline.oponentName=
                                        AvailablePlayersBase.avaliable.get(i+1);
                                break;
                            }
                        }
                        AvailablePlayersBase.boardGameOnline.prepare();
                        PickYourSideScreenBase pickYourSideScreenBase =new PickYourSideScreenBase();
                        pickYourSideScreenBase.backBtn.setVisible(false);
                        TicTacToe.scene.setRoot(pickYourSideScreenBase);
                    }
                    else if(dbResult[0].equals("rejectInvitation")){
                       Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                        alert.setTitle("Attention");
                        alert.setContentText("Player "+boardGameOnline.oponentName+" rijects your Invetation");
                        alert.show(); 
                       });
                    }else if(dbResult[0].equals("playing"))
                    {
                        if(!boardGameOnline.isPalying){
                        Platform.runLater(() -> {
                            boardGameOnline.isPalying=true;
                            Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK);
                            alert.setTitle("Attention");
                            alert.setContentText("Player "+boardGameOnline.oponentName+" Want to  play Again "+boardGameOnline.oponentName+"\n"+" Press Ok  To Hide this Dialog\nPress Play Again To Play ");
                            alert.show();
                        });
                        }
                    }else if(dbResult[0].equals("Close"))
                    {
                           isRunning=false;
                           boardGameOnline.isPalying=false;
                           Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                                alert.setTitle("Attention");
                                alert.setContentText("Server Closed !!");
                                alert.show(); 
                            });
                           TicTacToe.scene.setRoot(new MainPageScreenBase()); 
                           break;
                    }else if(dbResult[0].equals("UpdateAddAv")){
                          Platform.runLater(()->{
                                if(dbResult.length>=2&&AvailablePlayersBase.avaliable!=null){
                                    
                                    AvailablePlayersBase.avaliable.add(dbResult[1]);
                                    AvailablePlayersBase.avaliable.add(message.split(",")[2]);
                                    System.err.println(AvailablePlayersBase.avaliable.get(AvailablePlayersBase.avaliable.size()-1));
                                    AvailablePlayersBase.preperList(message.split(",")[2]);
                                    AvailablePlayersBase.availablePlayerslistView.refresh();
                                }
                           });
                    }
                    else if(dbResult[0].equals("UpdateRemAv")){
                        Platform.runLater(()->{
                                if(dbResult.length>=2){
                                    AvailablePlayersBase.avaliable.remove(dbResult[1]);
                                    AvailablePlayersBase.avaliable.remove(message.split(",")[2]);
                                    AvailablePlayersBase.removeFromList(message.split(",")[2]);
                                    AvailablePlayersBase.availablePlayerslistView.refresh();

                                }
                        });
                           
                     }else if(dbResult[0].equals("lBefo"))
                     {
                          Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK); 
                                alert.setTitle("Attention");
                                alert.setContentText("You Aleady LogedIn In Different Device !!");
                                alert.show(); 
                            });
                     }

                }
                else{
                    System.out.println("recieve is null");
                 
                }

            } catch (Exception ex) {
                System.out.print(ex.getMessage());

                   Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Alert alert = new Alert(Alert.AlertType.ERROR,"Attention",ButtonType.OK);
                            alert.setTitle("Information");
                            alert.setContentText("Lost Connection !!!");
                            alert.showAndWait();
                        }
                    });
                   break;

            }
        }
        try {
            socket.close();
        } catch (SocketException ex) {
          System.out.print(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.stop();
        
    }


    public void sendMessage(String message) {
        try {
            send.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

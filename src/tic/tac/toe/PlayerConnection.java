package tic.tac.toe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerConnection extends Thread{
    public DataInputStream recive;
    public static DataOutputStream send;

    Socket socket;
    String message;

    public PlayerConnection(Socket s) {
        try {
            message = "";
            socket = s;
            recive = new DataInputStream(socket.getInputStream());
            send = new DataOutputStream(socket.getOutputStream());
            start();

        } catch (Exception e) {

            System.out.println(e.getCause());
        }
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {

                if (recive != null) {
                    
                    message = recive.readUTF();//here message recived
                    
                    String dbResult[] = message.split(",");
                    
                    if (dbResult[0].equals("login")) {
                        
                        if (message.length() > 6) {
                            
                            LoginFXMLBase.playerData = new PlayerData(Integer.valueOf(dbResult[1]), dbResult[2], dbResult[3], dbResult[4], dbResult[5], Integer.valueOf(dbResult[6]), Integer.valueOf(dbResult[7]));
                            TicTacToe.scene.setRoot(new AvailablePlayersBase());
                        } 
                        else {
                             
                           TicTacToe.scene.setRoot(new MainPageScreenBase());

                        }
                        
                    }
                    else if(dbResult[0].equals("signUp")){
                        System.out.println(dbResult[1]);
                         
                        if(dbResult[1].equals("true")){
                             TicTacToe.scene.setRoot(new LoginFXMLBase());
                        }
                        else{
                            System.out.println("no insert happened");
                        }
                        
                    }
                    else if("Move".equals(dbResult[0])){
                            message=dbResult[1];
                           AvailablePlayersBase.boardGameOnline.reciveMove(message);
                    }
                    else if(dbResult[0].equals("Avaliable")){
                        AvailablePlayersBase.avaliable = dbResult;
                        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                        for(int i=2;i<dbResult.length;i+=2){
                            AvailablePlayersBase.preperList(dbResult[i]);
                        }
                    }else if(dbResult[0].equals("endGame"))
                    {
                        WinnerScreenBase winner=new WinnerScreenBase();
                        winner.PrepareWinnerScreen(LoginFXMLBase.playerData.userName,1);
                        AvailablePlayersBase.boardGameOnline.clear();
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
                    else if(dbResult[0].equals("acceptInvitation")){
                        PickYourSideScreenBase.level=4;
                        TicTacToe.scene.setRoot(new PickYourSideScreenBase());
                    }
                    else if(dbResult[0].equals("rejectInvitation")){
                        
                    }
                    

                }
                else{
                    System.out.println("recieve is null");
                }

            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }
    }


    public void sendMessage(String message) {
        try {
            send.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

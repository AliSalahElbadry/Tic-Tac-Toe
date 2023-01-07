
package tic.tac.toe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlayerConnection extends Thread{
  public DataInputStream recive;
    public DataOutputStream send;
   
    Socket socket;
    String message;
    
    public PlayerConnection(Socket s){
        try{
            message="";
            socket=s;
            recive=new DataInputStream(socket.getInputStream());
            send=new DataOutputStream(socket.getOutputStream());
            start();
            
        }catch(Exception e)
        {
            System.out.println(e.getCause());
        }
    }
    @Override
    public void run() {
        super.run(); 
        while(true){
            try {
                if(recive!=null){
                    message = recive.readUTF(); //here message recived
                    System.out.println(message);
                    String [] result = message.split(",");
                    if(result[0].equals("Avaliable")){
                        System.out.println("enter");
                        AvailablePlayersBase.avaliable = result;
                        
                        for(int i=2;i<result.length;i+=2){
                            System.out.println(result[i]);
                            AvailablePlayersBase.preperList(result[i]);
                            
                        }
                    }
             
                }
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }
    }
     public void sendMessage(String message)
     {
      try {
          System.err.println("send");
          send.writeUTF(message);
      } catch (IOException ex) {
          Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
      }
     }
}

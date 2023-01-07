
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
    
    public PlayerConnection(){
        try{
            message="";
            socket=new Socket("127.0.0.1",5005);
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
                    message=recive.readUTF();//here message recived
                  if("Move".equals(message.split(",")[0]))
                  {
                      message=message.split(",")[1];
                     //sendToReciveMove
                  }
                }
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }
    }
     public static void sendMessage(String message)
     {
      try {
          send.writeUTF(message);
      } catch (IOException ex) {
          Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
      }
     }
}

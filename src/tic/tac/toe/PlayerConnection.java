
package tic.tac.toe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
                    message=recive.readLine();//here message recived
                    System.err.println(message);
                }
            } catch (Exception ex) {
                  this.stop();//here set status offline
                System.out.print(ex.getMessage());
            }
        }
    }
       
}

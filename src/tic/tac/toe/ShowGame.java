
package tic.tac.toe;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class ShowGame implements Runnable{
    
    BoardScreenBase boardScreenBase;
    ArrayList<Move> move ;

    public ShowGame(Record record) {
        boardScreenBase = new BoardScreenBase();
        move = new ArrayList<>();
        this.move = record.recordList;
        boardScreenBase.levelText.setText(record.level);
        boardScreenBase.player1Text.setText(record.player2Name);
        boardScreenBase.player2Text.setText(record.player2Name);
        boardScreenBase.scorePlayer1.setText(record.getPlayer1_side());

        if(record.getPlayer1_side().equals("x")){
            boardScreenBase.scorePlayer2.setText("o");
        }else{
            boardScreenBase.scorePlayer2.setText("x");
        }
                

    }
    

    @Override
    public void run() {
        for(int i=0;i<move.size();i++){
            setMoveOnScreen(move.get(i).getX()+move.get(i).getY(), move.get(i).getSide());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShowGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       private void setMoveOnScreen(String location,String side)
   {
       side=side.toUpperCase();
       switch(location)
       {
           case "00":
               boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
               break;
           case "10":
               boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "20":
               boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "01":
               boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "11":
               boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "21":
               boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "02":
               boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "12":
               boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "22":
               boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
       }
            
   }
    
}

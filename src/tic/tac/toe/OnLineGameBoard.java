
package tic.tac.toe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author alisa
 */
public class OnLineGameBoard {//0 means the woner of comuter 1 means the other player
    BoardScreenBase boardScreenBase;
    int[][]board;
    public String PlayerName="Ali",oponentName="Hassan";
    public int oponentID;
    public static int playerRes=0,oponentRes=0;
    public char playerSide='X';
    public OnLineGameBoard ()
    {
        board=new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        boardScreenBase=new BoardScreenBase();
        boardScreenBase.player1Text.setText(PlayerName);
        boardScreenBase.player2Text.setText(oponentName);
        boardScreenBase.scorePlayer1.setText(""+playerRes);
        boardScreenBase.scorePlayer2.setText(""+oponentRes);
        boardScreenBase.box00.setOnMouseClicked(e->{
            if(board[0][0]==-1)
            {
                board[0][0]=0;
                setMoveOnScreen("00", playerSide=='X'?"X":"O");
                sendMove("00");
                
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box10.setOnMouseClicked(e->{
        if(board[1][0]==-1)
            {
                board[1][0]=0;
                setMoveOnScreen("10", playerSide=='X'?"X":"O");
                sendMove("10");
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box20.setOnMouseClicked(e->{
        if(board[2][0]==-1)
            {
                board[2][0]=0;
                setMoveOnScreen("20", playerSide=='X'?"X":"O");
                sendMove("20");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box01.setOnMouseClicked(e->{
        if(board[0][1]==-1)
            {
                board[0][1]=0;
                setMoveOnScreen("01", playerSide=='X'?"X":"O");
                sendMove("01");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box11.setOnMouseClicked(e->{
        if(board[1][1]==-1)
            {
                board[1][1]=0;
                setMoveOnScreen("11", playerSide=='X'?"X":"O");
                sendMove("11");
                showWinner(pridectWinner(board));
                
            }});
        boardScreenBase.box21.setOnMouseClicked(e->{
        if(board[2][1]==-1)
            {
                board[2][1]=0;
                setMoveOnScreen("21", playerSide=='X'?"X":"O");
                sendMove("21");
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box02.setOnMouseClicked(e->{
        if(board[0][2]==-1)
            {
                board[0][2]=0;
                setMoveOnScreen("02", playerSide=='X'?"X":"O");
                sendMove("02");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box12.setOnMouseClicked(e->{
        if(board[1][2]==-1)
            {
                board[1][2]=0;
                setMoveOnScreen("12", playerSide=='X'?"X":"O");
                sendMove("12");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box22.setOnMouseClicked(e->{
        if(board[2][2]==-1)
            {
                board[2][2]=0;
                setMoveOnScreen("22", playerSide=='X'?"X":"O");
                sendMove("22");
                showWinner(pridectWinner(board));
            }
        });
    }
    private int pridectWinner(int[][] board)
    {
      for(int i=0;i<3;i++)
      {
          if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[2][i]!=-1)
          {
              return board[0][i];
          }
      }
      //coloms
      for(int i=0;i<3;i++)
      {
          if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][2]!=-1)
          {
              return board[i][0];
          }
      }
         //diagonals
         if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]!=-1)
          {
              return board[1][1];
          }
          if(board[2][0]==board[1][1]&&board[1][1]==board[0][2]&&board[0][2]!=-1)
          {
              return board[2][0];
          }
          
       return -1;
   }
    private Boolean isMovesLeft(int board[][])
    {
        for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
               if (board[i][j] == -1)
                   return true;
        return false;
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
    public void sendMove(String location)
    {
   /*     try {
            String message="Move,"+oponentID+","+location;
            PlayerConnection.send.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(OnLineGameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public  void reciveMove(String location)
    {
        String col=""+location.charAt(0);
        String row=""+location.charAt(1);
        board[Integer.valueOf(col)][Integer.valueOf(row)]=1;
        setMoveOnScreen(location,playerSide=='X'?"O":"X");
        int winner=pridectWinner(board);
        showWinner(winner);
    }
    private void showWinner(int ev) {
     if(ev==0||ev==1)
     {
         if(playerSide==ev)playerRes++;
         else oponentRes++;
         
         WinnerScreenBase winner=new WinnerScreenBase();
         winner.PrepareWinnerScreen(ev==0?PlayerName:oponentName, ev==0?1:-1);
        
     }else if(ev==-1&&!isMovesLeft(board))
     {
          WinnerScreenBase winner=new WinnerScreenBase();
          winner.PrepareWinnerScreen("Draw",0);
     }
    }
}

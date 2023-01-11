
package tic.tac.toe;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author alisa
 */
public class OnLineGameBoard {//0 means the woner of comuter 1 means the other player
    
    public BoardScreenBase boardScreenBase;
    public int[][]board;
    public String PlayerName="",oponentName="";
    public  int oponentID;
    public  int playerRes=0,oponentRes=0;
    public  char playerSide='X';
    public  static boolean myTurn=false;
    public  boolean isPalying=false;
    public OnLineGameBoard ()
    {
        board=new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        boardScreenBase=new BoardScreenBase();
        boardScreenBase.levelText.fontProperty().set(Font.font("ARIAL", FontWeight.LIGHT, FontPosture.REGULAR, 16));
        PickYourSideScreenBase.level=4;
        boardScreenBase.levelText.setText("Online");
        PlayerName=LoginFXMLBase.playerData.userName;
        boardScreenBase.player1Text.setText(PlayerName);
        boardScreenBase.player2Text.setText(oponentName);
        boardScreenBase.scorePlayer1.setText(""+playerRes);
        boardScreenBase.scorePlayer2.setText(""+oponentRes);
        boardScreenBase.box00.setOnMouseClicked(e->{
            if(board[0][0]==-1&&myTurn&&isPalying)
            {
                board[0][0]=0;myTurn=false;
                setMoveOnScreen("00", playerSide=='X'?"X":"O");
                sendMove("00");playSound();
                
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box10.setOnMouseClicked(e->{
        if(board[1][0]==-1&&myTurn&&isPalying)
            {
                board[1][0]=0;myTurn=false;
                setMoveOnScreen("10", playerSide=='X'?"X":"O");
                sendMove("10");playSound();
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box20.setOnMouseClicked(e->{
        if(board[2][0]==-1&&myTurn&&isPalying)
            {
                board[2][0]=0;myTurn=false;
                setMoveOnScreen("20", playerSide=='X'?"X":"O");
                sendMove("20");playSound();
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box01.setOnMouseClicked(e->{
        if(board[0][1]==-1&&myTurn&&isPalying)
            {
                board[0][1]=0;myTurn=false;playSound();
                setMoveOnScreen("01", playerSide=='X'?"X":"O");
                sendMove("01");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box11.setOnMouseClicked(e->{
        if(board[1][1]==-1&&myTurn&&isPalying)
            {
                board[1][1]=0;playSound();
                setMoveOnScreen("11", playerSide=='X'?"X":"O");
                sendMove("11");myTurn=false;
                showWinner(pridectWinner(board));
                
            }});
        boardScreenBase.box21.setOnMouseClicked(e->{
        if(board[2][1]==-1&&myTurn&&isPalying)
            {
                board[2][1]=0;myTurn=false;playSound();
                setMoveOnScreen("21", playerSide=='X'?"X":"O");
                sendMove("21");
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.box02.setOnMouseClicked(e->{
        if(board[0][2]==-1&&myTurn&&isPalying)
            {
                board[0][2]=0;myTurn=false;playSound();
                setMoveOnScreen("02", playerSide=='X'?"X":"O");
                sendMove("02");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box12.setOnMouseClicked(e->{
        if(board[1][2]==-1&&myTurn&&isPalying)
            {
                board[1][2]=0;myTurn=false;playSound();
                setMoveOnScreen("12", playerSide=='X'?"X":"O");
                sendMove("12");
                showWinner(pridectWinner(board));
                
            }
        });
        boardScreenBase.box22.setOnMouseClicked(e->{
        if(board[2][2]==-1&&myTurn&&isPalying)
            {
                board[2][2]=0;myTurn=false;playSound();
                setMoveOnScreen("22", playerSide=='X'?"X":"O");
                sendMove("22");
                showWinner(pridectWinner(board));
            }
        });
        boardScreenBase.backButton.setOnMouseClicked(e->{
        
        Alert alert=new Alert(AlertType.WARNING,"Worning !",ButtonType.OK,ButtonType.CANCEL);
        alert.setContentText("YOU WILL LOSE !");
        alert.showAndWait().ifPresent(res->{
         if(res==ButtonType.OK)
         {
             
               LoginFXMLBase.playerConnection.sendMessage("endGame,"+oponentID);
               TicTacToe.scene.setRoot(new AvailablePlayersBase());
         }
        });
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
        try {
            playSound();
            String message="Move,"+oponentID+","+location;
            LoginFXMLBase.playerConnection.sendMessage(message);
        } catch (Exception ex) {
            Logger.getLogger(OnLineGameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void reciveMove(String location)
    {
        String col=""+location.charAt(0);playSound();
        String row=""+location.charAt(1);
        board[Integer.valueOf(col)][Integer.valueOf(row)]=1;
        setMoveOnScreen(location,playerSide=='X'?"O":"X");
        int winner=pridectWinner(board);
        showWinner(winner);
        myTurn=true;
    }
    private void showWinner(int ev) {
     if(ev==0||ev==1)
     {
         if(ev==0)playerRes++;
         else if(ev==1) oponentRes++;
         try {
             String message="";
            if(ev==0){
                message="wins,"+(LoginFXMLBase.playerData.wins+1);
                LoginFXMLBase.playerConnection.sendMessage(message);
                LoginFXMLBase.playerData.wins++;
            }
            message="PGames,"+""+(LoginFXMLBase.playerData.countGames+1);
            LoginFXMLBase.playerData.countGames++;
            LoginFXMLBase.playerConnection.sendMessage(message);
          isPalying=false;  
        } catch (Exception ex) {
            Logger.getLogger(OnLineGameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         WinnerScreenBase winner=new WinnerScreenBase();
         winner.PrepareWinnerScreen(ev==0?PlayerName:oponentName, ev==0?1:-1);
         
     }else if(ev==-1&&!isMovesLeft(board))
     {
        isPalying=false;
          WinnerScreenBase winner=new WinnerScreenBase();
          winner.PrepareWinnerScreen("Draw",0);
     }
    }
     private void playSound()
    {
        TicTacToe.player.stop();
        TicTacToe.player=new MediaPlayer(new Media(getClass().getResource("/sounds/x.mp3").toExternalForm()));
        TicTacToe.player.play();
    }

    public void prepare()
    {
      
      PlayerName=LoginFXMLBase.playerData.userName;
      boardScreenBase.player1Text.setText(PlayerName);
      boardScreenBase.player2Text.setText(oponentName);
      boardScreenBase.scorePlayer1.setText(""+playerRes);
      boardScreenBase.scorePlayer2.setText(""+oponentRes);
      boardScreenBase.box00.setImage(null);
      boardScreenBase.box10.setImage(null);
      boardScreenBase.box20.setImage(null);
      boardScreenBase.box01.setImage(null);
      boardScreenBase.box11.setImage(null);
      boardScreenBase.box21.setImage(null);
      boardScreenBase.box02.setImage(null);
      boardScreenBase.box12.setImage(null);
      boardScreenBase.box22.setImage(null);
      board=new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    }
  
}

package tic.tac.toe;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author alisa
 */
public class LevelHardClass  {
 
    BoardScreenBase boardScreen;
    
    int[][]board;
    public static int playerSide=0;
    private boolean win=false;
    public static String PlayerName="Ali";
    public LevelHardClass()
    {   
       boardScreen=new BoardScreenBase();
       board=new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
       boardScreen.levelText.setText("Hard");
       boardScreen.player1Text.setText("Computer");
       
       boardScreen.box00.setOnMouseClicked(e->{
          if(board[0][0]==-1&&win==false&&isMovesLeft(board))
          {
              board[0][0]=playerSide;
              setMoveOnScreen("00",""+(playerSide==0?'X':'O'));
              int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
       
        });
        boardScreen.box10.setOnMouseClicked(e->{
            if(board[1][0]==-1&&win==false&&isMovesLeft(board))
          {
              board[1][0]=playerSide;
              setMoveOnScreen("10",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
        boardScreen.box20.setOnMouseClicked(e->{
         if(board[2][0]==-1&&win==false&&isMovesLeft(board))
          {
              board[2][0]=playerSide;
              setMoveOnScreen("20",""+(playerSide==0?'X':'O'));
            int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
        boardScreen.box01.setOnMouseClicked(e->{
           if(board[0][1]==-1&&win==false&&isMovesLeft(board))
           {
              board[0][1]=playerSide;
              setMoveOnScreen("01",""+(playerSide==0?'X':'O'));
            int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
        boardScreen.box11.setOnMouseClicked(e->{
           if(board[1][1]==-1&&win==false&&isMovesLeft(board))
          {
              board[1][1]=playerSide;
              setMoveOnScreen("11",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
        boardScreen.box21.setOnMouseClicked(e->{
           
           if(board[2][1]==-1&&win==false&&isMovesLeft(board))
          {
              board[2][1]=playerSide;
              setMoveOnScreen("21",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
       boardScreen.box02.setOnMouseClicked(e->{
          
         if(board[0][2]==-1&&win==false&&isMovesLeft(board))
          {
              board[0][2]=playerSide;
              setMoveOnScreen("02",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
            
        });
        boardScreen.box12.setOnMouseClicked(e->{
            
         if(board[1][2]==-1&&win==false&&isMovesLeft(board))
          {
              board[1][2]=playerSide;
              setMoveOnScreen("12",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }         
        });
        boardScreen.box22.setOnMouseClicked(e->{
          if(board[2][2]==-1&&win==false&&isMovesLeft(board))
          {
              board[2][2]=playerSide;
              setMoveOnScreen("22",""+(playerSide==0?'X':'O'));
             int ev= pridectWinner(board);
                    ShowWinner(ev);
                    if(ev==-1)
                    moveComputer();
          }
        });
   }
   
   private void moveComputer()
   {
         int[]best=getbestMove();
       if(best[0]!=-1&&best[1]!=-1)
       {
           board[best[0]][best[1]]=playerSide==0?1:0;
           int winner=pridectWinner(board);
           setMoveOnScreen(""+best[0]+""+best[1],playerSide==0?"O":"X");
             
             try {
                 Thread.sleep(10);
             } catch (InterruptedException ex) {
                 Logger.getLogger(LevelHardClass.class.getName()).log(Level.SEVERE, null, ex);
             }
           ShowWinner(winner);
       }    
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
   private void setMoveOnScreen(String location,String side)
   {
       side=side.toUpperCase();
       switch(location)
       {
           case "00":
               boardScreen.box00.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
               break;
           case "10":
               boardScreen.box10.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "20":
               boardScreen.box20.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "01":
               boardScreen.box01.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "11":
               boardScreen.box11.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "21":
               boardScreen.box21.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "02":
               boardScreen.box02.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "12":
               boardScreen.box12.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
           case "22":
               boardScreen.box22.setImage(new Image(getClass().getResource("Photos/"+side+".png").toExternalForm()));
              
               break;
       }
            
   }

   private Boolean isMovesLeft(int board[][])
   {
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (board[i][j] == -1)
                return true;
    return false;
}
   private  int[] getbestMove()
   {
    int depth=10000;int depthStop=-10000;
    int []bestwin=new int[]{-1,-1};
    int []bestStop=new int[]{-1,-1};
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            if(board[j][i]==-1)
            {
                board[j][i]=playerSide==0?1:0;
               int h=gominimax(board,playerSide);
               if(h<=depth)
               {
                   bestwin[0]=j;
                   bestwin[1]=i;
                   depth=h;
               }
               if(h>=depthStop)
               {
                   bestStop[0]=j;
                   bestStop[1]=i;
                   depthStop=h;
               }
               board[j][i]=-1;
            }
        }
    }
    if(bestwin[0]!=-1){
    board[bestwin[0]][bestwin[1]]=playerSide==0?1:0;
    if(pridectWinner(board)==(playerSide==0?1:0))
    {
        board[bestwin[0]][bestwin[1]]=-1;
        return bestwin;
    }
    board[bestwin[0]][bestwin[1]]=-1;
    }
    if(bestStop[0]!=-1){
    board[bestStop[0]][bestStop[1]]=playerSide;
    if(pridectWinner(board)==(playerSide))
    {
        board[bestStop[0]][bestStop[1]]=-1;
        return bestStop;
    }
    board[bestStop[0]][bestStop[1]]=-1;
    }
    if(board[1][1]==-1)
    {
        return new int[]{1,1};
    }
    return bestStop;
}

    private int gominimax(int[][] board,int side) {
        int h=pridectWinner(board);
        int depth=1;
        if(h==(playerSide==0?1:0))
        {
            return depth;
        }else if(h==playerSide)
        {
            return -depth;
        }
        boolean hasEmptyCells=isMovesLeft(board);
        if(!hasEmptyCells)
        {
            return depth;
        }
         for(int i=0;i<3;i++)
         {
             for(int j=0;j<3;j++)
             {
                 if(board[j][i]==-1)
                 {
                    board[j][i]=side;
                    depth+=gominimax(board, side==0?1:0);
                    board[j][i]=-1;
                 }
             }
         }
     return depth;
    }

    private void ShowWinner(int ev) {
     if(ev==0||ev==1)
     {
         win=true; 
         WinnerScreenBase winner=new WinnerScreenBase();
         winner.PrepareWinnerScreen(ev==playerSide?PlayerName:"Computer", ev==playerSide?1:-1);
        
     }else if(ev==-1&&!isMovesLeft(board))
     {
         win=true;
          WinnerScreenBase winner=new WinnerScreenBase();
          winner.PrepareWinnerScreen("Draw",0);
     }
    }
}

package tic.tac.toe;

import java.util.Random;
import javafx.scene.image.Image;


public class Easy {
    BoardScreenBase boardScreen;
    static int side;
    boolean isWin;
    int board[][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    
    public Easy()
    {
        boardScreen =new BoardScreenBase();
        boardScreen.levelText.setText("Easy");
        isWin=false;
        if(side==0)
        {
            computerMove();
        }
        
        boardScreen.box00.setOnMouseClicked(e->{ 
        if(isPositionEmpty(board[0][0])&& !isWin){
            playInPosition("00");
            checkMove();     
        }
        });
        
        boardScreen.box01.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[0][1])&& !isWin){
                playInPosition("01");
                checkMove();     
            }
        });
        
        boardScreen.box02.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[0][2])&& !isWin){
                playInPosition("02");
                checkMove();     
            }
        });
        
        boardScreen.box10.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[1][0])&& !isWin){
                playInPosition("10");
                checkMove();     
            }
        });
        
        boardScreen.box11.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[1][1])&& !isWin){
                 playInPosition("11");
                checkMove();     
            }
        });
        
        boardScreen.box12.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[1][2])&& !isWin){
                playInPosition("12");
                checkMove();     
            }
        });
        
        boardScreen.box20.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[2][0])&& !isWin){
                playInPosition("20");
                checkMove();     
            }
        });
        
        boardScreen.box21.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[2][1])&& !isWin){
                playInPosition("21");
                checkMove();     
            }
        });
        
        boardScreen.box22.setOnMouseClicked(e->{ 
            if(isPositionEmpty(board[2][2])&& !isWin){
                playInPosition("22");
                checkMove();     
            }
        });
        
        
    }
   
    public boolean isPositionEmpty(int position)
    {
            return position==-1;
    }
    
    public void computerMove()
    {
        Random computerMove = new Random();
    int row = 0;
    int column =0;
    while (board[row][column] != -1) {
        
         row = computerMove.nextInt(3);
         column = computerMove.nextInt(3);
        if (board[row][column] == -1) {
            break;
        }
    }
    String position=String.valueOf(row).concat(String.valueOf(column));
        playInPosition(position);
 
        
    }
    
    public void playInPosition(String position)
    {
        switch(position)
    {
        case "00":
            if(side==0)
                {
                    boardScreen.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[0][0]=1; 
                }
                else
                {
                   boardScreen.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[0][0]=0;   
                }
        break;
        case "01":
            if(side==0)
                {
                    boardScreen.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[0][1]=1; 
                }
                else
                {
                   boardScreen.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[0][1]=0;   
                }
        break;
        case "02":
            if(side==0)
                {
                    boardScreen.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[0][2]=1; 
                }
                else
                {
                   boardScreen.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[0][2]=0;   
                }
        break;
        case "10":
            if(side==0)
                {
                    boardScreen.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[1][0]=1; 
                }
                else
                {
                   boardScreen.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[1][0]=0;   
                }
        break;
        case "11":
            if(side==0)
                {
                    boardScreen.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[1][1]=1; 
                }
                else
                {
                   boardScreen.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[1][1]=0;   
                }
        break;
        case "12":
            if(side==0)
                {
                    boardScreen.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[1][2]=1; 
                }
                else
                {
                   boardScreen.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[1][2]=0;   
                }
        break;
        case "20":
            if(side==0)
                {
                    boardScreen.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[2][0]=1; 
                }
                else
                {
                   boardScreen.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[2][0]=0;   
                }
        break;
        case "21":
            if(side==0)
                {
                    boardScreen.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[2][1]=1; 
                }
                else
                {
                   boardScreen.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[2][1]=0;   
                }
        break;
        case "22":
            if(side==0)
                {
                    boardScreen.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));  
                    board[2][2]=1; 
                }
                else
                {
                   boardScreen.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));  
                    board[2][2]=0;   
                }
        break;
    }
    }
    public int checkWinner()
    {
        
         for (int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!=-1){
                isWin = true;
                return board[i][0];
            }else if (board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]!=-1){
                isWin = true;
                return board[0][1];
            }else if (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]!=-1){
                isWin = true;
                return board[0][0];
            }else if ( board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]!=-1){
                isWin = true;
                return board[0][2];
            }
        
        }
         isWin = false;
         return -1;
    }
    
    public  boolean checkDraw() {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
            if (board[i][j] == -1) {
                return false;
            }
        }
    }
    return true;
}
    
    public void checkMove()
    {
        int isWinner=checkWinner();
                if(isWinner==-1)
                {
                    if(!checkDraw())
                    computerMove();
                }
                else
                {
                  return;
                    
                }
    }
    
}

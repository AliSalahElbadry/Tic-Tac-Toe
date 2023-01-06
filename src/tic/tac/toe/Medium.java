
package tic.tac.toe;

import java.util.Random;
import javafx.scene.image.Image;

public class Medium{
    
    public static String side ;
    BoardScreenBase boardScreenBase;

    int board[][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    
    boolean win = false ;
    
    public Medium(){
       
        boardScreenBase = new BoardScreenBase();
        boardScreenBase.levelText.setWrappingWidth(80);
        boardScreenBase.levelText.setText("Medium");
        
         click();
        
        
        
    }
    
    public void click(){
        boardScreenBase.box00.setOnMouseClicked(e->{ 
            if(isEmpty(board[0][0]) && !win){
                printSides(00);
                board[0][0]=1;
                winner();
                if(isMovesLeft(board)){
                computer();
                }
                winner();

            }
            
        
        });
        
        boardScreenBase.box01.setOnMouseClicked(e->{ 
            if(isEmpty(board[0][1]) && !win){
            printSides(01);
            board[0][1]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();

            }
        
        });
        
        boardScreenBase.box02.setOnMouseClicked(e->{ 
            if(isEmpty(board[0][2])&& !win){
            printSides(02);
            board[0][2]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
        boardScreenBase.box10.setOnMouseClicked(e->{  
            if(isEmpty(board[1][0])&& !win){
            printSides(10);
            board[1][0]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        boardScreenBase.box11.setOnMouseClicked(e->{  
            if(isEmpty(board[1][1])&& !win){
            printSides(11);
            board[1][1]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
        boardScreenBase.box12.setOnMouseClicked(e->{       
            if(isEmpty(board[1][2])&& !win){
            printSides(12);
            board[1][2]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
        boardScreenBase.box20.setOnMouseClicked(e->{     
            if(isEmpty(board[2][0])&& !win){
            printSides(20);
            board[2][0]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
        boardScreenBase.box21.setOnMouseClicked(e->{ 
            if(isEmpty(board[2][1])&& !win){
            printSides(21);
            board[2][1]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
        boardScreenBase.box22.setOnMouseClicked(e->{    
            if(isEmpty(board[2][2])&& !win){
            printSides(22);
            board[2][2]=1;
            winner();
            if(isMovesLeft(board)){
                computer();
                }
            winner();
            }
        });
        
    }
    
    public void printSides(int number){
    
        if (side == "x" ){
            switch(number){
                case 00:
                    boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                
                case 01:
                     boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                    
                case 02:
                    boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                
                case 10:
                    boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                    
                 case 11:
                    boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                
                case 12:
                    boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                    
                case 20:
                    boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                
                case 21:
                    boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;  
                    
                case 22:
                    boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    break;
                default :
                    break;
            }
         
           
        }else if (side == "o"){
            
            switch(number){
            
                case 00:
                    boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                
                case 01:
                    boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                    
                case 02:
                    boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                
                case 10:
                    boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                    
                 case 11:
                    boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                
                case 12:
                    boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                    
                case 20:
                    boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                
                case 21:
                    boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;  
                    
                case 22:
                    boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    break;
                default :
                    break;
            }
        
        }
    
    }
    
    public void winner(){
    
        if(pridectWinner(board)==1){
            System.err.println("x wins");
            win = true;
        }else if(pridectWinner(board)==0){
            System.err.println("o wins");
            win = true;
        }else if(! isMovesLeft(board)){
            System.err.println("draw");
            win = true; 
        }
    }
    
    public boolean isEmpty(int place){
        if (place>=0){
            return false;
        }else {
            return true;
        }
    }
    
    public void computer(){
        int counter = 0;
        int []move  = new int[2];
        
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    counter++;
                }
            }
        }
        
        if(counter<1){
           random();
        }else{
          
            move = getbestMove(board,side=="x"?0:1);
            board[move[0]][move[1]]=0;
            printSides(Integer.parseInt((Integer.toString(move[0])+""+Integer.toString(move[1]))));
            
            if(side == "x"){
                side = "o";
            }else{
                side = "x";
            }
            
           
        }
    }
    
    public void random(){
        String temp = side; 
    int random = new Random().nextInt(9);
            
            switch(random){
                case 0:
                    if(isEmpty(board[0][0])){
                        if(side=="x"){
                            side= "o";
                            printSides(00);
                            board[0][0]=0;
                        }else{
                            side="x";
                            printSides(00);
                            board[0][0]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                case 1:
                    if(isEmpty(board[0][1])){
                        if(side=="x"){
                            side= "o";
                            printSides(01);
                            board[0][1]=0;
                        }else{
                            side="x";
                            printSides(01);
                            board[0][1]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 2:
                    if(isEmpty(board[0][2])){
                        if(side=="x"){
                            side= "o";
                            printSides(02);
                            board[0][2]=0;
                        }else{
                            side="x";
                            printSides(02);
                            board[0][2]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 3:
                    if(isEmpty(board[1][0])){
                        if(side=="x"){
                            side= "o";
                            printSides(10);
                            board[1][0]=0;
                        }else{
                            side="x";
                            printSides(10);
                            board[1][0]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 4:
                    if(isEmpty(board[1][1])){
                        if(side=="x"){
                            side= "o";
                            printSides(11);
                            board[1][1]=0;
                        }else{
                            side="x";
                            printSides(11);
                            board[1][1]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 5:
                    if(isEmpty(board[1][2])){
                        if(side=="x"){
                            side= "o";
                            printSides(12);
                            board[1][2]=0;
                        }else{
                            side="x";
                            printSides(12);
                            board[1][2]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 6:
                    if(isEmpty(board[2][0])){
                        if(side=="x"){
                            side= "o";
                            printSides(20);
                            board[2][0]=0;
                        }else{
                            side="x";
                            printSides(20);
                            board[2][0]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 7:
                    if(isEmpty(board[2][1])){
                        if(side=="x"){
                            side= "o";
                            printSides(21);
                            board[2][1]=0;
                        }else{
                            side="x";
                            printSides(21);
                            board[2][1]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                    
                case 8:
                    if(isEmpty(board[2][2])){
                        if(side=="x"){
                            side= "o";
                            printSides(22);
                            board[2][2]=0;
                        }else{
                            side="x";
                            printSides(22);
                            board[2][2]=0;
                        }
                    }else{
                        random();
                    }
                    break;
                default:
                    
                    break;
            }
            
            side =temp;
            
    }
   
    private Boolean isMovesLeft(int board[][]){
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (board[i][j] == -1)
                return true;
    return false;
}
    
   private  int[] getbestMove(int [][]board , int playerSide){
       if(side == "x"){
           side = "o";
       }else{
           side = "x";
       }
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
    board[bestwin[0]][bestwin[1]]=playerSide==0?1:0;
    if(pridectWinner(board)==(playerSide==0?1:0))
    {
        board[bestwin[0]][bestwin[1]]=-1;
        return bestwin;
    }
    board[bestwin[0]][bestwin[1]]=-1;
    board[bestStop[0]][bestStop[1]]=playerSide;
    if(pridectWinner(board)==(playerSide))
    {
        board[bestStop[0]][bestStop[1]]=-1;
        return bestStop;
    }
    board[bestStop[0]][bestStop[1]]=-1;
    if(board[1][1]==-1)
    {
        return new int[]{1,1};
    }
    return bestStop;
}

    private int gominimax(int[][] board,int iside) {
        int h=pridectWinner(board);
        int depth=1;
        if(h==(side=="x"?1:0))
        {
            
            return depth;
        }else if(h==(side=="x"?0:1))
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
                    board[j][i]=iside;
                    depth+=gominimax(board, iside==0?1:0);
                    board[j][i]=-1;
                 }
             }
         }
     return depth;
    }
    
    private int pridectWinner(int[][] board){
      
      for(int i=0;i<3;i++)
      {
          if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[2][i]!=-1)
          {
              return board[0][i];
          }
      }
      for(int i=0;i<3;i++)
      {
          if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][2]!=-1)
          {
              return board[i][0];
          }
      }
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
    
    
}



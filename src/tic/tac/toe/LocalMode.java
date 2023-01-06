package tic.tac.toe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LocalMode  {
    
    BoardScreenBase boardScreenBase;
    PickYourSideScreenBase pickYourSideScreenBase;
    PlayersNamesScreenBase playersNamesScreenBase;
    
    int board[][]={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    int winnerSide;
    boolean winnerFlag;
    
    String defaultSide="X";
    boolean XSide;
    
    int player1Score;
    int player2Score;
    
    
    public LocalMode() {
        XSide=false;
        winnerSide=-1;
        winnerFlag=false;
        
        boardScreenBase=new BoardScreenBase();
        pickYourSideScreenBase=new PickYourSideScreenBase();
        playersNamesScreenBase=new PlayersNamesScreenBase();
        
        boardScreenBase.player1Text.setText(PlayersNamesScreenBase.player1Name);
        boardScreenBase.player2Text.setText(PlayersNamesScreenBase.player2Name);
        boardScreenBase.levelText.setText("Local");
        checkSideToStart(PickYourSideScreenBase.player1Side);
        play();
    }
  
     void checkSideToStart(String p1ayer1Side){
        if(p1ayer1Side.equals("O")){
            XSide=false;
        }
        else if(p1ayer1Side.equals("X")){
            XSide=true;
        }
    }
    void turnSide(boolean side){
        XSide=!side;
    }
    
    void play(){
        
        boardScreenBase.box00.setOnMouseClicked(e->{
            if(boardScreenBase.box00.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][0]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box00.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[0][0]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box01.setOnMouseClicked(e->{
              if(boardScreenBase.box01.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][1]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box01.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                 board[0][1]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box02.setOnMouseClicked(e->{
              if(boardScreenBase.box02.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][2]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box02.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                 board[0][2]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box10.setOnMouseClicked(e->{
             if(boardScreenBase.box10.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][0]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box10.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[1][0]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box11.setOnMouseClicked(e->{
              if(boardScreenBase.box11.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][1]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box11.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[1][1]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box12.setOnMouseClicked(e->{
             if(boardScreenBase.box12.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][2]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box12.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                 board[1][2]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box20.setOnMouseClicked(e->{
             if(boardScreenBase.box20.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][0]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box20.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][0]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box21.setOnMouseClicked(e->{
              if(boardScreenBase.box21.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][1]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box21.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][1]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box22.setOnMouseClicked(e->{
              if(boardScreenBase.box22.getImage()==null&&XSide==true&&winnerFlag==false){
                boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][2]=1;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
            else if(boardScreenBase.box22.getImage()==null&&XSide==false&&winnerFlag==false){
                boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][2]=0;
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        
    }
    void checkVertical(){
        for (int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!=-1){
                winnerSide=board[i][0];
                winnerFlag=true;
                endGame(winnerSide);
                return;
            }
        }
        
    }
    void checkHorizontal(){
        for (int i=0;i<3;i++){
            if(board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]!=-1){
                winnerSide=board[0][i];
                winnerFlag=true;
                endGame(winnerSide);
                return;
            }
        }
    }
    void checkDiagonal(){
        if (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]!=-1){
                winnerSide=board[0][0];
                winnerFlag=true;
                endGame(winnerSide);
        }else if (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]!=-1){
                winnerSide=board[0][2];
                winnerFlag=true;
                endGame(winnerSide);
        }
        
    }
    void checkEquality(){
        int counter=0;
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
                if(board[i][j]!=-1){
                    counter++;
                }
            }
       }
       
       if(counter==9&&winnerFlag==false){
           endGame(2);
       }
    }
    void endGame(int winnerSide){
        if(winnerSide==1){
            System.out.println("X won");
        }
        else if(winnerSide==0){
            System.out.println("O won");
        }
        else if(winnerSide==2){
            System.out.println("Both players won");
        }
        
    }
    
}

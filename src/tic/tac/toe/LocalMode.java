package tic.tac.toe;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class LocalMode {

    BoardScreenBase boardScreenBase;
    PickYourSideScreenBase pickYourSideScreenBase;
    PlayersNamesScreenBase playersNamesScreenBase;

    int board[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    int winnerSide;
    boolean winnerFlag;

    String defaultSide = "X";
    boolean XSide;

    static int player1Score = 0;
    static int player2Score = 0;
    ArrayList<Move> list;
    Timer timer ;

    public LocalMode() {
        timer = new Timer();
        list = new ArrayList<>();
        XSide = false;
        winnerSide = -1;
        winnerFlag = false;

        boardScreenBase = new BoardScreenBase();
        pickYourSideScreenBase = new PickYourSideScreenBase();
        playersNamesScreenBase = new PlayersNamesScreenBase();
        PickYourSideScreenBase.level = 3;

        boardScreenBase.player1Text.setText(PlayersNamesScreenBase.player1Name);
        boardScreenBase.player2Text.setText(PlayersNamesScreenBase.player2Name);
        boardScreenBase.scorePlayer1.setText(Integer.toString(player1Score));
        boardScreenBase.scorePlayer2.setText(Integer.toString(player2Score));
        boardScreenBase.levelText.setText("Local");
        checkSideToStart(PickYourSideScreenBase.player1Side);
        play();
    }

    void checkSideToStart(String p1ayer1Side) {
        if (p1ayer1Side.equals("O")) {
            XSide = false;
        } else if (p1ayer1Side.equals("X")) {
            XSide = true;
        }
    }

    void turnSide(boolean side) {
        XSide = !side;
    }

    void play() {

        boardScreenBase.box00.setOnMouseClicked(e -> {
            if (boardScreenBase.box00.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][0] = 1;
                playSound();
                Move move = new Move("x", "0", "0");
                list.add(move);
                turnSide(XSide);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box00.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[0][0] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "0", "0");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box01.setOnMouseClicked(e -> {
            if (boardScreenBase.box01.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][1] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "0", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box01.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[0][1] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "0", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box02.setOnMouseClicked(e -> {
            if (boardScreenBase.box02.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[0][2] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "0", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box02.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[0][2] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "0", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box10.setOnMouseClicked(e -> {
            if (boardScreenBase.box10.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][0] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "1", "0");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box10.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[1][0] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "1", "0");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box11.setOnMouseClicked(e -> {
            if (boardScreenBase.box11.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][1] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "1", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box11.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[1][1] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "1", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box12.setOnMouseClicked(e -> {
            if (boardScreenBase.box12.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[1][2] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "1", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box12.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[1][2] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "1", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box20.setOnMouseClicked(e -> {
            if (boardScreenBase.box20.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][0] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "2", "0");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box20.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][0] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "2", "0");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box21.setOnMouseClicked(e -> {
            if (boardScreenBase.box21.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][1] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "2", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box21.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][1] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "2", "1");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });
        boardScreenBase.box22.setOnMouseClicked(e -> {
            if (boardScreenBase.box22.getImage() == null && XSide == true && winnerFlag == false) {
                boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                board[2][2] = 1;
                turnSide(XSide);
                playSound();
                Move move = new Move("x", "2", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            } else if (boardScreenBase.box22.getImage() == null && XSide == false && winnerFlag == false) {
                boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                board[2][2] = 0;
                turnSide(XSide);
                playSound();
                Move move = new Move("o", "2", "2");
                list.add(move);
                checkDiagonal();
                checkHorizontal();
                checkVertical();
                checkEquality();
            }
        });

    }

    void checkVertical() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != -1) {
                winnerSide = board[0][i];
                winnerFlag = true;
                endGame(winnerSide);
                if (i == 0) {
                    boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreenBase.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return;
            }
        }

    }

    void checkHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != -1) {
                winnerSide = board[i][0];
                winnerFlag = true;
                endGame(winnerSide);
                if (i == 0) {
                    boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreenBase.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return;
            }
        }
    }

    void checkDiagonal() {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != -1) {
            winnerSide = board[0][0];
            winnerFlag = true;
            boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
            endGame(winnerSide);

        } else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != -1) {
            winnerSide = board[0][2];
            winnerFlag = true;
            boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
            endGame(winnerSide);
        }

    }

    void checkEquality() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != -1) {
                    counter++;
                }
            }
        }

        if (counter == 9 && winnerFlag == false) {
            endGame(2);
        }
    }

    void endGame(int winnerSide) {
        if (winnerSide == 1) {//X
            System.out.println("X won");
            if (pickYourSideScreenBase.player1Side == "X") {
                player1Score += 1;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        WinnerScreenBase winner = new WinnerScreenBase();
                        winner.PrepareWinnerScreen(PlayersNamesScreenBase.player1Name, 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
                recordGame(PlayersNamesScreenBase.player1Name, PlayersNamesScreenBase.player2Name);
            } else if (pickYourSideScreenBase.player1Side == "O") {
                player2Score += 1;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        WinnerScreenBase winner = new WinnerScreenBase();
                        winner.PrepareWinnerScreen(PlayersNamesScreenBase.player1Name, 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
                recordGame(PlayersNamesScreenBase.player2Name, PlayersNamesScreenBase.player2Name);
            }
        } else if (winnerSide == 0) {//O
            System.out.println("O won");
            if (pickYourSideScreenBase.player1Side == "O") {
                player1Score += 1;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        WinnerScreenBase winner = new WinnerScreenBase();
                        winner.PrepareWinnerScreen(PlayersNamesScreenBase.player1Name, 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
                recordGame(PlayersNamesScreenBase.player1Name, PlayersNamesScreenBase.player2Name);
            } else if (pickYourSideScreenBase.player1Side == "X") {
                player2Score += 1;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        WinnerScreenBase winner = new WinnerScreenBase();
                        winner.PrepareWinnerScreen(PlayersNamesScreenBase.player1Name, 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
                recordGame(PlayersNamesScreenBase.player2Name, PlayersNamesScreenBase.player2Name);
            }
        } else if (winnerSide == 2) {
            System.out.println("Both players won");
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    WinnerScreenBase winner = new WinnerScreenBase();
                    winner.PrepareWinnerScreen(PlayersNamesScreenBase.player1Name, 0);
                    timer.cancel();
                }
            }, 2000, 2000);
            recordGame("Draw", PlayersNamesScreenBase.player2Name);
        }

    }

    private void playSound() {
        TicTacToe.player.stop();
        TicTacToe.player = new MediaPlayer(new Media(getClass().getResource("/sounds/x.mp3").toExternalForm()));
        TicTacToe.player.play();
    }

    public void recordGame(String winner,String player2Name){

        if(BoardScreenBase.record == true){
            Gson gson = new Gson();
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            String date = timeStamp.replace(":", "-");

            Record record = new Record(0, player2Name, winner,"Local", list, new Date(),PickYourSideScreenBase.player1Side.toLowerCase());
            try {
                Writer writer = new FileWriter("Game//" + date.toString() + ".json");
                gson.toJson(record, writer);
                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
